package Archivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Presupuesto {
	public void setIngreso(String nombre,String motivo, double valor, double saldo, String fecha) {
		String num = valor+"";
		String num1 = saldo+"";
		int tam = num.length();
		int tam1 = num1.length();
		if(tam == 3) {
			num="            "+num;
		}
		else if(tam==4) {
			num="           "+num;
		}
		else if(tam==5) {
			num="          "+num;
		}
		else if(tam==6) {
			num="         "+num;
		}
		else if(tam==7) {
			num="        "+num;
		}
		else if(tam==8) {
			num="       "+num;
		}
		else if(tam==9) {
			num="      "+num;
		}
		if(tam1 == 3) {
			num1="            "+num1;
		}
		else if(tam1==4) {
			num1="           "+num1;
		}
		else if(tam1==5) {
			num1="          "+num1;
		}
		else if(tam1==6) {
			num1="         "+num1;
		}
		else if(tam1==7) {
			num1="        "+num1;
		}
		else if(tam1==8) {
			num1="       "+num1;
		}
		else if(tam1==9) {
			num1="      "+num1;
		}
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("FECHA     |DEBE           |HABER          |SALDO          |CONCEPTO");
				wr.println(fecha+" |"+num+"|"+"               |"+num1+"|"+motivo);
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
				wr.println(fecha+" |"+num+"|"+"               |"+num1+"|"+motivo);
				wr.close();
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
	public void setEgreso(String nombre,String motivo, Double valor, double saldo, String fecha) {
		String num = valor+"";
		String num1 = saldo+"";
		int tam = num.length();
		int tam1 = num1.length();
		if(tam == 3) {
			num="            "+num;
		}
		else if(tam==4) {
			num="           "+num;
		}
		else if(tam==5) {
			num="          "+num;
		}
		else if(tam==6) {
			num="         "+num;
		}
		else if(tam==7) {
			num="        "+num;
		}
		else if(tam==8) {
			num="       "+num;
		}
		else if(tam==9) {
			num="      "+num;
		}
		if(tam1 == 3) {
			num1="            "+num1;
		}
		else if(tam1==4) {
			num1="           "+num1;
		}
		else if(tam1==5) {
			num1="          "+num1;
		}
		else if(tam1==6) {
			num1="         "+num1;
		}
		else if(tam1==7) {
			num1="        "+num1;
		}
		else if(tam1==8) {
			num1="       "+num1;
		}
		else if(tam1==9) {
			num1="      "+num1;
		}
		File f;
		FileWriter w;
		PrintWriter wr;
		f = new File(nombre);
		if(!f.exists()) {
			try {
				f.createNewFile();
				w = new FileWriter(f,true);
				wr = new PrintWriter(w);
				wr.println("FECHA        |DEBE           |HABER           |SALDO          |CONCEPTO");
				wr.println(fecha+" |"+"              |"+num+"|"+num1+"|  "+motivo);
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
				wr.println(fecha+" |"+"               |"+num+"|"+num1+"|"+motivo);
				wr.close();
				w.close();
			}
			catch(IOException e) {
				System.out.println("no se ha podido crear el archivo"+ e);
			}
		}
	}
}
