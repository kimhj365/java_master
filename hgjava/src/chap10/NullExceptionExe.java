package chap10;

public class NullExceptionExe {
	public static void main(String[] args) {
		
		//Null 값을 참조할 경우 [주의]
		String name = "Hong";
		name = null;
		String menu = "2";
		int[] numAry = {2, 5, 7};

		try {
			name = "";
			System.out.println(name.toString());
			int num = Integer.parseInt(menu);
			System.out.println("입력값은 " + num);
			System.out.println(numAry[3]);
			
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("null 예외 발생");
			// e.printStackTrace();
//		} catch (NumberFormatException ne) {
//			System.out.println("숫자값을 입력하세요");
		} catch (Exception ee) {
			System.out.println("알 수 없는 예외");
		}
		
		System.out.println("end of prog.");
	}
}
