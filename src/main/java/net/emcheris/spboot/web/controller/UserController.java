package net.emcheris.spboot.web.controller;

import net.emcheris.spboot.web.form.UserForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    		UserForm user = new UserForm();
    		user.setProfile("POL");
        model.addAttribute("user", user);
        return "admin/user";
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UserForm user, Model model) {
        model.addAttribute("user", user);
        return "admin/viewuser";
    }

}
