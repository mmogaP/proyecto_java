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
	public ControladorHotel(VistaHotel vista,Modelo_Hotel modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.botonreservacion.addActionListener(this);
		this.vista.botoncancelacion.addActionListener(this);
		this.vista.bcheck_in.addActionListener(this);
		this.vista.bcheck_out.addActionListener(this);
		this.vista.barchivos.addActionListener(this);
		this.vista.breportes.addActionListener(this);
		this.vista.bservicios.addActionListener(this);
		this.vista.brestaurant.addActionListener(this);
	}
	private void setReserva() {
		ControladorReserva contres = new ControladorReserva(modelo);
	}
	private void setArchivo() {
		ControladorArchivo contarch = new ControladorArchivo(modelo);
	}
	private void setCancelacion() {
		ControladorCancelacion contrcan = new ControladorCancelacion(modelo);
	}
	private void setCheck_in() {
		ControladorCheck_in contche = new ControladorCheck_in(modelo);
	}
	private void setCheck_out() {
		ControladorCheck_out contcheout = new ControladorCheck_out(modelo);
	}
	private void setServicios() {
		ControladorServicios contsev = new ControladorServicios(modelo);
	}
	private void setMenu() {
		ControladorMenu contmenu = new ControladorMenu(modelo,modelo.getFormatoMenu());
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
		else if(e.getSource().equals(vista.botoncancelacion)) {
			setCancelacion();
		}
		else if(e.getSource().equals(vista.bcheck_in)) {
			setCheck_in();
		}
		else if(e.getSource().equals(vista.bcheck_out)) {
			setCheck_out();
		}
		else if(e.getSource().equals(vista.bservicios)) {
			setServicios();
		}
		else if(e.getSource().equals(this.vista.brestaurant)) {
			setMenu();
		}
	}
	public static void main(String[] argc) {
		VistaHotel vista = new VistaHotel();
		Hotel hot = new Hotel();
		Precio precio = new Precio();
		Modelo_Hotel modelo= new Modelo_Hotel(hot,precio);
		ControladorHotel controlador = new ControladorHotel(vista,modelo);
	}

}
