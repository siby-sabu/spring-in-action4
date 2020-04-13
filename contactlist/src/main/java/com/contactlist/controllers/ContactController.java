package com.contactlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contactlist.data.Contact;
import com.contactlist.repo.ContactRepository;

@Controller
@RequestMapping("/")
public class ContactController {

	private ContactRepository repository;

	@Autowired
	public ContactController(ContactRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String home(Model model) {

		List<Contact> contacts = repository.findAll();
		model.addAttribute("contacts", contacts);
		return "home";

	}

	@PostMapping
	public String submit(Contact contact) {
		repository.save(contact);
		return "redirect:/";
	}

}
