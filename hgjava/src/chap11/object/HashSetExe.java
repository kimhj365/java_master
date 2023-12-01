package chap11.object;

import java.util.HashSet;

public class HashSetExe {

	public static void main(String[] args) {

		// 배열 => 컬렉션(List, Set, Map)
		HashSet<String> set = new HashSet<String>();	// 중복값 허용하지 않는 배열?
		set.add("Hong");
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
		//set.add(new Member("Hong", 20));
		
		for(Object name : set) {
			System.out.println(name);
		}
		
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 22));
		members.add(new Member("홍길동", 20));
		
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
	}

}
