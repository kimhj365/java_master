package com.yedam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {

		// UserDAO, MovieDAO 偌羹 儅撩.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		ScheduleDAO scheduleDao = new ScheduleDAO();
		TicketDAO ticketDao = new TicketDAO();

		boolean run0 = true;
		Scanner scn = new Scanner(System.in);

		while (run0) {
			boolean run1 = true;
			boolean run2 = true;
			boolean run3 = false;
			String userId = "";

			// 0. 衛濛 顫檜ぎ.
			System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
			System.out.println("早 ≠                                                                 ≠ 早");
			System.out.println("早                         蕨氬衛啻葆 翕撩煎薄                         早");
			System.out.println("早 ≠                                                                 ≠ 早");
			System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");

			// I. 煎斜檣 / �蛾灠㊣�.
			while (run1) {
				System.out.println();
				System.out.println("旨收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收收收收收收收旬");
				System.out.println("早     1.煎斜檣      早      2.�蛾灠㊣�      早     3.Щ煎斜極 謙猿    早");
				System.out.println("曲收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收收收收收收收旭");
				System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
				int menu = 0;
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

				switch (menu) {
				// 1. 煎斜檣.
				case 1:
					System.out.println("\n< 煎斜檣 >");
					System.out.print("嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
					userId = scn.nextLine();
					System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
					String passwd = scn.nextLine();

					// UserDAO 煎斜檣 л熱 ��轎.
					if (userDao.login(userId, passwd)) {
						System.out.println("煎斜檣 諫猿!");
						// UserDAO 嶸盪 檜葷 陛螳螃晦 л熱 ��轎.
						String userName = userDao.getName(userId);
						System.out.println(userName + " 椒 �紊腎桭炴�!");

						// 婦葬濠 啗薑橾衛 婦葬濠 む檜雖煎 夥煎 剩橫馬
						if (userId.equals("sys")) {
							run2 = false;
							run3 = true;
						}
						run1 = false;
					} else {
						System.out.println("嬴檜蛤諦 綠塵廓�ㄧ� �挫恉牳撚�");
					}
					break;

				// 2. �蛾灠㊣�.
				case 2:
					System.out.println("\n< �蛾� 陛殮 >");
					System.out.print("嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
					userId = scn.nextLine();

					// 婦葬濠 嬴檜蛤 儅撩 寞雖
					if (userId.equals("sys")) {
						System.out.println("儅撩й 熱 橈朝 嬴檜蛤殮棲棻");
						break;
					}
					// 醞犒 嬴檜蛤 儅撩 寞雖
					if (userDao.chkUserId(userId)) {
						System.out.println("檜嘐 襄營ж朝 嬴檜蛤殮棲棻");
						break;
					}

					System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
					passwd = scn.nextLine();
					System.out.print("綠塵廓�ㄧ� и廓 渦 殮溘ж撮蹂 \n>>>> ");
					String passwd2 = scn.nextLine();

					// 綠塵廓�� 橾纂 �挫�.
					if (!passwd.equals(passwd2)) {
						System.out.println("綠塵廓�ㄟ� 棻落棲棻");
						break;
					}

					System.out.print("檜葷擊 殮溘ж撮蹂 \n>>>> ");
					String userName = scn.nextLine();
					System.out.print("翱塊籀蒂 殮溘ж撮蹂 \n>>>> ");
					String userTel = scn.nextLine();

					// User 偌羹 儅撩 => UseDAO �蛾灠㊣� л熱 檣熱高.
					User user = new User(userId, passwd, userName, userTel);
					if (userDao.signUp(user)) {
						System.out.println("�蛾灠㊣� 諫猿!");
					}
					else {
						System.out.println("�蛾灠㊣埥� 褒ぬц蝗棲棻");
					}
					break;

				case 3:
					System.out.println("Щ煎斜極 謙猿");
					run0 = false;
					run1 = false;
					run2 = false;
					break;
				default:
					System.out.println("螢夥艇 翕濛擊 殮溘ж撮蹂");
					break;
				} // end of switch
			} // end of while(run1)

			// II. 嶸盪 �飛�
			while (run2) {
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

				switch (menu) {
				// 1 瞪羹 艙�� 跡煙 褻��.
				case 1:
					boolean run4 = true;
					int page = 1;
					while (run4) {
						System.out.println("\n< 艙�� 跡煙 >");
						System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovieDAO む檜癒 脹 艙�飛騇� 轎溘 л熱.
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
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
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.艙�� 鼻撮 薑爾 早 4.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 1-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 1-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 1-3. 艙�� 鼻撮 薑爾 褻��.
						case 3:
							System.out.println("\n< 艙�� 鼻撮 薑爾 褻�� >");
							System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String movieNumber = scn.nextLine();
							// MovieDAO 艙�� 廓�ㄦ� 艙�� 瓊朝 蘭葬 л熱.
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
							run4 = false;
							break;
						default:
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
					System.out.println(
							"----------------------------------------------------------------------------------");
					// MovieDAO 艙�� 瓊晦 л熱.
					List<Movie> movies = movieDao.searchMovie(search);

					for (int i = 0; i < movies.size(); i++) {
						// Movie 艙�� 薑爾 轎溘л熱.
						movies.get(i).showMovieInfo();
					}
					System.out.println(
							"----------------------------------------------------------------------------------");

					// 憮粽詭景.
					System.out.println();
					System.out.println("旨收收收收收收收收收收收收收收收收收收有收收收收收收收收收收旬");
					System.out.println("早 1.艙�� 鼻撮 薑爾 早 2.釭陛晦 早");
					System.out.println("曲收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收旭");
					System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");

					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}

					switch (subMenu) {
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
					default:
						break;
					}

					break;

				// 3. 艙�� 蕨衙.
				case 3:
					boolean run5 = true;
					page = 1;
					while (run5) {
						System.out.println("\n< 艙�� 跡煙 >");
						System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovidDAO 蕨衙 陛棟и 艙�俯僅� л熱(螃棺 陳瞼 晦遽)/
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[⑷營 む檜雖: %d]  ", page);

						int count = movieDao.getMovieList().size();
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						// 憮粽詭景.
						System.out.println();
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.艙�� 蕨衙 ж晦 早 4.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 3-3. 蕨衙ж晦
						case 3:
							System.out.println("\n< 艙�� 蕨衙 ж晦 >");

							// 3-3-1. 陳瞼 摹鷗
							System.out.print("蕨衙й 陳瞼蒂 殮溘ж撮蹂 (YYYY-MM-DD) \n>>>> ");
							String strDate = scn.nextLine();

							DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate localDate;
							try {
								localDate = LocalDate.parse(strDate, formatter2);
							} catch (Exception e) {
								System.out.println("螢夥艇 陳瞼 ⑽衝擊 殮溘ж撮蹂");
								break;
							}
							LocalDate now = LocalDate.now();
							if (localDate.isBefore(now)) {
								System.out.println("蕨衙陛棟и 陳瞼陛 嬴椎棲棻");
								break;
							}

							// 3-3-2. 艙�� 摹鷗
							System.out.print("蕨衙й 艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String movieNumber = scn.nextLine();

							List<Movie> movies2 = movieDao.getMovieList();
							boolean chk = false;
							for (Movie movie : movies2) {
								if (movie.getMovieNumber().equals(movieNumber)) {
									chk = true;
								}
							}
							if (!chk) {
								System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
								break;
							}

							// 鼻艙 衛除ル 轎溘
							boolean run6 = true;
							while (run6) {
								List<Schedule> schedules = scheduleDao.getScheduleList(movieNumber, strDate);
								for (int i = 0; i < schedules.size(); i++) {
									scheduleDao.updateSeats(schedules.get(i).getScheduleId());
								}

								System.out.println("\n< 鼻艙 衛除ル >");
								System.out.println("  廓��	  艙�� 檜葷	  	    鼻艙 衛除        陴擎 謝戮      й檣");
								System.out.println(
										"----------------------------------------------------------------------------------");

								scheduleDao.showScheduleList2(schedules, page);

								System.out.println(
										"----------------------------------------------------------------------------------");
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
								System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收收收收有收收收收收收收收收收旬");
								System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.鼻艙 衛除 摹鷗 早 4.釭陛晦 早");
								System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收收收收朴收收收收收收收收收收旭");
								System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
								int subMenu2 = 0;
								try {
									subMenu2 = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									subMenu2 = 0;
								}

								switch (subMenu2) {
								// 3-1. 檜瞪 む檜雖.
								case 1:
									if (page > 1) {
										page--;
									}
									break;
								// 3-2. 棻擠 む檜雖.
								case 2:
									if (page < totalPage) {
										page++;
									}
									break;

								// 3-3. 艙�� 蕨衙
								case 3:
									System.out.print("\n蕨衙й 鼻艙 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
									int scheduleNum = 0;
									try {
										scheduleNum = Integer.parseInt(scn.nextLine());
									} catch (Exception e) {
										System.out.println("薑�旁� 鼻艙廓�ㄧ� 殮溘п輿撮蹂");
										break;
									}
									int scheduleId = scheduleDao.getScheduleId(scheduleNum, schedules);
									String discount = scheduleDao.getDiscount(scheduleNum, schedules);

									System.out.println("蕨衙 衙熱蒂 殮溘п輿撮蹂");
									int adult = 0;
									int youth = 0;

									try {
										System.out.print("撩檣    >>>> ");
										adult = Integer.parseInt(scn.nextLine());
										System.out.print("羶模喇  >>>> ");
										youth = Integer.parseInt(scn.nextLine());
									} catch (Exception e) {
										System.out.println("薑�旁� 蕨衙 衙熱蒂 殮溘п輿撮蹂");
										break;
									}

									char rowChar;
									int column = 0;
									for (int i = 0; i < adult; i++) {
										scheduleDao.showSeats(scheduleId);

										System.out.println("蕨衙й 謝戮擊 摹鷗ж撮蹂(撩檣)");
										try {
											System.out.print("\nч擊 殮溘ж撮蹂(A~E) \n>>>> ");
											rowChar = scn.nextLine().toUpperCase().charAt(0);
											if (rowChar < 65 || rowChar > 69) {
												System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
												i--;
												continue;
											}

											System.out.print("\n翮擊 殮溘ж撮蹂(1~10) \n>>>> ");
											column = Integer.parseInt(scn.nextLine());

											if (column < 1 || column > 10) {
												System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
												i--;
												continue;
											}

										} catch (Exception e) {
											System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
											i--;
											continue;
										}

										String row = String.valueOf(rowChar);
										Ticket ticket = new Ticket(userId, scheduleId, "撩檣", row, column, discount);

										System.out.println(ticket.reserveDate);
										if (ticketDao.isOccupied(row, column, scheduleId)) {
											System.out.println("檜嘐 蕨衙脹 謝戮殮棲棻\n");
											i--;
											continue;
										} else {
											if (ticketDao.reserveTicket(ticket)) {
												;
												System.out.println("蕨衙陛 諫猿腎歷蝗棲棻\n");
												for (int j = 0; j < schedules.size(); j++) {
//												scheduleDao.updateSeats(schedules.get(i).getScheduleId());
												}
											} else {
												System.out.println("蕨衙縑 褒ぬц蝗棲棻\n");
											}
										}

									} // end of for

									for (int i = 0; i < youth; i++) {
										scheduleDao.showSeats(scheduleId);

										System.out.println("蕨衙й 謝戮擊 摹鷗ж撮蹂(羶模喇)");
										try {
											System.out.print("\nч擊 殮溘ж撮蹂(A~E) \n>>>> ");
											rowChar = scn.nextLine().toUpperCase().charAt(0);
											if (rowChar < 65 || rowChar > 69) {
												System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
												i--;
												continue;
											}

											System.out.print("\n翮擊 殮溘ж撮蹂(1~10) \n>>>> ");
											column = Integer.parseInt(scn.nextLine());

											if (column < 1 || column > 10) {
												System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
												i--;
												continue;
											}

										} catch (Exception e) {
											System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
											i--;
											continue;
										}

										String row = String.valueOf(rowChar);
										Ticket ticket = new Ticket(userId, scheduleId, "羶模喇", row, column, discount);
										if (ticketDao.isOccupied(row, column, scheduleId)) {
											System.out.println("檜嘐 蕨衙脹 謝戮殮棲棻\n");
											i--;
											continue;
										} else {
											if (ticketDao.reserveTicket(ticket)) {
												;
												System.out.println("蕨衙陛 諫猿腎歷蝗棲棻\\n");
												for (int j = 0; j < schedules.size(); j++) {
													scheduleDao.updateSeats(schedules.get(i).getScheduleId());
												}
											} else {
												System.out.println("蕨衙縑 褒ぬц蝗棲棻\\n");
											}
										}

									} // end of for

									break;
								case 4:
									run6 = false;
									break;
								default:
									break;
								}
							} // end of while(run6)
							break;
						case 4:
							run5 = false;
							break;
						default:
							break;

						}
					} // end of while(run5)
					break;
					// 4. 葆檜む檜雖
				case 4:
					boolean run7 = true;
					while (run7) {
						System.out.println();
						System.out.println("旨收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.蕨衙 �挫� 早 2.謝戮 滲唳 早 3.蕨衙 鏃模 早 4.頂 薑爾 早 5.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 4-1. 蕨衙 �挫�
						case 1:
							System.out.println("\n< 蕨衙 �挫� >");
							System.out.println("廓��	  艙�倣抶�	  	 鼻艙陳瞼         翱滄   謝戮	    蕨衙陳瞼");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收旬");
							System.out.println("早 1.艙�倆� 爾晦 早 2.釭陛晦 早");
							System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收旭");
							int subMenu2 = 0;
							try {
								subMenu2 = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								subMenu2 = 0;
							}
							if(subMenu2 == 1) {
								System.out.print("褻�裔� 蕨衙 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
								int scrNum = 0;
								try {
									scrNum = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									System.out.println("螢夥艇 蕨衙 廓�ㄧ� 殮溘ж撮蹂");
									break;
								}
								Ticket ticket = ticketDao.getTicket(scrNum);
								Schedule schedule = scheduleDao.getSchedule(scrNum);
								Movie movie = movieDao.getMovie(scrNum);
								
								System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
								System.out.println("\n\t   艙�� 殮濰掏\n");
								System.out.println("  " + ticket.getReserveDate());
								System.out.println(" ================================");
								System.out.println("  " + movie.getAgeLimit() + "撮 檜鼻 婦塋陛\n");
								System.out.println("  " + movie.getMovieName() + "\n");
								System.out.println("  " + schedule.getMovieDate() + "\n");
								System.out.println("  1婦 " + ticket.getSeat_row()+"翮 "+ ticket.getSeat_column() +"翮\n");
								System.out.println(" ================================");
								System.out.println("  識檣錳 1貲("+ ticket.getAge() +")");
								System.out.println("  " + ticket.getPrice() +"\n");
								System.out.println(" --------------------------------");
								System.out.println("  蕨氬衛啻葆 翕撩煎薄\n");
								System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
							}

							break;
						// 4-2. 謝戮 滲唳
						case 2:
							System.out.println("\n< 謝戮 滲唳 >");
							System.out.println("廓��	  艙�倣抶�	  	 鼻艙陳瞼         翱滄   謝戮	    蕨衙陳瞼");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.print("謝戮擊 滲唳й 蕨衙 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							int modNum;
							try {
								modNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								modNum = 0;
							}
							if (!ticketDao.checkTicket(userId, modNum)) {
								System.out.println("蕨衙 廓�ㄟ� 橈蝗棲棻");
								break;
							} else {
								int scheduleId = ticketDao.getScheduleId(modNum);

								char rowChar;
								int column = 0;
								scheduleDao.showSeats(scheduleId);

								System.out.println("滲唳й 謝戮擊 摹鷗ж撮蹂");
								try {
									System.out.print("\nч擊 殮溘ж撮蹂(A~E) \n>>>> ");
									rowChar = scn.nextLine().toUpperCase().charAt(0);
									if (rowChar < 65 || rowChar > 69) {
										System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
										break;
									}
									System.out.print("\n翮擊 殮溘ж撮蹂(1~10) \n>>>> ");
									column = Integer.parseInt(scn.nextLine());

									if (column < 1 || column > 10) {
										System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
										break;
									}
								} catch (Exception e) {
									System.out.println("螢夥艇 謝戮 廓�ㄧ� 殮溘ж撮蹂");
									break;
								}

								String row = String.valueOf(rowChar);

								if (ticketDao.isOccupied(row, column, modNum)) {
									System.out.println("檜嘐 蕨衙脹 謝戮殮棲棻\n");
									break;
								} else {
									if (ticketDao.modifyTicket(modNum, row, column)) {
										System.out.println("謝戮 滲唳檜 諫猿腎歷蝗棲棻");
									} else {
										System.out.println("謝戮 滲唳縑 褒ぬц蝗棲棻");
									}
								}
							}
							break;
						// 蕨衙 鏃模
						case 3:
							System.out.println("\n< 謝戮 滲唳 >");
							System.out.println("廓��	  艙�倣抶�	  	 鼻艙陳瞼         翱滄   謝戮	    蕨衙陳瞼");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.print("鏃模й 蕨衙 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							int delNum;
							try {
								delNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								delNum = 0;
							}
							if (!ticketDao.checkTicket(userId, delNum)) {
								System.out.println("蕨衙 廓�ㄟ� 橈蝗棲棻");
								break;
							} else {
								if (ticketDao.deleteTicket(delNum)) {
									System.out.println("蕨衙 鏃模陛 諫猿腎歷蝗棲棻");
								} else {
									System.out.println("蕨衙 鏃模縑 褒ぬц蝗棲棻");
									break;
								}
							}
							break;
						// 頂 薑爾
						case 4:
							System.out.println("< 頂 薑爾 爾晦 >");
							User user = userDao.getUser(userId);
							System.out.println("----------------------------------------------------------------------------------\n");
							System.out.println("嬴檜蛤\t: " + user.getUserId());
							System.out.println("檜葷\t: " + user.getUserName());
							System.out.println("翱塊籀\t: " + user.getUserTel());
							System.out.println("陛殮橾\t: " + user.getJoinDate());
							System.out.println("\n----------------------------------------------------------------------------------");
							break;
						// 釭陛晦
						case 5:
							run7 = false;
							break;
						default:
							break;
						}
					} // end of while(run7)
					break;
				case 5:
					System.out.println("煎斜嬴醒 腎歷蝗棲棻");
					run2 = false;
					break;
				default:
					System.out.println("螢夥艇 翕濛擊 殮溘ж撮蹂");
				} // end of switch

			} // end of while(run2)

			// III. 婦葬濠 �飛�.
			while (run3) {
				System.out.println("\n< 婦葬濠 む檜雖 >");
				System.out.println("旨收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收旬");
				System.out.println("早 1.艙�� 婦葬 早 2.鼻艙 婦葬 早 3.蕨衙 婦葬 早 4.�蛾� 婦葬 早 5.煎斜嬴醒 早");
				System.out.println("曲收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收旭");
				System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
				int menu;
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					menu = 0;
				}
				switch (menu) {
				// 1. 艙�� 婦葬
				case 1:
					boolean run4 = true;
					int page = 1;
					while (run4) {
						System.out.println("\n< 艙�� 跡煙 >");
						System.out.println(" 廓��	  艙�� 檜葷		   馬絮                    轎翱寡辦");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovieDAO む檜癒 脹 艙�飛騇� 轎溘 л熱.
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
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
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收有收收收收收收收收有收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.薑爾 早 4.蹺陛 早 5.餉薯 早 6.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收朴收收收收收收收收朴收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 1-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 1-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 1-3. 艙�� 鼻撮 薑爾 褻��.
						case 3:
							System.out.println("\n< 艙�� 鼻撮 薑爾 褻�� >");
							System.out.print("艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String movieNumber = scn.nextLine();
							// MovieDAO 艙�� 廓�ㄦ� 艙�� 瓊朝 蘭葬 л熱.
							Movie movie = movieDao.getMovieDetail(movieNumber);
							try {
								// Movie 艙�� 薑爾 轎溘 л熱.
								movie.showMovieDetailInfo();
							} catch (NullPointerException e) {
								System.out.println("螢夥艇 艙�� 廓�ㄧ� 殮溘ж撮蹂");
							}
							break;
						// 1-4. 艙�� 蹺陛
						case 4:
							System.out.println("\n< 艙�� 薑爾 蹺陛 >");
							System.out.print("艙�食醽ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String movieNum = scn.nextLine();
							if (movieDao.chkMovie(movieNum)) {
								System.out.println("醞犒脹 艙�食醽�殮棲棻");
								break;
							}
							System.out.print("艙�倣抶尾� 殮溘ж撮蹂 \n>>>> ");
							String movieName = scn.nextLine();
							System.out.print("馬絮貲擊 殮溘ж撮蹂 \n>>>> ");
							String director = scn.nextLine();
							System.out.print("轎翱 寡辦菟擊 殮溘ж撮蹂 \n>>>> ");
							String actors = scn.nextLine();
							System.out.print("偃瑰橾擊 殮溘ж撮蹂(YYYY-MM-DD) \n>>>> ");
							String releaseDate = scn.nextLine();
							DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							try {
								LocalDate localDate = LocalDate.parse(releaseDate, formatter2);
							} catch (Exception e) {
								System.out.println("螢夥艇 陳瞼 ⑽衝擊 殮溘ж撮蹂");
								break;
							}
							System.out.print("濰腦蒂 殮溘ж撮蹂 \n>>>> ");
							String genre = scn.nextLine();
							System.out.print("翱滄薯и擊 殮溘ж撮蹂 \n>>>> ");
							int ageLimit = 0;
							try {
								ageLimit = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.print("鼻艙衛除擊 殮溘ж撮蹂 \n>>>> ");
							int runningTime = 0;
							try {
								runningTime = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.print("還剪葬蒂 殮溘ж撮蹂 \n>>>> ");
							String plot = scn.nextLine();
							Movie newMovie = new Movie(movieNum, movieName, director, releaseDate, genre, ageLimit,
									runningTime, plot, actors);
							if (movieDao.addMovie(newMovie)) {
								System.out.println("艙�� 薑爾 蹺陛陛 諫猿腎歷蝗棲棻");
							} else {
								System.out.println("艙�� 薑爾 蹺陛縑 褒ぬц蝗棲棻");
							}
							break;
						// 1-5. 艙�� 餉薯
						case 5:
							System.out.println("\n< 艙�� 薑爾 餉薯 >");
							System.out.print("艙�食醽ㄧ� 殮溘ж撮蹂 \n>>>> ");
							movieNum = scn.nextLine();
							if (movieDao.chkMovie(movieNum)) {
								String mName = movieDao.getMovieName(movieNum);
								System.out.print(mName + " 艙�飛� 餉薯ж衛啊蝗棲梱?(Y/N)");
								String delChk = scn.nextLine();
								switch (delChk) {
								case "Y":
								case "y":
									if (movieDao.deleteMovie(movieNum)) {
										System.out.println("艙�� 餉薯陛 諫猿腎歷蝗棲棻");
									} else {
										System.out.println("艙�� 餉薯縑 褒ぬц蝗棲棻");
									}
									break;
								case "N":
								case "n":
								default:
									System.out.println("艙�� 餉薯陛 鏃模腎歷蝗棲棻");
									break;
								}
							} else {
								System.out.println("艙�食醽ㄟ� 橈蝗棲棻");
								break;
							}
							break;
						// 1-6. 釭陛晦
						case 6:
							run4 = false;
							break;
						default:
							break;
						}
					}
					break;
				// 2. 鼻艙婦葬
				case 2:
					System.out.print("褻�裔� 陳瞼蒂 殮溘ж撮蹂 (YYYY-MM-DD) \n>>>> ");
					String strDate = scn.nextLine();

					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate;
					try {
						localDate = LocalDate.parse(strDate, formatter2);
					} catch (Exception e) {
						System.out.println("螢夥艇 陳瞼 ⑽衝擊 殮溘ж撮蹂");
						break;
					}
					LocalDate now = LocalDate.now();
					if (localDate.isBefore(now)) {
						System.out.println("褻�萼●囟� 陳瞼陛 嬴椎棲棻");
						break;
					}

					// 鼻艙 衛除ル 轎溘
					boolean run6 = true;
					page = 1;
					while (run6) {
						List<Schedule> schedules = scheduleDao.getAllScheduleList(strDate);
						for (int i = 0; i < schedules.size(); i++) {
							scheduleDao.updateSeats(schedules.get(i).getScheduleId());
						}

						System.out.println("\n< 鼻艙 衛除ル >");
						System.out.println("  廓��   鼻艙廓��    艙�� 檜葷	  	     鼻艙 衛除        陴擎 謝戮    й檣");
						System.out.println(
								"----------------------------------------------------------------------------------");

						scheduleDao.showScheduleList(schedules, page);

						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[⑷營 む檜雖: %d]  ", page);

						// 瞪羹 む檜雖 熱 轎溘.
						// MovieDAO 瞪羹 艙�� 跡煙 陛螳螃晦 л熱 => 艙�� 熱 count.
						int count = scheduleDao.getAllScheduleList(strDate).size();
						// 瞪羹 艙�� 熱 / 5 + 模熱 濠葩熱 螢葡 => 瞪羹 む檜雖 熱.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println("\n< 詭檣 �飛� >");
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收有收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.蹺陛 早 4.餉薯 早 5.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收朴收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;

						// 3-3. 鼻艙 衛除ル 蹺陛
						case 3:
							System.out.println("< 鼻艙 衛除ル 蹺陛 >");
							System.out.print("蹺陛й 艙�� 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String movieNum = scn.nextLine();
							System.out.print("蹺陛й 陳瞼諦 衛除渠蒂 殮溘ж撮蹂(yyyy-MM-dd HH:mm) \n>>>> ");
							String movieDate = scn.nextLine();
							DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
							LocalDateTime ldt;
							try {
								ldt = LocalDateTime.parse(movieDate, formatter3);
							} catch (Exception e) {
								System.out.println("螢夥艇 陳瞼 ⑽衝擊 殮溘ж撮蹂");
								break;
							}
							LocalDateTime ldtNow = LocalDateTime.now();
							if (ldt.isBefore(ldtNow)) {
								System.out.println("蹺陛 陛棟и 陳瞼陛 嬴椎棲棻");
								break;
							}
							if (scheduleDao.addSchedule(movieNum, movieDate)) {
								System.out.println("鼻艙 衛除ル 蹺陛陛 諫猿腎歷蝗棲棻.");
								scheduleDao.updateJojo();
								scheduleDao.updateSimya();
							} else {
								System.out.println("鼻艙 衛除ル 蹺陛縑 褒ぬц蝗棲棻.");
							}
							break;
						// 3-4. 鼻艙 衛除ル 餉薯
						case 4:
							System.out.println("\n< 鼻艙 衛除ル 餉薯 >");
							System.out.print("鼻艙 廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							int schdlNum;
							try {
								schdlNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								System.out.println("螢夥艇 鼻艙 廓�ㄧ� 殮溘ж撮蹂");
								break;
							}
							if (scheduleDao.chkSchedule(schdlNum)) {
								System.out.print(schdlNum + "廓 鼻艙 薑爾蒂 餉薯ж衛啊蝗棲梱?(Y/N) \n>>>> ");
								String delChk = scn.nextLine();
								switch (delChk) {
								case "Y":
								case "y":
									if (scheduleDao.delSchedule(schdlNum)) {
										System.out.println("鼻艙 薑爾 餉薯陛 諫猿腎歷蝗棲棻");
									} else {
										System.out.println("鼻艙 薑爾 餉薯縑 褒ぬц蝗棲棻");
									}
									break;
								case "N":
								case "n":
								default:
									System.out.println("鼻艙 薑爾 餉薯陛 鏃模腎歷蝗棲棻");
									break;
								}
							} else {
								System.out.println("艙�食醽ㄟ� 橈蝗棲棻");
								break;
							}
							break;
						case 5:
							run6 = false;
							break;
						default:
							break;
						}
					} // end of while(run6)
					break;
				// 3. 蕨衙 婦葬
				case 3:
					System.out.println("< 蕨衙 婦葬 >");
					System.out.print("褻�裔� 陳瞼蒂 殮溘ж撮蹂(YYYY-MM-DD) \n>>>> ");
					String srcDate = scn.nextLine();
					formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					try {
						localDate = LocalDate.parse(srcDate, formatter2);
					} catch (Exception e) {
						System.out.println("螢夥艇 陳瞼 ⑽衝擊 殮溘ж撮蹂");
						break;
					}

					boolean run8 = true;
					page = 1;
					while (run8) {
						List<Ticket> tickets = ticketDao.getTicketList(srcDate);

						System.out.println("\n< 蕨衙 頂羲 >");
						System.out.println("  廓��       嬴檜蛤    鼻艙 廓��  翱滄    謝戮         陛問         蕨衙橾濠");
						System.out.println(
								"---------------------------------------------------------------------------------------");

						ticketDao.showScheduleList(tickets, page);

						System.out.println(
								"---------------------------------------------------------------------------------------");
						System.out.printf("[⑷營 む檜雖: %d]  ", page);

						// 瞪羹 む檜雖 熱 轎溘.
						// MovieDAO 瞪羹 艙�� 跡煙 陛螳螃晦 л熱 => 艙�� 熱 count.
						int count = ticketDao.getTicketList(srcDate).size();
						// 瞪羹 艙�� 熱 / 5 + 模熱 濠葩熱 螢葡 => 瞪羹 む檜雖 熱.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println();
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.衙轎 �挫� 早 4.釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 3-3. 衙轎 褻��
						case 3:
							ticketDao.dailySales();
							break;
						// 3-4. 釭陛晦
						case 4:
							run8 = false;
							break;
						default:
							break;
						}
					}
					break;
				// 4. �蛾� 婦葬
				case 4:
					System.out.println("\n< �蛾� 婦葬 >");
					page = 1;
					boolean run9 = true;
					while (run9) {
						List<User> users = userDao.getUserList();

						System.out.println("\n< 鼻艙 衛除ル >");
						System.out.println("  廓��  嬴檜蛤     檜葷	  	   翱塊籀        陛殮橾濠");
						System.out.println(
								"----------------------------------------------------------------------------------");

						userDao.showUserList(users, page);

						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[⑷營 む檜雖: %d]  ", page);

						// 瞪羹 む檜雖 熱 轎溘.
						// MovieDAO 瞪羹 艙�� 跡煙 陛螳螃晦 л熱 => 艙�� 熱 count.
						int count = userDao.getUserList().size();
						// 瞪羹 艙�� 熱 / 5 + 模熱 濠葩熱 螢葡 => 瞪羹 む檜雖 熱.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println();
						System.out.println("旨收收收收收收收收收收收收收收收有收收收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收收收有收收收收收收收收收收收旬");
						System.out.println("早 1.檜瞪 む檜雖 早 2.棻擠 む檜雖 早 3.�蛾� 蹺陛 早 4.�蛾� 餉薯 早 5. 釭陛晦 早");
						System.out.println("曲收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收收收朴收收收收收收收收收收收旭");
						System.out.print("翕濛擊 殮溘ж撮蹂 \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 4-1. 檜瞪 む檜雖.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 4-2. 棻擠 む檜雖.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 4-3. 釭陛晦
						case 3:
							System.out.println("\n< �蛾� 蹺陛 >");
							System.out.print("蹺陛й 嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
							userId = scn.nextLine();

							// 婦葬濠 嬴檜蛤 儅撩 寞雖
							if (userId.equals("sys")) {
								System.out.println("儅撩й 熱 橈朝 嬴檜蛤殮棲棻");
								break;
							}
							// 醞犒 嬴檜蛤 儅撩 寞雖
							if (userDao.chkUserId(userId)) {
								System.out.println("檜嘐 襄營ж朝 嬴檜蛤殮棲棻");
								break;
							}

							System.out.print("綠塵廓�ㄧ� 殮溘ж撮蹂 \n>>>> ");
							String passwd = scn.nextLine();
							System.out.print("綠塵廓�ㄧ� и廓 渦 殮溘ж撮蹂 \n>>>> ");
							String passwd2 = scn.nextLine();

							// 綠塵廓�� 橾纂 �挫�.
							if (!passwd.equals(passwd2)) {
								System.out.println("綠塵廓�ㄟ� 棻落棲棻");
								break;
							}

							System.out.print("檜葷擊 殮溘ж撮蹂 \n>>>> ");
							String userName = scn.nextLine();
							System.out.print("翱塊籀蒂 殮溘ж撮蹂 \n>>>> ");
							String userTel = scn.nextLine();

							User user = new User(userId, passwd, userName, userTel);
							if (userDao.signUp(user)) {
								System.out.println("�蛾� 蹺陛陛 諫猿腎歷蝗棲棻");
							}
							else {
								System.out.println("�蛾� 蹺陛縑 褒ぬц蝗棲棻");
							}
							break;
						case 4:
							System.out.println("\n< �蛾� 餉薯 >");
							System.out.print("餉薯й 嬴檜蛤蒂 殮溘ж撮蹂 \n>>>> ");
							userId = scn.nextLine();
							// 婦葬濠 嬴檜蛤 餉薯 寞雖
							if (userId.equals("sys")) {
								System.out.println("餉薯й 熱 橈朝 嬴檜蛤殮棲棻");
								break;
							}
							// 橈朝 嬴檜蛤 殮溘 寞雖
							if (!userDao.chkUserId(userId)) {
								System.out.println("襄營ж雖 彊朝 嬴檜蛤殮棲棻");
								break;
							}
							if(userDao.deleteUser(userId)) {
								System.out.println("�蛾� 餉薯陛 諫猿腎歷蝗棲棻");
							}
							else {
								System.out.println("�蛾� 餉薯縑 褒ぬц蝗棲棻");
							}
							
							break;
						case 5:
							run9 = false;
							break;
						default:
							break;
						}
					}
					break;
				case 5:
					System.out.println("煎斜嬴醒 腎歷蝗棲棻");
					run3 = false;
					break;
				default:
					break;
				}
			} // end of while(run3)
		} // end of while(run0)
		scn.close();
		System.out.println("end of prog.");
	}

}
