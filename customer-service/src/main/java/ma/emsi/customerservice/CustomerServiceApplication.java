package ma.emsi.customerservice;

import ma.emsi.customerservice.entities.Customer;
import ma.emsi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Hajar").email("hajar@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Mehdi").email("mehdi@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Hind").email("hind@gmail.com")
					.build());
			customerRepository.findAll().forEach(customer -> {
				System.out.println("---------------");
				System.out.println(customer.getId());
				System.out.println(customer.getEmail());
				System.out.println(customer.getName());
			});
		};
	}

}
