package proxy;

public class BusinessProcessImpl implements BusinessProcess {

	@Override
	public void before() {
		System.out.println("before method called");
	}

	@Override
	public void processBusiness() {
		System.out.println("processBusiness method called");
	}

	@Override
	public void after() {
		System.out.println("after method called");
	}

}
