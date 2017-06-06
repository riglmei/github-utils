/**
 * Created by riglesias
 */
package com.riglesias.githubutils.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.riglesias")
public class Application {

    public static void main(String... args) {

        ConfigurableApplicationContext applicationContext =
            SpringApplication.run(new Object[] {Application.class }, args);
        applicationContext.registerShutdownHook();

    }
}
