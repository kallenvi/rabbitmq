package com.rabbit.demo;

import com.rabbit.demo.test.WLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {
    private static final Logger log = LoggerFactory.getLogger(RabbitmqApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
        System.out.println(System.getProperty("user.dir"));
        log.info("111");
    }

}
