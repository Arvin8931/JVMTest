package classLoader;

public class StaticResolution {

	static abstract class Human{
		
	}
	
	static class Man extends Human{
		
	}
	
	static class Woman extends Human{
		
	}
	
	public void sayHello(Human human){
		System.out.println("human hello");
	}
	
	public void sayHello(Man man){
		System.out.println("man hello");
	}
	
	public void sayHello(Woman woman){
		System.out.println("woman hello");
	}
	
	
	public static void main(){
		Human man = new Man();
		
		Human woman = new Woman();
		
		StaticResolution sr = new StaticResolution();
		sr.sayHello(man);
		sr.sayHello(woman);
	}
}
