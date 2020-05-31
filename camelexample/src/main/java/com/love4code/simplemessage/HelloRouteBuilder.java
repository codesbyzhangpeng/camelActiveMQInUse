package com.love4code.simplemessage;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

public class HelloRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("Hello Camel World!");
	}
}
