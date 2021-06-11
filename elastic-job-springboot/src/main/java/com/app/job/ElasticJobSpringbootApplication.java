package com.app.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author root
 */
@SpringBootApplication
@MapperScan("com.app.job.*.mapper")
public class ElasticJobSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticJobSpringbootApplication.class, args);
    }

}
