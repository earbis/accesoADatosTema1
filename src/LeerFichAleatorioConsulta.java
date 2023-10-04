import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorioConsulta {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile raf = new RandomAccessFile(fichero,"r");	
		int id, dep, posicion;
		Double salario;
		char apellido[]= new char[10];
		char aux;
		
	//Consulta
			int identificador=5;
			posicion= (identificador -1)*36;
			if(posicion>=raf.length()) {
				System.out.printf("ID: %d, no existe empleado... ", identificador);
			}else{
				
				raf.seek(posicion);
				id = raf.readInt();
				for(int i = 0;i < apellido.length; i++) {
					aux = raf.readChar();
					apellido[i] = aux;
				}
				dep = raf.readInt();
				salario = raf.readDouble();
				String apellidos = new String(apellido);
				
				
				
				if(id>0) 
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,apellidos.trim(),dep,salario );
			}
	}
}
