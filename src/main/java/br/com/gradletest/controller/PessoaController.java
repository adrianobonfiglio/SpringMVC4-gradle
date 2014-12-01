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
@RequestMapping(value="/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;

	/**
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		Pessoa pessoa = pessoaService.findByEmailLike("adrianobonfiglio@gmail.com");
		
		model.addObject("pessoa", pessoa);
		model.setViewName("/pessoa/list");
		
		return model;
		
	}
}
