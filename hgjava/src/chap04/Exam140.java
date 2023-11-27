package chap04;

public class Exam140 {

	public static void main(String[] args) {
		//ÁÖ»çÀ§ ¹øÈ£ »Ì±â
		int num = (int)(Math.random() * 6) + 1;
		if(num == 1) {
			System.out.println("1¹ø ³ª¿È");
		}
		else if(num == 2) {
			System.out.println("2¹ø ³ª¿È");
		}
		else if(num == 3) {
			System.out.println("3¹ø ³ª¿È");
		}
		else if(num == 4) {
			System.out.println("4¹ø ³ª¿È");
		}
		else if(num == 5) {
			System.out.println("5¹ø ³ª¿È");
		}
		else {
			System.out.println("6¹ø ³ª¿È");
		}
		
		switch(num) {
		case 1: System.out.println("s1¹ø ³ª¿È"); break;
		case 2: System.out.println("s2¹ø ³ª¿È"); break;
		case 3: System.out.println("s3¹ø ³ª¿È"); break;
		case 4: System.out.println("s4¹ø ³ª¿È"); break;
		case 5: System.out.println("s5¹ø ³ª¿È"); break;
		default: System.out.println("s6¹ø ³ª¿È");
		
		}
		
		
	}//end main()
	
}//end class
