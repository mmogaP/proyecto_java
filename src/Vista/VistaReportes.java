package Vista;

import java.awt.FlowLayout;
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
import javax.swing.JTextField;

public class VistaReportes extends JFrame {
	public JPanel panel;
	public JLabel etiqueta, et1, et2;
	public JTextField caja1,tf;
	public JButton boton1;
	public JComboBox<String> combo;
	public JTextArea textArea;
	
	String[] opcion = new String[12];
	String opciones;
	
	public VistaReportes() {
		setBounds(500, 500, 460,380);
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
		etiqueta = new JLabel("Revision de reportes:");
		etiqueta.setBounds(10, 10, 500, 30);
		etiqueta.setFont(new Font("Times New Roman", 0,15));
		panel.add(etiqueta);
		
		et1 = new JLabel("Fecha ingreso:");
		et1.setBounds(220, 10, 500, 30);
		et1.setFont(new Font("Times New Roman", 0,15));
		panel.add(et1);
		
		et2 = new JLabel("Fecha salida:");
		et2.setBounds(330, 10, 500, 30);
		et2.setFont(new Font("Times New Roman", 0,15));
		panel.add(et2);
	}
	
	private void ingreso() {
		caja1 = new JTextField();
		caja1.setBounds(220, 40, 100, 30);
		panel.add(caja1);
		
		tf = new JTextField();
		tf.setBounds(330, 40, 100, 30);
		panel.add(tf);
		
		textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 140, 420, 170);
 
        JScrollPane scroll=new JScrollPane(textArea);
        scroll.setBounds(10, 140, 420, 170);
        panel.add(scroll);
	}
	
	private void botones() {
		boton1 = new JButton("Mostrar Reporte");
		boton1.setBounds(150, 80, 150, 40);
		panel.add(boton1);
		}
	private void combobox() {
		combo = new JComboBox<String>();
		combo.setBounds(10, 40, 200, 30);
		combo.addItem(opcion[0] = "a) Número de reservaciones canceladas.");
		combo.addItem(opcion[1] = "b) Número de reservaciones efectivas.");
		combo.addItem(opcion[2] = "c) Adultos y niños atendidos.");
		combo.addItem(opcion[3] = "d) Ingresos por concepto de camas adicionales.");
		combo.addItem(opcion[4] = "e) Piso con mayor uso.");
		combo.addItem(opcion[5] = "f) Número de transferencias totales.");
		combo.addItem(opcion[6] = "g) Ingresos por uso de caja fuerte.");
		combo.addItem(opcion[7] = "h) Porcentaje de ocupación diaria.");
		combo.addItem(opcion[8] = "i) Promedio del porcentaje de ocupación diaria.");
		combo.addItem(opcion[9] = "j) Habitaciones ocupadas.");
		combo.addItem(opcion[10] = "k) Habitaciones reservadas (bloqueadas).");
		combo.addItem(opcion[11] = "l) Habitaciones libres.");
		
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
