package com.bpawan.halexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@EnableEntityLinks
public class HalExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HalExampleApplication.class, args);
    }
}
