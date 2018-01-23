package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHelloApplication{

	public static void main(String[] args) {
		SpringApplication.run(EurekaHelloApplication.class, args);
	}
}

@RestController
class MyController{
	
	RestTemplate restTemplate = new RestTemplate();
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }
    
    @RequestMapping(value="/getInstanceId/{host}/{port}", method= RequestMethod.GET)
    public String getInstanceId(@PathVariable String host, @PathVariable String port) {
    	
    	String url = "http://" + host + ":" + port + "/instanceId";
    	
    	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>(){} );

    	return response.getBody().toString();
    }
    
}
