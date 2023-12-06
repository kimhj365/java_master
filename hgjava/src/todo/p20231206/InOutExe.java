package todo.p20231206;

import java.text.SimpleDateFormat;
import java.util.*;

public class InOutExe {
	// 필드.
	// 싱글톤 패턴 : getInstance()로 동일한 하나의 인스턴스 가져옴.
	ProductExe pExe = ProductExe.getInstance();
	static ArrayList<InOut> inOutList = new ArrayList<>();
	
	// 생성자.
	InOutExe(){
		inOutList.add(new InOut("P001", "2023-12-06", 10));
		inOutList.add(new InOut("P001", "2023-12-06", -2));
		inOutList.add(new InOut("P001", "2023-12-06", -3));
	}
	
	// 메소드.
	// 1. 상품 판매 메소드.
	public boolean sellProduct(String inputCode, int inputQuantity) {	
		// productList의 요소 반복문.
		for(Product product : pExe.productList) {
			// (1)상품 코드가 같고 (2)재고-판매량이 음수가 아닐때 판매 이루어짐.
			if(product.getProdCode().equals(inputCode) && (remainQuantity(inputCode) - inputQuantity) >= 0) {
				// 거래일자는 오늘 날짜로 자동 생성.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String transDate = sdf.format(date);
				// inOutList에 거래 저장.
				// inputQuantity 양수면 구매 / 음수면 판매
				inOutList.add(new InOut(inputCode, transDate, -inputQuantity));
				return true;
			}
		}
		return false;
	}
	
	// 2. 상품 구매 메소드.
	public boolean buyProduct(String inputCode, int inputQuantity) {
		for(Product product : pExe.productList) {
			if(product.getProdCode().equals(inputCode)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String transDate = sdf.format(date);
				inOutList.add(new InOut(inputCode, transDate, inputQuantity));
				return true;
			}
		}
		return false;
	}
	
	// 3. 재고 확인 메소드.
	public int remainQuantity(String InputCode) {
		// 재고량 0으로 초기화
		int remainQuantity = 0;
		for(InOut inout : inOutList) {
			// inOutList 반복문 돌려서 하나하나 거래량 합계 구함
			// 구매 : 양수 / 판매 : 음수
			if(inout.getProdCode().equals(InputCode)) {
				remainQuantity += inout.getQuantity();
			}
		}
		return remainQuantity;
	}
}
