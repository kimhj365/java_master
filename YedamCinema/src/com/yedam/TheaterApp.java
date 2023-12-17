package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {
		
		// UserDAO, MovieDAO °´Ã¼ »ý¼º.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		
		// Oracle DB Á¢¼Ó.
		userDao.getConn();
		movieDao.getConn();
		
		Scanner scn = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		// 0. ½ÃÀÛ Å¸ÀÌÆ².
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
		System.out.println("¦­ ¡Ú                                                                 ¡Ú ¦­");
		System.out.println("¦­                         ¿¹´ã½Ã³×¸¶ µ¿¼º·ÎÁ¡                         ¦­");
		System.out.println("¦­ ¡Ú                                                                 ¡Ú ¦­");
		System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
		
		// I. ·Î±×ÀÎ / È¸¿ø°¡ÀÔ.
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
			
			switch(menu) {
			// 1. ·Î±×ÀÎ.
			case 1:
				System.out.println("\n< ·Î±×ÀÎ >");
				System.out.print("¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String passwd = scn.nextLine();
				
				// UserDAO ·Î±×ÀÎ ÇÔ¼ö È£Ãâ.
				if(userDao.login(userId, passwd)) {			
					System.out.println("·Î±×ÀÎ ¿Ï·á!");
					// UserDAO À¯Àú ÀÌ¸§ °¡Á®¿À±â ÇÔ¼ö È£Ãâ.
					String userName = userDao.getName(userId);
					System.out.println(userName + " ´Ô È¯¿µÇÕ´Ï´Ù!");
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
				
				// ºñ¹Ð¹øÈ£ ÀÏÄ¡ È®ÀÎ.
				if(passwd.equals(passwd2)) {
					// User °´Ã¼ »ý¼º => UseDAO È¸¿ø°¡ÀÔ ÇÔ¼ö ÀÎ¼ö°ª.
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
		
		// II. À¯Àú È­¸é
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
			// 1 ÀüÃ¼ ¿µÈ­ ¸ñ·Ï Á¶È¸.
			case 1:
				boolean run3 = true;
				int page = 1;
				while(run3){
					System.out.println("\n< ¿µÈ­ ¸ñ·Ï >");
					System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬¹è¿ì"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovieDAO ÆäÀÌÂ¡ µÈ ¿µÈ­¸ñ·Ï Ãâ·Â ÇÔ¼ö.
					movieDao.showAllMovie(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[ÇöÀç ÆäÀÌÁö: %d]  ", page);
					
					// ÀüÃ¼ ÆäÀÌÁö ¼ö Ãâ·Â.
					// MovieDAO ÀüÃ¼ ¿µÈ­ ¸ñ·Ï °¡Á®¿À±â ÇÔ¼ö => ¿µÈ­ ¼ö count.
					int count = movieDao.getAllMovie().size();
					// ÀüÃ¼ ¿µÈ­ ¼ö / 5 + ¼Ò¼ö ÀÚ¸´¼ö ¿Ã¸² => ÀüÃ¼ ÆäÀÌÁö ¼ö.
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// ¼­ºê¸Þ´º.
					System.out.println();
					System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
					System.out.println("¦­ 1.ÀÌÀü ÆäÀÌÁö ¦­ 2. ´ÙÀ½ÆäÀÌÁö ¦­ 3. ¿µÈ­ »ó¼¼ Á¤º¸ ¦­ 4. ³ª°¡±â ¦­");
					System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
					System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					// 1-1. ÀÌÀü ÆäÀÌÁö.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 1-2. ´ÙÀ½ ÆäÀÌÁö.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 1-3. ¿µÈ­ »ó¼¼ Á¤º¸ Á¶È¸.
					case 3:	
						System.out.println("\n< ¿µÈ­ »ó¼¼ Á¤º¸ Á¶È¸ >");
						System.out.print("¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
						String movieNumber = scn.nextLine();
						//	MovieDAO ¿µÈ­ ¹øÈ£·Î ¿µÈ­ Ã£´Â Äõ¸® ÇÔ¼ö.
						Movie movie = movieDao.getMovieDetail(movieNumber);
						try {
							// Movie ¿µÈ­ Á¤º¸ Ãâ·Â ÇÔ¼ö.
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("¿Ã¹Ù¸¥ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
						}
						break;
					// 1-4. ³ª°¡±â
					case 4:
						run3 = false;
						break;
					default :
						break;
					}
					
				}
				break;
				
			// 2. ¿µÈ­ °Ë»ö.
			case 2:
				System.out.println("\n< ¿µÈ­ °Ë»ö >");
				System.out.print("°Ë»ö¾î¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< ¿µÈ­ ¸ñ·Ï >");
				System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬ ¹è¿ì"); 
				System.out.println("----------------------------------------------------------------------------------");
				// MovieDAO ¿µÈ­ Ã£±â ÇÔ¼ö.
				List<Movie> movies = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies.size(); i++) {
					// Movie ¿µÈ­ Á¤º¸ Ãâ·ÂÇÔ¼ö.
					movies.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				// ¼­ºê¸Þ´º.
				System.out.println();
				System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦³¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
				System.out.println("¦­ 1.¿µÈ­ »ó¼¼ Á¤º¸ ¦­ 2. ³ª°¡±â ¦­");
				System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦µ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
				System.out.print("µ¿ÀÛÀ» ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
				
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				// 2-1. ¿µÈ­ »ó¼¼Á¤º¸ Á¶È¸ (== 1-3).
				case 1: 
					System.out.println("\n< ¿µÈ­ »ó¼¼ Á¤º¸ Á¶È¸ >");
					System.out.print("¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovieDetail(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("¿Ã¹Ù¸¥ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
					}
					break;
				// 2-2. ³ª°¡±â.
				case 2:
					break;
				default :
					break;
				}

				break;
			
			// 3. ¿µÈ­ ¿¹¸Å.
			case 3:
				boolean run4 = true;
				page = 1;
				while(run4){
					System.out.println("\n< ¿µÈ­ ¸ñ·Ï >");
					System.out.println(" ¹øÈ£	  ¿µÈ­ ÀÌ¸§		   °¨µ¶                    Ãâ¿¬¹è¿ì"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovidDAO ¿¹¸Å °¡´ÉÇÑ ¿µÈ­Á¶È¸ ÇÔ¼ö(¿À´Ã ³¯Â¥ ±âÁØ)/
					movieDao.showAvailableMovie(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[ÇöÀç ÆäÀÌÁö: %d]  ", page);
					
					int count = movieDao.getAvailableMovie().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// ¼­ºê¸Þ´º.
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
					// 3-1. ÀÌÀü ÆäÀÌÁö.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 3-2. ´ÙÀ½ ÆäÀÌÁö.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 3-3. ¿¹¸ÅÇÏ±â
					case 3:	
						System.out.println("\n< ¿µÈ­ ¿¹¸Å ÇÏ±â >");
						// 3-3-1. ³¯Â¥ ¼±ÅÃ
						System.out.print("¿¹¸ÅÇÒ ³¯Â¥¸¦ ÀÔ·ÂÇÏ¼¼¿ä (YYYY-MM-DD) \n>>>> ");
						String strDate = scn.nextLine();
						
						// String => Date ³¯Â¥ Æ÷¸Ë
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
						try {
							date = sdf.parse(strDate);
							System.out.println(strDate);
						} catch (ParseException e) {
							System.out.println("¿Ã¹Ù¸¥ ³¯Â¥¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
							break;
						}
						
						// 3-3-2. ¿µÈ­ ¼±ÅÃ
						System.out.print("¿¹¸ÅÇÒ ¿µÈ­ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä \n>>>> ");
						String movieNumber = scn.nextLine();
						
						
						List<Movie> movies2 = movieDao.getAvailableMovie();
						
						boolean chk = false;
						for(Movie movie : movies2){
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
