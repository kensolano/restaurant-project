import java.io.File;
import java.util.Scanner;


public class LectorArchivo
{
    private Scanner entrada ;
/**    
    public Agenda recuperar()
    {
	abrirArchivo();
	return recuperar();
	cerrarArchivo();
    }
*/
    public void abrirArchivo()
    {
	try
	{
	    entrada =  new Scanner( new File("contactos.txt") );	
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
    }
    
    // Recupera la informacion guardada en el archivo
    public Agenda recuperar()
    {	
	abrirArchivo();
	
	String registro = "";
	String nombre = "";
	String direccion = "";
	String telefono = "";
	String email = "";
	Agenda agenda = new Agenda();
//	ArrayList<Contacto> listContactos = new ArrayList<Contacto>();
//	System.out.printf("%-30s %-30s %-30s %-30s\n", "Nombre del Contacto","Direccion", "Telefono", "Email" );
	
	
	
	while (entrada.hasNext())
	{
	    registro = entrada.nextLine();
	    
	    nombre = registro.substring(0,registro.indexOf("|"));
	    registro = registro.substring(registro.indexOf("|")+1);
	    
	    direccion = registro.substring(0,registro.indexOf("|"));
	    registro = registro.substring(registro.indexOf("|")+1);

	    telefono = registro.substring(0,registro.indexOf("|"));
	    registro = registro.substring(registro.indexOf("|")+1); 
	    
	    email = registro.substring(0);
	    
	    agenda.add( new Contacto( nombre, direccion, telefono, email ) );
	    
//	    System.out.printf("%-30s %-30s %-30s %-30s\n", nombre, direccion, telefono, email);
	}
	
	cerrarArchivo();
	
	return agenda;
	
    } // fin del metodo recuperar
    
    public void cerrarArchivo() {
	if (entrada != null)
	{
	    entrada.close();
	}
    }	

}
