package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	
	// 필드.
	String prodCode;
	String prodName;
	int prodPrice;

	// 생성자.
	Product(){}

	Product(String prodCode, String prodName, int prodPrice) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	
	// 메소드.
	// 필드 출력 메소드.
	void showInfo() {
		System.out.printf("%8s %10s %10d\n", prodCode, prodName, prodPrice);
	}
	
}
