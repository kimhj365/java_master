package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	
	private String todo;
	private Date dueDate;
	
	Todo(String todo){
		this.todo = todo;
		this.dueDate = new Date();	// 호출되는 시점의 시간정보 (년월일시분초)
	}
	
	Todo(String todo, Date dueDate){
		this.todo = todo;
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return todo + " " + sdf.format(dueDate);
	}

	public String getTodo() {
		return todo;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
