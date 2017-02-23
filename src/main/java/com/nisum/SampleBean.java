package com.nisum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("someBean")
public class SampleBean {

	@Value("${greeting}")
	private String message;
	
	public String getMessage(){
		return message;
	}
}
