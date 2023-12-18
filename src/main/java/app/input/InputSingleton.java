package app.input;

import java.util.Scanner;

public class InputSingleton {
	private static Scanner scan;
	
	public static Scanner getScanner() {
		if (scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
}
