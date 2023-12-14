package remind06;

import java.sql.*;

// 저장공간 : Oracle DB.

// 추가, 수정, 삭제(executeUpdate) / 목록, 단건 조회(executeQuery) 기능.
public class StudentDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// 오라클 DB에 접속
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	
	// 목록 조회.
	Student[] getStudentList() {
		getConn();
		Student[] students = new Student[10];
		String sql = "SELECT * FROM student ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// Resultset.next() : 데이터 자리를 가리키는 커서
			//                    데이터가 있는 곳 가리키면 TRUE, 없는 곳 가리키면 FALSE
			while(rs.next()) {
				Student student = new Student();
				student.setStuNum(rs.getString("student_number"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("english_score"));
				student.setMathScore(rs.getInt("mathematics_score"));
				
				// 배열의 빈 곳에 한 건 저장.				
				for (int i = 0; i < students.length; i++) {
					if(students[i] == null) { 
						students[i] = student;
						break; // for 반복문 종료.
						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	// 정보 추가.
	boolean addStudent(Student std) {
		getConn();
		String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStuNum());
			psmt.setString(2, std.getStuName());
			psmt.setInt(3, std.getEngScore());
			psmt.setInt(4, std.getMathScore());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환 => 한 건 처리시 1
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 단건 조회.
	Student getStudent(String sno) {
		getConn();
		String sql = "SELECT * FROM student WHERE student_number = ?";	// 물음표 따옴표 묶으면 안됨
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Student student = new Student();
				student.setStuNum(rs.getString("student_number"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("english_score"));
				student.setMathScore(rs.getInt("mathematics_score"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	// 조회된 값 없으면 null값 반환
	}
	
	// 정보 수정.
	boolean modifyStudent(String num, int eng, int math) {
		getConn();
		String sql = "UPDATE student "//
				   + "SET    english_score = ?, "//
				   + "       mathematics_score = ? "//
				   + "WHERE  student_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, num);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 정보 삭제.
	boolean removeStudent(String name) {
		getConn();
		String sql = "DELETE student "
				   + "WHERE  student_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
