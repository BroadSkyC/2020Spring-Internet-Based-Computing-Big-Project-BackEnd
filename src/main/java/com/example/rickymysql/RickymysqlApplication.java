package com.example.rickymysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.rickymysql.mapper")
@SpringBootApplication
public class RickymysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickymysqlApplication.class, args);
    }

}
