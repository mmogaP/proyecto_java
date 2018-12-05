import java.util.ArrayList;
public class Precio {
	double precioind;
	double preciodob;
	double preciomat;
	double preciocua;
	double preciosui;
	ArrayList<String> formato_serv = new ArrayList<String>();
	ArrayList<Double> precio_serv=new ArrayList<Double>();
	ArrayList<String> nombre_serv=new ArrayList<String>();
	ArrayList<String> formato_menu = new ArrayList<String>();
	ArrayList<Double> precio_menu=new ArrayList<Double>();
	ArrayList<String> nombre_menu=new ArrayList<String>();

	
	//////////////////////////
	public void setHabitacion(String tipo,double precio) {
		if (tipo.equals("INDIV")) {
			this.precioind=precio;
		}
		else if(tipo.equals("DOUBLE")){
			this.preciodob=precio;
		}
		else if(tipo.equals("MATRI")) {
			this.preciomat=precio;
		}
		else if(tipo.equals("CUADR")) {
			this.preciocua=precio;
		}
		else if(tipo.equals("SUITE")) {
			this.preciosui=precio;
		}
	}
	public void setServicio(String formato,double precio,String nombre) {
		formato_serv.add(formato);
		precio_serv.add(precio);
		nombre_serv.add(nombre);
	}
	public void setMenu(String formato,double precio,String nombre) {
		formato_menu.add(formato);
		precio_menu.add(precio);
		nombre_menu.add(nombre);
	}
}