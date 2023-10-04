import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroTexto {
	public static void main(String[] args) throws IOException {
		File archivo = new File(".\\FicheroParaEscribir.txt");
		FileWriter fw = new FileWriter(archivo);
		String cadena = "esto es lo que va a ser escrito como prueba de la clase <EscribirFicheroTexto>";
		fw.write(cadena);
		fw.append("A");
		fw.close();
		
		
	}
}
