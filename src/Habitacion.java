
public class Habitacion {
int camas_ind;
int camas_mat;
String estado;
String numero_hab;
String tipo_de_habitacion;
boolean baño;
boolean aire;
boolean telefono;
boolean caja_fuerte;
boolean tv;
int num_personas;
int cant_ad;
int cant_infantes;
String titular;
double cuenta;
String check_in;
String check_out;
///////////////////////////////////////
public Habitacion(String tip,String hab) {
	this.numero_hab=hab;
	estado="Libre";
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
public void checkFull(int dd1,int mm1,int aa1,int dd2,int mm2,int aa2) {
	check_in=dd1+"/"+mm1+"/"+aa1;
	check_out=dd2+"/"+mm2+"/"+aa2;
}
 public void recervarHab(int adul,int infantes,String titular) {
	 this.estado = "Reservado";
	 this.cant_ad=adul;
	 this.cant_infantes=infantes;
	 this.titular=titular;

}
 public void cancelarReserva() {
	 this.estado="Libre";
	 this.cant_ad=0;
	 this.cant_infantes=0;
	 this.titular="";

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
public String fehcaCheck_in() {
	return check_in;
}
public String fehcaCheck_out() {
	return check_out;
}
public String getTitular() {
	return titular;
}
public void estadoIn() {
	this.estado="Ocupada";
}
public String getNumhabitacion() {
	if(numero_hab.length()==1) {
	return ("00"+numero_hab);
	}
	else {
	return ("0"+numero_hab);	
	}
}
public void resetHab() {
	this.estado="Libre";
	this.num_personas=0;
	this.cant_ad=0;
	this.cant_infantes=0;
	this.titular="";
	this.cuenta=0.0;
	this.check_in="";
	this.check_out="";
}
public double getCuenta() {
	return cuenta;
}
}
