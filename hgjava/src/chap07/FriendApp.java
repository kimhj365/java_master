package chap07;

import java.util.Scanner;

public class FriendApp {
	
	static Scanner scn = new Scanner(System.in);

	
	public static void main(String[] args) {

		boolean run = true;
		FriendExe.initData();
		
		while(run) {
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.등록 ┃ 2.목록 ┃ 3.상세조회 ┃ 4.종료 ┃");
			System.out.println("┗━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				addFriend(); 
				break;
			case 2:
				friendList(); 
				break;
			case 3:
				getFriend(); 
				break;
			default:
				System.out.println("종료합니다");
				run = false;
			}
		}
		System.out.println("end of program");
	} // end of main.
	
	// 1. 등록.
	private static void addFriend() {
		System.out.println("┌────────┬────────┬────────┬──────────┐");
		System.out.println("│ 1.친구 │ 2.학교 │ 3.회사 │ 4.나가기 │");
		System.out.println("└────────┴────────┴────────┴──────────┘");
		System.out.print("분류를 선택하세요 \n>> ");
		int subMenu = Integer.parseInt(scn.nextLine());

		if(subMenu == 4) return;
		
		System.out.print("이름 \n>> ");
		String name = scn.nextLine();
		System.out.print("연락처 \n>> ");
		String phone = scn.nextLine();
		
		Friend friend = null; // UnivFriend, CompFriend 인스턴스 대입 가능.
		
		// 친구: 이름, 연락처.
		if(subMenu == 1 ) {
			friend = new Friend(name, phone);	// Friend 인스턴스.
		}
		// 학교: 이름, 연락처, 학교, 전공.
		else if(subMenu == 2) {
			System.out.print("학교 \n>> ");
			String univ = scn.nextLine();
			System.out.print("전공 \n>> ");
			String major = scn.nextLine();
			friend = new UnivFriend(name, phone, univ, major);
		}
		// 회사: 이름, 연락처, 회사, 부서.
		else if(subMenu == 3) {
			System.out.print("회사 \n>> ");
			String comp = scn.nextLine();
			System.out.print("부서 \n>> ");
			String dept = scn.nextLine();
			friend = new CompFriend(name, phone, comp, dept);
		}
		else {
			System.out.println("정확한 분류를 선택하세요");
			return;
		}
		// 배열에 추가
		if(FriendExe.addFriend(friend)) {
			System.out.println("친구 추가에 성공했습니다!");
		}
		else {
			System.out.println("친구 추가에 실패했습니다");
		}
		
	} 
	
	// 2. 목록.
	private static void friendList() {
		System.out.println("< 친구 목록 >");
		FriendExe.friendList();

	} 
	
	// 3. 단건 조회.
	private static void getFriend() { // 이름 조회, 연락처 조회
		System.out.println("┌────────┬──────────┬──────────┐");
		System.out.println("│ 1.이름 │ 2.연락처 │ 3.나가기 │");
		System.out.println("└────────┴──────────┴──────────┘");
		System.out.print("검색 분류를 입력하세요 \n>> ");
		int subMenu = Integer.parseInt(scn.nextLine());
		String searchCond = "";
		
		if(subMenu == 3) return;
		
		if(subMenu == 1) {
			System.out.print("이름을 입력하세요 \n>> ");
			searchCond = scn.nextLine();
			Friend[] friend = null; 
			friend = FriendExe.searchName(searchCond);
			
			boolean searchCheck = false;
			for (int i = 0; i < friend.length; i++) {
				if(friend[i] != null) {
					System.out.println("< 검색 결과 >");
					System.out.println(friend[i].showInfo());
					searchCheck = true;
				}
			}
			if(!searchCheck) {
				System.out.println("검색 결과가 없습니다");
			}
		}
		
		else if(subMenu == 2) {
			System.out.print("연락처를 입력하세요 \n>> ");
			searchCond = scn.nextLine();
			Friend friend = null;
			friend = FriendExe.searchPhone(searchCond);
			if(friend != null) {
				System.out.println("< 검색 결과 >");
				System.out.println(friend.showInfo());
			}
			else {
				System.out.println("검색 결과가 없습니다");
			}
		}
		else {
			System.out.println("정확한 분류를 선택하세요");
		}
	} 
	
	
	void backup() { // 예시 작성한거 백업함.

		Friend parent = new Friend();
		parent.setName("홍길동");
		parent.setPhone("010-1234-5678");
		System.out.println(parent.toString());

		UnivFriend child = new UnivFriend();
		child.setName("김철수");
		child.setPhone("010-1111-2222");
		child.setUniv("구미대학교");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;

	}

}
