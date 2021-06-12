import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Demo {

	private JFrame frmEditorGrafico;
	private JScrollPane scrollPane;
	private Area miAreaDibujo;

	public Demo() {
		frmEditorGrafico = new JFrame();
		frmEditorGrafico.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmEditorGrafico.setTitle("Editor gráfico - Sergio Jiménez Roncero");
		frmEditorGrafico.setBounds(15, 15, 1200, 800);
		frmEditorGrafico.setVisible(true);

		scrollPane = new JScrollPane();
		frmEditorGrafico.getContentPane().add(scrollPane, BorderLayout.CENTER);

		miAreaDibujo = new Area();
		miAreaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);
	}

	public void dibujar() {

		int radius = 300;
		int colors = 392;
		int penwidth = 20 * 56 / colors;
		float hue = 0;

		for (int i = 0; i < colors; i++) {
			Color c = Color.getHSBColor(hue, 1, 1);
			System.out.println(Integer.toHexString(c.getRGB()));
			Circunferencia circunf = new Circunferencia(400, 400, radius + 600, 300, c, 1);
			miAreaDibujo.addCircunferencia(circunf);
			radius -= penwidth - 1;
			hue += 0.9 / colors;
		}

	}

}