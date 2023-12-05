package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {
		
		// Map.
		// 키(key) : 값(value) 쌍으로 구성 => 엔트리.
		Map<String, Integer> map = new HashMap<>();
		
		// 추가 : put(키, 값).
		map.put("홍길동", 80);
		map.put("고길동", 85);
		map.put("김현준", 100);
		map.put("홍길동", 90);
		
		// 값 가져오기 : get(키)
		Integer result = map.get("홍길동");
		System.out.println("홍길동의 값 : " + result);
		
		// 전체목록 가져오기 : Set 컬렉션 사용
		Set<String> set = map.keySet();	// Set: 여러개의 키 값 갖고 있음
		for(String key : set) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
	}
}
