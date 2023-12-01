package chap07.abstracts;

public class Bird extends Animal{

	@Override
	public void sound() {
		//추상 클래스를 상속하는 자식 클래스는 추상 메소드 구현 의무.
		//부모 클래스의 추상 메소드 오버라이드.
		
		System.out.println("짹짹");
	}

	
}
