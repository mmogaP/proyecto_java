package Controladores;
import java.awt.*;
import java.awt.event.*;
import Vista.*;
import hotel.proces.*;
public class ControladorHotel implements ActionListener{
	VistaHotel vista;
	Hotel hot;
	public ControladorHotel(VistaHotel vista) {
		this.vista = vista;
		hot = new Hotel();
		this.vista.botonreservacion.addActionListener(this);
		this.vista.botoncancelacion.addActionListener(this);
		this.vista.bcheck_in.addActionListener(this);
		this.vista.bcheck_out.addActionListener(this);
		this.vista.barchivos.addActionListener(this);
		this.vista.breportes.addActionListener(this);
		this.vista.bservicios.addActionListener(this);
	}
	private void setReserva() {
		ControladorReserva contres = new ControladorReserva();
		System.out.println(contres.getFecha1());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(vista.botonreservacion)) {
			setReserva();
		}
	}
	public static void main(String[] argc) {
		VistaHotel vista = new VistaHotel();
		ControladorHotel controlador = new ControladorHotel(vista);
	}

}
