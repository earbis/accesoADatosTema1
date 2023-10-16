import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPersona implements Serializable{
	private List<Persona> lista = new ArrayList<>();
	public ListaPersona() {}
	public void add (Persona persona) {
		lista.add(persona);
	}
	public List<Persona> getLista() {
		return lista;
	}

}
