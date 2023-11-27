package chap05;

public class ArrayExe3 {

	public static void main(String[] args) {
		
		String[] nameArray = {"홍길동", "김길동", "홍길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int count = 0;
		
		for(String name : nameArray) {
			if(search.equals(name)) count++;
		}
		
		System.out.println(search + "은 총 " + count + "명 입니다.");
		
		
		//최대값, 최소값 찾기
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = scores[0];
		int minScore = scores[0];
		
		for(int num : scores) {
			if(num > maxScore) maxScore = num;
			if(num < minScore) minScore = num;
		}
		
		System.out.println("최대값 : " + maxScore);
		System.out.println("최소값 : " + minScore);
		
	}
}
