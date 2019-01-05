package Vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class VistaHotel extends JFrame{
	public JButton botonreservacion,botoncancelacion,bcheck_in,bcheck_out,breportes,barchivos,bservicios,brestaurant;
	private JTextField ingreso,transformado;
	private JLabel tex;
	public VistaHotel() {
		setTitle("Hotel mi Refugio");
		setLayout(null);
		tex = new JLabel("Hotel Mi Refugio");
		tex.setBounds(270,15,200,50);
		tex.setFont(new java.awt.Font("Tahoma", 1, 15));
		add(tex);
		setSize(700,700);
		setBotones();//botones
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void setBotones() {
		botonreservacion = new JButton("Reservas");
		botonreservacion.setBounds(50, 80, 100, 50);
		add(botonreservacion);
		botoncancelacion = new JButton("Cancelar");
		botoncancelacion.setBounds(50, 160, 100, 50);
		add(botoncancelacion);
		bcheck_in = new JButton("Check in");
		bcheck_in.setBounds(50, 240, 100, 50);
		add(bcheck_in);
		bcheck_out = new JButton("Check out");
		bcheck_out.setBounds(50, 320, 100, 50);
		add(bcheck_out);
		breportes = new JButton("Reportes");
		breportes.setBounds(50, 400, 100, 50);
		add(breportes);
		bservicios = new JButton("Servicios");
		bservicios.setBounds(50, 480, 100, 50);
		add(bservicios);
		brestaurant = new JButton("Restaurant");
		brestaurant.setBounds(50, 560, 100, 50);
		add(brestaurant);
		barchivos = new JButton("Archivos");
		barchivos.setBounds(560, 580, 90, 30);
		add(barchivos);
	}
	
	public static void main(String[] args) {
	/*	VistaHotel hot = new VistaHotel();
		Check hot2 = new Check("Ingreso Titular/Check-out");
		hot2.setVisible(true);
		VistaReportes hot3 = new VistaReportes();
		hot3.setVisible(true);*/
		VistaServicios hot4 = new VistaServicios();
		hot4.setVisible(true);
		ArrayList<String> menu = new ArrayList<String>();
		VistaMenu hot5 = new VistaMenu(menu);
		hot5.setVisible(true);
	}
}
