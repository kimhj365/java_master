package todo.p20231128;

public class ArraySortExe {

	public static void main(String[] args) {
		
		int[] numAry = {2, 1, 5, 4, 3, 9, 8, 6, 7};
		
		int temp = 0;
		for (int i = 0; i < numAry.length - 1; i++) {
			for (int j = 0; j < numAry.length - 1; j++) {
				if(numAry[j] > numAry[j + 1]) {
					temp = numAry[j];
					numAry[j] = numAry[j + 1];
					numAry[j + 1] = temp;
				}
			}
		}
		for(int i : numAry) {
			System.out.println(i);
		}
	}
}