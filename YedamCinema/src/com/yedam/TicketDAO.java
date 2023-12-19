package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 0. 오라클 DB 연결.
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 0-1. DB 연결 해제
	void disConn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 1. 티켓 생성
	boolean reserveTicket(Ticket ticket) {
		getConn();
		String sql = "INSERT INTO  ticket "//
				+ "VALUES      (ticket_id_seq.NEXTVAL,?,?,?,?,?,?,?,"//
				+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ticket.getUser_id());
			psmt.setInt(2, ticket.getSchedule_id());
			psmt.setString(3, ticket.getAge());
			psmt.setString(4, ticket.getSeat_row().toUpperCase());
			psmt.setInt(5, ticket.getSeat_column());
			psmt.setString(6, ticket.getDiscount());
			psmt.setInt(7, ticket.getPrice());
			psmt.setString(8, ticket.getReserveDate());

			int r = psmt.executeUpdate(); // 처리된 건수 반환 => 한 건 처리시 1
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

//	
	// 1-1. 빈자리 찾기
	boolean isOccupied(String row, int column) {
		getConn();
		String sql = "SELECT  * "//
				+ "FROM    ticket "//
				+ "WHERE   seat_row = ? "//
				+ "AND     seat_column = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, row);
			psmt.setInt(2, column);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 2. 예매 확인
	void showTicket(String userId) {
		getConn();
		String sql = "SELECT  t.ticket_id, s.schedule_id, TO_CHAR(s.schedule_date, 'YYYY-MM-DD HH24:MI') str_date, "//
				+ "			  m.movie_name, t.age, t.seat_row, t.seat_column, "//
				+ "			  TO_CHAR(t.reserve_date, 'YYYY-MM-DD HH24:MI:SS') rsv_date "//
				+ "FROM    ticket t, schedule s, movie m "//
				+ "WHERE   t.schedule_id = s.schedule_id "//
				+ "AND     s.movie_id = m.movie_id "//
				+ "AND     t.user_id = ? " + "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.printf("%3s %-15s %20s %7s %4s %-2d %20s\n", //
						rs.getString("ticket_id"), rs.getString("movie_name"), rs.getString("str_date"), //
						rs.getString("age"), rs.getString("seat_row"), //
						rs.getInt("seat_column"), rs.getString("rsv_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

	// 전체 예매 내역 가져오기
	List<Ticket> getTicketList(String date) {
		getConn();
		List<Ticket> tickets = new ArrayList<>();
		String sql = "SELECT  ticket_id, user_id, schedule_id, "//
				+ "			  age, seat_row, seat_column, discount, price, reserve_date " //
				+ "FROM    ticket "//
				+ "WHERE   TO_CHAR(reserve_date, 'yyyy-MM-dd') = ? " + "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Ticket ticket = new Ticket(getSequence(tickets), rs.getInt("ticket_id"), rs.getString("user_id"),
						rs.getInt("schedule_id"), rs.getString("age"), rs.getString("seat_row"),
						rs.getInt("seat_column"), rs.getString("discount"), rs.getInt("price"),
						rs.getString("reserve_date"));
				tickets.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return tickets;
	}

	// 페이징
	public static List<Ticket> paging(List<Ticket> ticketList, int page) {
		List<Ticket> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 부터 시작
		int end = page * 5; // 5 전까지 (5개)

		for (int i = 0; i < ticketList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(ticketList.get(i));
			}
		}
		return resultList;
	}

	// 예매내역 페이징해서 출력
	public void showScheduleList(List<Ticket> searchTicket, int page) {
		List<Ticket> pagedTicketList = paging(searchTicket, page);

		for (Ticket ticket : pagedTicketList) {
			ticket.showInfo();
		}
	}

	// 번호 자동 매기기
	public static int getSequence(List<Ticket> schedules) {
		int seqNum = 1;
		int maxNum = 0; // 최대 번호 값 저장

		for (Ticket schdl : schedules) {
			if (schdl.getNum() > maxNum) {
				maxNum = schdl.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// 3. 좌석 변경
	boolean modifyTicket(int ticketId, String row, int column) {
		getConn();
		String sql = "UPDATE ticket "//
				+ "SET    seat_row = ?, seat_column = ? "//
				+ "WHERE  ticket_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, row);
			psmt.setInt(2, column);
			psmt.setInt(3, ticketId);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	int getScheduleId(int ticketId) {
		getConn();
		String sql = "SELECT  t.ticket_id, s.schedule_id "//
				+ "FROM    ticket t, schedule s "//
				+ "WHERE   t.schedule_id = s.schedule_id "//
				+ "AND     t.ticket_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("schedule_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return 0;

	}

	// 4. 예매 여부 확인
	boolean checkTicket(String userId, int ticketId) {
		getConn();
		String sql = "SELECT   * "//
				+ "FROM    ticket "//
				+ "WHERE   user_id = ? "//
				+ "AND     ticket_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setInt(2, ticketId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 5. 예매 취소
	boolean deleteTicket(int ticketId) {
		getConn();
		String sql = "DELETE  ticket "//
				+ "WHERE   ticket_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketId);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;

	}

	// 오늘 매출 조회
	void dailySales() {
		getConn();
		String sql = "SELECT  COUNT(*) count, SUM(price) sum "
					+ "FROM    ticket "
					+ "WHERE   TO_CHAR(reserve_date, 'YYYY-MM-DD') =  TO_CHAR(SYSDATE, 'YYYY-MM-DD')";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("오늘의 예매 수 : " + rs.getInt("count"));
				System.out.println("오늘의 매출    : " + rs.getInt("sum") + "원");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

}
