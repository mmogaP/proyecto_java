package Controladores;

import java.awt.event.ActionEvent;
import Modelo.Modelo_Hotel;
import java.awt.event.ActionListener;
import Vista.VistaReserva;
import hotel.proces.*;

public class ControladorReserva implements ActionListener {
	VistaReserva vista;
	String fecha1, fecha2, tipo;
	String[] personas;
	Modelo_Hotel modelo;
	public ControladorReserva(Modelo_Hotel modelo) {
		this.modelo=modelo;
		this.vista = new VistaReserva();
		this.vista.setIniciar();
		this.vista.botona.addActionListener(this);
		this.vista.botonc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(this.vista.botona)) {
			fecha1 = vista.getCuadro1();
			fecha2 = vista.getCuadro2();
			tipo = vista.getCuadro3();
			personas = vista.getTexa().split("\n");
			modelo.setReserva(tipo, personas, fecha1, fecha2);
			vista.setCerrar();
		} else if (arg0.getSource().equals(this.vista.botonc)) {
			vista.setCerrar();
		}
	}
}
