package com.nit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nit.interceptor.BrowserRestrictionInterceptor;
import com.nit.interceptor.TimeCheckInterceptor;

@Component
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private TimeCheckInterceptor tci;
	
	@Autowired
	private BrowserRestrictionInterceptor bri;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyWebMvcConfigurer.addInterceptors()");
		
		registry.addInterceptor(tci);
		registry.addInterceptor(bri);
	}
}
