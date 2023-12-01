package chap11.object;

public class SystemExe {

	public static void main(String[] args) {

		// System.
		// 1000*60*60*24
		long dayCnt = 1000 * 60 * 60 * 24 * 365;
		long cur = System.currentTimeMillis();	// ���� ������ Date (1970-01-01 0�� ����).
		System.out.println(cur/dayCnt);
		
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 0; i <= 1000000; i++) {
			sum += i;
		}
		System.out.println("������: " + sum);
		long end = System.currentTimeMillis();
		System.out.println("�ɸ� �ð�: " + (end - start));
	}

}