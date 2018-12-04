
public class ImplementacionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo_Leer texto_ini = new Archivo_Leer();
		Hotel hot = new Hotel();
		texto_ini.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\inicializar.txt");
		hot.setPresupuesto(Double.parseDouble(texto_ini.getLinea(0)));
		String aux=texto_ini.getLinea(1);
		String[] fecha_ = aux.split(" ");
		hot.setDd(Integer.parseInt(fecha_[0]));
		hot.setMm(Integer.parseInt(fecha_[1]));
		hot.setAa(Integer.parseInt(fecha_[2]));
		aux=texto_ini.getLinea(2);
		String[] piso = aux.split(" ");
		hot.setNum_habi(Integer.parseInt(piso[0]));
		hot.setMun_pisos(Integer.parseInt(piso[1]));
		for(int i=0;i<(hot.getMun_pisos()-1);i++) {
			aux=texto_ini.getLinea(i+3);
			String[] hab = aux.split(" ");
			hot.setPiso(i+1);
			for (int z=1;z<=Integer.parseInt(hab[0]);i++) {
				hot.setHabitacion(hab[z],i+1);
			}
		}
	}
}
