package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable
{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(new Date());
			try {
				TimeUnit.SECONDS.sleep(2);
			}catch(InterruptedException e) {
				System.out.println("FileClock is interrupted!");
			}
		}
	}
	public static void main(String[] args) {
		FileClock clock = new FileClock();
		Thread t1 = new Thread(clock);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}

}
