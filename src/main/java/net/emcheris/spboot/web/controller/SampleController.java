package net.emcheris.spboot.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@Value("${application.name}")
	private String name;
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Mon premier projet Spring boot : " + name;
    }

}
