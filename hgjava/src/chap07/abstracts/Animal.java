package chap07.abstracts;

//추상 클래스.
public abstract class Animal {

	private String name;
	
	public Animal() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNeme() {
		return name;
	}
	
	// 추상 메소드.
	public abstract void sound();
	
}
