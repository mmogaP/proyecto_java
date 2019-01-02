package Vista;
import java.awt.*;
import javax.swing.*;

public class VistaReserva extends JFrame {
	private JLabel tex,tex1,tex2;
	JTextField cuadro1;
	public VistaReserva(){
		setLayout(null);
		setTitle("Reservar");
		setSize(400, 600);
		tex = new JLabel("Reservar");
		tex.setBounds(155,5,100,50);
		tex.setFont(new java.awt.Font("Tahoma", 1, 15));
		add(tex);
		tex1= new JLabel("Fecha Ingreso");
		tex1.setBounds(10,50,100,50);
		add(tex1);
		cuadro1 = new JTextField();
		cuadro1.setBounds(100, 60, 100, 25);
		add(cuadro1);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
