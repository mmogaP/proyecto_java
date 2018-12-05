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
public void getReservar(int piso,int habitacion,int adul,int infantes,String titular) {
	hotel.get(piso).getReservar(habitacion, adul, infantes, titular);
	
}
public void checkFull(int piso,int habitacion,int dd1,int mm1,int aa1,int dd2,int mm2,int aa2) {
	hotel.get(piso).getCheck(habitacion, dd1, mm1, aa1, dd2, mm2, aa2);
}
public void agregarDia() {
	int[] dias = {31,28,31,30,31,30,31,31,30,31,30,31};
	dd++;
	if(dd>dias[mm-1]) {
		dd=1;
		mm++;
		if(mm>12) {
			aa++;
			mm=1;
		}
	}
}
public void setHabitacion(String tipo,int num,int num_habitacion) {
	hotel.get(num-1).getHabitacion(tipo,num_habitacion);
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
public int getNumCama(int pis,int hab) {
	return hotel.get(pis).getNumCama(hab);
}
public int getNum_habitaciones_x_piso(int piso) {
	return hotel.get(piso).num_habitaciones;
}
public String getEstado(int piso,int habitacion) {
	return hotel.get(piso).getEstado(habitacion);
}
public String getTipo(int piso,int habitacion) {
	return hotel.get(piso).getEstado(habitacion);
}

}
