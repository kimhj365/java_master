package chap11.object;

public class StringExe {

	public static void main(String[] args) {
		
		// Q. 파일 이름 찾기
		String[] fileNames = { "c:/images/prod/sample.jpg",//
				"d:/test/sample/americano.png",//
				"d:/goods/test/2023/moka.jpg" };

		for (String file : fileNames) {
			System.out.println(findFileName(file));
		}
		
		// Q. 주민번호 성별 찾기
		String[] numbers = {"980304-1234567",//
				"980304-2234567",//
				"020101-3456789",//
				"020104-4456789",//
				"0301053545678" };
		
		for (String no : numbers) {
			System.out.println(findGender(no));
		}
		
		// byte 배열 b1에 "Hello" 문자열의아스키 코드 값 입력.
		byte[] b1 = "Hello".getBytes();
		for (byte b : b1) {
			System.out.println(b);
		}
		
		// new String().
		String name = new String(new byte[] { 65, 66, 67, 68, 69 }); // byte 배열로 생성 => 아스키 코드 값.\
		System.out.println(name);
		
		name = new String(b1);
		System.out.println(name);
		
		// charAt() : 해당 배열 위치의 문자 값(char).
		char c1 = name.charAt(0);
		System.err.println(c1);
		
		// 성별을 반환.
		
		
	} // end of main().
	
	// 셩별 확인 메소드.
	static String findGender(String ssn) {
	// 주민번호 뒷자리 == 1, 2, 3, 4.
	
	// if문.
//		String gender = ssn.substring(6,8);
//		if(gender.equals("-1") || gender.equals("-3")) {
//			return "남";
//		}
//		else if(gender.equals("-2") || gender.equals("-4")) {
//			return "여";
//		}
//		else {
//			return null;
//		}
	
	// switch문.
//		String gender = ssn.substring(6,8);
//		switch(gender) {
//		case "-1":
//		case "-3":
//			return "남";
//		case "-2":
//		case "-4":
//			return "여";
//		default:
//			return null;
//		}
		
	// "-" 포함 여부 검사.
		char bar = ssn.charAt(6);
		if(bar == '-') {
			char gender = ssn.charAt(7);
			switch(gender) {
			case '1':
			case '3':
				return "남";
			case '2':
			case '4':
				return "여";
			default:
				return null;
			}
		}
		else {
			char gender = ssn.charAt(6);
			switch(gender) {
			case '1':
			case '3':
				return "남";
			case '2':
			case '4':
				return "여";
			default:
				return null;
			}
		}
	}
		
	// 파일명을 가져오기.
	// lastIndexOf().
	static String findFileName(String file) {
		int index = file.lastIndexOf("/") + 1;
		return file.substring(index);
	}
	
	// split().
//	static String findFileName(String file) {
//		String[] files = file.split("/");
//		return files[files.length -1];
//	}
	
	// 교수님 풀이.
//	static String findFileName(String file) {
//		int pos = 0;
//		while(true) {
//			int pos2 = file.indexOf("/", pos);
//			if(pos2 == -1)
//				break;
//			pos2++;
//			pos = pos2;
//		}
//		return file.substring(pos);
//	}
	

} // end of class.

