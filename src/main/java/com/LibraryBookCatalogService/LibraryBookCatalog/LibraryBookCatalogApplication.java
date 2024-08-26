package com.LibraryBookCatalogService.LibraryBookCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class LibraryBookCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBookCatalogApplication.class, args);
	}

}
