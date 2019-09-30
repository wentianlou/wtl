package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author wentianlou
 * Date 2019/9/30 10:31
 **/
@EnableScheduling
@SpringBootApplication
public class SchedulingDemo {
    public static void main(String[] args) {
        SpringApplication.run(SchedulingDemo.class, args);
    }
}
