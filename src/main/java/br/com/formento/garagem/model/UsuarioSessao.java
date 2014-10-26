package br.com.formento.garagem.model;

import java.util.List;

import org.springframework.ui.ModelMap;

import br.com.formento.garagem.compare.UsuarioComparatorUsernamePassword;
import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.dao.interfaces.CarroFotoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.UsuarioPermissaoDao;
import br.com.formento.garagem.enums.PermissaoEnum;
import br.com.formento.garagem.enums.ResultadoLoginEnum;

public class UsuarioSessao {
	private final UsuarioComparatorUsernamePassword usuarioComparatorUsernamePassword;

	private Usuario usuario;
	private List<TipoCategoriaOrcamento> listTipoCategoriaOrcamento;
	private List<UsuarioPermissao> listUsuarioPermissao;
	private List<Carro> listCarro;
	private Boolean isPermitidoAdministrar;
	private CarroFoto carroFoto;

	public UsuarioSessao() {
		this.usuarioComparatorUsernamePassword = new UsuarioComparatorUsernamePassword();
	}

	public ResultadoLoginEnum login(Usuario usuarioByView, Usuario usuarioByDao) {
		logout();

		if (usuarioByDao == null)
			return ResultadoLoginEnum.INVALIDO;

		String newPassword = MD5Converter.getMD5(usuarioByView.getPassword());
		usuarioByView.setPassword(newPassword);

		if (usuarioComparatorUsernamePassword.compare(usuarioByView, usuarioByDao) == 0) {
			if (usuarioByDao.getDataAtivacao() == null)
				return ResultadoLoginEnum.INATIVO;
			else {
				this.usuario = usuarioByDao;
				return ResultadoLoginEnum.SUCESSO;
			}
		} else
			return ResultadoLoginEnum.INVALIDO;
	}

	public void logout() {
		this.usuario = null;
		this.listTipoCategoriaOrcamento = null;
		this.listUsuarioPermissao = null;
		this.listCarro = null;
		this.isPermitidoAdministrar = null;
		this.carroFoto = null;
	}

	public boolean configurarUsuario(ModelMap modelMap, CarroDao carroDao, CarroFotoDao carroFotoDao,
			TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao, UsuarioPermissaoDao usuarioPermissaoDao) {
		listTipoCategoriaOrcamento = tipoCategoriaOrcamentoDao.lista();
		listUsuarioPermissao = usuarioPermissaoDao.getByUsuario(usuario);

		boolean isConfigurado = configurarCarro(modelMap, carroDao, usuario.getCarro());
		configurarCarroFoto(carroFotoDao);

		return isConfigurado;
	}

	public boolean configurarCarro(ModelMap modelMap, CarroDao carroDao, Carro carro) {
		listCarro = carroDao.getByUsuario(usuario);
		usuario.setCarro(carro);

		boolean isConfigurado = (!listCarro.isEmpty()) && usuario.getCarroSelecionado();

		if (isConfigurado)
			modelMap.addAttribute("codigo", usuario.getCarro().getCodigo());

		return isConfigurado;
	}

	public void configurarCarroFoto(CarroFotoDao carroFotoDao) {
		if (usuario.getCarroSelecionado())
			carroFoto = carroFotoDao.getByCarro(usuario.getCarro());
		else
			carroFoto = null;
	}

	public boolean isUsuarioLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean getPermitidoAdministrar() {
		if (isPermitidoAdministrar == null) {
			isPermitidoAdministrar = false;
			if (isUsuarioLogado())
				for (UsuarioPermissao usuarioPermissao : listUsuarioPermissao)
					if (usuarioPermissao.getPermissao().getPermissaoEnum().equals(PermissaoEnum.ADMINISTRAR)) {
						isPermitidoAdministrar = true;
						break;
					}
		}

		return isPermitidoAdministrar;
	}

	public List<TipoCategoriaOrcamento> getListTipoCategoriaOrcamento() {
		return listTipoCategoriaOrcamento;
	}

	public List<UsuarioPermissao> getListUsuarioPermissao() {
		return listUsuarioPermissao;
	}

	public List<Carro> getListCarro() {
		return listCarro;
	}

	public CarroFoto getCarroFoto() {
		return carroFoto;
	}

}
