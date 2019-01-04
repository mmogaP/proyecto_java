package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaMenus extends JFrame{
	public JPanel panel;
	public JLabel etiqueta;
	public JButton boton1, boton2, boton3, boton4;
	public JComboBox<String> combo;
	public JTextArea textArea;
	
	String[] menu = new String[12];
	String comida;
	
	public VistaMenus() {
		setBounds(500, 500, 520,400);
		iniciarComp();
	}
	
	private void iniciarComp() {
		panel();
		etiquetas();
		ingreso();
		botones();
		combobox();
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
	}
	
	private void ingreso() {
		textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 50, 320, 290);
 
        JScrollPane scroll=new JScrollPane(textArea);
        scroll.setBounds(10, 50, 320, 290);
        panel.add(scroll);
	}
	
	private void botones() {
		boton1 = new JButton("Ingresar orden");
		boton1.setBounds(340, 50, 150, 40);
		panel.add(boton1);
		
		//action listener
		ActionListener oyente1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//cerrar y guardar variable al ingresar
			}		
		};
		
		boton1.addActionListener(oyente1);
		
		boton2 = new JButton("Cancelar orden");
		boton2.setBounds(340, 105, 150, 40);
		panel.add(boton2);
		
		//action listener
		ActionListener oyente2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//cerrar y guardar variable al ingresar
			}		
		};
		
		boton2.addActionListener(oyente2);
		
		boton3 = new JButton("Enviar orden");
		boton3.setBounds(340, 245, 150, 40);
		panel.add(boton3);
		
		//action listener
		ActionListener oyente3 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//cerrar y guardar variable al ingresar
			}		
		};
		
		boton3.addActionListener(oyente3);
		
		boton4 = new JButton("Cancelar todo");
		boton4.setBounds(340, 299, 150, 40);
		panel.add(boton4);
		
		//action listener
		ActionListener oyente4 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//cerrar y guardar variable al ingresar
			}		
		};
		
		boton4.addActionListener(oyente4);
	}
	private void combobox() {
		combo = new JComboBox<String>();
		combo.setBounds(120, 10, 200, 30);
		combo.addItem(menu[0]);
		
		panel.add(combo);
		
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//.setText(combo.getSelectedItem().toString());
				//opciones = .getText();
			}
		});
		
	
	}
}

