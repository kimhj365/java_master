package com.yedam.student.service;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentService {
	// 목록, 입력, 수정, 삭제, 단건조회
	List<Student> studentList();
	boolean addStudent(Student std);
	boolean modStudent(String sno, int escore, int mscore);
	boolean remStudent(String sno);
	Student getStudent(String sno);
}
