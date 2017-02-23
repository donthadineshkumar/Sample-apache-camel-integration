package com.nisum;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author dineshdontha
 *
 * A sample Camel route that triggers from a timer and calls a bean & prints a system out
 * 
 * Use @Component to make Camel auto detect this route when starting
 *
 */
@Component
public class SampleRouter extends RouteBuilder{

	/*
	 * this method prints the message in the console
	 * for every 2 secs.
	 * 
	 * this route uses timer component. & trigggers for 2 secs
	 * 
	 * on startup of App, the SampleRouter is registered as a bean
	 * 
	 * 
	 * */
	@Override
	public void configure() throws Exception {
		
		//from - creates a new route from the given URI
		from("timer:timerComponent?period={{timer.period}}")
			.transform(method("someBean","getMessage")) //transform - adds a processor which sets body on OUT message
			.to("stream:out"); //sends the exchange to the given endpoint.
		
		
	}

}
