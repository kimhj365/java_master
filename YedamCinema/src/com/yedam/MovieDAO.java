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

	// 1. 영화 조회
	List<Movie> getMovieList() {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT	* "//
				+ "FROM		movie "//
				+ "ORDER BY 	1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
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

	// 1-1. 영화 목록 페이징.
	public static List<Movie> paging(List<Movie> allMovieList, int page) {
		List<Movie> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 부터 시작
		int end = page * 5; // 5 전까지 (5개)

		for (int i = 0; i < allMovieList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(allMovieList.get(i));
			}
		}
		return resultList;
	}

	// 1-2.영화 목록 페이징해서 출력.
	public void showMovieList(int page) {
		List<Movie> allMovieList = new ArrayList<>();
		allMovieList = getMovieList();
		List<Movie> pagedMovieList = MovieDAO.paging(allMovieList, page);

		for (Movie movie : pagedMovieList) {
			movie.showMovieInfo();
		}
	}

	// 2. 영화 상세정보 조회
	Movie getMovieDetail(String movieNumber) {
		String sql = ("SELECT * "//
				+ "FROM   movie "//
				+ "WHERE  movie_id = ?");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieNumber);
			rs = psmt.executeQuery();

			if (rs.next()) {
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
		// 영화 이름, 출연 배우 이름, 감독 이름으로 검색 쿼리.
		String sql = "SELECT * "//
				+ "FROM   movie "//
				+ "WHERE  movie_name LIKE '%'||?||'%' "//
				+ "OR     actors LIKE '%'||?||'%' "//
				+ "OR     director LIKE '%'||?||'%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search);
			psmt.setString(2, search);
			psmt.setString(3, search);
			rs = psmt.executeQuery();

			if (rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	
}
