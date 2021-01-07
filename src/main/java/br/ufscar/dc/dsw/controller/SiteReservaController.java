package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService;

@Controller
@RequestMapping("/sites")
public class SiteReservaController {
	
	@Autowired
	private ISiteReservaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(SiteReserva sitereserva) {
		return "sitereserva/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("sites",service.buscarTodos());
		return "sitereserva/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid SiteReserva sitereserva, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "sitereserva/cadastro";
		}
		
		service.salvar(sitereserva);
		attr.addFlashAttribute("sucess", "Site de Reserva inserido com sucesso.");
		return "redirect:/sites/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("sitereserva", service.buscarPorId(id));
		return "sitereserva/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid SiteReserva sitereserva, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "sitereserva/cadastro";
		}

		service.salvar(sitereserva);
		attr.addFlashAttribute("sucess", "Site de Reserva editado com sucesso.");
		return "redirect:/sites/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.siteTemPromo(id)) {
			model.addAttribute("fail", "Site de Reserva não excluído. Possui promo(s) vinculada(s).");
		} else {
			service.excluir(id);
			model.addAttribute("sucess", "Site de Reserva excluído com sucesso.");
		}
		return listar(model);
	}
}
