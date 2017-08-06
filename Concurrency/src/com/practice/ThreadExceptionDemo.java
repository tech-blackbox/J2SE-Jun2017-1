package com.practice;

public class ThreadExceptionDemo implements Runnable{
	@Override
	public void run() {
		int x = Integer.parseInt("Test");
	}
	
	public static void main(String[] args) {
		ThreadExceptionDemo tDemo = new ThreadExceptionDemo();
		Thread t = new Thread(tDemo, "Demo Thread");
		t.setUncaughtExceptionHandler(new MyThreadExceptionHandler());
		t.start();
		
	}
}
