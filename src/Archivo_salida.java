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
				wr.println("RESERVACIÓN--"+"("+fecha+")");
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
				wr.println("RESERVACIÓN--"+"("+fecha+")");
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
				wr.println("CANCELACIÓN--"+"("+fecha+" "+hora+")");
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
				wr.println("CANCELACIÓN--"+"("+fecha+" "+hora+")");
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
	public void escribirArch_out(String nombre,String fecha,String hora,String titular,double cuenta) {
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
	public void escribir_Archc(String nombre,String fecha1,String fecha2,int cant) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("Del "+fecha1+" al "+fecha2+" "+cant+"			"+"Reservaciones canceladas");
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
				wr.println("Del "+fecha1+" al "+fecha2+" "+cant+"			"+"Reservaciones canceladas");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribir_Arche(String nombre,String fecha1,String fecha2,int cant) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("Del "+fecha1+" al "+fecha2+" "+cant+"			"+"Reservaciones efectivas");
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
				wr.println("Del "+fecha1+" al "+fecha2+" "+cant+"			"+"Reservaciones efectivas");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribir_Archo(String nombre,String fecha1,int cant) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones ocupadas");
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
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones ocupadas");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribir_Archr(String nombre,String fecha1,int cant) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones recervadas");
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
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones reservadas");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void escribir_Archl(String nombre,String fecha1,int cant) {
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones libres");
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
				wr.println("Al  "+fecha1+"                  "+cant+"			"+"Reservaciones libres");
				wr.close();		
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
}
