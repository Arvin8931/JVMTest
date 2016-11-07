package proxy;

import java.lang.reflect.Method;

public class MethodInvoke {

	public int add (int i, int j){
		return i+j;
	}
	
	public static void main(String[] args) throws Exception{
		Class<MethodInvoke> clazz = MethodInvoke.class;
		MethodInvoke object = clazz.newInstance();
		Method method = clazz.getMethod("add",new Class[]{int.class,int.class});
		Object result = method.invoke(object,new Object[]{10,10});
		System.out.println(result);
	}
}
