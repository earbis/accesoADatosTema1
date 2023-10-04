import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile raf = new RandomAccessFile(fichero,"r");	
		int id, dep, posicion;
		Double salario;
		char apellido[]= new char[10],aux;
		posicion = 0;
		for(;;) {
			raf.seek(posicion);
			id = raf.readInt();
			for(int i = 0;i < apellido.length; i++) {
				aux = raf.readChar();
				apellido[i] = aux;
			}
			String apellidos = new String(apellido);
			dep = raf.readInt();
			salario = raf.readDouble();
			if(id>0) 
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,apellidos.trim(),dep,salario );
			posicion = posicion+36;
			if (raf.getFilePointer()==raf.length())break;
			
		}
		
		raf.close();
	}
}
