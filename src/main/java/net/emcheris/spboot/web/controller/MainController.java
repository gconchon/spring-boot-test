package net.emcheris.spboot.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Value("${application.name}")
	private String name;
	
    @RequestMapping("/")
    public String home() {
        return "logon";
    }
    
}
