package chap13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {
		
		// 배열.
		// 맨 앞에 요소 타입 선언.
		String[] strs = {"Mon", "Tue", "Wed"};
		// 요소 추가.
		strs[0] = "Thr";
		// 요소 삭제: null 값 대입(빈 공간 남음).
		strs[0] = null;
		//길이: .length
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			
		}
		
		
		// List 컬렉션: 꺾쇠 안에 요소 타입 선언, 크기 정하지 않음.
		List<String> list = new ArrayList<String>();
		// 요소 추가.
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		// 요소 삭제: 인덱스 or 값(빈 공간 없이 자리 당겨짐).
		list.remove(0);	// "Apple" 삭제.
		list.remove("Banana"); // "banana" 삭제.
		// 요소 변경
		list.set(0, "체리");
		// 전체 요소 삭제.
		list.clear();		
		// 길이: .size() 메소드
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 컬렉션의 크기 변경.
		for (int i = 0; i < 100; i++) {
			list.add("" + i);
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		// 이름 저장
		List<String> names = new ArrayList<String>();
		names.add("홍길동");	// 0: 첫번째.
		names.add("고길동");	// 1: 두번째.
		names.add("박철수");	// 2: 세번째.
		
		String search = "길동";
		int count = 0;	
		for(String str : names) {
			if(str.indexOf(search) != -1) {
				count++;
			}
		}
		System.out.printf("%s 중 \"%s\"과 일치하는 이름: %d명\n",names, search, count);
		
	}
}
