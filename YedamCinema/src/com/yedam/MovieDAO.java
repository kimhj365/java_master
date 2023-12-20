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

	// 1. 영화 조회
	List<Movie> getMovieList() {
		List<Movie> movies = new ArrayList<>();
		getConn();
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
		} finally {
			disConn();
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
		getConn();
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
		} finally {
			disConn();
		}
		return null;
	}

	// 3. 영화 검색.
	List<Movie> searchMovie(String search) {
		getConn();
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
		} finally {
			disConn();
		}
		return movies;
	}

	// 4. 영화 추가.
	boolean addMovie(Movie movie) {
		getConn();
		String sql = "INSERT INTO movie " + "VALUES (?,?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movie.getMovieNumber());
			psmt.setString(2, movie.getMovieName());
			psmt.setString(3, movie.getDirector());
			psmt.setString(4, movie.getGenre());
			psmt.setString(5, movie.getActors());
			psmt.setString(6, movie.getReleaseDate());
			psmt.setInt(7, movie.getAgeLimit());
			psmt.setInt(8, movie.getRunningTime());
			psmt.setString(9, movie.getPlot());

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

	// 5. 영화 중복 검사
	boolean chkMovie(String movieId) {
		getConn();
		String sql = "SELECT	* " + "FROM		movie " + "WHERE 	movie_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieId);
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

	Movie getMovie(int ticketNum) {
		getConn();
		Movie movie = new Movie();
		String sql = "SELECT * " 
				+ "FROM   movie "//
				+ "WHERE  movie_id = (SELECT movie_id "// 
				+ "                    FROM   schedule "//
				+ "                    WHERE  schedule_id = (SELECT schedule_id "//
				+ "                                            FROM   ticket "//
				+ "                                            WHERE  ticket_id = ?))";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketNum);
			rs = psmt.executeQuery();

			if(rs.next()) {
				movie.setMovieNumber(rs.getString("MOVIE_ID"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setDirector(rs.getString("DIRECTOR"));
				movie.setGenre(rs.getString("GENRE"));
				movie.setActors(rs.getString("ACTORS"));
				movie.setReleaseDate(rs.getString("RELEASE_DATE"));
				movie.setAgeLimit(rs.getInt("age_limit"));
				movie.setRunningTime(rs.getInt("running_time"));
				movie.setPlot(rs.getString("PLOT"));
				return movie;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return movie;
	}

	String getMovieName(String movieNum) {
		getConn();
		String sql = "SELECT * "//
				+ "FROM   movie "//
				+ "WHERE  movie_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieNum);
			rs = psmt.executeQuery();

			if(rs.next()) {
				return rs.getString("movie_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return null;
	}
	
	boolean deleteMovie(String movieNum) {
		getConn();
		String sql = "DELETE movie "
					+ "WHERE movie_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieNum);
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

}
