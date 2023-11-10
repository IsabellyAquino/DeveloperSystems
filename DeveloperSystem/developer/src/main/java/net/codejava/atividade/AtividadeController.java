package net.codejava.atividade;

import net.codejava.responsavel.Responsavel;
import net.codejava.responsavel.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AtividadeController {

	@Autowired
	private ResponsavelRepository responsavelRepo;

	@Autowired
	private AtividadeRepository atividadeRepo;

	@GetMapping("/atividades")
	public String listAtividades(Model model) {
		List<Atividade> listAtividades = atividadeRepo.findAll();
		model.addAttribute("listAtividades", listAtividades);
		return "atividades";
	}

	@GetMapping("/atividades/new")
	public String showAtividadeNewForm(Model model) {
		List<Responsavel> listResponsaveis = responsavelRepo.findAll();
		List<Atividade> listAtividades = atividadeRepo.findAll();

		model.addAttribute("atividade", new Atividade());
		model.addAttribute("listResponsaveis", listResponsaveis);
		model.addAttribute("listAtividades", listAtividades);

		return "atividade_form";
	}

	@GetMapping("atividades/edit/{id}")
	public String showAtividadeEditForm(@PathVariable("id") Integer id, Model model) {
		Atividade atividade = atividadeRepo.findById(id).get();
		model.addAttribute("atividade", atividade);

		List<Responsavel> listResponsaveis = responsavelRepo.findAll();
		model.addAttribute("listResponsaveis", listResponsaveis);

		List<Atividade> listAtividades = atividadeRepo.findAll();
		model.addAttribute("listAtividades", listAtividades);

		return "atividade_form";
	}


	@PostMapping("/atividades/save")
	public String saveAtividade(Atividade atividade) {
		atividadeRepo.save(atividade);
		return "redirect:/atividades";
	}

	@GetMapping("atividades/delete/{id}")
	public String deleteAtividade(@PathVariable("id") Integer id, Model model) {
		atividadeRepo.deleteById(id);
		return "redirect:/atividades";
	}

}
