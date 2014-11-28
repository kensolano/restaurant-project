/**
 * @author Kenneth Solano Gonzalez
 * 
 *         ESTA CLASE GESTIONA LOS ELEMENTOS EN SUS LISTAS INTERNAS DE MESAS Y
 *         CLIENTES ESTA CLASE ES IMPORTANTE PARA COORDINAR CAMBIOS QUE AFECTAN
 *         SIMULTANEAMENTE LA LISTA DE MESAS Y LA LISTA DE CLIENTES
 * 
 */
public class Restaurante
{
    private ListMesas listMesas;
    private ListClientes listClientes;
    private String pais;
    private String provincia;
    private String direccion;

    // Metodo constructor
    public Restaurante()
    {
	this.listMesas = new ListMesas();
	this.listClientes = new ListClientes();
	this.pais = "";
	this.provincia = "";
	this.direccion = "";
    } // fin del metodo constructor default

    // Metodo constructor
    public Restaurante( String pais, String provincia, String direccion )
    {
	this.listMesas = new ListMesas();
	this.listClientes = new ListClientes();
	this.pais = pais ;
	this.provincia = provincia ;
	this.direccion = direccion ;
    } // fin del metodo constructor
    
    public ListMesas getListMesas()
    {
	return listMesas;
    }

    public ListClientes getListClientes()
    {
	return listClientes;
    }
    
    

    public String getPais()
    {
        return pais;
    }

    public void setPais( String pais )
    {
        this.pais = pais;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public void setProvincia( String provincia )
    {
        this.provincia = provincia;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion( String direccion )
    {
        this.direccion = direccion;
    }

    public void setListMesas( ListMesas listMesas )
    {
        this.listMesas = listMesas;
    }

    public void setListClientes( ListClientes listClientes )
    {
        this.listClientes = listClientes;
    }

    // si el cliente tiene una mesa asignada lo agrega a la lista de clientes y
    // reserva la mesa
    public void asignarReservacion( ClienteExtranjero cliente )
    {
	cliente.asignarReservacion(this.listMesas);

	if (cliente.getNumMesa() != 0)
	{
	    this.listClientes.add(cliente);
	    this.listMesas.reservarMesa(cliente.getNumMesa());
	} // fin del if

    } // fin del metodo asignarReservacion

    // limpia la mesa y libera al cliente
    public void liberarReservacion( int numMesa )
    {
	listClientes.liberarCliente(numMesa);
	listMesas.limpiarMesa(numMesa);
    } // fin del metodo liberarReservacion

} // fin de la clase Restaurante
