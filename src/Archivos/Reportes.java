package Archivos;
import java.io.BufferedReader;
import java.io.FileReader;

public class Reportes {
	public int conprobar_Canceladas(String direccion,String fecha_1,String fecha_2) {
		int dd,mm,aa;
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			String c="(";
			while((linea = bf.readLine()) != null) {
				lineas = linea.split(c);
				if(lineas[0].equals("CANCELACIÓN--") ) {
					lineas=lineas[1].split(" ");
					lineas=lineas[0].split("/");
					aa=Integer.parseInt(lineas[3]);
					if(aa>=(Integer.parseInt(fecha1[2])) && aa<=(Integer.parseInt(fecha2[2]))) {
						mm = Integer.parseInt(lineas[2]);
						if(mm>=(Integer.parseInt(fecha1[1]))&& mm<=(Integer.parseInt(fecha2[1]))) {
							dd=Integer.parseInt(lineas[1]);
							if(dd>=(Integer.parseInt(fecha1[0]))&&dd<=(Integer.parseInt(fecha1[0]))) {
								cant++;
							}
						}
					}
				}
			}
			bf.close();
		}catch(Exception e) {
			System.out.println("error "+e);
		}
		return cant;
	}
	public int conprobar_Efectivas(String direccion,String fecha_1,String fecha_2) {
		int dd,mm,aa;
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			String c = "\\(";
			while((linea = bf.readLine()) != null){
				lineas = linea.split(c);
				if(lineas[0].equals("RESERVACIÓN--") ) {
					lineas=lineas[1].split("/");
					String l=lineas[2].replace(")", "");
					aa=Integer.parseInt(l);
					if(aa>=(Integer.parseInt(fecha1[2])) && aa<=(Integer.parseInt(fecha2[2]))) {
						mm = Integer.parseInt(lineas[1]);
						if(mm>=(Integer.parseInt(fecha1[1]))&& mm<=(Integer.parseInt(fecha2[1]))) {
							dd=Integer.parseInt(lineas[0]);
							if(dd>=(Integer.parseInt(fecha1[0]))&&dd<=(Integer.parseInt(fecha2[0]))) {
								cant++;
							}
						}
					}
				}
			}
			bf.close();
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return cant;
	}
	public double ingresos_Cama(String direccion,String fecha_1,String fecha_2) {
		int dd,mm,aa;
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			String[] fech;
			String c = "\\|";
			while((linea = bf.readLine()) != null){
				lineas = linea.split(c);
				if(lineas[4].equals("Cama Adicional ") ) {
					fech=lineas[0].split("/");
					String l=fech[2].replace(" ", "");
					aa=Integer.parseInt(l);
					if(aa>=(Integer.parseInt(fecha1[2])) && aa<=(Integer.parseInt(fecha2[2]))) {
						mm = Integer.parseInt(fech[1]);
						if(mm>=(Integer.parseInt(fecha1[1]))&& mm<=(Integer.parseInt(fecha2[1]))) {
							dd=Integer.parseInt(fech[0]);
							if(dd>=(Integer.parseInt(fecha1[0]))&&dd<=(Integer.parseInt(fecha2[0]))) {
								cant+=Double.parseDouble(lineas[1]);
							}
						}
					}
				}
			}
			bf.close();
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return cant;
	}
	public double ingresos_Caja(String direccion,String fecha_1,String fecha_2) {
		int dd,mm,aa;
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			String[] fech;
			String c = "\\|";
			while((linea = bf.readLine()) != null){
				lineas = linea.split(c);
				if(lineas[4].equals("Caja Fuerte ") ) {
					fech=lineas[0].split("/");
					String l=fech[2].replace(" ", "");
					aa=Integer.parseInt(l);
					if(aa>=(Integer.parseInt(fecha1[2])) && aa<=(Integer.parseInt(fecha2[2]))) {
						mm = Integer.parseInt(fech[1]);
						if(mm>=(Integer.parseInt(fecha1[1]))&& mm<=(Integer.parseInt(fecha2[1]))) {
							dd=Integer.parseInt(fech[0]);
							if(dd>=(Integer.parseInt(fecha1[0]))&&dd<=(Integer.parseInt(fecha2[0]))) {
								cant+=Double.parseDouble(lineas[1]);
							}
						}
					}
				}
			}
			bf.close();
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return cant;
	}
	public int cant_Acciones(String direccion,String fecha_1,String fecha_2) {
		int dd,mm,aa;
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			String c = "\\|";
			while((linea = bf.readLine()) != null){
				lineas = linea.split(c);
				lineas=lineas[0].split("/");
				if(lineas[0].equals("FECHA     ")!=true) {
				String l=lineas[2].replace(" ", "");
				aa=Integer.parseInt(l);
				if(aa>=(Integer.parseInt(fecha1[2])) && aa<=(Integer.parseInt(fecha2[2]))) {
					mm = Integer.parseInt(lineas[1]);
					if(mm>=(Integer.parseInt(fecha1[1]))&& mm<=(Integer.parseInt(fecha2[1]))) {
						dd=Integer.parseInt(lineas[0]);
						if(dd>=(Integer.parseInt(fecha1[0]))&&dd<=(Integer.parseInt(fecha2[0]))) {
							cant++;
						}
					}
				}
				}
			}
		bf.close();
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return cant;
	}
	public String cantDias(String fecha_1, String fecha_2,int habitaciones){
		int cant,porsentaje;
		String texto = "";
		String[] fecha1 = fecha_1.split("/");
		String[] fecha2 = fecha_2.split("/");
		int dias = Integer.parseInt(fecha2[0])-Integer.parseInt(fecha1[0]);
		for (int i=0;i<dias;i++) {
			cant = this.checkP(i+Integer.parseInt(fecha1[0]));
			porsentaje= (cant * 100)/habitaciones; 
			texto += porsentaje + "% ";
		}
		return texto;
	}
	public int checkP(int dia) {
		int cant = 0;
		try {
			BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\salida.txt"));
			String linea;
			String[] fecha;
			String[] lineas;
			String c = "\\(";
			while((linea = bf.readLine()) != null){
				lineas = linea.split(c);
					if(lineas[0].equals("CHECK_IN-----")) {
						String aux = lineas[1];
						fecha = aux.split("/");
						if(dia>=Integer.parseInt(fecha[0])) {
							cant++;
						}
					}
					else if(lineas[0].equals("CHECK_OUT----")) {
						String aux = lineas[1];
						fecha = aux.split("/");
						if(dia>=Integer.parseInt(fecha[0])) {
							cant--;
						}
					}
					else if(lineas[0].equals("CANCELACIÓN--")) {
						String aux = lineas[1];
						fecha = aux.split("/");
						if(dia>=Integer.parseInt(fecha[0])) {
							System.out.println("ok");
							cant--;
						}
					}
			}
		bf.close();
		}catch(Exception e) {
			System.out.println("Error aqui "+e);
		}
		return cant;
	}
}