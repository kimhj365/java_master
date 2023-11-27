package chap05;

//복합적인 형태의 데이터 구조
class Friend{		//클래스 => 데이터 타입
	String name;	//필드
	int age;		//필드
	double height; 	//필드
}

public class ReferenceExe1 {
	
	public static void main(String[] args) {
		
		//기본 타입 : 변수에 값이 담겨져 있음
		int a = 10;
		int b = a;
		System.out.println("a = "+ a + ", b = " + b);
		
		a = 20;
		System.out.println("a = "+ a + ", b = " + b);	//a값 바꿔도 b값 그대로
		
		//참조 타입 : 변수에 주소값이 저장되어 있음
		//실제 값을 담는 것(X) => 실제 값의 주소를 담고 있음(O)
			
		String name = "신용권";	//주소값에 "신용권" 담고있는 주소
		
		String name1 = "신용권";				//name, name1 같은 메모리 주소 가리킴
		System.out.println(name == name1);		//true
		System.out.println(name.equals(name1));	//true
		
		String name2 = new String("신용권");	//새로운 메모리 주소 생성
		System.out.println(name == name2);		//false
		System.out.println(name.equals(name2));	//true
		
		Friend myFriend = new Friend();		//new => 힙 메모리상에 객체 생성
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend;		//값이 아닌 주소를 복사 
//		
//		myFriend.name = "홍길동";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend();
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend);	// 주소값 비교 => false
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
			System.out.println(yourFriend.name);	//null값 참조시 에러 발생
		} catch(Exception e) {						//예외 처리
			System.out.println("null값을 참조합니다.");
		}
		
		

		
		
	}

}
