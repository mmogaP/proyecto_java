package Vista;
import java.awt.*;
import javax.swing.*;

public class VistaReserva extends JFrame {
	private JLabel tex,tex1,tex2,tex3,tex4;
	private JTextField cuadro1,cuadro2,cuadro3;
	private TextArea texa;
	public JButton botona,botonc;
	public VistaReserva(){
		setLayout(null);
		setTitle("Reservar");
		setSize(400, 600);
		tex = new JLabel("Reservar");
		tex.setBounds(155,5,100,50);
		tex.setFont(new java.awt.Font("Tahoma", 1, 15));
		add(tex);
		setIngresoText();
		}
	private void setIngresoText() {
		tex1= new JLabel("Fecha Ingreso:");
		tex1.setBounds(10,50,100,50);
		add(tex1);
		cuadro1 = new JTextField();
		cuadro1.setBounds(110, 60, 100, 25);
		add(cuadro1);
		////////////////////////////////////////////////
		tex2 = new JLabel("Fecha de Salida:");
		tex2.setBounds(10, 100, 100, 50);
		add(tex2);
		cuadro2 = new JTextField();
		cuadro2.setBounds(110, 110, 100, 25);
		add(cuadro2);
		//////////////////////////////////////////////////
		tex3 = new JLabel("Habitacion:");
		tex3.setBounds(10, 150, 100, 50);
		add(tex3);
		cuadro3 = new JTextField();
		cuadro3.setBounds(110, 160, 100, 25);
		add(cuadro3);
		//////////////////////////////////////////////////
		tex4 = new JLabel("Personas  Ingresar:");
		tex4.setBounds(10, 200, 130, 50);
		add(tex4);
		texa = new TextArea();
		texa.setBounds(150, 215, 200, 200);
		add(texa);
		botona = new JButton("Aceptar");
		botona.setBounds(50, 500, 100, 25);
		add(botona);
		botonc = new JButton("Cancelar");
		botonc.setBounds(200, 500, 100, 25);
		add(botonc);
	}
	public void setIniciar() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setCerrar() {
		setVisible(false);
	}
	public String getCuadro1() {
		return cuadro1.getText();
	}
	public String getCuadro2() {
		return cuadro2.getText();
	}
	public String getCuadro3() {
		return cuadro3.getText();
	}
	public String getTexa() {
		return texa.getText();
	}
	public void setCuadro1(String text) {
		this.cuadro1.setText(text);
	}
	public void setCuadro2(JTextField cuadro2) {
		this.cuadro2 = cuadro2;
	}
	public void setCuadro3(JTextField cuadro3) {
		this.cuadro3 = cuadro3;
	}
	public void setTexa(TextArea texa) {
		this.texa = texa;
	}
}
