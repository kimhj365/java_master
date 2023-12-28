package com.yedam.product.vo;

import lombok.Data;

@Data

public class ProductVO {
	String productCode;
	String productName;
	String productDesc;
	int originPrice;
	int salePrice;
	int likeIt;
	String image;
}
