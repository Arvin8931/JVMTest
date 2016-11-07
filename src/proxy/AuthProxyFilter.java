package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class AuthProxyFilter implements CallbackFilter {
	
	private static final int AUTH_NEED = 0;
	private static final int AUTH_NOT_NEED = 1;

	@Override
	public int accept(Method paramMethod) {
		// TODO Auto-generated method stub
		if (paramMethod.getName().equals("query")) {
			return AUTH_NOT_NEED;
		}
		return AUTH_NEED;
	}

}
