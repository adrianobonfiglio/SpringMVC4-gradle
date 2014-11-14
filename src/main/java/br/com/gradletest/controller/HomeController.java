package br.com.gradletest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gradletest.service.HomeService;

/**
 * @author Adriano
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	/**
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		view.addObject("nome", homeService.getNome());
		view.setViewName("index");
		return view;
	}

}
