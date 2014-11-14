package br.com.gradletest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gradletest.entity.Pessoa;
import br.com.gradletest.service.PessoaService;

/**
 * @author Adriano S. Bonfiglio
 *
 */
@Controller
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;

	/**
	 * @return
	 */
	@RequestMapping(value="/pessoa")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		List<Pessoa> pessoas = pessoaService.findAll();
		
		model.addObject("listPessoas", pessoas);
		model.setViewName("index");
		
		return model;
		
	}
}
