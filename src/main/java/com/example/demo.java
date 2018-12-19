package com.example;

import com.example.CONFIGs.StorageProperties;
import com.example.ServiceInterface.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class demo {

	public static void main(String[] args) {

		SpringApplication.run(demo.class, args);

		String encoded=new BCryptPasswordEncoder().encode("userpassword");
		System.out.println(encoded);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
