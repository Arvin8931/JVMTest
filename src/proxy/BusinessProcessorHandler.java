package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BusinessProcessorHandler implements InvocationHandler {
	
	public Object target = null;
	
	BusinessProcessorHandler (Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before process");
		Object result = method.invoke(target, args);
		System.out.println("after process");
		return result;
	}

}
