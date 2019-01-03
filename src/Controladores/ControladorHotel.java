package Controladores;
import java.awt.*;
import java.awt.event.*;
import Vista.*;
public class ControladorHotel implements ActionListener{
	VistaHotel vista;
	public ControladorHotel(VistaHotel vista) {
		this.vista = vista;
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
