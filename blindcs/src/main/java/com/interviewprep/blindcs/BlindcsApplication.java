package com.interviewprep.blindcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlindcsApplication {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World1";
    }

    public static void main(String[] args) {
        SpringApplication.run(BlindcsApplication.class, args);


        Test1 t1 = new Test1();
        System.out.println(t1.test());
    }

}


