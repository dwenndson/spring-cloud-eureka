package io.github.diegowenndson.mscliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
public class MsclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsclienteApplication.class, args);
	}

}
