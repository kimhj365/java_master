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
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
		System.out.println("¦­ ¡Ú                                                                 ¡Ú ¦­");
		System.out.println("¦­                         ¿¹´ã½Ã³×¸¶ µ¿¼º·ÎÁ¡                         ¦­");
		System.out.println("¦­ ¡Ú                                                                 ¡Ú ¦­");
		System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
		
		// ½ÃÀÛÈ­¸é.
		while(run1) {
			System.out.println();
			System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
			System.out.println("¦­            1. ·Î±×ÀÎ              ¦­            2.È¸¿ø°¡ÀÔ           ¦­");
			System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
			System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			// 1. ·Î±×ÀÎ.
			switch(menu) {
			case 1:
				System.out.println("\n< ·Î±×ÀÎ >");
				System.out.print("¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String passwd = scn.nextLine();
				
				if(userDao.login(userId, passwd)) {			
					System.out.println("·Î±×ÀÎ ¿Ï·á!");
					String userName = userDao.getName(userId);
					System.out.println(userName + "´Ô È¯¿µÇÕ´Ï´Ù!");
					run1 = false;
				}
				else {
					System.out.println("¾ÆÀÌµð¿Í ºñ¹Ð¹øÈ£¸¦ È®ÀÎÇÏ¼¼¿ä");
				}
				break;
			
			// 2. È¸¿ø°¡ÀÔ.
			case 2 :
				System.out.println("\n< È¸¿ø °¡ÀÔ >");
				System.out.print("¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				userId = scn.nextLine();
				System.out.print("ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("ºñ¹Ð¹øÈ£¸¦ ÇÑ¹ø ´õ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("¿¬¶ôÃ³¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String userTel = scn.nextLine();
					
				if(passwd.equals(passwd2)) {
					User user = new User(userId, passwd, userName, userTel);
					if(userDao.signUp(user)) {
						System.out.println("È¸¿ø°¡ÀÔ ¿Ï·á!");
					}
				}
				else {
					System.out.println("ºñ¹Ð¹øÈ£°¡ ´Ù¸¨´Ï´Ù");					
				}
				break;
			default :
				System.out.println("¿Ã¹Ù¸¥ µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä");
			} // end of switch
		} // end of while(run1)
		
		while(run2) {
			System.out.println();
			System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
			System.out.println("¦­ 1.¿µÈ­ ¸ñ·Ï ¦­ 2.¿µÈ­ °Ë»ö ¦­ 3.¿µÈ­ ¿¹¸Å ¦­ 4.¸¶ÀÌÆäÀÌÁö ¦­ 5.·Î±×¾Æ¿ô ¦­");
			System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
			System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			switch(menu) {
			// 1. ÀüÃ¼ ¿µÈ­ ¸ñ·Ï Á¶È¸
			case 1:
				boolean run3 = true;
				int page = 1;
				while(run3){
					System.out.println("\n< ¿µÈ­ ¸ñ·Ï >");
					System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬¹è¿ì"); 
					System.out.println("----------------------------------------------------------------------------------");
					movieDao.showAllMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					
					int count = movieDao.getAllMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					System.out.printf("[ÇöÀç ÆäÀÌÁö: %d]  ", page);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					System.out.println();
					System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
					System.out.println("¦­ 1.ÀÌÀü ÆäÀÌÁö ¦­ 2. ´ÙÀ½ÆäÀÌÁö ¦­ 3. ¿µÈ­ Á¤º¸ º¸±â ¦­ 4. ³ª°¡±â ¦­");
					System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
					System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
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
						System.out.println("\n< ¿µÈ­ Á¤º¸ º¸±â >");
						System.out.print("¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
						String movieNumber = scn.nextLine();
						Movie movie = movieDao.getMovie(movieNumber);
						try {
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("¿Ã¹Ù¸¥ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
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
				
			// 2. ¿µÈ­ °Ë»ö
			case 2:
				System.out.println("\n< ¿µÈ­ °Ë»ö >");
				System.out.print("°Ë»ö¾î¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< ¿µÈ­ ¸ñ·Ï >");
				System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬ ¹è¿ì"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies2 = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies2.size(); i++) {
					movies2.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
				System.out.println("¦­ 1.¿µÈ­ Á¤º¸ º¸±â ¦­ 2. ³ª°¡±â ¦­");
				System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
				System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("\n< ¿µÈ­ Á¤º¸ º¸±â >");
					System.out.print("¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("¿Ã¹Ù¸¥ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
			
			// ¿µÈ­ ¿¹¸Å.
			case 3:
				boolean run4 = true;
				page = 1;
				while(run4){
					System.out.println("\n< ¿µÈ­ ¸ñ·Ï >");
					System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬¹è¿ì"); 
					System.out.println("----------------------------------------------------------------------------------");
					movieDao.showAvailableMovieList(page);
					System.out.println("----------------------------------------------------------------------------------");
					
					int count = movieDao.getAvailableMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					System.out.printf("[ÇöÀç ÆäÀÌÁö: %d]  ", page);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					System.out.println();
					System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
					System.out.println("¦­ 1.ÀÌÀü ÆäÀÌÁö ¦­ 2. ´ÙÀ½ÆäÀÌÁö ¦­ 3. ¿µÈ­ ¿¹¸Å ÇÏ±â ¦­ 4. ³ª°¡±â ¦­");
					System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
					System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
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
						System.out.println("\n< ¿µÈ­ ¿¹¸Å ÇÏ±â >");
						System.out.print("¿¹¸ÅÇÒ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
						String movieNumber = scn.nextLine();
						List<Movie> movies = movieDao.getAvailableMovieList();
						
						boolean chk = false;
						for(Movie movie : movies){
							if(movie.getMovieNumber().equals(movieNumber)) {
								chk = true;
							}
						}
						if(!chk) {
							System.out.println("¿Ã¹Ù¸¥ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
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
				System.out.println("·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù");
				scn.close();
				run2 = false;
				break;
			default:
				System.out.println("¿Ã¹Ù¸¥ µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä");
			} // end of switch
			
		} // end of while(run2)
		System.out.println("end of prog.");
	}

}
