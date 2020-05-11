package org.javaboy.vhr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "org.javaboy.vhr.*")
public class VhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class, args);
    }

}
