package com.s0qva.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.s0qva.core.entity")
@SpringBootApplication(scanBasePackages = "com.s0qva.domain")
public class ApiLauncher {

    public static void main(String[] args) {
        SpringApplication.run(ApiLauncher.class);
    }
}
