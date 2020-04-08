package com.richard.danis.www.ouath2;

import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * Entry point of the application.
 */
@SpringBootApplication
public class Starter extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder
                .banner(new ResourceBanner(new DefaultResourceLoader().getResource("banner.txt")))
                .sources(Starter.class);

        return builder;
    }

    /**
     * Main method of the application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}
