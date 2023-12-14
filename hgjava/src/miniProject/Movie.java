package miniProject;

import lombok.Data;

@Data

public class Movie {

//	1. 영화 테이블
//	-영화 번호(PK)
//	-영화 이름(NOT NULL)
//	-감독명
//	-개봉일
//	-장르
//	-연령제한
//	-상영시간
//	-줄거리
//	-출연 배우진
	
	// 필드.
	private String movieNumber;
	private String movieName;
	private String director;
	private String releaseDate;
	private String genre;
	private int ageLimit;
	private int runningTime;
	private String plot;
	private String[] actors;
	
	// 생성자.
	Movie(){}

	public Movie(String movieNumber, String movieName, String director, String releaseDate, String genre, int ageLimit,
			int runningTime, String plot, String[] actors) {
		super();
		this.movieNumber = movieNumber;
		this.movieName = movieName;
		this.director = director;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.ageLimit = ageLimit;
		this.runningTime = runningTime;
		this.plot = plot;
		this.actors = actors;
	}
	
	// 메서드.
	
	
}
