package chap07.casting;

public class MainExe {

	public static void main(String[] args) {
		
		double d1 = 100;
		int n1 = (int) 100.0;
		
		// 자동 형변환(promotion).
		Parent p1 = new Child();	// 자식 클래스는 부모 클래스로 자동 형변환.
		
		// 강제 형변환(casting).
		// Child c1 = (Child)new Parent();	// 부모 클래스는 자식 클래스로 강제 형변환 필요.
				
		// 강제 형변환.
		// 자식 인스턴스를 담고 있는 부모 인스턴스만 자식 클래스로 강제 형변환 가능.
		// == 부모 클래스로 형변환 된 적 있는 인스턴스만 다시 자식 클래스로 형변환 가능
		// 에러: 컴파일에러 / 실행에러.
		Parent p2 = new Parent();
		Child c2 = new Child();
		
		 p2 = c2;
		
		 //형변환 전에 인스턴스 유형 체크
		 if(p2 instanceof Child) {
			 Child c3 = (Child) p2;
			 System.out.println("실행완료");
		 }
		System.out.println("end of prog.");
	}

}
