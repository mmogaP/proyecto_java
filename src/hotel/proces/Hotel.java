package hotel.proces;
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
public void gastoM() {//gasto mensual
	this.presupuesto=presupuesto - 25000.00;
}
public void setPiso(int num) {//crea el piso
	Piso aux2 = new Piso(num);
	hotel.add(aux2);
}
public void getReservar(int piso,int habitacion,int adul,int infantes,String titular) {//crea la reserva
	hotel.get(piso).setReservar(habitacion, adul, infantes, titular);
}
public int[] setReservacion(String tipo) {//busca habitacion para la reserva
	int[] cord = new int[2];
	for(int i = 0;i<mun_pisos;i++) {
		for(int y = 0;y<getNum_habitaciones_x_piso(i);y++) {
			if(getEstado(i,y).equals("Libre")&&(getTipo(i, y).equals(tipo))) {//si encuentra una habitacion libre se le asigna y listo
				cord[0]=i;
				cord[1]=y;
				return cord;
			}
		}
	}
	return cord;
}
public void checkFull(int piso,int habitacion,int dd1,int mm1,int aa1,int dd2,int mm2,int aa2) {
	hotel.get(piso).checkFull(habitacion, dd1, mm1, aa1, dd2, mm2, aa2);
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
public void sumPresupuesto(double valor) {
	this.presupuesto+=valor;
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
	return hotel.get(piso).getTipo(habitacion);
}
public String getFecha() {
	return dd+"/"+mm+"/"+aa;
}
public String getFecha_in(int piso,int habitacion) {
	return hotel.get(piso).getFecha_in(habitacion);
}
public String getFecha_out(int piso,int habitacion) {
	return hotel.get(piso).getFecha_out(habitacion);
}
public int getDias(int piso,int habitacion){
	String[] fech_in=hotel.get(piso).getFecha_in(habitacion).split("/");
	String[] fech_out=hotel.get(piso).getFecha_out(habitacion).split("/");
	int dia_in=Integer.parseInt(fech_in[0]);
	int dia_out=Integer.parseInt(fech_out[0]);
	return dia_out-dia_in;
}
public String getTitular(int piso,int habitacion) {
	return hotel.get(piso).getTitular(habitacion);
}
public void cancelarReserva(int piso,int habitacion) {
	hotel.get(piso).cancelarReserva(habitacion);
}
public void estadoIn(int piso,int habitacion) {
	hotel.get(piso).estadoIn(habitacion);
}
public String numHabitacion(int piso,int habitacion) {
	return hotel.get(piso).getNumhabitacion(habitacion);
}
public double getCuenta(int piso,int habitacion) {
	return hotel.get(piso).getCuenta(habitacion);
}
public void setCuenta(int piso, int habitacion, double cuenta) {
	hotel.get(piso).setCuenta(habitacion,cuenta);
}
public double getSaldo() {
	return presupuesto;
}
public void setReinicio(int piso, int habitacion) {
	hotel.get(piso).setReinicio(habitacion);
}

}
