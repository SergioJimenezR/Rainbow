import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGrafico.getInstancia();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
