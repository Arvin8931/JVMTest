package MemAllocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestThreadMonitor {

	/**
	 * 线程死循环
	 */
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println("testBusyThread");
				}
				
			}
		}, "testBusyThread");
		
		thread.start();
	}
	
	/**
	 * 线程锁等待
	 */
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		},"testLockThread");
		
		thread.start();
	}
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			createBusyThread();
			br.readLine();
			Object obj = new Object();
			createLockThread(obj);
			obj.notify();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
