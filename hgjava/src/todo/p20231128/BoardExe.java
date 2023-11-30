package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

// 저장소: boards
public class BoardExe {	// 여러 기능 처리하는 용도의 클래스.
	// 필드
	static Board[] boards;	// static 변수로 선언.
	
	// 생성자
	BoardExe(){
//		boards = new Board[100];	// 크기 100 배열 기본 생성 => static 변수는 인스턴스 만들 필요 없음
	}
	static {
		boards = new Board[100];	//	
	}
	
	// 0-1. 초기값 몇개 미리 생성
	public static void initData() {
//		boards[0] = new Board(1, "자바게시판 입니다", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다.", "2023-11-27");
//		boards[1] = new Board(2, "공부합시다\t", "user02", "자바를 공부합시다.", "2023-11-28");
//		//board[2] <= 5번글
//		boards[3] = new Board(4, "SQL이 기대됩니다", "user03", "정말 기대됩니다 ", "2023-11-28");
		
		boards[0] = new Board(1, "첫 번째 게시물  ", "user01", "첫번째 게시물 입니다 ", "2023-11-27");
		boards[1] = new Board(2, "두 번째 게시물  ", "user01", "두번째 게시물 입니다 ", "2023-11-27");
		boards[2] = new Board(3, "세 번째 게시물  ", "user01", "세번째 게시물 입니다 ", "2023-11-28");
		boards[3] = new Board(4, "네 번째 게시물  ", "user02", "네번째 게시물 입니다 ", "2023-11-28");
		boards[4] = new Board(5, "다섯 번째 게시물", "user02", "다섯번째 게시물 입니다 ", "2023-11-28");
		boards[5] = new Board(6, "여섯 번째 게시물", "user03", "여섯번째 게시물 입니다 ", "2023-11-28");
		boards[6] = new Board(7, "일곱 번째 게시물", "user03", "일곱번째 게시물 입니다 ", "2023-11-29");
		boards[7] = new Board(8, "여덟 번째 게시물", "khj93", "여덟번째 게시물 입니다 ", "2023-11-29");
		
	}
	
	// 0-2. 신규 번호 자동 생성 : 현재 글 번호 +1
	public static int getSequence() {
		int seqNum = 1;
		int maxNum = 0;	// 최대 번호 값 저장
		
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() > maxNum) {
				maxNum = boards[i].getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}
	
	// 1. 등록 메소드
	public static boolean addArticle(Board board) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board;
				return true;	// 반복문 종료 (= break;) 
			}
		}
		return false;
	}
	
	// 2. 목록 조회 메소드 + 정렬 => Board[] 배열 반환
	public static Board[] showList() {
		// 정렬 : i번 요소를 i+1번 요소와 비교 => 자리 바꾸기
		Board temp = null;
		for (int i = 0; i < boards.length - 1; i++) {
			for (int j = 0; j < boards.length - 1; j++) {
				if(boards[j] != null && boards[j+1] != null) {
					if(boards[j].getNum() > boards[j + 1].getNum()) {
					temp = boards[j];
					boards[j] = boards[j + 1]; 
					boards[j + 1] = temp;
					}
				}
			}
		}
		return boards;
	}
	
	// 2-1. 게시판 페이지 배열 만들기 => 이 부분 좀 더 공부 필요!!
	public static Board[] pageList(Board[] ary, int page) {	// 기존 Board[] 배열 가져옴.
		Board[] resultAry = new Board[5];
		// 한 페이지에 게시물 5개 담는 배열 생성 
		// => 기존 배열 5개씩 잘라서 붙여넣기.
		// => 5개씩 보여줌.
		
		int start = (page -1) * 5;	// 0 부터 시작
		int end = page * 5;	// 6 전까지 (5개)
		int j = 0;
		
		for (int i = 0; i < ary.length; i++) {
			if(i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	// 3. 단건조회. 매개변수 : 글번호 / 반환값 : Board => Board 클래스에서 출력문
	public static Board showContent(int num) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				return boards[i];
			}
		}
		return null;
	}
	
	// 4. 수정 메소드
	public static boolean modifyContent(int num, String title, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				boards[i].setTitle(title);
				boards[i].setContent(content);
				boards[i].setWriteDate(sdf.format(today));;
				return true;
			}
		}
		return false;
	}
	
	// 5. 삭제 메소드
	public static boolean removeContent(int num) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 6. 사용자가 해당 글 번호 수정, 삭제 권한 체크 메소드 => boolean.
	public static boolean checkResponsibility(String id, int num) {
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null//
					&& boards[i].getNum() == num//
					&& boards[i].getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	// 7. 게시글을 담고 있는 배열에서 값이 있는 건수를 반환. = 데이터 건수
	public static int getBoardCount() {
		int realCount = 0;
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCount++;
			}
		}
		return realCount++;	// null이 아닌 데이터 건수 카운트
	}
	
}
