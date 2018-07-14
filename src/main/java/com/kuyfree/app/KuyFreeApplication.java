package com.kuyfree.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.kuyfree.app.config.EnableSwagger;
import com.kuyfree.app.config.FileServerLocationConfiguration;
import com.kuyfree.app.config.MvcConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableCaching
@EnableTransactionManagement
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = { "com.kuyfree.app" })
@Import({ EnableSwagger.class, MvcConfig.class, FileServerLocationConfiguration.class })
public class KuyFreeApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(KuyFreeApplication.class, args);
	}

	/**
	 * enable to deploy in web container
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KuyFreeApplication.class);
	}
}
