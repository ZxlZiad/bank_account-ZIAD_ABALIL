package com.ziad.customerservice;

import com.ziad.customerservice.entities.Customer;
import com.ziad.customerservice.repository.CustomerRepository;
import com.ziad.customerservice.config.GlobalConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Ziad")
							.lastName("ABALIL")
							.email("ziadabalil@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Ziad")
							.lastName("Abalil")
							.email("ziadabalil@gmail.com")
							.build()

			);
			customerRepository.saveAll(customerList);
		};
	}

}
