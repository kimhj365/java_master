package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = null;		// Friend 참조 타입 변수 요소로 갖는 배열 friends 정의
	
	// case 1 친구 배열 크기 입력
	public static void friendNum() {
		System.out.print("친구 수 입력 >> ");
		int frndNum = Integer.parseInt(scn.nextLine());
		friends = new Friend[frndNum];	// friends 배열의 크기 입력
	}
	
	// case 2 친구 정보 입력
	public static void addFriend() {
		System.out.println("친구 정보 입력 >> ");
		for(int i = 0; i < friends.length; i++) {
			Friend friend = new Friend();	// Friend 클래스의 인스턴스 friend 생성
			System.out.printf("[%d]번째 친구 이름 입력 >> ", i);
			friend.name = scn.nextLine();
			System.out.printf("[%d]번째 친구 연락처 입력 >> ", i);
			friend.telNum = scn.nextLine(); 
			System.out.printf("[%d]번째 친구 혈액형 입력 >> ", i);
			friend.bloodType = scn.nextLine();
			friends[i] = friend;	// friend 인스턴스를 friends 배열의 요소로 대입
		}
	}
	
	// case 3 전체 친구 목록 조회
	public static void searchFriend() {
		System.out.println("친구 목록 >> ");
		for(Friend frnd : friends) {
			System.out.printf("이름 : %s\t 연락처 : %s\t 혈액형 : %s\n",frnd.name, frnd.telNum, frnd.bloodType);
		}
	}
	
	// case 4 친구 정보 수정
	public static void modify() {
		System.out.print("조회할 이름 입력 >> ");
		String srcName = scn.nextLine();
		boolean exist = false;	// 변경 이력 조회
		for(int i = 0; i < friends.length; i++) {
			if(srcName.equals(friends[i].name)) {
				System.out.print("변경할 연락처 입력 >> ");
				friends[i].telNum = scn.nextLine();
				System.out.print("변경할 혈액형 입력 >> ");
				friends[i].bloodType = scn.nextLine();
				exist = true;
			}
		}
		if(!exist) {
			System.out.println("찾는 이름이 없습니다");
		}
	}

	public static void main(String[] args) {
	
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("| 1.친구수 2.입력 3.목록 4.수정 5.종료 |");
			System.out.println("----------------------------------------");
			System.out.print("번호를 입력하세요 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				friendNum();
				break;
			case 2:
				addFriend();
				break;
			case 3:
				searchFriend();
				break;
			case 4:
				modify();
				break;
			case 5:
				System.out.println("종료 >> ");
				run = false;
				break;
			}
			
		}
		System.out.println("end program");
		
	} // end of main()

}	// end of FriendApp
