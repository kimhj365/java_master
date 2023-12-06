package todo.p20231206;

import java.util.Scanner;

public class ProductApp {
	

	public static void main(String[] args) {
		
		// ProductExe의 객체에 접근 위해 getInstance() 메소드 호출(싱글톤).
		ProductExe pExe = ProductExe.getInstance();
		InOutExe ioExe = new InOutExe();
		Scanner scn = new Scanner(System.in);

		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.상품 관리 ┃ 2.입출고 관리 ┃ 3.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu;
			//Integer.parseInt() 예외처리 => 오류나면 default로 가서 while문 다시 돌림.
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch(NumberFormatException e) {
				menu = 0;
			}
			
			switch(menu) {
			
			// 1. 상품 관리.
			case 1:
				boolean run2 = true;
				while(run2) {
					System.out.println("\n< 상품 관리 >");
					System.out.println("┏━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━┓");
					System.out.println("┃ 1.등록 ┃ 2.수정 ┃ 3.목록 ┃ 4.나가기 ┃");
					System.out.println("┗━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━┛");
					System.out.print("동작을 입력하세요 \n>> ");
					int subMenu;
					//Integer.parseInt() 예외처리.
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch(NumberFormatException e) {
						subMenu = 0;
					}
					switch(subMenu) {
					// 1-1) 상품 등록.
					case 1:
						System.out.println("\n< 상품 등록 >");
						System.out.print("상품코드를 입력하세요 \n>> ");
						String inputCode = scn.nextLine();
						System.out.print("상품명을 입력하세요 \n>> ");
						String inputName = scn.nextLine();
						System.out.print("가격을 입력하세요 \n>> ");
						// Integer.parseInt() 예외처리.
						int inputPrice = 0;
						try {
							inputPrice = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("올바른 상품 가격을 입력하세요");;
						}
						
						// ProductExe 클래스의 상품 등록 메소드 호출.
						boolean chk = pExe.addProduct(inputCode, inputName, inputPrice);
						if(chk)
							System.out.println("상품 등록이 완료되었습니다");
						else
							System.out.println("상품 코드가 중복되었습니다.");
						break;
					
					// 1-2) 상품 수정
					case 2:
						System.out.println("\n< 상품 수정 >");
						System.out.print("상품코드를 입력하세요 \n>> ");
						inputCode = scn.nextLine();
						System.out.print("수정할 상품명을 입력하세요 \n>> ");
						inputName = scn.nextLine();
						System.out.print("수정할 가격을 입력하세요 \n>> ");
						inputPrice = 0;
						// Integer.parseInt() 예외처리.
						try {
							inputPrice = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("올바른 상품 가격을 입력하세요");;
						}
						
						//  ProductExe 클래스의 상품 수정 메소드 호출.
						chk = pExe.modifyProduct(inputCode, inputName, inputPrice);
						if(chk)
							System.out.println("상품 정보 수정이 완료되었습니다");
						else
							System.out.println("상품 정보 수정에 실패했습니다.");
						break;
					
					// 1-3) 목록 조회
					case 3:
						System.out.println("\n< 상품 목록 조회>");
						System.out.printf("%5s %8s %8s\n", "상품코드", "상품명", "가격");
						System.out.println("===================================");
						
						//  ProductExe 클래스의 목록 조회 메소드 호출.
						pExe.getProductList();
						break;
						
					// 1-4) subMenu while문 종료.
					case 4:
						System.out.println("< 나가기 >");
						run2 = false;
						break;
						
					default:
						break;
					}
				}
				break;
				
			// 2. 입출고 관리.	
			case 2:
				boolean run3 = true;
				while(run3) {
					System.out.println("\n< 입출고 관리 >");
					System.out.println("┏━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━┓");
					System.out.println("┃ 1.판매 ┃ 2.구매 ┃ 3.재고 ┃ 4.나가기 ┃");
					System.out.println("┗━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━┛");
					System.out.print("동작을 입력하세요 \n>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch(NumberFormatException e) {
						subMenu = 0;
					}
					switch(subMenu) {
					
					// 2-1) 상품 판매
					case 1:
						System.out.println("\n< 상품 판매 >");
						System.out.print("판매할 상품의 상품코드를 입력하세요 \n>> ");
						String inputCode = scn.nextLine();
						System.out.print("판매 수량을 입력하세요 \n>> ");
						int inputQuantity = 0;
						// Integer.parseInt() 예외처리.
						try {
							inputQuantity = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("올바른 상품 수량을 입력하세요");;
						}
						
						// InOutExe 클래스의 상품 판매 메소드 호출.
						boolean chk = ioExe.sellProduct(inputCode, inputQuantity);
						if(chk)
							System.out.println("상품 판매가 완료되었습니다");
						else
							System.out.println("상품 판매에 실패했습니다");
						break;
						
					// 2-2) 상품 구매
					case 2:
						System.out.println("\n< 상품 구매 >");
						System.out.print("구매할 상품의 상품코드를 입력하세요 \n>> ");
						inputCode = scn.nextLine();
						System.out.print("구매 수량을 입력하세요 \n>> ");
						inputQuantity = 0;
						// Integer.parseInt() 예외처리.
						try {
							inputQuantity = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("올바른 상품 수량을 입력하세요");;
						}
						
						// InOutExe 클래스의 상품 구매 메소드 호출.
						chk = ioExe.buyProduct(inputCode, inputQuantity);
						if(chk)
							System.out.println("상품 구매가 완료되었습니다");
						else
							System.out.println("상품 구매에 실패했습니다");
						break;
					
					// 2-3) 재고 조회
					case 3:
						System.out.println("\n< 재고 조회>");
						System.out.printf("%5s %6s\n", "상품코드", "재고수량");
						System.out.println("=========================");
						
						// productList의 한건한건의 재고를 반복문으로 출력.
						for(Product product : pExe.productList) {
							// InOutExe 클래스의 재고 조회 메소드 호출.
							System.out.printf("%8s %8d\n",product.getProdCode(), ioExe.remainQuantity(product.prodCode));
						}
						break;
					// 2-4) subMenu while문 종료
					case 4:
						System.out.println("< 나가기 >");
						run3 = false;
						break;
					default:
					}
				}
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다");
				scn.close();
				run = false;
				break;
				
			default:
				System.out.println("올바른 동작을 입력하세요");
				break;
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
