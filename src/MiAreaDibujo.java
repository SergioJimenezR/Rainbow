import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;

public class MiAreaDibujo extends JLabel {

	private static final long serialVersionUID = 1L;

	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();

	public MiAreaDibujo() {
	}

	public void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}

	public ObjetoGrafico getUltimoObjetoGrafico() {
		return objetosGraficos.get(objetosGraficos.size() - 1);
	}

	public void paint(Graphics g) {

		super.paint(g);

		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);

			if (objg instanceof CircunferenciaGrafico) {
				Graphics2D g2 = (Graphics2D) g;

				CircunferenciaGrafico circunferencia = (CircunferenciaGrafico) objg;
				g2.setStroke(new BasicStroke(circunferencia.getGrosor()));
				g2.setColor(circunferencia.getColor());

				int radioGrande = 200;

				int radio = circunferencia.getRadio();
				// g2.drawArc(500 + (radioGrande - radio) / 2, 500 + (radioGrande - radio) / 2,
				// radio, radio, 0, 180);
			}

		}
	}
}