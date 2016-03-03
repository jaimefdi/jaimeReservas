package es.fdi.reservas.users.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.fdi.reservas.users.business.boundary.UserService;
import es.fdi.reservas.users.business.entity.User;


@Controller
public class UserController {

	private UserService user_service;
	
	@Autowired
	public UserController(UserService userService){
		user_service = userService;
	}
	
	/*
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "welcome";
	}
	*/
	@RequestMapping(value="/new_user")
	public String nuevoUsuario(){
		 
	    return "new_user";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
	   return "login";
	}
	
	
	
}
