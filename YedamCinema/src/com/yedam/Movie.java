package com.yedam;

import java.util.ArrayList;

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
	private String actors;
	
	// 생성자.
	Movie(){}

	public Movie(String movieNumber, String movieName, String director, String releaseDate, String genre, int ageLimit,
			int runningTime, String plot, String actors) {
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
	
	void showMovieInfo() {
		System.out.printf("%7s | %-14s\t | %-10s\t | %-30s\t \n",
				movieNumber, movieName, director, actors);
	}
	
	void showMovieDetailInfo() {
		System.out.println("----------------------------------------------------------------------------------\n");
		System.out.println("영화번호	: " + movieNumber);
		System.out.println("영화이름	: " + movieName);
		System.out.println("감독		: " + director);
		System.out.println("출연배우	: " + actors);
		System.out.println("개봉일		: " + releaseDate);
		System.out.println("장르		: " + genre);
		if(ageLimit == 0 )
			System.out.println("연령제한	: 전체관람가");
		else
			System.out.println("연령제한	: " + ageLimit + "세 이상 관람가");
		System.out.println("상영시간	: " + runningTime + "분");
		System.out.println("줄거리		: " + plot);
		System.out.println("\n----------------------------------------------------------------------------------");
	}
}
