package classLoader;

public class DeadLoopClass{
	
	static{
		if(true){
			
			System.out.println(Thread.currentThread() + "is initing");
			while(true){}
			
		}
	}
	
	
	
	public static void main(String args){
		Runnable script = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				DeadLoopClass dClass = new DeadLoopClass();
				System.out.println(Thread.currentThread() + "run over");
				
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
	
}


