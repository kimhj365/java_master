package com.yedam;

import java.sql.*;
import java.util.*;

public class MovieDAO {
	// 필드.
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
	
	// 1. 모든 영화 목록 조회.
	List<Movie> getAllMovieList() {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT	* "//
				   + "FROM		movie "//
				   + "ORDER BY 	1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setMovieNumber(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setActors(rs.getString("actors"));
				movie.setReleaseDate(rs.getString("release_date"));
				movie.setAgeLimit(rs.getInt("age_limit"));
				movie.setRunningTime(rs.getInt("running_time"));
				movie.setPlot(rs.getString("plot"));
			
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	// 1. 예매 가능 영화 목록 조회.
		List<Movie> getAvailableMovieList() {
			List<Movie> movies = new ArrayList<>();
			String sql = "SELECT	* "//
					   + "FROM		movie "//
					   + "WHERE		release_date <= SYSDATE "//
					   + "ORDER BY 	1";
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Movie movie = new Movie();
					movie.setMovieNumber(rs.getString("movie_id"));
					movie.setMovieName(rs.getString("movie_name"));
					movie.setDirector(rs.getString("director"));
					movie.setGenre(rs.getString("genre"));
					movie.setActors(rs.getString("actors"));
					movie.setReleaseDate(rs.getString("release_date"));
					movie.setAgeLimit(rs.getInt("age_limit"));
					movie.setRunningTime(rs.getInt("running_time"));
					movie.setPlot(rs.getString("plot"));
				
					movies.add(movie);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return movies;
		}
	
	// 1-1. 페이징
	public static List<Movie> pageList(List<Movie> allMovieList, int page) {
		List<Movie> resultList = new ArrayList<>();
		
		int start = (page -1) * 5;	// 0 부터 시작
		int end = page * 5;	// 6 전까지 (5개)
		
		for (int i = 0; i < allMovieList.size(); i++) {
			if(i >= start && i < end) {
				resultList.add(allMovieList.get(i));
			}
		}
		return resultList;
	}
	
	// 1-2.
	public void showAllMovieList(int page) {
		List<Movie> allMovieList = new ArrayList<>();
		allMovieList = getAllMovieList();
		List<Movie> pagedMovieList = MovieDAO.pageList(allMovieList, page);
						
		for (Movie movie : pagedMovieList) {
			movie.showMovieInfo();
		}
	}
	
	public void showAvailableMovieList(int page) {
		List<Movie> availableMovieList = new ArrayList<>();
		availableMovieList = getAvailableMovieList();
		List<Movie> pagedMovieList = MovieDAO.pageList(availableMovieList, page);
						
		for (Movie movie : pagedMovieList) {
			movie.showMovieInfo();
		}
	}
	

	// 2. 영화 상세정보 조회
	Movie getMovie(String movieNumber) {
		String sql = ("SELECT * "
					+ "FROM   movie "
					+ "WHERE  movie_id = ?");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieNumber);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Movie movie = new Movie();
				movie.setMovieNumber(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setActors(rs.getString("actors"));
				movie.setReleaseDate(rs.getString("release_date"));
				movie.setAgeLimit(rs.getInt("age_limit"));
				movie.setRunningTime(rs.getInt("running_time"));
				movie.setPlot(rs.getString("plot"));
				
				return movie;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 3. 영화 검색
	List<Movie> searchMovie(String search) {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM   movie "
				+ "WHERE  movie_name LIKE '%'||?||'%' "
				+ "OR     actors LIKE '%'||?||'%' "
				+ "OR     director LIKE '%'||?||'%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search);
			psmt.setString(2, search);
			psmt.setString(3, search);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Movie movie = new Movie();
				movie.setMovieNumber(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setActors(rs.getString("actors"));
				movie.setReleaseDate(rs.getString("release_date"));
				movie.setAgeLimit(rs.getInt("age_limit"));
				movie.setRunningTime(rs.getInt("running_time"));
				movie.setPlot(rs.getString("plot"));
				
				movies.add(movie);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	// 4. 영화 예매
	List<String[]> searchSchedule(String movieId){
		List<String[]> schedule = new ArrayList<>();
		String sql = "SELECT  s.schedule_id, m.movie_name, "
				+ "        TO_CHAR(s.schedule_date, 'YYYY/MM/DD HH24:MI') date_time, "
				+ "        s.discount, s.remain_seat "
				+ "FROM    schedule s, movie m "
				+ "where   s.movie_id = m.movie_id "
				+ "AND     s.movie_id = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieId);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String[] sArray = new String[5];
				sArray[0] = rs.getString("schedule_id");
				sArray[1] = rs.getString("movie_name");
				sArray[2] = rs.getString("date_time");
				sArray[3] = rs.getString("discount");
				sArray[4] = rs.getString("remain_seat");
				
				schedule.add(sArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedule;
	}
	
	void getSchedule(List<String[]> schedule) {
		for(String[] ary : schedule) {
			
			System.out.printf("%s %s %s %s %s\n",
					ary[0], ary[1], ary[2], ary[3], ary[4] );
		}
	}
	
	
}
