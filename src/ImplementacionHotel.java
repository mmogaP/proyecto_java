
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
			for (int z=1;z<=Integer.parseInt(hab[0]);z++) {
				hot.setHabitacion(hab[z],i+1,z);
			}
		}
		/////////////////////////////////////Precios
		Archivo_Leer texto_pre = new Archivo_Leer();
		Precio precio = new Precio();
		texto_pre.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\precios.txt");
		String parametros = texto_pre.getLinea(0);
		String[] parametros2 = parametros.split(" ");
		int num_hab = Integer.parseInt(parametros2[0]);
		for(int i=0;i<num_hab;i++) {
			String[] aux2 = (texto_pre.getLinea(i+1)).split(" ");
			precio.setHabitacion(aux2[0], Double.parseDouble(aux2[1]));
		}
		int num_serv=Integer.parseInt(parametros2[1]);
		for(int i=0;i<num_serv;i++) {
			String[] aux2 = (texto_pre.getLinea(i+num_hab+1)).split(" ");
			String aux_nombre = "";
			for(int z=2;z<aux2.length;z++) {
				aux_nombre = aux2[z]+" ";
			}
			precio.setServicio(aux2[0],Double.parseDouble(aux2[1]), aux_nombre);
		}
		int num_menu=Integer.parseInt(parametros2[2]);
		for(int i=0;i<num_menu;i++) {
			String[] aux2=(texto_pre.getLinea(i+num_serv+num_hab+1)).split(" ");
			String aux_nombre="";
			for(int z = 0;z<aux2.length;z++) {
				aux_nombre = aux2[z]+" ";
			}
			precio.setMenu(aux2[0], Double.parseDouble(aux2[1]), aux_nombre);
		}
		///////////////////////
		Archivo_Leer op = new Archivo_Leer();
		op.leerArchivo("C:\\Users\\Abuelo\\eclipse-workspace\\Hotel1\\txt\\operaciones.txt");
		for(int i = 0;i<op.getTamaño();i++) {
			if((op.getLinea(i)).equals("0")) {
				hot.agregarDia();
				continue;
			}
			else if(op.getLinea(i).equals("1")) {
				int[] habitacion_libre=new int[2];
				boolean fin=false;
				for(int y=0;y<hot.getMun_pisos();y++) {
					for(int j=0;j<hot.getNum_habitaciones_x_piso(y);j++) {
						if(hot.getEstado(y, j).equals("Libre")) {
							habitacion_libre[0]= y;
							habitacion_libre[1]= j;
							fin=true;
							break;
						}
					}
					if(fin==true) {
						break;
					}
				}
				String linea = op.getLinea(i+1);
				String[] check=linea.split(" ");
				linea = op.getLinea(i+2);
				hot.checkFull(habitacion_libre[0], habitacion_libre[1], Integer.parseInt(check[0]), Integer.parseInt(check[1]), Integer.parseInt(check[2]), Integer.parseInt(check[3]), Integer.parseInt(check[4]), Integer.parseInt(check[5]));
				
			}
		}
	}
}
