package com.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name) {
		this.name=name;
		counter =0;
		stats = new ArrayList<String>();
	}
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r,name+"-Thread_"+counter);
		counter ++;
		stats.add(String.format("Create thread %d with name %s on %s\n",t.getId(), t.getName(), new Date()));
		return t;
	}
	
	public String getStats() {
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while(it.hasNext()){
			sb.append(it.next());
			sb.append("\n");
		}
		return sb.toString();
	}

}
