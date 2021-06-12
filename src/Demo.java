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
		
		for (int r = 400; r <= 1000; r++) {
			Circunferencia circunf = new Circunferencia(90, 90, r, 1000, Color.red, 1);
			miAreaDibujo.addCircunferencia(circunf);
		}

	}

}