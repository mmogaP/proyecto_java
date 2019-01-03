package Controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaReserva;
public class ControladorReserva implements ActionListener {
	VistaReserva vista;
	public ControladorReserva() {
		this.vista = new VistaReserva();
		this.vista.setIniciar();
		this.vista.botona.addActionListener(this);
		this.vista.botonc.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.vista.botona)) {
			
		}
		else if(arg0.getSource().equals(this.vista.botonc)) {
			vista.setCerrar();
		}
	}
}
