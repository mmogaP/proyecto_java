package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaMenu extends JFrame{
	public JPanel panel;
	public JLabel etiqueta,etiqueta2;
	public JTextField caja1;
	public JButton boton1, boton3, boton4;
	public JComboBox<String> combo;
	public JTextArea textArea;
	String comida;
	
	public VistaMenu(ArrayList<String> menu) {
		setBounds(500, 500, 520,400);
		iniciarComp(menu);
	}
	
	private void iniciarComp(ArrayList<String> menu) {
		panel();
		etiquetas();
		ingreso();
		botones();
		combobox(menu);
	}
	
	private void panel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
	}
	
	private void etiquetas() {
		etiqueta = new JLabel("Tomar orden");
		etiqueta.setBounds(10, 10, 500, 30);
		etiqueta.setFont(new Font("Times New Roman", 0,20));
		panel.add(etiqueta);
		etiqueta2 = new JLabel("Titular");
		etiqueta2.setBounds(340,150,150,40);
		etiqueta2.setFont(new Font("Times New Roman", 0,20));
		panel.add(etiqueta2);
	}
	
	private void ingreso() {
		textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 50, 320, 290);
        JScrollPane scroll=new JScrollPane(textArea);
        scroll.setBounds(10, 50, 320, 290);
        panel.add(scroll);
        
        caja1 = new JTextField();
        caja1.setBounds(340,190,150,30);
        panel.add(caja1);
	}
	
	private void botones() {
		boton1 = new JButton("Ingresar orden");
		boton1.setBounds(340, 50, 150, 40);
		panel.add(boton1);
		boton3 = new JButton("Enviar orden");
		boton3.setBounds(340, 245, 150, 40);
		panel.add(boton3);
		boton4 = new JButton("Cancelar todo");
		boton4.setBounds(340, 299, 150, 40);
		panel.add(boton4);
	}
	private void combobox(ArrayList<String> menu) {
		combo = new JComboBox<String>();
		combo.setBounds(120, 10, 200, 30);
		for(int i=0;i<menu.size();i++) {
			combo.addItem(menu.get(i));
		}
		panel.add(combo);
	}
	public String getTextB() {
		return (String) combo.getSelectedItem();
	}
	public void setTextA(String men) {
		String aux = textArea.getText();
		aux = aux+men+"\n";
		textArea.setText(aux);
	}
	public String getText() {
		return caja1.getText();
	}
	public String getTexta() {
		return textArea.getText();
	}
}
