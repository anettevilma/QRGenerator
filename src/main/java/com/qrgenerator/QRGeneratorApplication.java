package com.qrgenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.qrgenerator.QRGeneratorApplication;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling
public class QRGeneratorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(QRGeneratorApplication.class, args);
	}

}
