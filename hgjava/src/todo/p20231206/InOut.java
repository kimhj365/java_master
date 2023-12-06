package todo.p20231206;

import lombok.Data;

@Data

public class InOut {
	
	// 필드.
	String prodCode;
	String transDate;
	int quantity;
	
	// 생성자.
	InOut(){}
	
	public InOut(String prodCode, String transDate, int quantity) {
		super();
		this.prodCode = prodCode;
		this.transDate = transDate;
		this.quantity = quantity;
	}

	// 메소드.
	// 상품코드+재고량 출력 메소드.
	void showInOutList() {
		String sellBuy = "";
		if(quantity >= 0) 
			sellBuy = "구매";
		else 
			sellBuy = "판매";
		
		System.out.printf("%5s %15s %5d %8s\n", prodCode, transDate, quantity, sellBuy);
	}

	public static void main(String[] args) {
		
//		InOutExe ioExe = new InOutExe();	// inOutExe의 인스턴스를 받아오고 싶은데 방법 잘 모르겠음
		
		System.out.println("< 판매정보 >");
		System.out.println("상품코드    처리날짜    수량     판(구)매");
		System.out.println("=========================================");
		for(int i = 0; i < InOutExe.inOutList.size(); i++) {
			// inOutList 전체 목록 출력
			InOutExe.inOutList.get(i).showInOutList();
		}
		
	}
}
