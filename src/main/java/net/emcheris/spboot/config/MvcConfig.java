package net.emcheris.spboot.config;

import net.emcheris.spboot.web.conversion.DateFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		DateFormatter dateFormatter = new DateFormatter();
		registry.addFormatter(dateFormatter);
	}

}
