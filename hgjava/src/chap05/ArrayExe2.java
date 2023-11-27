package chap05;

public class ArrayExe2 {

	public static void main(String[] args) {
		
		// 정수를 담을 수 있는 배열을 생성(크기는 10의 정수를 저장)
		int[] intAry = new int[10];
		for(int i = 0; i < intAry.length; i++) {
			// intAry => 10 ~100 저장
			intAry[i] = 10 * (i + 1);
			// 출력
			System.out.println(intAry[i]);
		}
		
		// 출력 : 확장 for문
		int sum = 0;	// 50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		for(int num : intAry) {	// num에 배열의 "값"을 반복해서 저장
			System.out.println(num);
			// 50보다 큰 수를 sum에 누적합
			if(num > 50) {
				sum += num;	
				count++;
			}
		}
		avg = (double)sum / count;
		
		System.out.println("50보다 큰 수의 합계 : " + sum);
		System.out.println("50보다 큰 수의 평균 : " + avg);
	}

}
