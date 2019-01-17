package com.sudip.springboot;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sudip.springboot.filter.CORSFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 470009
 *
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableSwagger2
@ComponentScan(basePackages = "com.sudip.springboot")
public class Application extends SpringBootServletInitializer {
	
	private static final Logger LOGGER = LogManager.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("ProjectManger APP Started");
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new CORSFilter());
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	}
	
	@Bean
	public DozerBeanMapper dozerMapper() {
		
		List<String> mappingFiles = Arrays.asList("mapper-dozer.xml");
		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	} 
	
}
