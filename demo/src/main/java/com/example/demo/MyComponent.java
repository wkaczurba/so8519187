package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyComponent implements InitializingBean {
	
	@Value("${mycomponent.value:Magic}")
	public String value;
	
	public MyComponent() {
		log.info("MyComponent in constructor: [{}]", value); // (0) displays: Null [properties not set yet]
	}
	
	@PostConstruct
	public void postConstruct() {
		log.info("MyComponent in postConstruct: [{}]", value); // (1) displays: Magic
	}

	@Override // (equivalent to init-method in XML; overrides InitializingBean.afterPropertiesSet()
	public void afterPropertiesSet() {
		log.info("MyComponent in afterPropertiesSet: [{}]", value);  // (2) displays: Magic
	}	

	@PreDestroy
	public void preDestroy() {
		log.info("MyComponent in preDestroy: [{}], self=[{}]", value); // (3) displays: 
	}
}
