package com.yedam;

import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		boolean run1 = true;
		boolean run2 = true;
		
		
		// 시작화면.
		while(run1) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃                         예담시네마 동성로점                         ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃            1. 로그인              ┃            2.회원가입           ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			// 1. 로그인.
			switch(menu) {
			case 1:
				System.out.println("< 로그인 >");
				System.out.print("아이디를 입력하세요 \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("비밀번호를 입력하세요 \n>>>> ");
				String passwd = scn.nextLine();
				
				if(userDao.login(userId, passwd)) {			
					System.out.println("로그인 완료!");
					String userName = userDao.getName(userId);
					System.out.println(userName + "님 환영합니다!");
					run1 = false;
				}
				else {
					System.out.println("아이디와 비밀번호를 확인하세요");
				}
				break;
			
			// 2. 회원가입.
			case 2 :
				System.out.println("< 회원 가입 >");
				System.out.print("아이디를 입력하세요 \n>>>> ");
				userId = scn.nextLine();
				System.out.print("비밀번호를 입력하세요 \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("비밀번호를 한번 더 입력하세요 \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("이름을 입력하세요 \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("연락처를 입력하세요 \n>>>> ");
				String userTel = scn.nextLine();
					
				if(passwd.equals(passwd2)) {
					User user = new User(userId, passwd, userName, userTel);
					if(userDao.signUp(user)) {
						System.out.println("회원가입 완료!");
					}
				}
				else {
					System.out.println("비밀번호가 다릅니다");					
				}
				break;
			default :
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch
		} // end of while(run1)
		
		while(run2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━━┳━━━━━━━━━━━━┓");
			System.out.println("┃ 1.영화 목록 ┃ 2.영화 검색 ┃ 3.영화 예매 ┃ 4.마이페이지 ┃ 5.로그아웃 ┃");
			System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━━┻━━━━━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			switch(menu) {
			// 1. 전체 영화 목록 조회
			case 1:
				System.out.println("< 영화 목록 >");
				System.out.println(" 번호	  영화 이름		   감독                    출연배우"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies = new ArrayList<>();
				movies = movieDao.getMovieList();
				
				for (int i = 0; i < movies.size(); i++) {
					movies.get(i).showMovieInfo();
				}
				System.out.println("----------------------------------------------------------------------------------");

				System.out.println("┏━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
				System.out.println("┃ 1.영화 정보 보기 ┃ 2. 나가기 ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
				System.out.print("동작을 입력하세요 \n>>>> ");
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("< 영화 정보 보기 >");
					System.out.print("영화 번호를 입력하세요 \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("올바른 영화 번호를 입력하세요");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
				
			// 2. 영화 단건 조회
			case 2:
				System.out.println("< 영화 단건 조회 >");
				System.out.print("검색어를 입력하세요 \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< 영화 목록 >");
				System.out.println(" 번호	  영화 이름		   감독                    출연 배우"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies2 = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies2.size(); i++) {
					movies2.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				System.out.println("┏━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
				System.out.println("┃ 1.영화 정보 보기 ┃ 2. 나가기 ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
				System.out.print("동작을 입력하세요 \n>>>> ");
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("< 영화 정보 보기 >");
					System.out.print("영화 번호를 입력하세요 \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("올바른 영화 번호를 입력하세요");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
			
			// 영화 예매.
			case 3:
				System.out.println("< 영화 예매 >");
				
				
				break;
			case 4:
				break;
			case 5:
				System.out.println("로그아웃 되었습니다");
				scn.close();
				run2 = false;
				break;
			default:
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch
			
		} // end of while(run2)
		System.out.println("end of prog.");
	}

}
