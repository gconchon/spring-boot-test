package net.emcheris.spboot.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import net.emcheris.spboot.core.service.UserService;
import net.emcheris.spboot.data.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "admin/createUser";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String greetingSubmit(@Valid User user, BindingResult br, Model model) {
		if (br.hasErrors()) {
			LOG.error("Des erreurs se sont produites");
			return "admin/createUser";
		}

		userService.saveUser(user);
		model.addAttribute("user", user);
		return "admin/viewUser";
	}

	/**
	 * Accès à l'écran de recherche d'un utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String initSearchUsers(Model model) {
		User criteria = new User();
		model.addAttribute("criteria", criteria);
		return "admin/listUsers";
	}

	/**
	 * Recherche d'un utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String searchUsers(Model model) {
		User criteria = new User();
		model.addAttribute("criteria", criteria);

		List<User> listUsers = userService.listUsers(new User());
		
		model.addAttribute("listUsers", listUsers);

		return "admin/listUsers";
	}

}
