package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

public class MainExe {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO vo = new BoardVO();
		
		// 1. 목록보기
		List<BoardVO> list = mapper.selectList();
		for(BoardVO bvo : list) {
			System.out.println(bvo.toString());
		}
		
		// 2. 단건조회
//		vo = mapper.selectOne(2);
//		System.out.println(vo.toString());
		
		// 3. 추가
//		vo.setTitle("집에 가고싶어요");
//		vo.setWriter("김현준");
//		vo.setContent("보내줘잉");
//		if(mapper.insertBoard(vo) > 0) {
//			System.out.println("추가 완료");
//		}
//		else {
//			System.out.println("추가 실패");
//		}
		
		// 4. 수정
//		vo.setBoardNo(6);
//		vo.setContent("쫌 보내줘잉~");
//		if(mapper.updateBoard(vo) > 0) {
//			System.out.println("수정 완료");
//		}
//		else {
//			System.out.println("수정 실패");
//		}
		
		// 5. 삭제
//		if(mapper.deleteBoard(5) > 0) {
//			System.out.println("삭제 완료");
//		}
//		else {
//			System.out.println("삭제 실패");
//		}
		
		// 6. 조회수 증가
		if(mapper.updateCnt(6) > 0) {
			System.out.println("조회수 증가 완료");
		}
		else {
			System.out.println("조회수 증가 실패");
		}
		
	}
}
