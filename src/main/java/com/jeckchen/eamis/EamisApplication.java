package com.jeckchen.eamis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import javax.swing.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jeckchen"})
public class EamisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamisApplication.class, args);
    }

}
