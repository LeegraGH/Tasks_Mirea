package com.example.task_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.with.files.FileHasher;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(FileHasher.class, args);
    }

}
