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
		else if(tipo.equals("DOBLE")){
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
	public double getPrecio_hab(String tipo) {
		if (tipo.equals("INDIV")) {
			return precioind;
		}
		else if(tipo.equals("DOBLE")){
			return preciodob;
		}
		else if(tipo.equals("MATRI")) {
			return preciomat;
		}
		else if(tipo.equals("CUADR")) {
			return preciocua;
		}
		else if(tipo.equals("SUITE")) {
			return preciosui;
		}
		return 0.0;
	}
	public Double getPrecio_menu(String plato) {
		for(int i=0;i<formato_menu.size();i++) {
			if(formato_menu.get(i).equals(plato)) {
				return precio_menu.get(i);
			}
		}
		return 0.0;
	}
	public Double getPrecio_serv(String serv) {
		for(int i=0;i<formato_serv.size();i++) {
			if(formato_serv.get(i).equals(serv)) {
				return precio_serv.get(i);
			}
		}
		return 0.0;
	}	
	public String getNombre_serv(String tipo) {
		for(int i = 0;i<formato_serv.size();i++) {
			if(formato_serv.get(i).equals(tipo)) {
				return nombre_serv.get(i);
			}
		}
		return "";
	}
	public String getNombre_menu(String tipo) {
		for(int i = 0;i<formato_menu.size();i++) {
			if(formato_menu.get(i).equals(tipo)) {
				return nombre_menu.get(i);
			}
		}
		return "";
	}
}
