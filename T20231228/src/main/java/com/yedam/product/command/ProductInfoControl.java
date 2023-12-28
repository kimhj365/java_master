package com.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String productCode = req.getParameter("productCode");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(productCode);
		List<ProductVO> list = svc.productListLikeIt();
		
		req.setAttribute("vo", vo);
		req.setAttribute("productList", list);
		RequestDispatcher rd = req.getRequestDispatcher("product/productInfo.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
