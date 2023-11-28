package todo.p20231128;

public class Board {
	// 필드
	int num;
	String title;
	String writer;
	String content;
	String date;
	
	// 생성자
	public Board(){}

	public Board(int num, String title, String writer, String content, String date) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}
	
	void showInfo() {
		System.out.printf("%d\t %s\t %s\t", num, title, writer);
	}

	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	boolean addWriting(Board brd) {
		Board[] board = null;
		for(int i = 0; i < board.length; i++) {
			if(board[i] == null) {
				board[i] = brd;
				return true;
			}
		}
		return false;
	}
	
	
	
}


