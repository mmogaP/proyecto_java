
public class ImplementacionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo_Leer texto_ini = new Archivo_Leer();
		Hotel hot = new Hotel();
		texto_ini.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\inicializar.txt");
		hot.setPresupuesto(Integer.parseInt(texto_ini.getLinea(0)));
		String fecha=texto_ini.getLinea(1);
		String[] fecha_ = fecha.split(" ");
		hot.setDd(Integer.parseInt(fecha_[0]));
		hot.setMm(Integer.parseInt(fecha_[1]));
		hot.setAa(Integer.parseInt(fecha_[2]));
	}
}
