
public class Habitacion {
int camas_ind;
int camas_mat;
String estado;
int numero_hab;
String tipo_de_habitacion;
boolean baño;
boolean aire;
boolean telefono;
boolean caja_fuerte;
boolean tv;
///////////////////////////////////////
public Habitacion(String tip) {
	if (tip.equals("INDIV")) {
		this.camas_ind = 1;
		this.tipo_de_habitacion = "INDV";
	}
	else if(tip.equals("DOBLE")) {
		this.camas_ind = 2;
		this.tipo_de_habitacion = "DOBLE";
	}
	else if(tip.equals("MATRI")) {
		this.camas_mat = 1;
		this.tipo_de_habitacion = "MATRI";
	}
	else if(tip.equals("CUADR")) {
		this.camas_ind = 4;
		this.tipo_de_habitacion = "CUADR";
	}
	else if(tip.equals("SUITE")) {
		this.camas_mat = 2;
		this.camas_ind = 5;
		this.tipo_de_habitacion = "SUITE";
	}
}
 public void recervarHab() {
	 this.estado = "Reservado";
 }
 public void agregarCama() {
	 this.camas_ind += 1;
 }
public String getEstado() {
	return estado;
}
public String getTipo() {
	return tipo_de_habitacion;
}
public int getCamas_ind() {
	return camas_ind;
}
public int getCamas_mat() {
	return camas_mat;
}
}
