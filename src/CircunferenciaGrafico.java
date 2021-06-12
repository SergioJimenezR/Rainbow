import java.awt.Color;
import java.io.Serializable;

public class CircunferenciaGrafico extends ObjetoGrafico implements Serializable {

	private static final long serialVersionUID = 1L;

	private int radio;
	private Color color;
	private int grosor;

	public CircunferenciaGrafico(int x, int y, int radio, Color color, int grosor) {
		super(x,y);
		this.radio = radio;
		this.color = color;
		this.grosor = grosor;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

}