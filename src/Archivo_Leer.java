import java.io.*;
import java.util.ArrayList;
public class Archivo_Leer {
	ArrayList<String> text = new ArrayList<String>();
public void leerArchivo(String direccion) {
	try {
		BufferedReader bf = new BufferedReader(new FileReader(direccion));
		String linea;
		while((linea = bf.readLine()) != null) {
			text.add(linea);
		}
		bf.close();
	}catch(Exception e) {
		System.out.println("No se encuentra el archivo");
	}
}
public String getLinea(int num) {
	return text.get(num);
}
public int getTamaño() {
	return text.size();
}
}
