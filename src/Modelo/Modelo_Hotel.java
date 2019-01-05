package Modelo;
import hotel.proces.*;

import java.util.ArrayList;
import java.util.Calendar;

import Archivos.*;
public class Modelo_Hotel {
	String salida="C:\\Users\\Abuelo\\Desktop\\Nueva carpeta\\Reservas.txt";
	String contabilidad="C:\\Users\\Abuelo\\Desktop\\Nueva carpeta\\contabilidad.txt";
	Hotel hot ;
	Precio precio;
	Calendar c = Calendar.getInstance();
	public Modelo_Hotel(Hotel hot,Precio precio) {
		this.hot = hot;
		this.precio = precio;
	}
	public void iniciarHotel(String direccion) {
		Archivo_Leer texto_ini = new Archivo_Leer();
		texto_ini.leerArchivo(direccion);
		hot.setPresupuesto(Double.parseDouble(texto_ini.getLinea(0)));//desde el archivo inicilaizar le paso la variable presupuesto al hotel		
		String aux=texto_ini.getLinea(1);//le doy la linea donde va la fecha
		String[] fecha_ = aux.split(" ");//separa la fecha por los espacios
		hot.setDd(Integer.parseInt(fecha_[0]));//dia
		hot.setMm(Integer.parseInt(fecha_[1]));//mes
		hot.setAa(Integer.parseInt(fecha_[2]));//año
		aux=texto_ini.getLinea(2);//ahora aux pasa a ser la linea de cantidad de pisos
		String[] piso = aux.split(" ");//lista con habitacioes piso
		hot.setNum_habi(Integer.parseInt(piso[0]));
		hot.setMun_pisos(Integer.parseInt(piso[1]));
		for(int i=0;i<(hot.getMun_pisos());i++) {//recorro los pisos para agregar el tipo de habitacion en cada uno
			aux=texto_ini.getLinea(i+3);
			String[] hab = aux.split(" ");
			hot.setPiso(i+1);
			for (int z=1;z<=Integer.parseInt(hab[0]);z++) {
				hot.setHabitacion(hab[z],i+1,z);
			}
		}
	}//inicializar
	
	public void iniciarPrecios(String direccion) {
		Archivo_Leer texto_pre = new Archivo_Leer();//creo un nuevo objeto para leer el archivo de los precios
		texto_pre.leerArchivo(direccion);//aca se le da la direccion
		String parametros = texto_pre.getLinea(0);//Se le da el tipo de habitacion y los servicios que pide
		String[] parametros2 = parametros.split(" ");
		int num_hab = Integer.parseInt(parametros2[0]);
		for(int i=0;i<num_hab;i++) {//recorro  la cantidad de habitaciones que se le da
			String[] aux2 = (texto_pre.getLinea(i+1)).split(" ");
			precio.setHabitacion(aux2[0], Double.parseDouble(aux2[1]));//le doy el precio a cada una de las habitaciones
		}
		int num_serv=Integer.parseInt(parametros2[1]);
		for(int i=0;i<num_serv;i++) {//ahora con los servicios y sus respectivos precios
			String[] aux2 = (texto_pre.getLinea(i+num_hab+1)).split(" ");
			String aux_nombre = "";
			for(int z=2;z<aux2.length;z++) {
				aux_nombre = aux_nombre+aux2[z]+" ";
			}
			precio.setServicio(aux2[0],Double.parseDouble(aux2[1]), aux_nombre);
		}
		int num_menu=Integer.parseInt(parametros2[2]);
		for(int i=0;i<num_menu;i++) {//ahora con los menu y el respectivo precio de cada plato en el menu
			String[] aux2=(texto_pre.getLinea(i+num_serv+num_hab+1)).split(" ");
			String aux_nombre="";
			for(int z = 2;z<aux2.length;z++) {
				aux_nombre = aux_nombre+aux2[z]+" ";
			}
			precio.setMenu(aux2[0], Double.parseDouble(aux2[1]), aux_nombre);
		}
	}//set precio
	
	public void setReserva(String tipo,String[] personas,String fechain,String fechaout) {
		int[] cord = hot.setReservacion(tipo);
		String[] fecha1=fechain.split(" ");
		String[] fecha2=fechaout.split(" ");
		String titular="";
		int adult=0;
		int infantes=0;
		for(int y = 0;y<personas.length;y++) {//ahora agrego quienes se van ospedar, quien es el titular y si tiene niños
			String[] separacion=personas[y].split(" ");
			if(y==0) {
				titular=separacion[1];
			}
			if(separacion[0].equals("A")) {
				adult++;
			}
			else if(separacion[0].equals("N")) {
				infantes++;
			}	
		}
		hot.setReservar(cord[0], cord[1], adult, infantes, titular);
		hot.checkFull(cord[0], cord[1], Integer.parseInt(fecha1[0]), Integer.parseInt(fecha1[1]), Integer.parseInt(fecha1[2]), Integer.parseInt(fecha2[0]),Integer.parseInt(fecha2[1]), Integer.parseInt(fecha2[2]));
		Archivo_salida sal = new Archivo_salida();
		sal.escribirArch_Res(salida,hot.getFecha(),hot.getFecha_in(cord[0], cord[1]),hot.getFecha_out(cord[0], cord[1]),titular,hot.getTipo(cord[0], cord[1]),hot.getDias(cord[0], cord[1]));//Ago el reporte de salida
	}//Reserva
	
	public void setCancelacion(String titular) {
		boolean fin = false;//cerrar lo ciclos antes
		Archivo_salida m=new Archivo_salida();//se escribe la cancalacion
		for(int y=0;y<hot.getMun_pisos();y++) {
			for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {//for para recorer el hotel habitacion x habitacion
				if(hot.getEstado(y,j).equals("Reservado")) {
					if(hot.getTitular(y, j).equals(titular)) {
						hot.cancelarReserva(y,j);
						int hora = c.get(Calendar.HOUR_OF_DAY);
						int minuto = c.get(Calendar.MINUTE);
						int segundo = c.get(Calendar.SECOND);
						String time = hora + ":" + minuto +":"+segundo;
						m.escribirArch_can(salida, hot.getFecha(), time, titular);
						fin=true;
						break;
					}
				}
			}
			if(fin==true) {
				break;
			}
		}
	}//cancelacion

	public void setCheck_in(String titular) {
		boolean fin =false;
		Archivo_salida m=new Archivo_salida();
		for(int y=0;y<hot.getMun_pisos();y++) {
			for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
				if(hot.getEstado(y,j).equals("Reservado")) {
					if(hot.getTitular(y, j).equals(titular)) {
						hot.estadoIn(y,j);
						int hora = c.get(Calendar.HOUR_OF_DAY);
						int minuto = c.get(Calendar.MINUTE);
						int segundo = c.get(Calendar.SECOND);
						String time = hora + ":" + minuto +":"+segundo;
						m.escribirArch_in(salida, hot.getFecha(), time, hot.getTitular(y, j),hot.numHabitacion(y,j));
						fin=true;
						break;
					}
				}
			}
			if(fin==true) {
				break;
			}
		}
	}//check_in

	public void setCheck_out(String titular) {
		boolean fin =false;
		Presupuesto pre = new Presupuesto();
		Archivo_salida m=new Archivo_salida();
		for(int y=0;y<hot.getMun_pisos();y++) {
			for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
				if(hot.getEstado(y,j).equals("Ocupada")) {
					if(hot.getTitular(y,j).equals(titular)) {
						int hora = c.get(Calendar.HOUR_OF_DAY);
						int minuto = c.get(Calendar.MINUTE);
						int segundo = c.get(Calendar.SECOND);
						String time = hora + ":" + minuto +":"+segundo;
						m.escribirArch_out(salida, hot.getFecha(), time, hot.getTitular(y, j),hot.getCuenta(y,j));
						hot.sumPresupuesto(hot.getCuenta(y, j));
						pre.setIngreso(contabilidad, "CHECK-OUT", hot.getCuenta(y, j),hot.getSaldo() , hot.getFecha());
						fin=true;
						hot.setReinicio(y,j);
						break;
					}
				}
			}
			if(fin==true) {
				break;
			}
		}
	}//Check_out

	public void setServicio(String titular ,String servicios) {
		Presupuesto pre = new Presupuesto();
		String[] serv = servicios.split(" ");
		int[] cord = new int[2];
		for(int y=0;y<hot.getMun_pisos();y++) {
			for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
				if(hot.getEstado(y, j).equals("Ocupada")) {
					if(hot.getTitular(y, j).equals(titular)) {
						cord[0] = y;
						cord[1] = j;
						break;
					}
				}
			}
		}
		int cantidad_serv = serv.length;
		double precio_s=0.0;
		for(int y=0; y<cantidad_serv;y++) {
			precio_s =(precio.getPrecio_serv(serv[0])) * Integer.parseInt(serv[1]);
			hot.sumPresupuesto(precio_s);
			pre.setIngreso(contabilidad, precio.getNombre_serv(serv[0]), precio_s, hot.getSaldo(), hot.getFecha());
		}
	}
	
	public void setMenu(String titular,String menu) {
		Presupuesto pre=new Presupuesto();
		String[] menus = menu.split("\n");
		int cantd_platos = menus.length;
		for(int z=0;z<cantd_platos;z++) {
			String plato = menus[z];
			hot.sumPresupuesto(precio.getPrecio_menu(plato));
			pre.setIngreso(contabilidad,precio.getNombre_menu(plato), precio.getPrecio_menu(plato), hot.getSaldo(), hot.getFecha());
		}
	}
	
	public ArrayList<String> getFormatoMenu(){
		return precio.getFormato_menu();
	}
}