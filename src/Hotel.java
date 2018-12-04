import java.util.ArrayList;
public class Hotel {
ArrayList<Piso> hotel = new ArrayList<Piso>();
int mun_pisos;
int num_habi;
double presupuesto;
int dd;
int mm;
int aa;
///////////////////////////////////////
public void setPiso(int num) {
	Piso aux2 = new Piso(num);
	hotel.add(aux2);
}
public void setHabitacion(String tipo,int num) {
	hotel.get(num-1).getHabitacion(tipo);
}
public int getMun_pisos() {
	return mun_pisos;
}
public void setMun_pisos(int mun_pisos) {
	this.mun_pisos = mun_pisos;
}
public int getNum_habi() {
	return num_habi;
}
public void setNum_habi(int num_habi) {
	this.num_habi = num_habi;
}
public void setPresupuesto(double presupuesto) {
	this.presupuesto = presupuesto;
}
public int getDd() {
	return dd;
}
public void setDd(int dd) {
	this.dd = dd;
}
public int getMm() {
	return mm;
}
public void setMm(int mm) {
	this.mm = mm;
}
public int getAa() {
	return aa;
}
public void setAa(int aa) {
	this.aa = aa;
}
}
