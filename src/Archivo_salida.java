import java.io.*;
public class Archivo_salida {
	public void escribirArch_Res(String nombre,String fecha,String check_in,String check_up,String titular,String tipo,int dias) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("RESERVACION--"+"("+fecha+")");
				wr.println(" Titular: "+titular);
				wr.println(" Habitacion "+tipo+" del "+check_in+" al "+check_up+" ("+dias+")");
				wr.close();				
				w.close();
		
			}
			catch(IOException e) {
			System.out.println("no se ha podido crear el archivo"+ e);
			}	
		}else {
			try {
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("RESERVACION--"+"("+fecha+")");
				wr.println(" Titular: "+titular);
				wr.println(" Habitacion "+tipo+" del "+check_in+" al "+check_up+" ("+dias+")");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribirArch_can(String nombre,String fecha,String hora,String titular) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("RESERVACION--"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.close();				
				w.close();
		
			}
			catch(IOException e) {
			System.out.println("no se ha podido crear el archivo"+ e);
			}	
		}else {
			try {
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("RESERVACION--"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribirArch_in(String nombre,String fecha,String hora,String titular,String habitacion) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("CHECK_IN-----"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.println(" Habitacion: "+habitacion);
				wr.close();				
				w.close();
		
			}
			catch(IOException e) {
			System.out.println("no se ha podido crear el archivo"+ e);
			}	
		}else {
			try {
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("CHECK_IN-----"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.println(" Habitacion: "+habitacion);
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribirArch_out(String nombre,String fecha,String hora,String titular,int cuenta) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("CHECK_OUT-----"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.println(" Cancelo: "+cuenta);
				wr.close();				
				w.close();
		
			}
			catch(IOException e) {
			System.out.println("no se ha podido crear el archivo"+ e);
			}	
		}else {
			try {
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("CHECK_OUT-----"+"("+fecha+" "+hora+")");
				wr.println(" Titular: "+titular);
				wr.println(" Cancelo: "+cuenta);
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
}
