package com.geo.ignite;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.geo.ignite.jpaRepository")
@EntityScan(basePackages = {"com.geo.ignite.model","co.id.artslv.lib"})
@EnableIgniteRepositories(basePackages = "com.geo.ignite.igniteRepository")
public class IgniteSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgniteSpringBootApplication.class, args);
	}
}
