package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.product.command.ProductInfoControl;
import com.yedam.product.command.ProductListControl;

public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		// 상품컨트롤.
		map.put("/productList.do", new ProductListControl());
		map.put("/productInfo.do", new ProductInfoControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length());

		Control ctrl = map.get(path);
		ctrl.execute(req, resp);

	}

}
