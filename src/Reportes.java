import java.io.BufferedReader;
import java.io.FileReader;

public class Reportes {
	public void conprobar_Canceladas(String direccion,String fecha) {
		int dd,mm,aa;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String linea;
			String[] lineas;
			while((linea = bf.readLine()) != null) {
				lineas = linea.split("(");
				if(lineas[0].equals("CANCELACIÓN--") ) {
					lineas=lineas[1].split(" ");
					lineas=lineas[0].split("/");
					dd=Integer.parseInt(lineas[0]);
					mm=Integer.parseInt(lineas[2]);
					aa=Integer.parseInt(lineas[3]);
					if()
				}
			}
			bf.close();
		}catch(Exception e) {
			System.out.println("Wea mala");
		}
	}
}