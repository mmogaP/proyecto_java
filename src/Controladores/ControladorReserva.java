package Controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaReserva;
public class ControladorReserva implements ActionListener {
	VistaReserva vista;
	String fecha1,fecha2,tipo;
	String[] personas;
	public ControladorReserva() {
		this.vista = new VistaReserva();
		this.vista.setIniciar();
		this.vista.botona.addActionListener(this);
		this.vista.botonc.addActionListener(this);
	}
	public String getFecha1() {
		return fecha1;
	}
	public String getFecha2() {
		return fecha2;
	}
	public String getTipo() {
		return tipo;
	}
	public String[] getPersonas() {
		return personas;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.vista.botona)) {
			fecha1 = vista.getCuadro1();
			fecha2 = vista.getCuadro2();
			tipo = vista.getCuadro3();
			personas = vista.getTexa().split("\n");
		}
		else if(arg0.getSource().equals(this.vista.botonc)) {
			vista.setCerrar();
		}
	}
}
