/**
 * @author Kenneth Solano Gonzalez
 * 
 *         ESTA CLASE MODELA UN OBJETO DE TIPO MESA ADEMAS CONTIENE METODOS QUE
 *         RETORNAN INFORMACION DE LA CLASE
 * 
 */
public class Mesa
{
    private int numMesa;
    private int tipoMesa;
    private boolean disponible;

    // constructor default
    public Mesa()
    {
	this.disponible = false;
	this.numMesa = 0;
	this.tipoMesa = 0;
    } // fin del metodo constructor default

    // constructor sobrecargado
    public Mesa(int numeroMesa, int tipoMesa)
    {
	this.numMesa = numeroMesa;
	this.tipoMesa = tipoMesa;
	this.disponible = true;
    } // fin del metodo constructor sobrecargado

    // constructor sobrecargado
    public Mesa(int tipoMesa)
    {
	this.numMesa = 0;
	this.tipoMesa = tipoMesa;
	this.disponible = true;
    } // fin del metodo constructor sobrecargado

    public int getTipoMesa()
    {
	return this.tipoMesa;
    }

    public void setNumMesa( int numMesa )
    {
	this.numMesa = numMesa;
    }

    public int getNumMesa()
    {
	return this.numMesa;
    }

    // metodo que retorna la variable disponible
    public boolean estaDisponible()
    {
	return disponible;
    }

    // metodo para indicar que la mesa esta ocupada
    public void setDisponible( boolean disponible )
    {
	this.disponible = disponible;
    }

    // Retorna un arreglo de String con las variables de la clase
    public String[] getStringMesa()
    {
	String mesaString[] = { "" + numMesa, "" + tipoMesa, "" + disponible };
	return mesaString;
    }

} // fin de la clase Mesa
