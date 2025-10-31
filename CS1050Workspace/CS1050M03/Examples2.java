
public class Examples2 {

	public static void main(String[] args) {
		
		int[] arrayOne = {0, 1, 2, 3, 4, 5 };
		int[] arrayTwo = new int[6];
		
		for (int i = 0; i < arrayOne.length; i++) {
			System.out.println(arrayTwo[i]);
			arrayTwo[i] = arrayOne[i];
			System.out.println(arrayTwo[i]);
		}
	}

}
