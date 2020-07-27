
package com.user.jattana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.user.jattana" })
public class AppConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setViewClass(JstlView.class);
		ir.setPrefix("/WEB-INF/views/");
		ir.setSuffix(".jsp");
		return ir;
	}
}
