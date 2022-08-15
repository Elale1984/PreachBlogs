package com.gcu.preach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan({ "com.gcu" })
public class PreachBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreachBlogApplication.class, args);
	}

}
