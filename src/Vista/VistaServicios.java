package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VistaServicios extends JFrame{
	public JPanel panel;
	public JLabel etiqueta,etiqueta2;
	public JTextField caja1;
	public JButton boton1;
	public JRadioButton boton2, boton3;
	
	public VistaServicios() {
		setBounds(500, 500, 240,220);
		iniciarComp();
	}
	
	private void iniciarComp() {
		panel();
		etiquetas();
		botonr();
		botones();
		ingreso();
	}
	
	private void panel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
	}
	
	private void etiquetas() {
		etiqueta = new JLabel("Ingreso de Servicios:");
		etiqueta.setBounds(10, 5, 500, 30);
		etiqueta.setFont(new Font("Times New Roman", 0,15));
		panel.add(etiqueta);
		etiqueta2 = new JLabel("Titular:");
		etiqueta2.setBounds(25, 90, 70, 30);
		etiqueta2.setFont(new Font("Times New Roman", 0,15));
		panel.add(etiqueta2);
	}
	
	private void ingreso() {
		caja1 = new JTextField();
		caja1.setBounds(80, 97, 90, 20);
		panel.add(caja1);
	}
	
	private void botones() {
		boton1 = new JButton("INGRESAR");
		boton1.setBounds(60, 130, 100, 30);
		panel.add(boton1);
	}
	
	private void botonr() {
		boton2 = new JRadioButton("Cama adicional", false);
		boton2.setBounds(10, 30, 200, 30);
		panel.add(boton2);
		
		boton3 = new JRadioButton("Caja fuerte", false);
		boton3.setBounds(10, 60, 100, 30);
		panel.add(boton3);
	}
	public String getText(){
		return caja1.getText();
	}
}
