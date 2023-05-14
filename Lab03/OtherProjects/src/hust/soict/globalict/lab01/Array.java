package hust.soict.globalict.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n;
		int sum = 0;
		System.out.print("Enter the number of elements: ");
		n = inp.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			a[i] = inp.nextInt();
			sum += a[i];
		}
		Arrays.sort(a);
		System.out.println("The sorted array is: ");
		for (int i : a)
			System.out.print(i + " ");
		System.out.println("\nThe sum of the elements is: " + sum);
		System.out.println("The average of the elements is: " + (double) sum / n);
		inp.close();
	}
}
