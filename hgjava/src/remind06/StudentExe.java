package remind06;

// 저장공간 :  배열
// 추가/수정/삭제/목록/단건 조회
public class StudentExe {
	// 필드
	private Student[] students;	// 배열

	// 생성자
	StudentExe(){
		students = new Student[100];
		students[0] = new Student("23-001", "김현준", 88, 77);
		students[1] = new Student("23-002", "박지웅", 89, 92);
		students[2] = new Student("23-003", "전상진", 100, 100);
	}
	
	// 기능 함수 구현
	// 추가
	boolean addStudent(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				return true;	// 메소드 안에서 return문은 메소드의 끝
			}
		}
		return false;
	}
	
	// 목록
	Student[] showStudentList() {
		return students;
	}
	
	// 단건 조회
	Student showStudent(String num) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				return students[i];
			}
		}
		return null;
	}
	
	//수정
	boolean modifyStudent(String num, int eng, int math) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(math);
				return true;
			}
		}
		return false;
	}
	
	//삭제
	boolean removeStudent(String num) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
}
