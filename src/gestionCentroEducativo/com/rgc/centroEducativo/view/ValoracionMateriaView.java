package gestionCentroEducativo.com.rgc.centroEducativo.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestionCentroEducativo.com.rgc.centroEducativo.ControllerMateria;
import gestionCentroEducativo.com.rgc.centroEducativo.controller.ControllerEstudiante;
import gestionCentroEducativo.com.rgc.centroEducativo.controller.ControllerProfesor;
import gestionCentroEducativo.com.rgc.centroEducativo.controller.ControllerValoracionMateria;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Curso;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Estudiante;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Materia;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Profesor;
import gestionCentroEducativo.com.rgc.centroEducativo.model.ValoracionMateria;

import javax.swing.JComboBox;

public class ValoracionMateriaView extends JPanel {
	
	private JTextField jtfId;
	private JTextField jtfValoracion;
	private JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	private JComboBox <Profesor> jcbProfesor;
	private JComboBox <Estudiante> jcbEstudiante;
	private JComboBox <Materia> jcbMateria;



	/**
	 * Create the panel.
	 */
	public ValoracionMateriaView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowHeights = new int[]{36, 0, 0, 30, 29, 22, 0};
		gridBagLayout.columnWidths = new int[]{0, 88, 339, 91};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de valoración materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id profesor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbIdProfesor = new GridBagConstraints();
		gbc_jcbIdProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbIdProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdProfesor.gridx = 2;
		gbc_jcbIdProfesor.gridy = 2;
		add(jcbProfesor, gbc_jcbIdProfesor);
		
		JLabel lblNewLabel_2_1 = new JLabel("Id estudiante:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 3;
		add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		jcbEstudiante = new JComboBox();
		GridBagConstraints gbc_jcbIdEstudiante = new GridBagConstraints();
		gbc_jcbIdEstudiante.insets = new Insets(0, 0, 5, 5);
		gbc_jcbIdEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdEstudiante.gridx = 2;
		gbc_jcbIdEstudiante.gridy = 3;
		add(jcbEstudiante, gbc_jcbIdEstudiante);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Id Materia");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1.gridy = 4;
		add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbIdMateria = new GridBagConstraints();
		gbc_jcbIdMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbIdMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdMateria.gridx = 2;
		gbc_jcbIdMateria.gridy = 4;
		add(jcbMateria, gbc_jcbIdMateria);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Valoración:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_2.gridx = 1;
		gbc_lblNewLabel_2_1_2.gridy = 5;
		add(lblNewLabel_2_1_2, gbc_lblNewLabel_2_1_2);
		
		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 2;
		gbc_jtfValoracion.gridy = 5;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControllerValoracionMateria.findFirst());
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControllerValoracionMateria.findPrevious(
						Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControllerValoracionMateria.findNext(
						Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControllerValoracionMateria.findLast());
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnEliminar);
	
		cargarJcbs();
		cargarEnPantalla(ControllerValoracionMateria.findFirst());
		
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", 
				"Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	int actualId = Integer.parseInt(this.jtfId.getText());
		    if (ControllerValoracionMateria.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	ValoracionMateria vmAnterior = ControllerValoracionMateria.findPrevious(actualId);
		    	if (vmAnterior != null) {
		    		cargarEnPantalla(vmAnterior);
		    	}
		    	else {
		    		ValoracionMateria vmSiguiente = ControllerValoracionMateria.findNext(actualId);
		    		if (vmSiguiente != null) {
		    			cargarEnPantalla(vmSiguiente);
		    		}
		    		else { // No quedan registros, has eliminado el único
		    			limpiarDatos();
		    		}
		    	}
		    }
	    }	
	}
	
	
	/**
	 * 
	 */
	private void limpiarDatos() {
		this.jtfId.setText("0");
		this.jcbProfesor.removeAllItems();
		this.jcbEstudiante.removeAllItems();
		this.jcbMateria.removeAllItems();
		this.jtfValoracion.setText("");

	}
	
	
	/**
	 * 
	 */
	private void guardar() {
		ValoracionMateria vm = new ValoracionMateria();
		vm.setId(Integer.parseInt(this.jtfId.getText()));
		vm.setEstudiante((Estudiante)jcbEstudiante.getSelectedItem());
		vm.setProfesor((Profesor)jcbProfesor.getSelectedItem());
		vm.setMateria((Materia)jcbMateria.getSelectedItem());
		vm.setValoracion(Float.parseFloat(this.jtfValoracion.getText()));

		String strError = "No se ha podido guardar";
		if (vm.getId() == 0) {
			int nuevoIdInsertado = ControllerValoracionMateria.insertar(vm);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				this.jtfId.setText("" + nuevoIdInsertado);
				JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
			}
		}
		else {
			if (ControllerValoracionMateria.modificar(vm) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
			}
		}	
	}
	
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (ValoracionMateria vm) {
		if (vm != null) {
			this.jtfId.setText("" + vm.getId());
			vm.setEstudiante((Estudiante)jcbEstudiante.getSelectedItem());
			vm.setProfesor((Profesor)jcbProfesor.getSelectedItem());
			vm.setMateria((Materia)jcbMateria.getSelectedItem());
			this.jtfValoracion.setText("" + vm.getValoracion());
		}
		
		// Habilito y deshabilito botones de navegación
		if (ControllerValoracionMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		}
		else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControllerValoracionMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	}
	
	/**
	 * 
	 */
	private void cargarJcbs () {
		List<Profesor> lp = ControllerProfesor.findAll();
		for (Profesor profesor : lp) {
			jcbProfesor.addItem(profesor);
		}
		
		List<Estudiante> le = ControllerEstudiante.findAll();
		for (Estudiante estudiante : le) {
			jcbEstudiante.addItem(estudiante);
		}
		
		List<Materia> lm = ControllerMateria.findAll();
		for (Materia materia : lm) {
			jcbMateria.addItem(materia);
		}
	}

}
