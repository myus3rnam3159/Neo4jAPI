package com.onechain.graph_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.onechain")
public class GraphDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphDbApplication.class, args);
	}

}
