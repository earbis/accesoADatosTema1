

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTextoConArray {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\MICHAEL\\eclipse-workspace\\accesoADatosTema1\\LeerFichTexto.java");
		FileReader fic = new FileReader(fichero);
		int i;
		char b []= new char[20];
		while ((i = fic.read(b))!=-1) {
			System.out.println(b);
		}
		fic.close();
	}
}
