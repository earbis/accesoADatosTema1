import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class CrearEmpleadoXml {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile raf= new RandomAccessFile(fichero, "r");
		int id, dep, posicion= 0;
		Double salario;
		char apellido [] = new char[10], aux;
		
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation= builder.getDOMImplementation();
			Document document= implementation.createDocument(null,  "Empleados",null) ;
			document.setXmlVersion("1.0");
			for(;;) {
				raf.seek(posicion);
				id = raf.readInt();
				for(int i = 0; i< apellido.length;i++) {
					aux = raf.readChar();
					apellido[i]=aux;
				}
				String apellidos = new String(apellido);
				dep = raf.readInt();
				salario= raf.readDouble();
				if(id>0) {
					org.w3c.dom.Element raiz= document.createElement("empleado");
					document.getDocumentElement().appendChild(raiz);
					CrearElemento("id",Integer.toString(id),raiz,document);
					CrearElemento("apellido",apellidos.trim(),raiz,document);
					CrearElemento("dep",Integer.toString(dep),raiz,document);
					CrearElemento("salario",Double.toString(salario),raiz,document);
					posicion = posicion+36;
					if(raf.getFilePointer() ==raf.length()) break;
				}
				Source source = new DOMSource(document);
				javax.xml.transform.Result result = new StreamResult(new java.io.File("Empleados.xml"));
				Transformer transformer= TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
			}
		} catch (Exception e) {
			// : handle exception
		}
		raf.close();
	}
	
	
	static void CrearElemento(String datoEmple, String valor, org.w3c.dom.Element raiz, Document document) {
		org.w3c.dom.Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		((Node) raiz).appendChild(elem);
		elem.appendChild(text);
	}
}
