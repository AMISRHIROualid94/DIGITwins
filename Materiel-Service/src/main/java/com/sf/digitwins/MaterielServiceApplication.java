package com.sf.digitwins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MaterielServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterielServiceApplication.class, args);
    }

}
