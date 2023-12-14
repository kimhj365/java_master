package remind06;

import java.sql.*;

public class MainExe {

	static Connection conn;
	public static void main(String[] args) {

		// jdbc lib.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			// jdbc 드라이버 연결. 
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev"); // => dev 계정 연결.
			System.out.println("연결성공!!");
			
			// SELECT 쿼리 함수
			select();
			
			// INSERT 쿼리
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  "23-003");
			psmt.setString(2,  "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			// 입력, 수정, 삭제 => executeUpdate();
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("입력 성공!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Driver 없음.");
		}
		
	} // end of main.
	
	public static void select() throws Exception{
		// SQL 쿼리문 작성.
		// 쿼리문 오류시 SQLSyntaxError => 칼럼명 오타X, 세미콜론 없어야함.
		String sql = "select * from student";	
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		
		// SQL 쿼리결과 출력.
		while(rs.next()) {
			System.out.println("번호: " + rs.getString("student_number")//
						   + ", 이름: " + rs.getString("student_name")//
						   + ", 영어: " + rs.getInt("english_score")//
						   + ", 수학: " + rs.getInt("mathematics_score"));
		}
	}
} // end of class.

