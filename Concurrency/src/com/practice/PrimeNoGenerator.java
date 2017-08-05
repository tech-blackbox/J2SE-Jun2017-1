package com.practice;

public class PrimeNoGenerator extends Thread {
	
	private boolean isPrime(long number) {
		if (number<=2)
			return true;
		for(long i=2; i<number; i++) {
			if(number%i == 0)
				return false;
		}
		return true;
	}
	
	@Override
	public void run() {
		
		long number=1L;
		
		while(true) {
			if(isPrime(number))
				System.out.println("Prime No : "+ number);
			if(isInterrupted()) {
				System.out.println("Prime No Generator is interrupted!");
				return;
			}
			number++;
		}
		
		
	}

	public static void main(String[] args) {
		
		Thread t1 = new PrimeNoGenerator();
		t1.start();
		try {
			System.out.println("Sleeping now..");
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Got up. Interruptig Thread now..");
		t1.interrupt();

	}

}
