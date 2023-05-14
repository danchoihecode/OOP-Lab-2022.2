package hust.soict.globalict.lab01;

import java.util.Scanner;

public class AddMatrix {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);

		System.out.print("Enter the matrices sizes: ");
		int n = inp.nextInt();
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];

		System.out.println("Enter the first matrix : ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = inp.nextInt();
			}
		}

		System.out.println("Enter the second matrix : ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = inp.nextInt();
			}
		}

		System.out.println("The sum of the matrices is : ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + b[i][j] + " ");
			}
			System.out.print("\n");
		}
		inp.close();
	}
}
