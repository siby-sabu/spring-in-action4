package com.spittr.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.Spitter;
import com.spittr.SpitterValidator;
import com.spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	SpitterRepository repository;

	@Autowired
	public SpitterController(SpitterRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	private SpitterValidator validator;
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	

	public SpitterController() {
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationController(Model model) {
		model.addAttribute("spitter", new Spitter());
		return "registrationForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register( @Valid @ModelAttribute("spitter") Spitter spitter, BindingResult result,
			Model model) {
		
		validator.validate(spitter, result);
		if (result.hasErrors()) {
			System.out.println("Errors detected");
			return "registrationForm";
		}
		repository.save(spitter);
		return "redirect:/spitter/" + spitter.getUserName();
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName, Model model) {
		Spitter spitter = repository.get(userName);
		model.addAttribute("spitter", spitter);
		return "profile";
	}

}
