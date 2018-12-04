
public class Precio {
	double precioind;
	double preciodob;
	double preciomat;
	double preciocua;
	double preciosui;
	
	
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
}
