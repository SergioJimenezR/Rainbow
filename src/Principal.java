import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Demo e = new Demo();
				e.dibujar();
			}
		});
	}

}
