package todo.p20231128;

public class User {
	//필드
	private String userId;
	private String passwd;
	private String userName;

	//생성자
	public User(){}

	public User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}
	
	// getter
	public String getUserId() {
		return userId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public String getUserName() {
		return userName;
	}
}
