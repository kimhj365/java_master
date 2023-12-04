package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
	
	static Scanner scn = new Scanner(System.in);
	static List<Member> members = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// 회원등록(회원번호, 이름, 포인트).
		// 1.등록 2.이름조회 3.포인트 변경 4.삭제 5. 종료
		
		members.add(new Member("M-001", "홍길동", 1000));
		members.add(new Member("M-002", "김길동", 1500));
		members.add(new Member("M-003", "최인수", 2000));
		
		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.회원 등록 ┃ 2.이름 조회 ┃ 3.포인트 변경 ┃ 4.삭제 ┃ 5.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu = 0;
			String name = "";
			
			try {
			menu = Integer.parseInt(scn.nextLine());
			} catch(Exception e) {
				System.out.println("올바른 동작을 입력하세요");
				continue;
			}
			
			switch(menu) {
			// 1.회원 등록
			case 1:
				addMember();
				break;
				
			// 2.이름 조회
			case 2:
				findMember();
				break;
				
			// 3.포인트 변경
			case 3:
				changePoint();
				break;
				
			// 4.삭제
			case 4:
				removeMember();
				break;
				
			// 5.종료
			case 5:
				System.out.println("프로그램을 종료합니다.");
				scn.close();
				run = false;
		
			}
		} // end of while.
		System.out.println("end of prog.");
		
	} // end of main.
	
	public static void addMember() {
		System.out.println("< 회원 등록 >");
		System.out.print("회원번호 이름 포인트 순으로 입력하세요 \n>> ");
		String input = " ";
		input = scn.nextLine();
		String[] inAry = input.split(" ");
		
		try {
			members.add(new Member(inAry[0], inAry[1], Integer.parseInt(inAry[2])));
			System.out.println("회원 등록 완료!");
		} catch(Exception e) {
			System.out.println("올바른 회원정보를 입력하세요");
			return;
		}
	}
	
	public static void findMember() {
		System.out.println("< 회원 조회 >");
		System.out.print("조회할 회원의 이름을 입력하세요 \n>> ");
		String name = scn.nextLine();
		boolean chk = false;
		System.out.printf("%7s %9s %9s\n","회원번호", "이름", "포인트");
		System.out.println("=======================================");
		
		for(Member mem : members) {
			if(mem.getMemberName().indexOf(name) != -1) { 
				System.out.printf("%10s %10s %10d\n",mem.getMemberNo(), mem.getMemberName(), mem.getPoint());
				chk = true;
			}
		}
		if(chk == false) System.out.println("찾는 이름이 없습니다.");
	}
	
	public static void changePoint() {
		System.out.println("< 포인트 변경 >");
		System.out.print("이름 포인트 순으로 입력하세요 \n>> ");
		String input = scn.nextLine();
		String[] inAry2 = input.split(" ");
		
		boolean chk = false;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().equals(inAry2[0])) {
				members.get(i).setPoint(Integer.parseInt(inAry2[1]));
				chk = true;
			}
		}
		if(chk) {
			System.out.println("포인트 변경 완료!");
		}
		else {
			System.out.println("포인트 변경에 실패했습니다");
		}
	}
	
	public static void removeMember() {
		System.out.println("< 회원 삭제 >");
		System.out.print("삭제할 회원의 이름을 입력하세요 \n>> ");
		String name = scn.nextLine();
		boolean chk = false;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().equals(name)) {
				members.remove(i);
				chk = true;
			}
		}
		if(chk) {
			System.out.println("회원 삭제 완료!");
		}
		else {
			System.out.println("회원 삭제에 실패했습니다");
		}
	}
	
} // end of class.
