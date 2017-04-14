package com.ukyi.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	private ModelAndView errorHandler(Exception e){
		ModelAndView mav = new ModelAndView();
		   mav.addObject("exception", e);
		   mav.setViewName("error/error_common");
		   
		return mav;
	}
}