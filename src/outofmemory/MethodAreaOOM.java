package outofmemory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class MethodAreaOOM {
	
	public static void  main (String[] args) throws NoSuchMethodException, SecurityException{
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object object, Method method, Object[] objects,
						MethodProxy proxy) throws Throwable {
					// TODO Auto-generated method stub
					return proxy.invokeSuper(object, objects);
				}
			});
			enhancer.create();
			System.out.println("");
		}
	}
	static class OOMObject{
		public void print(){
			System.out.println("print execute");
		}
	}
}
