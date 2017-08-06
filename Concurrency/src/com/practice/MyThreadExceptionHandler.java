package com.practice;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyThreadExceptionHandler implements UncaughtExceptionHandler {
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("An exception has occured in thread : "+ t.getName());
		System.out.println("Exception : "+ e.getMessage());
		System.out.println("State of Thread : "+t.getState());
		e.printStackTrace(System.out);
	}

}
