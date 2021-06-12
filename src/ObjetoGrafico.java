import java.io.Serializable;

public class ObjetoGrafico implements Serializable {

	private static final long serialVersionUID = 1L;

	private int x, y;

	public ObjetoGrafico(int x, int y) {
		this.x = x;
		this.y = y;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}