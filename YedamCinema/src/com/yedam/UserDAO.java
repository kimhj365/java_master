package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 0. 오라클 DB 연결
	Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:xe";
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
	User getUser(String userId) {
		getConn();
		User user = new User();
		String sql = "SELECT * "//
				+ "	  FROM	 t_user "//
				+ "   WHERE  user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getString("user_id"));
				user.setPasswd(rs.getString("passwd"));
				user.setUserName(rs.getString("user_name"));
				user.setUserTel(rs.getString("user_tel"));
				user.setJoinDate(rs.getString("join_date"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return null;
	}

	// 1. 로그인.
	boolean login(String id, String pw) {
		getConn();
		String sql = "SELECT	* "//
				+ "FROM		t_user "//
				+ "WHERE		user_id = ? "//
				+ "AND		passwd = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 1-1. 회원 이름 가져오기
	String getName(String userId) {
		getConn();
		String sql = "SELECT * "//
				+ "FROM   t_user "//
				+ "WHERE  user_id = ?";
		String userName = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				userName = rs.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return userName;
	}

	// 2. 회원 가입.
	boolean signUp(User user) {
		getConn();
		String sql = "INSERT INTO t_user(user_id, passwd, user_name, user_tel) " 
					+ "VALUES (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getPasswd());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserTel());

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

	// 2-1. 중복 아이디 가입 방지
	boolean chkUserId(String userId) {
		getConn();
		String sql = "SELECT * "//
				+ "FROM   t_user "//
				+ "WHERE  user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}
	
	// 유저 정보 가져오기
	List<User> getUserList() {
		getConn();
		List<User> users = new ArrayList<>();
		String sql = "SELECT * "//
				+ "FROM   t_user "//
				+ "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				User user = new User(getSequence(users),rs.getString("user_id"), rs.getString("passwd"), rs.getString("user_name"),
						rs.getString("user_tel"), rs.getString("join_date"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return users;
	}

	// 페이징
	public static List<User> paging(List<User> userList, int page) {
		List<User> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 부터 시작
		int end = page * 5; // 5 전까지 (5개)

		for (int i = 0; i < userList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(userList.get(i));
			}
		}
		return resultList;
	}

	// 예매내역 페이징해서 출력
	public void showUserList(List<User> searchTicket, int page) {
		List<User> pagedTicketList = paging(searchTicket, page);

		for (User user : pagedTicketList) {
			user.showUserInfo();
		}
	}

	// 번호 자동 매기기
	public static int getSequence(List<User> users) {
		int seqNum = 1;
		int maxNum = 0; // 최대 번호 값 저장

		for (User user : users) {
			if (user.getNum() > maxNum) {
				maxNum = user.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// 유저 삭제
	boolean deleteUser(String userId) {
		getConn();
		String sql = "DELETE t_user " 
					+ "WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환 => 한 건 처리시 1
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disConn();
		}
		return false;
	}
	
}
