package com.nit.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		
		System.out.println("TimeCheckInterceptor.preHandle()");
		
		if(req.getServletPath().equalsIgnoreCase("/"))
			return true;
		
		//Get System date & time
		LocalDateTime ldt = LocalDateTime.now();
		
		//get current hour of the day
		int hour = ldt.getHour();
		
		if(hour<9 || hour>15) {
			RequestDispatcher rd= req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		
		return true;
	}
}
