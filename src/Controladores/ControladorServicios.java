package Controladores;

import java.awt.event.*;
import Modelo.Modelo_Hotel;
import Vista.VistaServicios;

public class ControladorServicios implements ActionListener{
	Modelo_Hotel modelo;
	VistaServicios vista;
	public ControladorServicios(Modelo_Hotel modelo) {
		this.modelo=modelo;
		this.vista=new VistaServicios();
		this.vista.boton1.addActionListener(this);
		this.vista.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.vista.boton1)) {
			String pedido = "";
			if(vista.boton2.isSelected()) {
				pedido = "CAM_A ";
			}
			if(vista.boton3.isSelected()) {
				pedido= pedido + "CAJ_F";
			}
			String titular = this.vista.getText();
			this.modelo.setServicio(titular, pedido);
		}
	}

}
