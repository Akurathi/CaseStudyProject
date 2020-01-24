package com.example.customer;

import com.example.customer.controller.CustomerController;
import com.example.customer.model.Customer;


import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerApplication implements ExitCodeGenerator {

	private static ConfigurableApplicationContext context;

	private static CustomerController customerController;

	public static void main(String[] args) {
		context = SpringApplication.run(CustomerApplication.class, args);

		testApp();
	}

//	@Bean(initMethod = "start", destroyMethod = "stop")
//	public Server h2Server() throws SQLException {
//		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//	}

	public static void testApp(){
		System.out.println();
		customerController = (CustomerController) context.getBean("customerController");

		// create customers
//		Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).withOwner(owner1).build();
		Customer customer1 = Customer.builder().withFirstName("SriHarsha").withLastName("Akurathi").withEmail("sunnyakurathi@gmail.com").build();
		Customer customer2 = Customer.builder().withFirstName("Sravani").withLastName("Goli").withEmail("sravs.goli@gmail.com").build();

		customerController.add(customer1);
		customerController.add(customer2);

		display(customerController.getAll());
		display(customerController.getByEmail("sunnyakurathi@gmail.com"));
	}

	private static void display(Object obj) {

		if (obj instanceof List) {

			List<?> list = (List) obj;
			for (Object o : list) {
				System.out.println("\t" + o);
			}

		} else {

			System.out.println(obj);

		}

		System.out.println();
	}

	@Override
	public int getExitCode() {
		return 42;
	}

}
