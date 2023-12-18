package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

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

	// 1. 상영 시간표 가져오기.
	List<Schedule> getScheduleList(String movieId, String strDate) {
		getConn();
		List<Schedule> schedule = new ArrayList<>();
		String sql = "SELECT  s.schedule_id, m.movie_name, "//
				+ "        TO_CHAR(s.schedule_date, 'yyyy-MM-dd HH24:MI') date_time, "//
				+ "		  s.remain_seat, s.discount  "//
				+ "   FROM    schedule s, movie m "//
				+ "   WHERE   s.movie_id = m.movie_id "//
				+ "   AND     s.movie_id = ? "//
				+ "   AND	  TO_CHAR(s.schedule_date, 'yyyy-MM-dd') = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieId);
			psmt.setString(2, strDate);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Schedule schdl = new Schedule(getSequence(schedule), rs.getInt("schedule_id"),
						rs.getString("movie_name"), rs.getString("date_time"), rs.getInt("remain_seat"),
						rs.getString("discount"));

				schedule.add(schdl);
			}
		} catch (SQLException e) {
			return schedule;
		} finally {
			disConn();
		}
		return schedule;
	}

	// 1-1. 상영 시간표 페이징.
	public static List<Schedule> paging2(List<Schedule> scheduleList, int page) {
		List<Schedule> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 부터 시작
		int end = page * 5; // 5 전까지 (5개)

		for (int i = 0; i < scheduleList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(scheduleList.get(i));
			}
		}
		return resultList;
	}

	// 1-2. 상영시간표 페이징해서 출력
	public void showScheduleList(List<Schedule> searchSchedule, int page) {
		List<Schedule> pagedScheduleList = paging2(searchSchedule, page);

		for (Schedule schedule : pagedScheduleList) {
			schedule.showInfo();
		}
	}

	// 1-3. 번호 자동 매기기
	public static int getSequence(List<Schedule> schedules) {
		int seqNum = 1;
		int maxNum = 0; // 최대 번호 값 저장

		for (Schedule schdl : schedules) {
			if (schdl.getNum() > maxNum) {
				maxNum = schdl.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// 1-4. scheduleId 가져오기
	int getScheduleId(int scheduleNum, List<Schedule> schedules) {
		for (Schedule schdl : schedules) {
			if (schdl.getNum() == scheduleNum) {
				return schdl.getScheduleId();
			}
		}
		return 0;
	}
	
	// 1-5. discount 가져오기
	String getDiscount(int scheduleNum, List<Schedule> schedules) {
		for (Schedule schdl : schedules) {
			if (schdl.getNum() == scheduleNum) {
				return schdl.getDiscount();
			}
		}
		return null;
	}
	
	// 2. 좌석 출력
	// 2-1. 좌석 초기화
	String[][] iniSeats() {
		String[][] seat = new String[5][11];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 11; j++) {
				seat[i][j] = "□";
			}
		}
		return seat;
	}

	// 2-2. 좌석 출력
	void showSeats() {
		getConn();
		String[][] seat = iniSeats();

		String sql = "SELECT  ticket_id, seat_row, seat_column "//
				+ "FROM   ticket ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			int seat_row = 0;

			while (rs.next()) {
				switch (rs.getString("seat_row")) {
				case "A":
				case "a":
					seat_row = 0;
					break;
				case "B":
				case "b":
					seat_row = 1;
					break;
				case "C":
				case "c":
					seat_row = 2;
					break;
				case "D":
				case "d":
					seat_row = 3;
					break;
				case "E":
				case "e":
					seat_row = 4;
				}
				seat[seat_row][rs.getInt("seat_column")] = "■";
			}
		} catch (SQLException e) {
			return;
		}

		char row = 'A';
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		for (int i = 0; i < 5; i++) {
			System.out.print(row + " ");

			for (int j = 1; j < 11; j++) {
				System.out.print(seat[i][j] + " ");
			}
			row++;
			System.out.println();
		}

		disConn();
	}

	// 남은 자리 수 DB에 반영
	void updateSeats(int schedulId) {
		getConn();
		String sql = "UPDATE  schedule "//
				+ "SET     remain_seat = 50 - (SELECT  COUNT(*) "//
				+ "                            FROM    ticket "//
				+ "                            WHERE   schedule_id = ?) "//
				+ "WHERE   schedule_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, schedulId);
			psmt.setInt(2, schedulId);

			int r = psmt.executeUpdate(); // 처리된 건수 반환 => 한 건 처리시 1

			if (r > 0) {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return;

	}

}
