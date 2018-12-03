import java.util.ArrayList;
public class Hotel {
ArrayList<Piso> hotel = new ArrayList<Piso>();
int mun_pisos;
int num_habi;
///////////////////////////////////////
public void setPiso() {
	Piso aux2 = new Piso();
	hotel.add(aux2);
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
}
