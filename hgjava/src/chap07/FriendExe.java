package chap07;

public class FriendExe {

	static Friend[] storage = new Friend[10];

	// 1. 등록.
	public static boolean addFriend(Friend friend) {
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	}
	
	// 2. 목록.
	public static Friend[] friendList() {
		for (Friend friend : storage) {
			if(friend != null) {
				System.out.println(friend.showInfo());
			}
		}
		return storage;
	}

	// 3. 조회.
	// 결과값 null 여부로 체크 불가능. => null 아닌 값 몇개 있는지 체크
	public static Friend[] searchName(String name) {
		// 반환유형이 정해져있음.(배열 이미 선언되어 있음 => null 아님)
		Friend[] result = new Friend[10];
		int count = 0;
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] != null && storage[i].getName().equals(name)) {
				result[count] = storage[i];
				count++;
			}
		}
		if(count != 0) {
			return result;
		}
		else{
			return null;
		}
	}

	// 결과값 null 여부로 체크 가능.
	public static Friend searchPhone(String phone) {
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] != null && storage[i].getPhone().equals(phone)) {
				return storage[i];
			}
		}
		return null;
	}

}
