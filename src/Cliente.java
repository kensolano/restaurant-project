/**
 * @author Kenneth Solano Gonzalez
 * 
 *         ESTA CLASE MODELA UN OBJETO DE TIPO CLIENTE ADEMAS CONTIENE METODOS
 *         QUE RETORNAN INFORMACION DE LA CLASE
 * 
 */
public class Cliente implements Comparable<Cliente>
{
    private int numComensales;
    private int numMesa;
    private String nombre;
    private String telefono;

    // constructor default
    public Cliente()
    {
	this.numComensales = 0;
	this.numMesa = 0;
	this.nombre = "";
	this.telefono = "";
    }

    // constructor sobrecargado
    public Cliente(int numComensales, String nombre, String telefono)
    {
	this.numComensales = numComensales;
	this.nombre = nombre;
	this.telefono = telefono;
    } // fin del metodo constructor

    // constructor sobrecargado
    public Cliente(int numComensales, int numMesa, String nombre,
	    String telefono)
    {
	this.numComensales = numComensales;
	this.numMesa = numMesa;
	this.nombre = nombre;
	this.telefono = telefono;
    } // fin del metodo constructor

    public void setNumMesa( int numMesa )
    {
	this.numMesa = numMesa;
    }

    public int getNumMesa()
    {
	return numMesa;
    }

    public int getNumComensales()
    {
	return this.numComensales;
    }

    public String getNombre()
    {
	return this.nombre;
    }

    public int compareTo( Cliente cliente )
    {
	return this.getNombre().compareToIgnoreCase(cliente.getNombre());
    } // fin del metodo CompareTo

    // asigna una mesa al cliente, le asigna 0 cuando no hay una mesa adecuada
    // para la cantidad de comensales
    public void asignarReservacion( ListMesas listMesas )
    {
	this.numMesa = listMesas.buscarMesaDisponible(this.numComensales);
    } // fin del metodo asignarReservacion

    // retorna una arreglo de String con las datos del cliente
    public String[] getStringCliente()
    {
	String clienteString[] = { "" + nombre, "" + telefono, "" + numMesa, "" + numComensales };
	return clienteString;
    } // fin del metodo getStringCliente

} // fin de la clase cliente
