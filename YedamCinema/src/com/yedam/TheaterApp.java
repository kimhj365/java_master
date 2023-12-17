package com.yedam;

import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		movieDao.getConn();
		
		
		boolean run1 = true;
		boolean run2 = true;
		System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
		System.out.println("早 ≠                                                                 ≠ 早");
		System.out.println("早                         蕨氬衛啻葆 翕撩煎薄                         早");
		System.out.println("早 ≠                                                                 ≠ 早");
		System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
		
		// 衛濛�飛�.
		while(run1) {
			System.out.println();
			System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
			System.out.println("早            1. 煎斜檣              早            2.�蛾灠㊣�           早");
			System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
			System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			// 1. 煎斜檣.
			switch(menu) {
			case 1:
				System.out.println("\n< 煎斜檣 >");
				System.out.print("嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
				String passwd = scn.nextLine();
				
				if(userDao.login(userId, passwd)) {			
					System.out.println("煎斜檣 諫猿!");
					String userName = userDao.getName(userId);
					System.out.println(userName + "椒 �紊腎桭炴�!");
					run1 = false;
				}
				else {
					System.out.println("嬴檜蛤諦 綠塵廓�ㄧ� �挫恉牳撚�");
				}
				break;
			
			// 2. �蛾灠㊣�.
			case 2 :
				System.out.println("\n< �蛾� 陛殮 >");
				System.out.print("嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
				userId = scn.nextLine();
				System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("綠塵廓�ㄧ� и廓 渦 殮溘ж撮蹂 \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("檜葷擊 殮溘ж撮蹂 \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("翱塊籀蒂 殮溘ж撮蹂 \n>>>> ");
				String userTel = scn.nextLine();
					
				if(passwd.equals(passwd2)) {
					User user = new User(userId, passwd, userName, userTel);
					if(userDao.signUp(user)) {
						System.out.println("�蛾灠㊣� 諫猿!");
					}
				}
				else {
					System.out.println("綠塵廓�ㄟ� 棻落棲棻");					
				}
				break;
			default :
				System.out.println("螢夥艇 翕濛擊 殮溘ж撮蹂");
			} // end of switch
		} // end of while(run1)
		
		while(run2) {
			System.out.println();
			System.out.println("旨收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收收有收收收收收收收收收收收收旬");
			System.out.println("早 1.艙�� 跡煙 早 2.艙�� 匐儀 早 3.艙�� 蕨衙 早 4.葆檜む檜雖 早 5.煎斜嬴醒 早");
			System.out.println("曲收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收收朴收收收收收收收收收收收收旭");
			System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			switch(menu) {
			// 1. 瞪羹 艙�� 跡煙 褻��
			case 1:
				boolean run3 = true;
				int page = 1;
				while(run3){
					System.out.println("\n< 艙�� 跡煙 >");
					System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦"); 
					System.out.println("----------------------------------------------------------------------------------");
					movieDao.showAllMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					
					int count = movieDao.getAllMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					System.out.printf("[⑷營 む檜雖: %d]  ", page);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					System.out.println();
					System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
					System.out.println("早 1.檜瞪 む檜雖 早 2. 棻擠む檜雖 早 3. 艙�� 薑爾 爾晦 早 4. 釭陛晦 早");
					System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
					System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					case 3:	
						System.out.println("\n< 艙�� 薑爾 爾晦 >");
						System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
						String movieNumber = scn.nextLine();
						Movie movie = movieDao.getMovie(movieNumber);
						try {
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
						}
						break;
					case 4:
						run3 = false;
						break;
					default :
						break;
					}
					
				}
				
				
				break;
				
			// 2. 艙�� 匐儀
			case 2:
				System.out.println("\n< 艙�� 匐儀 >");
				System.out.print("匐儀橫蒂 殮溘ж撮蹂 \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< 艙�� 跡煙 >");
				System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱 寡辦"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies2 = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies2.size(); i++) {
					movies2.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				System.out.println("旨收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
				System.out.println("早 1.艙�� 薑爾 爾晦 早 2. 釭陛晦 早");
				System.out.println("曲收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
				System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
				
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("\n< 艙�� 薑爾 爾晦 >");
					System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
			
			// 艙�� 蕨衙.
			case 3:
				boolean run4 = true;
				page = 1;
				while(run4){
					System.out.println("\n< 艙�� 跡煙 >");
					System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦"); 
					System.out.println("----------------------------------------------------------------------------------");
					movieDao.showAvailableMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					
					int count = movieDao.getAvailableMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					System.out.printf("[⑷營 む檜雖: %d]  ", page);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					System.out.println();
					System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
					System.out.println("早 1.檜瞪 む檜雖 早 2. 棻擠む檜雖 早 3. 艙�� 蕨衙 ж晦 早 4. 釭陛晦 早");
					System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
					System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					case 3:	
						System.out.println("\n< 艙�� 蕨衙 ж晦 >");
						System.out.print("蕨衙й 艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
						String movieNumber = scn.nextLine();
						List<Movie> movies = movieDao.getAvailableMovieList();
						
						boolean chk = false;
						for(Movie movie : movies){
							if(movie.getMovieNumber().equals(movieNumber)) {
								chk = true;
							}
						}
						if(!chk) {
							System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
							break;
						}
						List<String[]> schedule = movieDao.searchSchedule(movieNumber);
						movieDao.getSchedule(schedule);
						
						break;
						
					case 4:
						run4 = false;
						break;
					default :
						break;
					}
				}
				
			case 4:
				break;
				
			case 5:
				System.out.println("煎斜嬴醒 腎歷蝗棲棻");
				scn.close();
				run2 = false;
				break;
			default:
				System.out.println("螢夥艇 翕濛擊 殮溘ж撮蹂");
			} // end of switch
			
		} // end of while(run2)
		System.out.println("end of prog.");
	}

}
