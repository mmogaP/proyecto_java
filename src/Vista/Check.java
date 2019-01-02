package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Check extends JFrame{
	public JPanel panel;
	public JLabel etiqueta;
	public JTextField caja1;
	public JButton boton1;
	
	public Check(String texto) {
		setBounds(500, 500, 240,200);
		iniciarComp(texto);
	}
	
	private void iniciarComp(String texto) {
		panel();
		etiquetas(texto);
		ingreso();
		botones();
	}
	
	private void panel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
	}
	
	private void etiquetas(String text) {
		etiqueta = new JLabel(text);
		etiqueta.setBounds(10, 10, 500, 30);
		etiqueta.setFont(new Font("Times New Roman", 0,15));
		panel.add(etiqueta);
		
	}
	
	private void ingreso() {
		caja1 = new JTextField();
		caja1.setBounds(10, 50, 200, 30);
		panel.add(caja1);
	}
	
	private void botones() {
		boton1 = new JButton("INGRESAR");
		boton1.setBounds(60, 90, 100, 40);
		panel.add(boton1);
		
		//action listener
		ActionListener oyente1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//cerrar y guardar variable al ingresar
			}		
		};
		
		boton1.addActionListener(oyente1);
	}
}