package com.yedam;

import java.time.LocalDateTime;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {
		
		// UserDAO, MovieDAO 偌羹 儅撩.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		ScheduleDAO scheduleDao = new ScheduleDAO();
		
		// Oracle DB 蕾樓.
		userDao.getConn();
		movieDao.getConn();
		scheduleDao.getConn();
		
		Scanner scn = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		// 0. 衛濛 顫檜ぎ.
		System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
		System.out.println("早 ≠                                                                 ≠ 早");
		System.out.println("早                         蕨氬衛啻葆 翕撩煎薄                         早");
		System.out.println("早 ≠                                                                 ≠ 早");
		System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
		
		// I. 煎斜檣 / �蛾灠㊣�.
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
			
			switch(menu) {
			// 1. 煎斜檣.
			case 1:
				System.out.println("\n< 煎斜檣 >");
				System.out.print("嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
				String passwd = scn.nextLine();
				
				// UserDAO 煎斜檣 л熱 ��轎.
				if(userDao.login(userId, passwd)) {			
					System.out.println("煎斜檣 諫猿!");
					// UserDAO 嶸盪 檜葷 陛螳螃晦 л熱 ��轎.
					String userName = userDao.getName(userId);
					System.out.println(userName + " 椒 �紊腎桭炴�!");
					
					// 婦葬濠 啗薑橾衛 婦葬濠 む檜雖煎 夥煎 剩橫馬
					if(userId.equals("sys")) {
						run2 = false;
					}
					
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
				
				// 婦葬濠 嬴檜蛤 儅撩 寞雖
				if(userId.equals("sys")) {
					System.out.println("儅撩й 熱 橈朝 嬴檜蛤殮棲棻");
					break;
				}
				// 醞犒 嬴檜蛤 儅撩 寞雖
				if(!userDao.chkUserId(userId)) {
					System.out.println("檜嘐 襄營ж朝 嬴檜蛤殮棲棻");
					break;
				}
				
				System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("綠塵廓�ㄧ� и廓 渦 殮溘ж撮蹂 \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("檜葷擊 殮溘ж撮蹂 \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("翱塊籀蒂 殮溘ж撮蹂 \n>>>> ");
				String userTel = scn.nextLine();
								
				
				// 綠塵廓�� 橾纂 �挫�.
				if(passwd.equals(passwd2)) {
					// User 偌羹 儅撩 => UseDAO �蛾灠㊣� л熱 檣熱高.
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
		
		
		
		// II. 嶸盪 �飛�
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
			// 1 瞪羹 艙�� 跡煙 褻��.
			case 1:
				boolean run3 = true;
				int page = 1;
				while(run3){
					System.out.println("\n< 艙�� 跡煙 >");
					System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovieDAO む檜癒 脹 艙�飛騇� 轎溘 л熱.
					movieDao.showMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[⑷營 む檜雖: %d]  ", page);
					
					// 瞪羹 む檜雖 熱 轎溘.
					// MovieDAO 瞪羹 艙�� 跡煙 陛螳螃晦 л熱 => 艙�� 熱 count.
					int count = movieDao.getMovieList().size();
					// 瞪羹 艙�� 熱 / 5 + 模熱 濠葩熱 螢葡 => 瞪羹 む檜雖 熱.
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// 憮粽詭景.
					System.out.println();
					System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
					System.out.println("早 1.檜瞪 む檜雖 早 2. 棻擠む檜雖 早 3. 艙�� 鼻撮 薑爾 早 4. 釭陛晦 早");
					System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
					System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					// 1-1. 檜瞪 む檜雖.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 1-2. 棻擠 む檜雖.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 1-3. 艙�� 鼻撮 薑爾 褻��.
					case 3:	
						System.out.println("\n< 艙�� 鼻撮 薑爾 褻�� >");
						System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
						String movieNumber = scn.nextLine();
						//	MovieDAO 艙�� 廓�ㄦ� 艙�� 瓊朝 蘭葬 л熱.
						Movie movie = movieDao.getMovieDetail(movieNumber);
						try {
							// Movie 艙�� 薑爾 轎溘 л熱.
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
						}
						break;
					// 1-4. 釭陛晦
					case 4:
						run3 = false;
						break;
					default :
						break;
					}
					
				}
				break;
				
			// 2. 艙�� 匐儀.
			case 2:
				System.out.println("\n< 艙�� 匐儀 >");
				System.out.print("匐儀橫蒂 殮溘ж撮蹂 \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< 艙�� 跡煙 >");
				System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱 寡辦"); 
				System.out.println("----------------------------------------------------------------------------------");
				// MovieDAO 艙�� 瓊晦 л熱.
				List<Movie> movies = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies.size(); i++) {
					// Movie 艙�� 薑爾 轎溘л熱.
					movies.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				// 憮粽詭景.
				System.out.println();
				System.out.println("旨收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
				System.out.println("早 1.艙�� 鼻撮 薑爾 早 2. 釭陛晦 早");
				System.out.println("曲收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
				System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
				
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				// 2-1. 艙�� 鼻撮薑爾 褻�� (== 1-3).
				case 1: 
					System.out.println("\n< 艙�� 鼻撮 薑爾 褻�� >");
					System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovieDetail(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
					}
					break;
				// 2-2. 釭陛晦.
				case 2:
					break;
				default :
					break;
				}

				break;
			
			// 3. 艙�� 蕨衙.
			case 3:
				boolean run4 = true;
				page = 1;
				while(run4){
					System.out.println("\n< 艙�� 跡煙 >");
					System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovidDAO 蕨衙 陛棟и 艙�俯僅� л熱(螃棺 陳瞼 晦遽)/
					movieDao.showMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[⑷營 む檜雖: %d]  ", page);
					
					int count = movieDao.getMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// 憮粽詭景.
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
					// 3-1. 檜瞪 む檜雖.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 3-2. 棻擠 む檜雖.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 3-3. 蕨衙ж晦
					case 3:	
						System.out.println("\n< 艙�� 蕨衙 ж晦 >");
						
						// 3-3-1. 陳瞼 摹鷗
						System.out.print("蕨衙й 陳瞼蒂 殮溘ж撮蹂 (YYYY-MM-DD) \n>>>> ");
						String strDate = scn.nextLine();
						
						// 3-3-2. 艙�� 摹鷗
						System.out.print("蕨衙й 艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
						String movieNumber = scn.nextLine();
						
						
						List<Movie> movies2 = movieDao.getMovieList();
						
						System.out.println("\n< 鼻艙 衛除ル >");
						System.out.println("  廓��	  艙�� 檜葷	  	  鼻艙 衛除        陴擎 謝戮      й檣"); 
						System.out.println("----------------------------------------------------------------------------------");
						
						boolean chk = false;
						for(Movie movie : movies2){
							if(movie.getMovieNumber().equals(movieNumber)) {
								chk = true;
							}
						}
						if(!chk) {
							System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
							break;
						}
						List<Schedule> schedules = scheduleDao.getScheduleList(movieNumber, strDate);
						scheduleDao.showScheduleList(schedules, page);
						
						System.out.println("----------------------------------------------------------------------------------");
						System.out.printf("[⑷營 む檜雖: %d]  ", page);
						
						// 瞪羹 む檜雖 熱 轎溘.
						// MovieDAO 瞪羹 艙�� 跡煙 陛螳螃晦 л熱 => 艙�� 熱 count.
						count = scheduleDao.getScheduleList(movieNumber, strDate).size();
						// 瞪羹 艙�� 熱 / 5 + 模熱 濠葩熱 螢葡 => 瞪羹 む檜雖 熱.
						totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}
						
						System.out.println();
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2. 棻擠む檜雖 早 3. 鼻艙 衛除 摹鷗 早 4. 釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}
						
						switch(subMenu) {
						// 3-1. 檜瞪 む檜雖.
						case 1: 
							if(page > 1) {
								page--;
							}
							break;
						// 3-2. 棻擠 む檜雖.
						case 2:
							if(page < totalPage) {
								page++;
							}
							break;
						case 3:	
						}
						System.out.print("\n蕨衙й 鼻艙 衛除擊 殮溘ж撮蹂 \n>>>> ");
						String schedule = scn.nextLine();
						
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
