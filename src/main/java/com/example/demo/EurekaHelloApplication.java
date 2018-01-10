package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHelloApplication.class, args);
	}
}

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ipaddress() throws Exception {
        return "Hello";
    }
}
