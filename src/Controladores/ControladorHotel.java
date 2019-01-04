package Controladores;
import java.awt.*;
import java.awt.event.*;
import Vista.*;
import Modelo.Modelo_Hotel;
import hotel.proces.*;
public class ControladorHotel implements ActionListener{
	VistaHotel vista;
	Hotel hot;
	Modelo_Hotel modelo;
	public ControladorHotel(VistaHotel vista) {
		this.vista = vista;
		hot = new Hotel();
		modelo = new Modelo_Hotel(hot);
		this.vista.botonreservacion.addActionListener(this);
		this.vista.botoncancelacion.addActionListener(this);
		this.vista.bcheck_in.addActionListener(this);
		this.vista.bcheck_out.addActionListener(this);
		this.vista.barchivos.addActionListener(this);
		this.vista.breportes.addActionListener(this);
		this.vista.bservicios.addActionListener(this);
	}
	private void setReserva() {
		ControladorReserva contres = new ControladorReserva(modelo);
	}
	private void setArchivo() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(vista.botonreservacion)) {
			setReserva();
		}
		else if(e.getSource().equals(vista.barchivos)) {
			setArchivo();
		}
	}
	public static void main(String[] argc) {
		VistaHotel vista = new VistaHotel();
		ControladorHotel controlador = new ControladorHotel(vista);
	}

}
