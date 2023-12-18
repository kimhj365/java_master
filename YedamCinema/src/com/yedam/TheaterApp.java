package com.yedam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {

		// UserDAO, MovieDAO 객체 생성.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		ScheduleDAO scheduleDao = new ScheduleDAO();
		TicketDAO ticketDao = new TicketDAO();

		// Oracle DB 접속.

		Scanner scn = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		boolean run3 = true;
		String userId = "";

		// 0. 시작 타이틀.
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃ ★                                                                 ★ ┃");
		System.out.println("┃                         예담시네마 동성로점                         ┃");
		System.out.println("┃ ★                                                                 ★ ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		// I. 로그인 / 회원가입.
		while (run1) {
			System.out.println();
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

			switch (menu) {
			// 1. 로그인.
			case 1:
				System.out.println("\n< 로그인 >");
				System.out.print("아이디를 입력하세요 \n>>>> ");
				userId = scn.nextLine();
				System.out.print("비밀번호를 입력하세요 \n>>>> ");
				String passwd = scn.nextLine();

				// UserDAO 로그인 함수 호출.
				if (userDao.login(userId, passwd)) {
					System.out.println("로그인 완료!");
					// UserDAO 유저 이름 가져오기 함수 호출.
					String userName = userDao.getName(userId);
					System.out.println(userName + " 님 환영합니다!");

					// 관리자 계정일시 관리자 페이지로 바로 넘어감
					if (userId.equals("sys")) {
						run2 = false;
					}

					run1 = false;
				} else {
					System.out.println("아이디와 비밀번호를 확인하세요");
				}
				break;

			// 2. 회원가입.
			case 2:
				System.out.println("\n< 회원 가입 >");
				System.out.print("아이디를 입력하세요 \n>>>> ");
				userId = scn.nextLine();

				// 관리자 아이디 생성 방지
				if (userId.equals("sys")) {
					System.out.println("생성할 수 없는 아이디입니다");
					break;
				}
				// 중복 아이디 생성 방지
				if (!userDao.chkUserId(userId)) {
					System.out.println("이미 존재하는 아이디입니다");
					break;
				}

				System.out.print("비밀번호를 입력하세요 \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("비밀번호를 한번 더 입력하세요 \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("이름을 입력하세요 \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("연락처를 입력하세요 \n>>>> ");
				String userTel = scn.nextLine();

				// 비밀번호 일치 확인.
				if (passwd.equals(passwd2)) {
					// User 객체 생성 => UseDAO 회원가입 함수 인수값.
					User user = new User(userId, passwd, userName, userTel);
					if (userDao.signUp(user)) {
						System.out.println("회원가입 완료!");
					}
				} else {
					System.out.println("비밀번호가 다릅니다");
				}
				break;
			default:
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch
		} // end of while(run1)

		// II. 유저 화면
		while (run2) {
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

			switch (menu) {
			// 1 전체 영화 목록 조회.
			case 1:
				boolean run4 = true;
				int page = 1;
				while (run4) {
					System.out.println("\n< 영화 목록 >");
					System.out.println(" 번호	  영화 이름		   감독                    출연배우");
					System.out.println(
							"----------------------------------------------------------------------------------");
					// MovieDAO 페이징 된 영화목록 출력 함수.
					movieDao.showMovieList(page);
					System.out.println(
							"----------------------------------------------------------------------------------");
					System.out.printf("[현재 페이지: %d]  ", page);

					// 전체 페이지 수 출력.
					// MovieDAO 전체 영화 목록 가져오기 함수 => 영화 수 count.
					int count = movieDao.getMovieList().size();
					// 전체 영화 수 / 5 + 소수 자릿수 올림 => 전체 페이지 수.
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}

					// 서브메뉴.
					System.out.println();
					System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
					System.out.println("┃ 1.이전 페이지 ┃ 2. 다음페이지 ┃ 3. 영화 상세 정보 ┃ 4. 나가기 ┃");
					System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
					System.out.print("동작을 입력하세요 \n>>>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}

					switch (subMenu) {
					// 1-1. 이전 페이지.
					case 1:
						if (page > 1) {
							page--;
						}
						break;
					// 1-2. 다음 페이지.
					case 2:
						if (page < totalPage) {
							page++;
						}
						break;
					// 1-3. 영화 상세 정보 조회.
					case 3:
						System.out.println("\n< 영화 상세 정보 조회 >");
						System.out.print("영화 번호를 입력하세요 \n>>>> ");
						String movieNumber = scn.nextLine();
						// MovieDAO 영화 번호로 영화 찾는 쿼리 함수.
						Movie movie = movieDao.getMovieDetail(movieNumber);
						try {
							// Movie 영화 정보 출력 함수.
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("올바른 영화 번호를 입력하세요");
						}
						break;
					// 1-4. 나가기
					case 4:
						run4 = false;
						break;
					default:
						break;
					}
				}
				break;

			// 2. 영화 검색.
			case 2:
				System.out.println("\n< 영화 검색 >");
				System.out.print("검색어를 입력하세요 \n>>>> ");
				String search = scn.nextLine();

				System.out.println("< 영화 목록 >");
				System.out.println(" 번호	  영화 이름		   감독                    출연 배우");
				System.out
						.println("----------------------------------------------------------------------------------");
				// MovieDAO 영화 찾기 함수.
				List<Movie> movies = movieDao.searchMovie(search);

				for (int i = 0; i < movies.size(); i++) {
					// Movie 영화 정보 출력함수.
					movies.get(i).showMovieInfo();
				}
				System.out
						.println("----------------------------------------------------------------------------------");

				// 서브메뉴.
				System.out.println();
				System.out.println("┏━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
				System.out.println("┃ 1.영화 상세 정보 ┃ 2. 나가기 ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
				System.out.print("동작을 입력하세요 \n>>>> ");

				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}

				switch (subMenu) {
				// 2-1. 영화 상세정보 조회 (== 1-3).
				case 1:
					System.out.println("\n< 영화 상세 정보 조회 >");
					System.out.print("영화 번호를 입력하세요 \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovieDetail(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("올바른 영화 번호를 입력하세요");
					}
					break;
				// 2-2. 나가기.
				case 2:
					break;
				default:
					break;
				}

				break;

			// 3. 영화 예매.
			case 3:
				boolean run5 = true;
				page = 1;
				while (run5) {
					System.out.println("\n< 영화 목록 >");
					System.out.println(" 번호	  영화 이름		   감독                    출연배우");
					System.out.println(
							"----------------------------------------------------------------------------------");
					// MovidDAO 예매 가능한 영화조회 함수(오늘 날짜 기준)/
					movieDao.showMovieList(page);
					System.out.println(
							"----------------------------------------------------------------------------------");
					System.out.printf("[현재 페이지: %d]  ", page);

					int count = movieDao.getMovieList().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}

					// 서브메뉴.
					System.out.println();
					System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
					System.out.println("┃ 1.이전 페이지 ┃ 2. 다음페이지 ┃ 3. 영화 예매 하기 ┃ 4. 나가기 ┃");
					System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
					System.out.print("동작을 입력하세요 \n>>>> ");
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}

					switch (subMenu) {
					// 3-1. 이전 페이지.
					case 1:
						if (page > 1) {
							page--;
						}
						break;
					// 3-2. 다음 페이지.
					case 2:
						if (page < totalPage) {
							page++;
						}
						break;
					// 3-3. 예매하기
					case 3:
						System.out.println("\n< 영화 예매 하기 >");

						// 3-3-1. 날짜 선택
						System.out.print("예매할 날짜를 입력하세요 (YYYY-MM-DD) \n>>>> ");
						String strDate = scn.nextLine();

						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate;
						try {
							localDate = LocalDate.parse(strDate, formatter2);
						} catch (Exception e) {
							System.out.println("올바른 날짜 형식을 입력하세요");
							break;
						}
						LocalDate now = LocalDate.now();
						if (localDate.isBefore(now)) {
							System.out.println("예매가능한 날짜가 아닙니다");
							break;
						}

						// 3-3-2. 영화 선택
						System.out.print("예매할 영화 번호를 입력하세요 \n>>>> ");
						String movieNumber = scn.nextLine();

						List<Movie> movies2 = movieDao.getMovieList();
						boolean chk = false;
						for (Movie movie : movies2) {
							if (movie.getMovieNumber().equals(movieNumber)) {
								chk = true;
							}
						}
						if (!chk) {
							System.out.println("올바른 영화 번호를 입력하세요");
							break;
						}

						// 상영 시간표 출력
						boolean run6 = true;
						while (run6) {
							List<Schedule> schedules = scheduleDao.getScheduleList(movieNumber, strDate);
							for (int i = 0; i < schedules.size(); i++) {
								scheduleDao.updateSeats(schedules.get(i).getScheduleId());
							}

							System.out.println("\n< 상영 시간표 >");
							System.out.println("  번호	  영화 이름	  	  상영 시간        남은 좌석      할인");
							System.out.println(
									"----------------------------------------------------------------------------------");

							scheduleDao.showScheduleList(schedules, page);

							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.printf("[현재 페이지: %d]  ", page);

							// 전체 페이지 수 출력.
							// MovieDAO 전체 영화 목록 가져오기 함수 => 영화 수 count.
							count = scheduleDao.getScheduleList(movieNumber, strDate).size();
							// 전체 영화 수 / 5 + 소수 자릿수 올림 => 전체 페이지 수.
							totalPage = (int) Math.ceil(count / 5.0);
							for (int i = 1; i <= totalPage; i++) {
								System.out.print(i + " ");
							}

							System.out.println();
							System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
							System.out.println("┃ 1.이전 페이지 ┃ 2. 다음페이지 ┃ 3. 상영 시간 선택 ┃ 4. 나가기 ┃");
							System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
							System.out.print("동작을 입력하세요 \n>>>> ");
							try {
								subMenu = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								subMenu = 0;
							}

							switch (subMenu) {
							// 3-1. 이전 페이지.
							case 1:
								if (page > 1) {
									page--;
								}
								break;
							// 3-2. 다음 페이지.
							case 2:
								if (page < totalPage) {
									page++;
								}
								break;

							// 3-3. 영화 예매
							case 3:
								System.out.print("\n예매할 상영 번호를 입력하세요 \n>>>> ");
								int scheduleNum = 0;
								try {
									scheduleNum = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									System.out.println("정확한 상영번호를 입력해주세요");
									break;
								}
								int scheduleId = scheduleDao.getScheduleId(scheduleNum, schedules);
								String discount = scheduleDao.getDiscount(scheduleNum, schedules);

								System.out.println("예매 매수를 입력해주세요");
								int adult = 0;
								int youth = 0;

								try {
									System.out.print("성인  >>>> ");
									adult = Integer.parseInt(scn.nextLine());
									System.out.print("청소년  >>>> ");
									youth = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									System.out.println("정확한 예매 매수를 입력해주세요");
									break;
								}

								char rowChar;
								int column = 0;
								for (int i = 0; i < adult; i++) {
									scheduleDao.showSeats();

									System.out.println("예매할 좌석을 선택하세요(성인)");
									try {
										System.out.print("\n행을 입력하세요(A~E) \n>>>> ");
										rowChar = scn.nextLine().toUpperCase().charAt(0);
										if (rowChar < 65 || rowChar > 69) {
											System.out.println("올바른 좌석 번호를 입력하세요");
											break;
										}

										System.out.print("\n열을 입력하세요(1~10) \n>>>> ");
										column = Integer.parseInt(scn.nextLine());

										if (column < 1 || column > 10) {
											System.out.println("올바른 좌석 번호를 입력하세요");
											break;
										}

									} catch (Exception e) {
										System.out.println("올바른 좌석 번호를 입력하세요");
										break;
									}

									String row = String.valueOf(rowChar);
									Ticket ticket = new Ticket(userId, scheduleId, "성인", row, column, discount);

									System.out.println(ticket.reserveDate);
									if (ticketDao.isOccupied(row, column)) {
										System.out.println("이미 예매된 좌석입니다\n");
										i--;
									} else {
										if (ticketDao.reserveTicket(ticket)) {
											;
											System.out.println("예매가 완료되었습니다");
											for (int j = 0; j < schedules.size(); j++) {
												scheduleDao.updateSeats(schedules.get(i).getScheduleId());
											}
										} else {
											System.out.println("예매에 실패했습니다");
										}
									}

								} // end of for

								for (int i = 0; i < youth; i++) {
									scheduleDao.showSeats();

									System.out.println("예매할 좌석을 선택하세요(청소년)");
									try {
										System.out.print("\n행을 입력하세요(A~E) \n>>>> ");
										rowChar = scn.nextLine().toUpperCase().charAt(0);
										if (rowChar < 65 || rowChar > 69) {
											System.out.println("올바른 좌석 번호를 입력하세요");
											break;
										}

										System.out.print("\n열을 입력하세요(1~10) \n>>>> ");
										column = Integer.parseInt(scn.nextLine());

										if (column < 1 || column > 10) {
											System.out.println("올바른 좌석 번호를 입력하세요");
											break;
										}

									} catch (Exception e) {
										System.out.println("올바른 좌석 번호를 입력하세요");
										break;
									}

									String row = String.valueOf(rowChar);
									Ticket ticket = new Ticket(userId, scheduleId, "청소년", row, column, discount);
									if (ticketDao.isOccupied(row, column)) {
										System.out.println("이미 예매된 좌석입니다\n");
										i--;
									} else {
										if (ticketDao.reserveTicket(ticket)) {
											;
											System.out.println("예매가 완료되었습니다");
											for (int j = 0; j < schedules.size(); j++) {
												scheduleDao.updateSeats(schedules.get(i).getScheduleId());
											}
										} else {
											System.out.println("예매에 실패했습니다");
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
						} // end of while(run5)
					case 4:
						run5 = false;
						break;
					default:
						break;

					}
				} // end of while(run4)

			// 4. 마이페이지
			case 4:
				boolean run7 = true;
				while (run7) {
					System.out.println();
					System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
					System.out.println("┃ 1.예매 확인 ┃ 2. 좌석 변경 ┃ 3. 예매 취소 ┃ 4. 나가기 ┃");
					System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━┻━━━━━━━━━━━┛");
					System.out.print("동작을 입력하세요 \n>>>> ");
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}

					switch (subMenu) {
					// 4-1. 예매 확인
					case 1:
						System.out.println("\n< 예매 확인 >");
						System.out.println("번호	  영화이름	  	 상영날짜         연령   좌석	    예매날짜");
						System.out.println(
								"----------------------------------------------------------------------------------");
						ticketDao.showTicket(userId);
						System.out.println(
								"----------------------------------------------------------------------------------");
						break;
					// 4-2. 좌석 변경
					case 2:
						System.out.println("\n< 좌석 변경 >");
						System.out.println("번호	  영화이름	  	 상영날짜         연령   좌석	    예매날짜");
						System.out.println(
								"----------------------------------------------------------------------------------");
						ticketDao.showTicket(userId);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.print("좌석을 변경할 예매 번호를 입력하세요 \n>>>> ");
						int modNum;
						try {
							modNum = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							modNum = 0;
						}
						if (!ticketDao.checkTicket(userId, modNum)) {
							System.out.println("예매 번호가 없습니다");
							break;
						} else {
							ticketDao.getScheduleId(modNum);

							char rowChar;
							int column = 0;
							scheduleDao.showSeats();

							System.out.println("변경할 좌석을 선택하세요");
							try {
								System.out.print("\n행을 입력하세요(A~E) \n>>>> ");
								rowChar = scn.nextLine().toUpperCase().charAt(0);
								if (rowChar < 65 || rowChar > 69) {
									System.out.println("올바른 좌석 번호를 입력하세요");
									break;
								}

								System.out.print("\n열을 입력하세요(1~10) \n>>>> ");
								column = Integer.parseInt(scn.nextLine());

								if (column < 1 || column > 10) {
									System.out.println("올바른 좌석 번호를 입력하세요");
									break;
								}

							} catch (Exception e) {
								System.out.println("올바른 좌석 번호를 입력하세요");
								break;
							}

							String row = String.valueOf(rowChar);

							if (ticketDao.isOccupied(row, column)) {
								System.out.println("이미 예매된 좌석입니다\n");
								break;
							} else {
								if (ticketDao.modifyTicket(modNum, row, column)) {
									System.out.println("좌석 변경이 완료되었습니다");
								} else {
									System.out.println("좌석 변경에 실패했습니다");
								}
							}
						}
					// 예매 취소
					case 3:
						System.out.println("\n< 좌석 변경 >");
						System.out.println("번호	  영화이름	  	 상영날짜         연령   좌석	    예매날짜");
						System.out.println(
								"----------------------------------------------------------------------------------");
						ticketDao.showTicket(userId);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.print("좌석을 변경할 예매 번호를 입력하세요 \n>>>> ");
						int delNum;
						try {
							delNum = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							delNum = 0;
						}
						if (!ticketDao.checkTicket(userId, delNum)) {
							System.out.println("예매 번호가 없습니다");
							break;
						}  else {
							if(ticketDao.deleteTicket(delNum)) {
								System.out.println("예매 취소가 완료되었습니다");
							} else {
								System.out.println("예매 취소에 실패했습니다");
								break;
							}
						}
						
						break;
					case 4:
						run7 = false;
						break;
					default:
						break;
					}
				}
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
		
		// III. 관리자 화면.
		while(run3) {
			System.out.println("관리자 화면입니다");
			break;
		}
		System.out.println("end of prog.");
	}

}
