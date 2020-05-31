package com.love4code.sendfile2activeMQ;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class File2ActiveMQ {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		
		context.addComponent("jms", (Component)JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:input_box?noop=true")
				.to("activemq:queue:my_queue");
			}
		});
		
		while(true)
			context.start();
		
	}
}
