package com.practice;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SearchFile implements Runnable {
	
	private String fileName;
	private String intialPath;
	
	public SearchFile(String fileName, String initialPath) {
		this.fileName = fileName;
		this.intialPath = initialPath;
	}
	
	public void run() {
		File file = new File(intialPath);
		if(file.isDirectory()) {
			try {
				processDirectory(file);
			}catch(InterruptedException e) {
				System.out.println("Couldn't find the file in desired time!");
			}
		}
	}
	
	
	private void processDirectory(File file) throws InterruptedException {
		File list[] = file.listFiles();
		if(list!=null) {
			for(int i=0; i<list.length; i++) {
				//System.out.println("Found -- "+ list[i]);
				
				if(list[i].isDirectory())
					processDirectory(list[i]);
				else {
					if(list[i].getName().equals(fileName)) {
						
						System.out.println("File found - " + list[i].getAbsolutePath());
						if(Thread.interrupted()) {
							throw new InterruptedException();
						}
						
					}
						
				}
			}
		}
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	public static void main(String[] args) {
		
		SearchFile sf = new SearchFile("A.class", "E:\\");
		Thread t1 = new Thread(sf);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();

	}

}
