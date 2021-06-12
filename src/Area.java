import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Area extends JLabel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Circunferencia> lista = new ArrayList<Circunferencia>();

	public Area() {
	}

	public void addCircunferencia(Circunferencia circunf) {
		lista.add(circunf);
	}

	@Override
	public void paint(Graphics g) {

		for (int i = 0; i < lista.size(); i++) {

			Circunferencia circunferencia = lista.get(i);

			Graphics2D g2d = (Graphics2D) g;

			g2d.setStroke(new BasicStroke(circunferencia.getGrosor()));
			g2d.setColor(circunferencia.getColor());

			g2d.drawArc(circunferencia.getX(), circunferencia.getY(), circunferencia.getRadio(),
					circunferencia.getRadio(), 0, 180);

		}
	}
}