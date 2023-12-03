package todo.p20231201;

public class CalenderExe {
	public static void main(String[] args) {
		// 12월 달력 만들기(금요일부터 시작).
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		int j;
		for(j = 0; j < 5; j++) {
			System.out.printf("%4s", " ");
		}
		
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if((i + j) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n========== the end ==========");
	}
}
