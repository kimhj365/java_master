package chap11.object;

public class WrapperExe {

	public static void main(String[] args) {

		int i1 = 10;		// 정수형 변수
		Integer i2 = new Integer(20);	// 정수 클래스 타입 
		i1 = Integer.valueOf("30");
		i1 = Integer.parseInt("40");
		
		double d1 = 10.0;
		double d2 = new Double(10.1);
		d1 = Double.valueOf(10.2);
		d1 = Double.valueOf(10.3);
		
	}

}
