package todo.p20231128;

public class MainExe {

	public static void main(String[] args) {
		
		String[] strs = {"1sdfsd", "2asdfw", "3wgweg", "4gfbfe", "5yntnt", "6uyjft", "7zxzfs", "8ngfhr", "9hemyr"};
		int page = 2;
		int start = (page -1) * 5;
		int end = page * 5;
		
		for (int i = 0; i < strs.length; i++) {
			if(i >= start && i < end) {
				System.out.println(strs[i]);
			}
		}
		
		int count = 36;
		
		int totalPage = (int)Math.ceil(count/5.0);
		System.out.println(totalPage);
		
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
	}

}
