import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class EditorGrafico {

	private static EditorGrafico mInstanciaSingleton = null;

	private JFrame frmEditorGrafico;
	private JScrollPane scrollPane;

	private MiAreaDibujo miAreaDibujo;

	public static EditorGrafico getInstancia() {
		if (mInstanciaSingleton == null) {
			mInstanciaSingleton = new EditorGrafico();
			mInstanciaSingleton.frmEditorGrafico.setVisible(true);
		}
		return mInstanciaSingleton;
	}

	private EditorGrafico() {
		frmEditorGrafico = new JFrame();
		frmEditorGrafico.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmEditorGrafico.setTitle("Editor gráfico - Sergio Jiménez Roncero");
		frmEditorGrafico.setBounds(15, 15, 1200, 800);

		scrollPane = new JScrollPane();
		frmEditorGrafico.getContentPane().add(scrollPane, BorderLayout.CENTER);

		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);

		dibujar();
	}

	private void dibujar() {
		CircunferenciaGrafico circunf1 = new CircunferenciaGrafico(1, 1, 100, Color.RED, 1);
		miAreaDibujo.addObjetoGrafico(circunf1);
		CircunferenciaGrafico circunf2 = new CircunferenciaGrafico(1, 1, 200, Color.GREEN, 1);
		miAreaDibujo.addObjetoGrafico(circunf2);
	}

}