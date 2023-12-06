package todo.p20231206;

import java.util.*;

public class ProductExe {
	// <싱글톤 패턴> :
	// 전체 프로그램에서 하나의 인스턴스만 만들어서 공유.
	// 1. 클래스 외부에서 new 연산자로 호출 못하게 막음 => private 생성자
	// 2. 자신 타입의 정적필드 생성하고 초기화 => private static ProductExe
	// 3. 외부에서 호출 가능한 정적 메소드 getInstance() 선언 => static 필드의 인스턴스 리턴
	//
	// => 다른 클래스에서 ProductExe 클래스의 인스턴스 얻으려면 getInstance() 메소드만 써야함
	// => getInstance는 단 하나의 객체만 리턴
	
	// 필드.
	private static ProductExe instance = new ProductExe();
	ArrayList<Product> productList = new ArrayList<>();
	
	// 생성자.
	private ProductExe(){
		productList.add(new Product("P001", "볼펜", 1000));
		productList.add(new Product("P002", "연필", 1200));
		productList.add(new Product("N001", "노트100", 1000));
		productList.add(new Product("N002", "다이어리", 3000));
	}

	// 메소드.
	// 0. 자신 타입의 인스턴스 반환 메소드(싱글톤)
	public static ProductExe getInstance() {
		return instance;
	}
	
	// 1. 상품 추가 메소드.
	public boolean addProduct(String inputCode, String inputName, int inputPrice) {
		// 중복 체크: productList에 상품 코드와 일치하는 값 있으면 false 리턴.
		for(Product product : productList) {
			if(product.getProdCode().equals(inputCode)) {
				return false;
			}
		}
		// 중복값 없으면 productList에 추가.
		productList.add(new Product(inputCode, inputName, inputPrice));
		return true;
	}

	// 2. 상품 수정 메소드
	public boolean modifyProduct(String inputCode, String inputName, int inputPrice) {
		// productList에 상품 코드와 일치하는 값 있으면 set 메소드로 값 변경
		for(Product product : productList) {
			if(product.getProdCode().equals(inputCode)) {
				product.setProdName(inputName);
				product.setProdPrice(inputPrice);
				return true;
			}
		}
		return false;
	}

	// 3. 목록 조회 메소드
	public void getProductList() {
		// for문 돌려서 하나씩 showInfo()로 출력
		for(Product product : productList) {
			product.showInfo();
		}
	}
	
	
	
}
