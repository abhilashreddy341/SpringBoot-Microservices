package com.egiants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.Egiants")
@SpringBootApplication
public class SprApplication{
    
	public static void main(String[] args) {
		SpringApplication.run(SprApplication.class, args);
	}
}
