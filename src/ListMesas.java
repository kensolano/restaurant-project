import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Kenneth Solano Gonzalez
 * 
 *         ESTA CLASE CONTIENE UNA COLECCION DE OBJETOS DE TIPO MESA CONTIENE
 *         METODOS QUE MANEJAN LOS ELEMENTOS INTERNOS ADEMAS CONTIENE METODOS
 *         QUE RETORNAN INFORMACION DE LA LISTA
 * 
 * 
 */
public class ListMesas
{
    private ArrayList<MesaExtranjero> listMesas;

    public ListMesas()
    {
	this.listMesas = new ArrayList<MesaExtranjero>();
    } // fin del metodo constructor

    // agrega una mesa al arreglo listMesas
    public void add( MesaExtranjero mesa )
    {
	this.listMesas.add(mesa);
    } // fin del metodo agregarMesa

    // Retorna el numero de la mesa disponible mas adecuada al numero de
    // comensales, retorna 0 si no hay una mesa disponible adecuada al numero de
    // comensales
    public int buscarMesaDisponible( int numComensales )
    {
	int mesaMasAdecuada = 0;

	for (int i = 0; i < listMesas.size() && mesaMasAdecuada == 0; i++)
//	    if (listMesas.get(i) != null)
		mesaMasAdecuada = (listMesas.get(i).estaDisponible() && numComensales <= listMesas.get(i).getTipoMesa() && (listMesas.get(i).getTipoMesa() - numComensales) < 2) ? (i + 1) : 0;

	for (int i = 0; i < listMesas.size() && mesaMasAdecuada == 0; i++)
		mesaMasAdecuada = (listMesas.get(i).estaDisponible() && numComensales <= listMesas.get(i).getTipoMesa() && (listMesas.get(i).getTipoMesa() - numComensales) < 4) ? (i + 1) : 0;

	for (int i = 0; i < listMesas.size() && mesaMasAdecuada == 0; i++)
		mesaMasAdecuada = (listMesas.get(i).estaDisponible() && numComensales <= listMesas.get(i).getTipoMesa() && (listMesas.get(i).getTipoMesa() - numComensales) < 6) ? (i + 1) : 0;

	for (int i = 0; i < listMesas.size() && mesaMasAdecuada == 0; i++)
		mesaMasAdecuada = (listMesas.get(i).estaDisponible() && numComensales <= listMesas.get(i).getTipoMesa() && (listMesas.get(i).getTipoMesa() - numComensales) < 8) ? (i + 1) : 0;

	return mesaMasAdecuada;

    } // fin del metodo buscarMesaDisponible

    public void limpiarMesa( int numMesa )
    {
	listMesas.get(numMesa - 1).setDisponible(true);
    }

    public void reservarMesa( int numMesa )
    {
	listMesas.get(numMesa - 1).setDisponible(false);
    }

    public int size()
    {
	return this.listMesas.size();
    }
    
    // Retorna los numeros de mesa de todas las mesas que estan ocupadas
    public int[] getMesasReservadas()
    {
	int pos = 0;
	int[] listMesasReservadas;

	for (int i = 0; i < listMesas.size(); i++)
	    if (listMesas.get(i) != null && !listMesas.get(i).estaDisponible())
		pos++;

	listMesasReservadas = new int[pos];

	pos = 0;

	for (int i = 0; i < listMesas.size(); i++)
	    if (listMesas.get(i) != null && !listMesas.get(i).estaDisponible())
	    {
		listMesasReservadas[pos] = listMesas.get(i).getNumMesa();
		pos++;
	    }

	return listMesasReservadas;

    } // fin del metodo getMesasReservadas

    // Retorna un arreglo de string bidimencional con la informacion del arreglo
    // string unidimencional de cada mesa
    public String[][] getStringListMesas()
    {
	int arrayLength = 0;
	String[][] stringListMesas;

	for (int i = 0; i < listMesas.size(); i++)
//	    if (listMesas[i] != null)
		arrayLength++;

	stringListMesas = new String[arrayLength][3];

	for (int i = 0; i < listMesas.size(); i++)
//	    if (listMesas[i] != null)
		stringListMesas[i] = this.listMesas.get(i).getStringMesa();

	return stringListMesas;

    } // fin del metodo getStringListMesas

    // retorna un arreglo de Strings que solamente contiene las mesas ocupadas
    public String[] getListMesasOcupadas()
    {
	int arrayLength = 0;
	String[] listMesasOcupadas;

	for (int i = 0; i < listMesas.size(); i++)
	    if ( !listMesas.get(i).estaDisponible() )
		arrayLength++;

	listMesasOcupadas = new String[arrayLength];

	arrayLength = 0;

	for (int i = 0; i < listMesas.size(); i++)
	    if ( !listMesas.get(i).estaDisponible() )
	    {
		listMesasOcupadas[arrayLength] = Integer.toString(listMesas.get(i).getNumMesa());
		arrayLength++;
	    } // fin del if

	return listMesasOcupadas;

    } // fin del metodo getListMesasOcupadas
    
    public String toString()
    {
	String listString = "";

	for( Iterator<MesaExtranjero> i = this.listMesas.iterator(); i.hasNext();)
	{
	    listString += i.next().toString() + "\n" ;
//	    listString += (i.hasNext())? "\n" : "";
	}

	return listString;


    } // fin de toString

} // fin de la clase ListMesas
