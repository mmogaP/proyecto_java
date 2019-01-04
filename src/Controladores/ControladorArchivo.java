package Controladores;

import java.awt.event.*;
import Vista.*;
import Modelo.Modelo_Hotel;
public class ControladorArchivo implements ActionListener{
	VistaArchicos vista;
	Modelo_Hotel modelo;
	public ControladorArchivo(Modelo_Hotel modelo) {
		this.modelo = modelo;
		vista = new VistaArchicos();
		vista.vistaIniciar();
		this.vista.botoni.addActionListener(this);
		this.vista.botonp.addActionListener(this);
		this.vista.botona.addActionListener(this);
		this.vista.botonc.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.vista.botoni)) {
			this.vista.archBuscar();
		}
		else if(e.getSource().equals(this.vista.botonp)) {
			this.vista.archBuscar1();
		}
		else if(e.getSource().equals(this.vista.botona)) {
			
		}
		else if(e.getSource().equals(this.vista.botonc)) {
			this.vista.cerrarVista();
		}
	}

}
