package Controladores;

import java.awt.event.*;
import Modelo.Modelo_Hotel;
import Vista.VistaCancelar;

public class ControladorCancelacion implements ActionListener {
	Modelo_Hotel modelo;
	VistaCancelar vista;
	public ControladorCancelacion(Modelo_Hotel modelo) {
		this.modelo=modelo;
		this.vista=new VistaCancelar();
		this.vista.setVisible(true);
		this.vista.boton1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.vista.boton1)) {
			this.modelo.setCancelacion(this.vista.getText());
			this.vista.setVisible(false);
		}
	}

}
