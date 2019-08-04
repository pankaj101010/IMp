package javaT;

public class Pattern_1 {

	public static void main(String[] args) {
		int lines = 9;
		for (int i = 1; i <= lines; i++) {
			for (int j = 1; j <=lines - i + 1; j++) {
				System.out.print(j);
			}
			for (int j = 1; j <=i-1; j++) {
				System.out.print("**");
			}
			for (int j = lines-i+1; j>=1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}

	}

}
