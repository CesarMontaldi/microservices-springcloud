package br.com.cesarmontaldi.msavalidorcredito;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRabbit
public class MsavalidorcreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsavalidorcreditoApplication.class, args);
	}

}
