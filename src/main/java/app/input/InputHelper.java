package app.input;

import java.util.Scanner;

public class InputHelper {
	public static String div = "-".repeat(30);
	public static String prompt = "> ";
	public static Scanner scan = InputSingleton.getScanner();
	
	public static Long leerLong(String msg) {
		Long nro;
		while (true) {
			System.out.println(msg);
			System.out.print(prompt);
			try {
				nro = Long.parseLong(scan.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato inválido, vuelva a intentarlo.");
			}
			System.out.println(div);
		}
		return nro;
	}
	
	public static Double leerDouble(String msg) {
		Scanner scan = InputSingleton.getScanner();
		Double db;
		while (true) {
			System.out.println(msg);
			System.out.print(prompt);
			try {
				db = Double.parseDouble(scan.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato inválido, vuelva a intentarlo.");
			}
			System.out.println(div);
		}
		return db;
	}
	
	public static String leerStr(String msg) {
		System.out.println(msg);
		System.out.print(prompt);
		String res = scan.nextLine();
		System.out.println(div);
		return res;
	}
}
