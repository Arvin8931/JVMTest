package MemAllocation;

public class TestAllocation {
	private static final int _1M = 1024*1024;
	
	public static void main(String[] args){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[_1M / 4];
		allocation2 = new byte[4 * _1M];
		allocation3 = new byte[4 * _1M];
		allocation4 = new byte[_1M / 100];
		allocation3 = null;
		
		allocation3 = new byte[4 * _1M];
//		System.out.println(allocation1);
//		System.out.println(allocation2);
//		System.out.println(allocation3);
//		System.out.println(allocation4);
	}
}
