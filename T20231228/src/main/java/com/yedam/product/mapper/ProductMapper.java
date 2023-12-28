package com.yedam.product.mapper;

import java.util.List;

import com.yedam.product.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> selectList();
	ProductVO getProduct(String pno);
}
