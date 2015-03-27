package net.emcheris.spboot.web.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * Accès à l'écran de création d'un nouvel utilisateur
	 * @param model
	 * @return La redirection vers l'écran de sortie
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "admin/editUser";
	}

	/**
	 * Création d'un nouvel utilisateur
	 * 
	 * @param user
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createUser(@Valid User user, BindingResult br, Model model) {
		if (br.hasErrors()) {
			LOG.error("Des erreurs se sont produites");
			return "admin/editUser";
		}

		userService.saveUser(user);
		model.addAttribute("user", user);
		return "";
	}

	/**
	 * Accès à l'écran de recherche d'un utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String initSearchUser(Model model) {
		User criteria = new User();
		model.addAttribute("criteria", criteria);
		return "admin/searchUser";
	}

	/**
	 * Recherche d'un utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String searchUsers(@ModelAttribute User criteria, Model model) {
		List<User> listUsers = userService.listUsers(criteria);
		
		model.addAttribute("criteria", criteria);
		model.addAttribute("listUsers", listUsers);

		return "admin/searchUser";
	}

	/**
	 * Modification d'un utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable Long userId, Model model) {
		// Chargement de l'utilisateur
		User user = userService.getUser(userId);
		
		model.addAttribute("user", user);
		return "admin/editUser";
	}

}
