import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroAleatorio {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
		String apellido[]= {"Fernandez","Gil","Lopez","Ramos","Sevilla","Castilla","Rey"};
		int dep []= {10,20,10,10,30,30,20};
		Double salario []= {1000.45,2400.60,3000.0,1500.56,2200.0,1435.87,2000.0};
		StringBuffer buffer =null;
		int n =apellido.length;
		for(int i = 0; i<n;i++) {
			raf.writeInt(i+1);
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10);
			raf.writeChars(buffer.toString());
			raf.writeInt(dep[i]);
			raf.writeDouble(salario[i]);
		}
		raf.close();
		
	}
}
