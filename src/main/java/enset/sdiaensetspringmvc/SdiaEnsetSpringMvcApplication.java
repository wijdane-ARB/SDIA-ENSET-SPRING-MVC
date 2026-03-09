package enset.sdiaensetspringmvc;

import enset.sdiaensetspringmvc.entities.Products;
import enset.sdiaensetspringmvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SdiaEnsetSpringMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(SdiaEnsetSpringMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Products.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
                    .build());
                productRepository.save(Products.builder()
                        .name("Printer")
                        .price(1200)
                        .quantity(11)
                        .build());
                productRepository.save(Products.builder()
                        .name("Smartphone")
                        .price(12000)
                        .quantity(33)
                        .build());
                productRepository.findAll().forEach(p -> {
                    System.out.println(p.toString());
                });
        };

    }

}
