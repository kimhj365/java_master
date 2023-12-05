package chap13;

import java.util.*;

public class TypingSpeedGame {

	public static void main(String[] args) {
		// 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 하나씩 컬렉션에서 삭제.
		// 시작시점 ~ 종료시점까지 걸린 시간을 초 단위로 계산.
		// => ex. "완료하는데 35초가 걸림"
		
		Scanner scn = new Scanner(System.in);
		String word = "Total coffee acreage in the country is probably about 600,000 hectares";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();	// 배열을 List로 바꿈
		for (String str : words) {
			list.add(str);
		}
		
		System.out.print("< 타자연습 > \n시작하려면 enter를 입력하세요 \n>> ");
		scn.nextLine();
		long startTime = System.currentTimeMillis();
		
		while(true) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				String input = scn.nextLine();
				if(list.get(i).equals(input)) 
					list.remove(i);
			}
			if(list.size() == 0) {
				break;
			}
		}
		
		long finishTime = System.currentTimeMillis();
		System.out.println("종료!");
		
		long spendTime = (finishTime - startTime) / 1000;
		System.out.println("걸린 시간 : " + spendTime + "초");
		scn.close();
	}
}
