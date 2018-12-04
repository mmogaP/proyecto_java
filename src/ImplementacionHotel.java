
public class ImplementacionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo_Leer texto_ini = new Archivo_Leer();
		texto_ini.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\inicializar.txt");
		String text=texto_ini.getLinea(0);
	}
}
