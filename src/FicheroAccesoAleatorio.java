import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FicheroAccesoAleatorio {
	
		
		private File f;
		private List<Pair> campos;
		private long longReg;
		private long numReg = 0;
		private Pair par;
		public FicheroAccesoAleatorio(String nomFich, List<Pair> campos) {
			this.f = new File(nomFich);
			this.campos = campos;
			longReg = 0;
			for(Pair campo: campos) {
				this.longReg += campo.segundo;
			}
			if (f.exists()) {
				this.numReg = f.length()/this.longReg;
			}
		}
		public long getNumReg() {
			return numReg;
		}
		public void insertar(Map<String, String> reg) throws IOException {
			insertar(reg, this.numReg++);
			}
		public void insertar(Map<String, String> reg, long pos) throws FileNotFoundException, IOException {
			try (
				RandomAccessFile raf = new RandomAccessFile(f, "rws")){
					raf.seek(pos*this.longReg);
					for (Pair campo:campos) {
						String nomCampo = campo.primero;
						Integer longCampo = campo.segundo;
						String valorCampo = reg.get(nomCampo);
						if (valorCampo==null) {
							valorCampo = "";
						}
						String valorCampoForm = String.format("%1$-"+ longCampo+"s",valorCampo);
						raf.write(valorCampoForm.getBytes("UTF-8"),0,longCampo);
					}
				}
			
		}
		public static void main(String[] args) {
			List<Pair> campos = new ArrayList<>();
			campos.add(new Pair("DNI",9));
			campos.add(new Pair("Nombre",60));
			campos.add(new Pair("CP",5));
			try {
				FicheroAccesoAleatorio faa = new FicheroAccesoAleatorio("Fic_acceso", campos);
				Map<String, String> reg = new HashMap<>();
				reg.put("DNI", "56789012B");
				reg.put("Nombre", "Samper");
				reg.put("CP", "29730");
				faa.insertar(reg);
				reg.clear();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		/*
		public FicheroAccesoAleatorio(String primero, int segundo, File f, List<Pair> campos) {
			
			this.f = f;
			this.campos = campos;
			longReg = 0;
			for (Pair campo: campos) {
				this.longReg += campo.getValue();
				
			}
			*/
		}
		
		
		
		
		
		
		

