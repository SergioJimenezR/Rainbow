import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class EditorGrafico {

	private static EditorGrafico mInstanciaSingleton = null;

	private JFrame frmEditorGrafico;

	private JToolBar tbBarraDibujo;
	private JButton btnCargarMapa;

	private JButton btnRecta;

	private JButton btnLimpiar;

	private JScrollPane scrollPane;

	int modo = -1;
	private final int RECTA = 12;

	private int x, y;

	private MiAreaDibujo miAreaDibujo;

	private ImageIcon imagenFondo;

	public static EditorGrafico getInstancia() {
		if (mInstanciaSingleton == null) {
			mInstanciaSingleton = new EditorGrafico();
			mInstanciaSingleton.frmEditorGrafico.setVisible(true);
		}
		return mInstanciaSingleton;
	}

	private EditorGrafico() {
		initialize();
	}

	private void initialize() {
		frmEditorGrafico = new JFrame();
		frmEditorGrafico.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmEditorGrafico.setTitle("Editor gráfico - Sergio Jiménez Roncero");
		frmEditorGrafico.setBounds(15, 15, 1200, 800);
		{
			tbBarraDibujo = new JToolBar();
			frmEditorGrafico.getContentPane().add(tbBarraDibujo, BorderLayout.NORTH);
			{
				btnCargarMapa = new JButton("");
				btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
				tbBarraDibujo.add(btnCargarMapa);
			}
			{
				{
					btnRecta = new JButton("");
					btnRecta.setEnabled(false);
					btnRecta.addActionListener(new BtnRectaActionListener());
					tbBarraDibujo.add(btnRecta);
				}
				btnLimpiar = new JButton("");
				btnLimpiar.addActionListener(new BtnLimpiarActionListener());
				tbBarraDibujo.add(btnLimpiar);
			}
		}
		{
			scrollPane = new JScrollPane();
			frmEditorGrafico.getContentPane().add(scrollPane, BorderLayout.CENTER);
		}

		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);
	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frmEditorGrafico);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagenFondo = new ImageIcon(file.getAbsolutePath());
				miAreaDibujo.setIcon(imagenFondo);

				btnRecta.setEnabled(true);

			}
		}
	}

	private class BtnRectaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = RECTA;
		}
	}

	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if (imagenFondo != null) {
				switch (modo) {
				case RECTA:
					miAreaDibujo.addObjetoGrafico(new RectaGrafico(x, y, x, y, Color.RED, 5));
					break;
				}
			}

		}
	}

	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTA && imagenFondo != null) {
				((RectaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
		}
	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			miAreaDibujo.limpiar(miAreaDibujo.getGraphics());
		}
	}

}