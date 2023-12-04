package chap11.object;

public class MathExe {

	public static void main(String[] args) {

		double a = -1.5;
		
		long result = Math.round(a);
		System.out.println("round: " + result);
		
		double result2 = Math.rint(a);	
		System.out.println("rint: " + result2);
		
		for (int i = 1; i <= 10; i++) {
			int r = (int)(Math.random() * (100 - 61 + 1) + 61 );
			System.out.println(r);
		}
		
		// Q. 1 ~ 6 까지 랜덤 발생 => 중복되지 않게 배열에 저장.
		int[] numbers = new int[5];
		for(int i = 0; i < 5; i++)  {
			boolean check = true;
			
			// 1~6 랜덤 발생
			int dice = (int)(Math.random() * 6 + 1);
			
			// 배열 중 랜덤값과 일치하는 값 체크.
			for(int j = 0; j < 5; j++) {
				if(dice == numbers[j]) {
					check = false;
				}
			}
			
			// 중복 값 없을 시 배열에 저장.
			if(check == true)
				numbers[i] = dice;
			// 중복 값 있을시 => 다시 한번 더 랜덤 돌림.
			else {
				i--;
				continue;	// 
			}
				
			System.out.println(numbers[i]);
		}
		
	}

}
