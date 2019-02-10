package application;

import java.util.Scanner;

public class ConsoleReaderApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your nationality: ");
		String nationality = scanner.nextLine();
		 
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		scanner.close();
		//scanner.nextInt()

	}

}
