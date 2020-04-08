package com.spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;
import com.spittr.exception.DuplicateSpitterException;
import com.spittr.exception.SpittleNotFoundException;

@Controller
@RequestMapping(value = "spittles")
public class SpittleController {
	
	private static final  String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;

	SpittleRepository repository;

	@Autowired
	public SpittleController(SpittleRepository repository) {
		this.repository = repository;
	}


	@RequestMapping(method = RequestMethod.GET)
	public String spittles(@RequestParam(name = "max", defaultValue = MAX_LONG_AS_STRING) long max, @RequestParam(name = "count", defaultValue = "20") int count, Model model) {
		List<Spittle> spittles = repository.findSpittles(max, count);
		model.addAttribute(spittles);
		return "spittles";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{spittleId}")
	public String spittle(Model model, @PathVariable long spittleId) {
		Spittle spittle = repository.findOne(spittleId);
		model.addAttribute("spittle", spittle);
		return "spittle";
	}
	
	
}
