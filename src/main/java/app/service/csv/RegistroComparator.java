package app.service.csv;

import java.util.Comparator;

public class RegistroComparator implements Comparator<RegistroCSV> {
	public int compare(RegistroCSV o1, RegistroCSV o2) {
		int i = Long.compare(o1.dni, o2.dni);
		if (i != 0) {
			return i;
		}
		
		return Double.compare(o1.saldo, o2.saldo);
	}
	
}