package com.rodes.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring/appServlet/servlet-context.xml")
@ComponentScan(basePackages="com.rodes")
public class MvcConfig {

}
