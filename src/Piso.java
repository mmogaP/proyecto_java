import java.util.ArrayList;

public class Piso {
int num_piso;
ArrayList<Habitacion> piso = new ArrayList<Habitacion>();
////////////////////////////////////////////////////////////
public Piso(int num) {
	this.num_piso=num;
}
public void getHabitacion(String tipo) {
	Habitacion aux = new Habitacion(tipo); 
	piso.add(aux);
}
public void getNum(int num) {
	this.num_piso = num;
}
public int setNum() {
	return num_piso;
}
}
