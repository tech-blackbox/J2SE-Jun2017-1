package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};
	
	
	
	@Override
	public void run() {
		System.out.println("Starting thread "+Thread.currentThread().getId()+" at "+ startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing thread "+Thread.currentThread().getId()+" at "+ startDate.get());
	}
	
	public static void main(String[] args) {
		SafeTask task = new SafeTask();
		for (int i = 0; i<5; i++) {
			Thread t = new Thread(task);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
