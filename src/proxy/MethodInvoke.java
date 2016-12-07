package proxy;

import java.lang.reflect.Method;

public class MethodInvoke {
	
	static{
		System.out.println("静态代码块");
	}
	
	MethodInvoke(){
		System.out.println("构造方法");
	}
	
	{
		System.out.println("非静态代码块");
	}

	public int add (int i, int j){
		return i+j;
	}
	
	public static void main(String[] args) throws Exception{
		Class<MethodInvoke> clazz = MethodInvoke.class;
		MethodInvoke object = clazz.newInstance();
		Method method = clazz.getMethod("add",new Class[]{int.class,int.class});
		Object result = method.invoke(object,new Object[]{10,10});
		System.out.println(result);
		System.out.println("------------");
		
		Class<?> t =  Class.forName("proxy.MethodInvoke");
		MethodInvoke m = (MethodInvoke)t.newInstance();
		int result1 = m.add(10, 10);
		System.out.println(result1);
		System.out.println("------------");
		
		Class<?> t1 =  Class.forName("proxy.MethodInvoke");
		Method m1 = t1.getMethod("add", int.class,int.class);
		int result2 = (int)m1.invoke(t1.newInstance(), 10,10);
		System.out.println(result2);
		System.out.println("------------");
		
		
		MethodInvoke mInvoke = new MethodInvoke();
		int result3 = mInvoke.add(10, 10);
		System.out.println(result3);
		
		
		
	}
}
