package com.yedam.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.book.mapper.BookMapper;
import com.yedam.book.service.BookService;
import com.yedam.book.vo.BookVO;
import com.yedam.common.DataSource;

public class BookServiceImpl implements BookService{

	SqlSession session = DataSource.getInstance().openSession(true);
	BookMapper mapper = session.getMapper(BookMapper.class);
	
	@Override
	public List<BookVO> bookList() {
		return mapper.bookList();
	}

}
