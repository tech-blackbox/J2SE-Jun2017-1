package com.practice;

import java.util.concurrent.TimeUnit;

public class ThreadFactoryDemo implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThreadFactory fact = new MyThreadFactory("MyFirstThreadFactory");
		ThreadFactoryDemo tDemo = new ThreadFactoryDemo();
		Thread t;
		System.out.println("Starting the threads");
		for(int i =0; i<10; i++)
		{
			t = fact.newThread(tDemo);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Factory Stats----");
		System.out.println(fact.getStats());
		
		}
}
