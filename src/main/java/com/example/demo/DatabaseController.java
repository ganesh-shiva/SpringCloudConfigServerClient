package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DatabaseController {
	
	@Value("${mongodb.database}")
	String mongodbDatabase;
	@Value("${mongodb.host}")
    String mongodbHost;
	@Value("${mongodb.port}")
    String mongodbPort;
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbDetails() {
		Map<String, String> info = new HashMap<>(); 
		info.put("mongodbDatabase", mongodbDatabase);
		info.put("mongodbHost", mongodbHost);
		info.put("mongodbPort", mongodbPort);
		return info.toString();
	}
}