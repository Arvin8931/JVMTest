package classLoader;

public class ConstantClass{
	
	static{
		System.out.println("constant class init");
	}
	
	public static final String HELLO_WORLD = "hello world";
}


