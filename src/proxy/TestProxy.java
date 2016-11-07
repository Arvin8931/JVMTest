package proxy;

import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args){
		BusinessProcessImpl bpImpl = new BusinessProcessImpl();
		BusinessProcessorHandler bph = new BusinessProcessorHandler(bpImpl);
		BusinessProcess bp = (BusinessProcess)Proxy.newProxyInstance(bpImpl.getClass().getClassLoader(), bpImpl.getClass().getInterfaces(), bph);
		bp.before();
		bp.processBusiness();
		bp.after();
	}
}
