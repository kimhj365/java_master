package todo.p20231128;

public class UserExe {
	//필드
	private User[] users;
	
	public UserExe() {
		users = new User[] {//
				new User("user01", "1111", "강민호"),//
				new User("user02", "2222", "구자욱"),//
				new User("user03", "3333", "원태인"),//	
				new User("khj93", "1234", "김현준")
		};
	} // 생성자.
	
	User logIn(String id, String pw) {
		for (int i = 0; i < users.length; i++) {
			if(users[i] != null//
					&& users[i].getUserId().equals(id)//
					&& users[i].getPasswd().equals(pw)
			) {
				return users[i];
			}
		}
		return null;
	} // end of logIn.
		
} // end of class.
