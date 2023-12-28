package com.yedam.product.service;

import java.util.List;

import com.yedam.product.vo.ProductVO;

public interface ProductService {
	// 목록, 단건조회.
	List<ProductVO> productList();
	List<ProductVO> productListLikeIt();
	ProductVO getProduct(String pno);
}
