package app.service;

import java.util.Scanner;

public class InputService {
	private static Scanner scan;
	
	public static Scanner getScanner() {
		if (scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
}
