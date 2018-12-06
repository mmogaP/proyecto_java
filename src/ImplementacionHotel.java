
public class ImplementacionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo_Leer texto_ini = new Archivo_Leer();
		Hotel hot = new Hotel();
		texto_ini.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\inicializar.txt");
		hot.setPresupuesto(Double.parseDouble(texto_ini.getLinea(0)));
		String aux=texto_ini.getLinea(1);
		String[] fecha_ = aux.split(" ");
		hot.setDd(Integer.parseInt(fecha_[0]));
		hot.setMm(Integer.parseInt(fecha_[1]));
		hot.setAa(Integer.parseInt(fecha_[2]));
		aux=texto_ini.getLinea(2);
		String[] piso = aux.split(" ");
		hot.setNum_habi(Integer.parseInt(piso[0]));
		hot.setMun_pisos(Integer.parseInt(piso[1]));
		for(int i=0;i<(hot.getMun_pisos());i++) {
			aux=texto_ini.getLinea(i+3);
			String[] hab = aux.split(" ");
			hot.setPiso(i+1);
			for (int z=1;z<=Integer.parseInt(hab[0]);z++) {
				hot.setHabitacion(hab[z],i+1,z);
			}
		}
		/////////////////////////////////////Precios
		Archivo_Leer texto_pre = new Archivo_Leer();
		Precio precio = new Precio();
		texto_pre.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\precios.txt");
		String parametros = texto_pre.getLinea(0);
		String[] parametros2 = parametros.split(" ");
		int num_hab = Integer.parseInt(parametros2[0]);
		for(int i=0;i<num_hab;i++) {
			String[] aux2 = (texto_pre.getLinea(i+1)).split(" ");
			precio.setHabitacion(aux2[0], Double.parseDouble(aux2[1]));
		}
		int num_serv=Integer.parseInt(parametros2[1]);
		for(int i=0;i<num_serv;i++) {
			String[] aux2 = (texto_pre.getLinea(i+num_hab+1)).split(" ");
			String aux_nombre = "";
			for(int z=2;z<aux2.length;z++) {
				aux_nombre = aux2[z]+" ";
			}
			precio.setServicio(aux2[0],Double.parseDouble(aux2[1]), aux_nombre);
		}
		int num_menu=Integer.parseInt(parametros2[2]);
		for(int i=0;i<num_menu;i++) {
			String[] aux2=(texto_pre.getLinea(i+num_serv+num_hab+1)).split(" ");
			String aux_nombre="";
			for(int z = 0;z<aux2.length;z++) {
				aux_nombre = aux2[z]+" ";
			}
			precio.setMenu(aux2[0], Double.parseDouble(aux2[1]), aux_nombre);
		}
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		Archivo_Leer op = new Archivo_Leer();
		op.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\operaciones.txt");
		for(int i = 0;i<op.getTamaño();i++) {
			if((op.getLinea(i)).equals("0")) {
				hot.agregarDia();
			}
			else if(op.getLinea(i).equals("1")) {
				String linea = op.getLinea(i+1);
				String[] check=linea.split(" ");
				linea = op.getLinea(i+2);
				int[] habitacion_libre=new int[2];
				boolean fin=false;
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y, j).equals("Libre")&&(hot.getTipo(y, j).equals(linea))) {
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
				hot.checkFull(habitacion_libre[0], habitacion_libre[1], Integer.parseInt(check[0]), Integer.parseInt(check[1]), Integer.parseInt(check[2]), Integer.parseInt(check[3]), Integer.parseInt(check[4]), Integer.parseInt(check[5]));
				hot.setCuenta(habitacion_libre[0], habitacion_libre[1], precio.getPrecio_hab(linea));
				String titular="";
				int adult=0;
				int infantes=0;
				for(int y = 0;y<Integer.parseInt(op.getLinea(i+3));y++) {
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
				Archivo_salida m = new Archivo_salida();
				m.escribirArch_Res("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt",hot.getFecha(),hot.getFecha_in(habitacion_libre[0], habitacion_libre[1]),hot.getFecha_out(habitacion_libre[0], habitacion_libre[1]),titular,hot.getTipo(habitacion_libre[0], habitacion_libre[1]),hot.getDias(habitacion_libre[0], habitacion_libre[1]));
			}
			else if(op.getLinea(i).equals("2")) {
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
			else if(op.getLinea(i).equals("3")) {
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
			else if(op.getLinea(i).equals("4")) {
				String[] linea = op.getLinea(i+1).split(" ");
				boolean fin =false;
				Archivo_salida m=new Archivo_salida();
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y,j).equals("Ocupada")) {
							if(hot.getTitular(y,j).equals(linea[0])) {
								m.escribirArch_out("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt", hot.getFecha(), linea[1], hot.getTitular(y, j),hot.getCuenta(y,j));
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
			else if(op.getLinea(i).equals("6")) {
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
					precio_s = precio_s + (precio.getPrecio_serv(serv[0])) * Integer.parseInt(serv[1]);
				}
				if(op.getLinea(i+3+cantidad_serv).equals("5")) {
					int cantd_platos = Integer.parseInt(op.getLinea(i+3+cantidad_serv));
					double precio_m=0.0;
					for(int z=0;z<cantd_platos;z++) {
						String plato = op.getLinea(z+i+4+cantidad_serv);
						precio_m = precio_m + precio.getPrecio_menu(plato); 
					}
					double cuenta_f = precio_m + precio_s;
					hot.setCuenta(habitacion_libre[0], habitacion_libre[1], cuenta_f);
					i=i+3+cantidad_serv+cantd_platos;
				}
				
			}
			
			else if(op.getLinea(i).equals("7")) {
				String report = op.getLinea(i+1);
				int reporte = Integer.parseInt(report);
				for(int y=0;y<reporte;y++) {
					
				}
			}			
		}				
	}
}

