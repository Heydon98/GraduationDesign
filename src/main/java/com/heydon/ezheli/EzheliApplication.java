package com.heydon.ezheli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.heydon.ezheli.dao")
public class EzheliApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzheliApplication.class, args);
    }
}

