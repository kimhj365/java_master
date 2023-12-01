package chap11.object;

public class ObjectExe {
	
	public static void main(String[] args) {
	
	//equals()
	Object obj1 = new Object();
	Object obj2 = new Object();
	// Object의 equals(): 객체의 주소값을 비교.
	System.out.println(obj1.equals(obj2));	// false.
	 
	String str1 = new String("Hello");
	String str2 = new String("Hello");
	// String의 equals(): 객체의 내용을 비교
	System.out.println(str1.equals(str2));	// true.
	
	Member mem1 = new Member("홍길동", 20);
	Member mem2 = new Member("홍길동", 22);
	System.out.println(mem1.equals(mem2));	// false => 재정의시 true/
	
	}
}
