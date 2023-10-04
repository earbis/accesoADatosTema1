import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Actividad1_2 {
	public static void main(String[] args) throws IOException {
		File archivo = new File(args[0]);
		FileReader fic = new FileReader(archivo);
		int i;
		while ((i = fic.read()	)!=-1) {
			System.out.print((char) i	);
			
		}
		fic.close();
	}
}
