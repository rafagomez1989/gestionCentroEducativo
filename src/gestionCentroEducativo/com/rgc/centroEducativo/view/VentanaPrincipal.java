package gestionCentroEducativo.com.rgc.centroEducativo.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Cursos", new CursoView());
		tabedPane.add("Materias", new MateriaView());
		tabedPane.add("Estudiantes", new EstudianteView());
		tabedPane.add("Profesores", new ProfesorView());
		tabedPane.add("Valoración materias", new ValoracionMateriaView());


		this.setMinimumSize(new Dimension(800, 600));

		
		this.setContentPane(tabedPane);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
