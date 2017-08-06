package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	private Date startDate;
	
	
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.println("Starting thread "+Thread.currentThread().getId()+" at "+ startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing thread "+Thread.currentThread().getId()+" at "+ startDate);
	}
	
	public static void main(String[] args) {
		UnsafeTask task = new UnsafeTask();
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
