package com.fdmgroup.demos.town;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TownSimulationAnnotation {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TownSimulationAnnotation.class);

		
		
		
		context.close();
	}

}
