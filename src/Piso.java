import java.util.ArrayList;

public class Piso {
int num_piso;
int num_habitaciones;
ArrayList<Habitacion> piso = new ArrayList<Habitacion>();
////////////////////////////////////////////////////////////
public Piso(int num) {
	this.num_piso=num;
}
public void getHabitacion(String tipo,int num_habitacion) {
	Habitacion aux = new Habitacion(tipo); 
	piso.add(aux);
	num_habitaciones=num_habitacion;
}
public void getNum(int num) {
	this.num_piso = num;
}
public int setNum() {
	return num_piso;
}
public int getNumCama(int num){
	return piso.get(num).getCamas_ind();
	
}
public void getCheck(int habitacion,int dd1,int mm1,int aa1,int dd2,int mm2,int aa2) {
	this.piso.get(habitacion).checkFull(dd1,mm1,aa1,dd2,mm2,aa2);
}
public int getNum_habitaciones_x_piso() {
	return num_habitaciones;
}
public String getEstado(int habitacion) {
	return piso.get(habitacion).getEstado();
}
public String getTipo(int habitacion) {
	return piso.get(habitacion).getTipo();
}
public void getReservar(int habitacion,int adul,int infantes,String titular) {
	piso.get(habitacion).recervarHab(adul, infantes, titular);
}
}
