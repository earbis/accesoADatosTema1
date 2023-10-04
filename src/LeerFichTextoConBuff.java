import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTextoConBuff {
	public static void main(String[] args) throws IOException {
		File archivo = new File("C:\\Users\\MICHAEL\\eclipse-workspace\\accesoADatosTema1\\Contenido.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader bff = new BufferedReader(fr);
		String i;
		while((i = bff.readLine())!= null) System.out.println(i);
		
		
		bff.close();
	}
}
