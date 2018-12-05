import java.io.*;

public class Archivo_salida {
		
		public void escribirArch(String nombre) {
			File f;
			FileWriter w;
			BufferedWriter bw;
			PrintWriter wr;
			Hotel ho = new Hotel();
			
			try {
				
				f = new File(nombre);
				w = new FileWriter(f);
				bw = new BufferedWriter(w);
				wr = new PrintWriter(bw);
				
				wr.write("Reservacion--"+ho.dd+"/"+ho.mm+"/"+ho.aa);//primera linea,  para  agregar variables
				wr.append(" ");//segunda linea
				wr.append(""); //tercera linea
				
				wr.close();
				bw.close();
				
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}	
		
		}	
	}
