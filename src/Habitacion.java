
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
int num_personas;
int cant_ad;
int cant_infantes;
String titular;
double cuenta;
int[] check_in=new int[3];
int[] check_out=new int[3];
///////////////////////////////////////
public Habitacion(String tip) {
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
	this.check_in[0]=dd1;
	this.check_in[1]=mm1;
	this.check_in[2]=aa1;
	this.check_out[0]=dd2;
	this.check_out[1]=mm2;
	this.check_out[2]=aa2;
}
 public void recervarHab(int adul,int infantes,String titular) {
	 this.estado = "Reservado";
	 this.cant_ad=adul;
	 this.cant_infantes=infantes;
	 this.titular=titular;

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
