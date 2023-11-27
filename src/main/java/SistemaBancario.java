import app.MenuPrincipal;
import model.*;

public class SistemaBancario {
	public static void main(String[] args) {
		Banco banco = new Banco("JediBanco", 33.33d, 1000d);
		new MenuPrincipal(banco).run();
	}
}
