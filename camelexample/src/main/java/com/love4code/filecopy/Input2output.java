package com.love4code.filecopy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Input2output {
	public static void main(String[] args) throws Exception {
		final CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:input_box?noop=true")
				.to("file:output_Box");
			}
			

		});
		
		while(true) {
			context.start();
		}
	}
}
