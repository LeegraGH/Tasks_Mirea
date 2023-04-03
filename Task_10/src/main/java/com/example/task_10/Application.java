package com.example.task_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private ApplicationContext context = new AnnotationConfigApplicationContext(ProgrammerConfig.class);
    private Programmer programmer;

    @Autowired
    public void run(String programmerBean) {
        programmer = context.getBean(programmerBean, Programmer.class);
        programmer.doCoding();
    }

}
