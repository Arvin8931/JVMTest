package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AuthProxy implements MethodInterceptor {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthProxy(String name){
		this.name = name;
	}

	@Override
	public Object intercept(Object paramObject, Method paramMethod,
			Object[] paramArrayOfObject, MethodProxy paramMethodProxy)
			throws Throwable {
		if (!"test".equals(this.name)) {
			System.out.println("have no auth");
			return null;
		}
		return paramMethodProxy.invokeSuper(paramObject, paramArrayOfObject);
	}

}
