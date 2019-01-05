package Controladores;

import java.awt.event.*;
import java.util.ArrayList;

import Modelo.Modelo_Hotel;
import Vista.VistaMenu;

public class ControladorMenu implements ActionListener{
	Modelo_Hotel modelo;
	VistaMenu vista;
	public ControladorMenu(Modelo_Hotel modelo,ArrayList<String> menu) {
		this.modelo=modelo;
		this.vista = new VistaMenu(menu);
		this.vista.boton1.addActionListener(this);
		this.vista.boton3.addActionListener(this);
		this.vista.boton4.addActionListener(this);
		this.vista.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(vista.boton1)) {
			String men = vista.getTextB();
			vista.setTextA(men);
		}
		else if(e.getSource().equals(vista.boton3)) {
			modelo.setMenu(vista.getText(), vista.getTexta());
			this.vista.setVisible(false);
		}
		else if(e.getSource().equals(vista.boton4)) {
			vista.setVisible(false);
		}
	}

}
