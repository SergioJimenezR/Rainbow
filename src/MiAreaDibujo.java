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

	public void deshacer() {

		objetosGraficos.remove(objetosGraficos.size() - 1);

		paint(this.getGraphics());
	}

	public void limpiar(Graphics g) {
		objetosGraficos.clear();
		paint(g);
	}

	public void paint(Graphics g) {

		super.paint(g);

		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico) {
				g.drawImage(((ImagenGrafico) objg).getImagen(), objg.getX(), objg.getY(), null);
			} else if (objg instanceof RectaGrafico) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(((RectaGrafico) objg).getGrosor()));
				g2.setColor(((RectaGrafico) objg).getColor());
				int w = ((RectaGrafico) objg).getX1() - objg.getX();
				int h = ((RectaGrafico) objg).getY1() - objg.getY();
				g2.drawLine(objg.getX(), objg.getY(), objg.getX() + w, objg.getY() + h);
			}
		}
	}
}