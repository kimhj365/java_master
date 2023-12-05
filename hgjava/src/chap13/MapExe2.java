package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {

	public static void main(String[] args) {

		// HashMap 선언
		Map<Member, String> map;
		map = new HashMap<>();
		
		// 요소 추가.
		map.put(new Member("M001","홍길동", 100), "경기도 100번지");
		map.put(new Member("M002","김민수", 90), "서울시 200번지");
		map.put(new Member("M003","김현준", 80), "대구시 300번지");
		map.put(new Member("M001","홍길동", 100), "경기도 400번지");
		// 홍길동 키 값 같아보여도 각각 new로 생성한 별개의 인스턴스(물리적).
		// hashCode(), equals() 재정의하면 동일한 객체로 취급 가능(논리적)
		
		// 요소 삭제.
		map.remove(new Member("M001","홍길동", 100));
		
		// 요소 가져오기.
		// 1.
		// key => Set 컬렉션에 저장
		Set<Member> set = map.keySet();
		for(Member member : set) {
			System.out.println("key : " + member + ", value : " + map.get(member));
		}
		
		// 2. key, value => Set 컬렉션에 저장
		Set<Entry <Member, String>> entry = map.entrySet();	// key + value 한쌍 => entry
		for(Entry<Member, String> ent: entry) {
			System.out.println("key : " + ent.getKey() + ", val : " + ent.getValue());
		}
		
	}
	
}
