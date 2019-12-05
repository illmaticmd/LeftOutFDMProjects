package com.fdmgroup.demos.town;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TownSimulationXML {
public static void main(String[] args) {
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
}
}
