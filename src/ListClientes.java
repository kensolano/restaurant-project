import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kenneth Solano Gonzalez
 * 
 *         ESTA CLASE CONTIENE UNA COLECCION DE OBJETOS DE TIPO CLIENTE CONTIENE
 *         METODOS QUE MANEJAN LOS ELEMENTOS INTERNOS ADEMAS CONTIENE METODOS
 *         QUE RETORNAN INFORMACION DE LA LISTA
 * 
 * 
 */
public class ListClientes
{
    private ArrayList<ClienteExtranjero> listClientes;

    // Metodo constructor
    public ListClientes()
    {
	this.listClientes = new ArrayList<ClienteExtranjero>();
    } // fin del metodo constructor

    // agrega un cliente al arreglo listClientes
    public void add( ClienteExtranjero cliente )
    {
	listClientes.add(cliente);
	Collections.sort(listClientes);
    } // fin del metodo add

    // busca el cliente que tenga cierto numero de mesa y se la pone en 0
    public void liberarCliente( int numMesa )
    {
	for (int i = 0; i < listClientes.size(); i++)
	{
	    if (listClientes.get(i).getNumMesa() == numMesa)
		listClientes.get(i).setNumMesa(0);
	}
    } // fin del metodo liberarCliente
    
    // Retorna un arreglo de string bidireccional con la informacion del arreglo
    // string unidireccional de cada cliente
    public String[][] getStringListClientes()
    { 
	int arrayLength = 0; String[][]
		stringListClientes;

	for (int i = 0; i < listClientes.size(); i++) 
	        if (listClientes.get(i) != null) 
	            arrayLength++;

	stringListClientes = new String[arrayLength][4];

	for (int i = 0; i < listClientes.size(); i++)
//	    if (listClientes[i] != null) 
		stringListClientes[i] = this.listClientes.get(i).getStringCliente();

	return stringListClientes;

    } // fin del metodo getStringListClientes
      
    // Retorna un arreglo de string bidimencional con la informacion delarreglo 
    // string unidimencional de cada cliente 
    public String[][] getStringListReservaciones()
    { 
	int arrayLength = 0; 
	String[][] stringListClientes;

	for (int i = 0; i < listClientes.size(); i++) 
	    if (listClientes.get(i).getNumMesa() > 0) 
		arrayLength++;

	stringListClientes = new String[arrayLength][4];

	arrayLength = 0;

	for (int i = 0; i < listClientes.size(); i++) 
	    if ( listClientes.get(i).getNumMesa() > 0 ) 
	{ 
	    stringListClientes[arrayLength] = this.listClientes.get(i).getStringCliente();
	    arrayLength++; 
	}

	return stringListClientes;

    } // fin del metodo getStringListReservaciones
      
    public void printListClientes() 
    { 
	Cliente cliente;

	for (int i = 0; i < listClientes.size(); i++) 
	{ 
	    if ( listClientes.get(i) != null ) 
	    { 
		cliente = listClientes.get(i); 
		System.out.println("Nombre: " + cliente.getNombre()); 
		System.out.println("Mesa Numero: " + cliente.getNumMesa());

	    } 
	}

    } // fin del metodo printListClientes
 
} // fin de la clase ListClientes

