package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;
import com.example.demo.entity.ifaces.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	
	
	@Bean
	CommandLineRunner runner(ProductRepository repo) {

		// Lambda

		return args ->{	
		
		repo.save(new Product(102, "Samsung TV", 550000, LocalDate.of(2043,3, 15)));
			
		};
	}
	
	
	// Anonymous class
	
//		return new CommandLineRunner() {
//			
//			@Autowired
//			ProductRepository repo;
//			
//			@Override
//			public void run(String... args) throws Exception {
//
//				
//				repo.save(new Product(101, "sony tv", 450000, LocalDate.of(2045, 2, 14)));
//			}
//		};
//	}
			
}
