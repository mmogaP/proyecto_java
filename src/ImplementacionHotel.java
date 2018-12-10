
public class ImplementacionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo_Leer texto_ini = new Archivo_Leer();//creo un nuevo objeto para leer el archivo inicial
		Hotel hot = new Hotel();//creo el objeto hotel para llenar variables de hotel
		Presupuesto pre = new Presupuesto();
		texto_ini.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\inicializar.txt");//se le da el primer archivo que contiene la info del hotel
		hot.setPresupuesto(Double.parseDouble(texto_ini.getLinea(0)));//desde el archivo inicilaizar le paso la variable presupuesto al hotel		
		String aux=texto_ini.getLinea(1);//le doy la linea donde va la fecha
		String[] fecha_ = aux.split(" ");//separa la fecha por los espacios
		hot.setDd(Integer.parseInt(fecha_[0]));//dia
		hot.setMm(Integer.parseInt(fecha_[1]));//mes
		hot.setAa(Integer.parseInt(fecha_[2]));//año
		pre.setIngreso("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\contabilidad.txt", "Saldo Inicial", Double.parseDouble(texto_ini.getLinea(0)), hot.getSaldo(), hot.getFecha());
		aux=texto_ini.getLinea(2);//ahora aux pasa a ser la linea de cantidad de pisos
		String[] piso = aux.split(" ");//se creo con una lista como pueden ser 1 o mas pisos
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
		/////////////////////////////////////Precios
		Archivo_Leer texto_pre = new Archivo_Leer();//creo un nuevo objeto para leer el archivo de los precios
		Precio precio = new Precio();
		texto_pre.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\precios.txt");//aca se le da la direccion
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
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		Archivo_Leer op = new Archivo_Leer();//ahora la ultima parte lee lo que sucede en el hotel
		op.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\operaciones.txt");
		for(int i = 0;i<op.getTamaño();i++) {//se recorre segun el tamaño del texto que puede ir variando
			if(hot.getDd()==15) {
				hot.gastoM();
				pre.setEgreso("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\contabilidad.txt", "Nómina", 25000.00, hot.getSaldo(), hot.getFecha());
			}
			if((op.getLinea(i)).equals("0")) {//si es 0 avanza el dia 
				hot.agregarDia();
			}
			else if(op.getLinea(i).equals("1")) {//al tomar un uno hace la reservación de la persona
				String linea = op.getLinea(i+1);
				String[] check=linea.split(" ");
				linea = op.getLinea(i+2);
				int[] habitacion_libre=new int[2];
				boolean fin=false;
				for(int y=0;y<hot.getMun_pisos();y++) {//primero revisa disponibilidad
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y, j).equals("Libre")&&(hot.getTipo(y, j).equals(linea))) {//si encuentra una habitacion libre se le asigna y listo
							habitacion_libre[0]= y;
							habitacion_libre[1]= j;
							fin=true;
							break;
						}
					}
					if(fin==true) {
						break;
					}
				}
				int dias=Integer.parseInt(check[3])-Integer.parseInt(check[0]);
				hot.checkFull(habitacion_libre[0], habitacion_libre[1], Integer.parseInt(check[0]), Integer.parseInt(check[1]), Integer.parseInt(check[2]), Integer.parseInt(check[3]), Integer.parseInt(check[4]), Integer.parseInt(check[5]));
				hot.setCuenta(habitacion_libre[0], habitacion_libre[1], (precio.getPrecio_hab(linea))*dias);
				String titular="";
				int adult=0;
				int infantes=0;
				for(int y = 0;y<Integer.parseInt(op.getLinea(i+3));y++) {//ahora agrego quienes se van ospedar, quien es el titular y si tiene niños
					linea=op.getLinea(y+i+4);
					String[] separacion = linea.split(" ");
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
				hot.getEstado(habitacion_libre[0], habitacion_libre[1]);
				hot.getReservar(habitacion_libre[0], habitacion_libre[1], adult, infantes, titular);
				i=i+3+Integer.parseInt(op.getLinea(i+3));
				Archivo_salida m = new Archivo_salida();//una vez hecho esto creo el archivo de salida donde muestro todos los datos, la reservacion, el check-in y el check-out y si cancelo. 
				m.escribirArch_Res("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt",hot.getFecha(),hot.getFecha_in(habitacion_libre[0], habitacion_libre[1]),hot.getFecha_out(habitacion_libre[0], habitacion_libre[1]),titular,hot.getTipo(habitacion_libre[0], habitacion_libre[1]),hot.getDias(habitacion_libre[0], habitacion_libre[1]));
			}
			else if(op.getLinea(i).equals("2")) {//cuando entra al 2 cancela una reservacion
				String[] linea = op.getLinea(i+1).split(" ");
				boolean fin = false;
				Archivo_salida m=new Archivo_salida();
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y,j).equals("Reservado")) {
							if(hot.getTitular(y, j).equals(linea[0])) {
							hot.cancelarReserva(y,j);
							m.escribirArch_can("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", hot.getFecha(), linea[1], hot.getTitular(y, j));
							fin=true;
							break;
							}
						}
					}
					if(fin==true) {
						break;
					}
				}
				i=i+2;	
			}
			else if(op.getLinea(i).equals("3")) {//se realiza el check-in 
				String[] linea = op.getLinea(i+1).split(" ");
				boolean fin =false;
				Archivo_salida m=new Archivo_salida();
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y,j).equals("Reservado")) {
							if(hot.getTitular(y, j).equals(linea[0])) {
								hot.estadoIn(y,j);
								m.escribirArch_in("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", hot.getFecha(), linea[1], hot.getTitular(y, j),hot.numHabitacion(y,j));
								fin=true;
								break;
							}
						}
					}
					if(fin==true) {
						break;
					}
				}
				i=i+1;
			}
			else if(op.getLinea(i).equals("4")) {//Realiza el check-out
				String[] linea = op.getLinea(i+1).split(" ");
				boolean fin =false;
				Archivo_salida m=new Archivo_salida();
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y,j).equals("Ocupada")) {
							if(hot.getTitular(y,j).equals(linea[0])) {
								m.escribirArch_out("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", hot.getFecha(), linea[1], hot.getTitular(y, j),hot.getCuenta(y,j));
								hot.sumPresupuesto(hot.getCuenta(y, j));
								pre.setIngreso("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\contabilidad.txt", "CHECK-OUT", hot.getCuenta(y, j),hot.getSaldo() , hot.getFecha());
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
				i=i+2;
			}
			else if(op.getLinea(i).equals("6")) {//solicita los servicios dentro de este esta el 5 que es el servicio restaurant
				int[] habitacion_libre=new int[2];
				String titular = op.getLinea(i+1);
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y, j).equals("Ocupada")) {
							if(hot.getTitular(y, j).equals(titular)) {
								habitacion_libre[0] = y;
								habitacion_libre[1] = j;
								break;
							}
						}
					}
				}
				int cantidad_serv = Integer.parseInt(op.getLinea(i+2));
				double precio_s=0.0;
				for(int y=0; y<cantidad_serv;y++) {
					String[] serv = op.getLinea(y+i+3).split(" ");
					precio_s =(precio.getPrecio_serv(serv[0])) * Integer.parseInt(serv[1]);
					hot.sumPresupuesto(precio_s);
					pre.setIngreso("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\contabilidad.txt", precio.getNombre_serv(serv[0]), precio_s, hot.getSaldo(), hot.getFecha());
				}
				if(op.getLinea(i+3+cantidad_serv).equals("5")) {
					int cantd_platos = Integer.parseInt(op.getLinea(i+4+cantidad_serv));
					for(int z=0;z<cantd_platos;z++) {
						String plato = op.getLinea(z+i+5+cantidad_serv);
						hot.sumPresupuesto(precio.getPrecio_menu(plato));
						pre.setIngreso("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\contabilidad.txt",precio.getNombre_menu(plato), precio.getPrecio_menu(plato), hot.getSaldo(), hot.getFecha());
					}
					i=i+3+cantidad_serv+cantd_platos;
				}
				
			}
			
			else if(op.getLinea(i).equals("7")) {//por ultimo devuelve los reportes y se le pide cuantos quiere hacer
				Archivo_salida salida = new Archivo_salida();
				int reporte = Integer.parseInt(op.getLinea(i+1));
				for(int y=0;y<reporte;y++) {
					String[] reportes_i = op.getLinea(i+2).split(" ");
					Reportes rep = new Reportes();
					if(reportes_i[0].equals("a")) {
						String fecha1=reportes_i[1]+"/"+reportes_i[2]+"/"+reportes_i[3];
						String fecha2=reportes_i[4]+"/"+reportes_i[5]+"/"+reportes_i[6];
						int cant = rep.conprobar_Canceladas("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", fecha1, fecha2);
						salida.escribir_Archc("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\reportes.txt", fecha1, fecha2, cant);
					}
					else if (reportes_i[0].equals("b")) {
						String fecha1=reportes_i[1]+"/"+reportes_i[2]+"/"+reportes_i[3];
						String fecha2=reportes_i[4]+"/"+reportes_i[5]+"/"+reportes_i[6];
						int cant = rep.conprobar_Efectivas("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", fecha1, fecha2);
						salida.escribir_Arche("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\reportes.txt", fecha1, fecha2, cant);	
					}
					else if (reportes_i[0].equals("c")) {
						
					}
					else if (reportes_i[0].equals("d")) {
						
					}
					else if (reportes_i[0].equals("e")) {
						
					}
					else if (reportes_i[0].equals("f")) {
						
					}
					else if (reportes_i[0].equals("g")) {
						
					}
					else if (reportes_i[0].equals("h")) {
						
					}
					else if (reportes_i[0].equals("i")) {
						
					}
					else if (reportes_i[0].equals("j")) {
						int cant=0;
						for(int z=0;z<hot.getMun_pisos();z++) {
							for(int j=0;j<hot.getNum_habitaciones_x_piso(z);j++) {
								if(hot.getEstado(z, j).equals("Ocupada")) {
									cant++;
								}
							}
						}
						salida.escribir_Archo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\reportes.txt", hot.getFecha(), cant);
					}
					else if (reportes_i[0].equals("k")) {
						int cant=0;
						for(int z=0;z<hot.getMun_pisos();z++) {
							for(int j=0;j<hot.getNum_habitaciones_x_piso(z);j++) {
								if(hot.getEstado(z, j).equals("Reservado")) {
									cant++;
								}
							}
						}
						salida.escribir_Archr("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\reportes.txt", hot.getFecha(), cant);
					}
					else if (reportes_i[0].equals("l")) {
						int cant=0;
						for(int z=0;z<hot.getMun_pisos();z++) {
							for(int j=0;j<hot.getNum_habitaciones_x_piso(z);j++) {
								if(hot.getEstado(z, j).equals("Libre")) {
									cant++;
								}
							}
						}
						salida.escribir_Archl("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\reportes.txt", hot.getFecha(), cant);
					}
				}
				i=i+reporte+2;
			}			
		}				
	}
}

