package Vista;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VistaArchicos extends JFrame {
	private JLabel tex,tex2;
	private JTextField cuadro,cuadro1;
	public JButton botoni,botonp,botona,botonc;
	public VistaArchicos() {
		setLayout(null);
		setSize(400, 250);
		setLabels();
		setCuadrados();
		setBotones();
	}
	private void setLabels() {
		tex = new JLabel("Archivo Inicializar:");
		tex.setBounds(10, 20, 125, 25);
		tex2 = new JLabel("Archivo Precio:");
		tex2.setBounds(10, 100, 100, 25);
		add(tex);
		add(tex2);
	}
	private void setCuadrados() {
		cuadro = new JTextField();
		cuadro.setBounds(120, 20, 150, 25);
		add(cuadro);
		cuadro1 = new JTextField();
		cuadro1.setBounds(120, 100, 150,25);
		add(cuadro1);
	}
	private void setBotones() {
		botoni = new JButton("Selecione Archivo");
		botonp = new JButton("Selecione Arhcivo");
		botoni.setBounds(120, 50, 150, 25);
		add(botoni);
		botonp.setBounds(120, 130, 150, 25);
		add(botonp);
		botona = new JButton("Aceptar");
		botonc= new JButton("Cancelar");
		botona.setBounds(25, 170, 100, 25);
		add(botona);
		botonc.setBounds(250, 170, 100, 25);
		add(botonc);
	}
	public void vistaIniciar() {
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void cerrarVista() {
		setVisible(false);
	}
	public void archBuscar() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt"); 
        chooser.setFileFilter(filtro); 
		int returnVal = chooser.showOpenDialog(null); 
		if(returnVal == JFileChooser.APPROVE_OPTION) { 
			cuadro.setText(chooser.getSelectedFile().getAbsolutePath());
		} 
	}
	public void archBuscar1() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt"); 
        chooser.setFileFilter(filtro); 
		int returnVal = chooser.showOpenDialog(null); 
		if(returnVal == JFileChooser.APPROVE_OPTION) { 
			cuadro1.setText(chooser.getSelectedFile().getAbsolutePath());
		} 
	}
}
