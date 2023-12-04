package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {

	public static void main(String[] args) {
		
		List<Member> members = new ArrayList<>();	// 뒤에 꺾쇠 내용 안쓰면 앞에꺼로 알아서 인식함
		members.add(new Member("M-001", "홍길동", 1000));
		members.add(new Member("M-002", "김길동", 1500));
		members.add(new Member("M-003", "최인수", 2000));
		System.out.println(members.size());
		
		String search = "길동";
		int count = 0;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().indexOf(search) != -1//
					&& members.get(i).getPoint() >= 1500) {
				count++;
				members.remove(i);
			}
			
		}
		System.out.printf("\"%s\"과 이름이 일치하고 1500 이상인 사람: %d명\n", search, count);
		for(Member mem : members) {
			System.out.println(mem.getMemberName());
		}
	}
}
