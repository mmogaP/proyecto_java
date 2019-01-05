package Controladores;

import java.awt.event.*;
import Modelo.Modelo_Hotel;
import Vista.Check;

public class ControladorCheck_in implements ActionListener {
	Modelo_Hotel modelo;
	Check vista;
	public ControladorCheck_in(Modelo_Hotel modelo){
		this.modelo=modelo;
		this.vista = new Check("Ingreso Titular/Check-in");
		this.vista.boton1.addActionListener(this);
		this.vista.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.vista.boton1)) {
			this.modelo.setCheck_in(this.vista.getText());
			this.vista.setVisible(false);
		}
	}

}
