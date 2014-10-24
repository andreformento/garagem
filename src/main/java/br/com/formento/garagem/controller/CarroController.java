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
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CarroFoto;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.Usuario;

@Transactional
@Controller
public class CarroController {

	@Autowired
	private CarroDao dao;

	@Autowired
	private CarroFotoDao carroFotoDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping("cadastraCarro")
	public String form(final ModelMap modelMap, Integer codigo) {
		Carro entidade;
		if (codigo == null || codigo <= 0)
			entidade = new Carro();
		else
			entidade = dao.buscaPorId(codigo);

		modelMap.addAttribute("entidade", entidade);

		return "carro/formulario";
	}

	@RequestMapping("mergeCarro")
	public String merge(@Valid Carro entidade, BindingResult result, final ModelMap modelMap, HttpServletRequest httpServletRequest)
			throws IOException {
		if (result.hasFieldErrors("marca") || result.hasFieldErrors("modelo") || result.hasFieldErrors("ano") || result.hasFieldErrors("historia")
				|| result.hasFieldErrors("meta") || result.hasFieldErrors("cor"))
			return "carro/formulario";

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		entidade.setUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario());

		// http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) httpServletRequest;
		MultipartFile multipartFile = multipartRequest.getFile("txtFile");

		CarroFoto carroFoto;
		if (multipartFile.isEmpty()) {
			// entidade.setCarroFoto(null);
			carroFoto = carroFotoDao.getByCarro(entidade);
		} else {
			// entidade.setCarroFoto(carroFoto);
			carroFoto = new CarroFoto(multipartFile.getBytes(), entidade);
		}

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else {
			Carro entidadeGravada = dao.buscaPorId(entidade.getCodigo());

			if (entidadeGravada == null || (!entidadeGravada.getUsuario().equals(managerUsuarioSessao.getUsuarioSessao().getUsuario())))
				return "redirect:cadastraCarro?mensagem=Registro inv&aacutelido";

			dao.altera(entidade);
		}

		if (carroFoto != null) {
			if (multipartFile.isEmpty())
				carroFotoDao.remove(carroFoto.getCodigo());
			else if (carroFoto.getCodigo() <= 0)
				carroFotoDao.adiciona(carroFoto);
			else
				carroFotoDao.altera(carroFoto);
		}

		alteraSelecaoCarro(modelMap, httpServletRequest, entidade);

		return "redirect:cadastraCarro?mensagem=Gravado com sucesso";
	}

	@RequestMapping("removeCarro")
	public String remove(int codigo) {
		dao.remove(codigo);
		return "redirect:cadastraCarro?mensagem=Removido com sucesso";
	}

	private void alteraSelecaoCarro(final ModelMap modelMap, HttpServletRequest httpServletRequest, Carro carro) {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		Usuario usuario = managerUsuarioSessao.getUsuarioSessao().getUsuario();

		if (carro.getUsuario().equals(usuario)) {
			usuario.setCarro(carro);
			usuarioDao.altera(usuario);

			managerUsuarioSessao.getUsuarioSessao().setListCarro(dao.getByUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario()));

			modelMap.addAttribute("codigo", carro.getCodigo());
		}
	}

	@RequestMapping("selecionaCarro")
	public String selecionaCarro(int codigo, final ModelMap modelMap, HttpServletRequest httpServletRequest) {

		Carro carro = dao.buscaPorId(codigo);
		if (carro != null)
			alteraSelecaoCarro(modelMap, httpServletRequest, carro);

		return "redirect:cadastraCarro";
	}

}
