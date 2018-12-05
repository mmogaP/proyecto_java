import java.io.*;

public class Archivo_salida {
	
	public static void main(String[] args) {
		File archivo1;
		try {
			
			archivo1 = new File("D:\\proyecto_java\\txt\\reservaciones.txt");
			if(archivo1.createNewFile()) {
				System.out.println("Se ha creado el archivo");
				
			}
		}catch(IOException e) {
			System.out.println("no se ha podido crear el archivo"+ e);
		}
	}
}
