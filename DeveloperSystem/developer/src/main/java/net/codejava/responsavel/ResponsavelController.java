package net.codejava.responsavel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ResponsavelController {

	@Autowired
	private ResponsavelRepository repo;

	@GetMapping("/responsaveis")
	public String listResponsaveis(Model model) {
		List<Responsavel> listResponsaveis = repo.findAll();
		model.addAttribute("listResponsaveis", listResponsaveis);
		return "responsaveis";
	}

	@GetMapping("/responsaveis/new")
	public String showResponsavelNewForm(Model model) {

		model.addAttribute("responsavel", new Responsavel());

		return "responsavel_form";
	}

	@GetMapping("responsaveis/edit/{id}")
	public String showResponsavelEditForm(@PathVariable("id") Integer id, Model model) {
		Responsavel responsavel = repo.findById(id).get();

		model.addAttribute("responsavel", responsavel);

		return "responsavel_form";
	}

	@PostMapping("/responsaveis/save")
	public String saveResponsavel(Responsavel responsavel) {
		repo.save(responsavel);
		return "redirect:/responsaveis";
	}

	@GetMapping("responsaveis/delete/{id}")
	public String deleteResponsavel(@PathVariable("id") Integer id, Model model) {

		try
		{
			repo.deleteById(id);
			return "redirect:/responsaveis";
		}
		catch(Exception e)
		{
			return "responsavel_erro";
		}
	}

}
