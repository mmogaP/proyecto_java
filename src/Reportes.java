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
		System.out.println(cant);
		return cant;
	}
	
}