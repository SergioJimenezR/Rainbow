import java.awt.Color;
import java.io.Serializable;

public class Circunferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	private int xCentro;
	private int yCentro;
	private int x;
	private int y;
	private int radio, maxRadioConcentrico;
	private Color color;
	private int grosor;

	public Circunferencia(int xCentro, int yCentro, int radio, int maxRadioConcentrico, Color color, int grosor) {
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		this.x = xCentro + (maxRadioConcentrico - radio) / 2;
		this.y = yCentro + (maxRadioConcentrico - radio) / 2;
		this.radio = radio;
		this.maxRadioConcentrico = maxRadioConcentrico;
		this.color = color;
		this.grosor = grosor;
	}

	public int getxCentro() {
		return xCentro;
	}

	public void setxCentro(int xCentro) {
		this.xCentro = xCentro;
	}

	public int getyCentro() {
		return yCentro;
	}

	public void setyCentro(int yCentro) {
		this.yCentro = yCentro;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getMaxRadioConcentrico() {
		return maxRadioConcentrico;
	}

	public void setMaxRadioConcentrico(int maxRadioConcentrico) {
		this.maxRadioConcentrico = maxRadioConcentrico;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}