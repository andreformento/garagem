package br.com.formento.garagem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.dao.interfaces.CarroFotoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.dao.interfaces.UsuarioPermissaoDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CarroFoto;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.Usuario;

@Transactional
@Controller
public class CarroController {

	@Autowired
	private CarroDao carroDao;

	@Autowired
	private CarroFotoDao carroFotoDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@Autowired
	private UsuarioPermissaoDao usuarioPermissaoDao;

	@RequestMapping("cadastraCarro")
	public String form(final ModelMap modelMap, int codigo, HttpServletRequest httpServletRequest) {
		Carro entidade;
		if (codigo <= 0)
			entidade = new Carro();
		else {
			entidade = carroDao.buscaPorId(codigo);

			ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
			if (managerUsuarioSessao.getUsuarioSessao().getCarroFoto() != null)
				modelMap.addAttribute("carroFotoEncode", managerUsuarioSessao.getUsuarioSessao().getCarroFoto().getEncode());
		}

		modelMap.addAttribute("entidade", entidade);

		return "carro/formulario";
	}

	@RequestMapping("nenhumCarro")
	public String nenhumCarro() {
		return "carro/nenhumCarro";
	}

	@RequestMapping("mergeCarro")
	public String merge(@Valid Carro entidade, BindingResult result, final ModelMap modelMap, HttpServletRequest httpServletRequest)
			throws IOException {
		if (result.hasFieldErrors("marca") || result.hasFieldErrors("modelo") || result.hasFieldErrors("ano") || result.hasFieldErrors("historia")
				|| result.hasFieldErrors("meta") || result.hasFieldErrors("cor"))
			return "carro/formulario";

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		entidade.setUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario());

		if (entidade.getCodigo() <= 0)
			carroDao.adiciona(entidade);
		else {
			Carro entidadeGravada = carroDao.buscaPorId(entidade.getCodigo());

			if (entidadeGravada == null || (!entidadeGravada.getUsuario().equals(managerUsuarioSessao.getUsuarioSessao().getUsuario())))
				return "redirect:cadastraCarro?mensagem=Registro inv&aacutelido&codigo=" + entidade.getCodigo();

			carroDao.altera(entidade);
		}

		/**
		 * Foto
		 */
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) httpServletRequest;
		MultipartFile multipartFile = multipartRequest.getFile("txtFile");
		if (!multipartFile.isEmpty()) {
			CarroFoto carroFoto = carroFotoDao.getByCarro(entidade);
			if (carroFoto == null)
				carroFoto = new CarroFoto(entidade);

			carroFoto.setImagem(multipartFile.getBytes());
			if (carroFoto.getCodigo() <= 0)
				carroFotoDao.adiciona(carroFoto);
			else
				carroFotoDao.altera(carroFoto);
		}

		alteraSelecaoCarro(modelMap, httpServletRequest, entidade);

		return "redirect:cadastraCarro?mensagem=Gravado com sucesso&codigo=" + entidade.getCodigo();
	}

	// @RequestMapping("removeCarro")
	// public String remove(int codigo) {
	// carroDao.remove(codigo);
	// return "redirect:cadastraCarro?mensagem=Removido com sucesso";
	// }

	private void alteraSelecaoCarro(final ModelMap modelMap, HttpServletRequest httpServletRequest, Carro carro) {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		Usuario usuario = managerUsuarioSessao.getUsuarioSessao().getUsuario();

		if (carro.getUsuario().equals(usuario)) {
			usuario.setCarro(carro);
			usuarioDao.altera(usuario);

			managerUsuarioSessao.getUsuarioSessao().configurarCarro(modelMap, carroDao, carro);
			managerUsuarioSessao.getUsuarioSessao().configurarCarroFoto(carroFotoDao);
		}
	}

	@RequestMapping("selecionaCarro")
	public String selecionaCarro(int codigo, final ModelMap modelMap, HttpServletRequest httpServletRequest) {
		Carro carro = carroDao.buscaPorId(codigo);
		if (carro != null)
			alteraSelecaoCarro(modelMap, httpServletRequest, carro);

		return "redirect:cadastraCarro?codigo=" + carro.getCodigo();
	}

}
