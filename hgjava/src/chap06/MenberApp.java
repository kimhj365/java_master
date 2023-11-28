package chap06;

public class MenberApp {

	public static void main(String[] args) {
		Member[] members = new Member[10];
		
		members[0] = new Member(1, "Hong", "010-1111-2222", "Men") ;
		members[1] = new Member(2, "Park", "010-3333-4444", "Women");
		members[2] = new Member(3, "Choi", "010-5555-6666", "Women");
		
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null && members[i].getGender().equals("Women")) 
				System.out.println(members[i].showAllInfo());
		}
	}

	static void test1() {
		Member mem1 = new Member(); // 인스턴스 생성 (생성자)
		System.out.println(mem1);
//		mem1.memberNo = 10;
//		mem1.memberName = "Hong";
//		mem1.phone = "010-1234-5678";
//		mem1.gender = "Men";
		mem1.setMemberNo(10);
		mem1.setMemberName("Hong");
		mem1.setPhone("010-1234-5678");
		mem1.setGender("Men");
		
		mem1.showInfo();
		
		Member mem2 = new Member(11, "Hwang");
//		mem2.phone = "010-3333-4444";
		mem2.setPhone("010-3333-4444");
		mem2.showInfo();
		
		Member mem3 = new Member(12, "Park", "010-5678-8765", "Women");
		mem3.showInfo();	// 반환유형 : void
		String msg = mem3.showAllInfo();	// 반환유형 : String
		System.out.println(msg);
	}	// end of test1
}
