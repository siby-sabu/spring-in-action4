package com.spittr.web;


import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.spittr.Spitter;
import com.spittr.SpitterConstants;
import com.spittr.SpitterValidator;
import com.spittr.data.SpitterRepository;
import com.spittr.exception.DuplicateSpitterException;

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
	public String register( /** @RequestPart ("profilePicture") MultipartFile profilePicture, **/ @Valid @ModelAttribute("spitter") Spitter spitter, BindingResult result,
			RedirectAttributes model) throws IllegalStateException, IOException, DuplicateSpitterException {
		
		validator.validate(spitter, result);
		if (result.hasErrors()) {
			System.out.println("Errors detected");
			return "registrationForm";
		}
		//System.out.println("Multipart file length "+ profilePicture.getOriginalFilename());
		Spitter savedSpitter = repository.save(spitter);
		//saveFile(profilePicture);
		model.addAttribute("userName", savedSpitter.getUserName());
		model.addFlashAttribute("spitter", spitter);
		//profilePicture.transferTo(new File("/Users/I336545/Documents/learnings/spring/tmp/spittr/upload/"+profilePicture.getOriginalFilename()));
		return "redirect:/spitter/{userName}" ;
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName, Model model) {
		if(!model.containsAttribute("spitter")) {
			System.out.println("Spitter attribute not present");
			model.addAttribute("spitter", repository.get(userName));
		}
		return "profile";
	}

	
	
	private void saveFile(MultipartFile profilePicture) {
		try 
		{
			AWSCredentials awsCredentials = new BasicAWSCredentials(SpitterConstants.awsAccessKeyId, SpitterConstants.awsSecretKey);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
													.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
													.withRegion("us-east-2")
													.build();
			File newFile = new File("/Users/I336545/Documents/learnings/spring/tmp/spittr/upload/"+profilePicture.getOriginalFilename());
			s3Client.putObject(SpitterConstants.awsBucketName, "profile-picture", newFile);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
