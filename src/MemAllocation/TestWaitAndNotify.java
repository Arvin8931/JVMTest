package MemAllocation;

public class TestWaitAndNotify {
	
	class Account{
		String name = "name1";
		double balance = 0.0;
		
		Account(){}
		
		Account(String name, double balance){
			this.name = name;
			this.balance = balance;
		}
		
		public void deposit(double money){
			System.out.println("存钱之前金额：" + this.balance);
			this.balance += money;
			System.out.println("存钱之后金额：" + this.balance);
		}
		
		public void draw(double money){
			System.out.println("取钱之前金额：" + this.balance);
			this.balance -= money;
			System.out.println("取钱之后金额：" + this.balance);
		}
	}
	
	
	Account account = new Account();
	
	class DepositThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++) {
					synchronized (account) {
						System.out.println("存钱线程的for:" + i);
						account.deposit(10);
						account.notify();
//						account.notifyAll();
					}
				}
		}
	}
	
	class WithDrawThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for (int i = 0; i < 100; i++) {
					synchronized(account){
						System.out.println("取钱线程的for:" + i);
						while (account.balance<=0) {
							account.wait();
						}
						account.draw(50);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void test(){
		DepositThread depositThread = new DepositThread();
		WithDrawThread withDrawThread = new WithDrawThread();
		
		depositThread.start();
		withDrawThread.start();
	}
	
	public static void main (String[] args){
		TestWaitAndNotify testWaitAndNotify = new TestWaitAndNotify();
		testWaitAndNotify.test();
		
	}
}
