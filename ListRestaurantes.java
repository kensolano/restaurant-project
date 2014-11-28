import java.util.ArrayList;
import java.util.Iterator;


public class ListRestaurantes
{
    private ArrayList<Restaurante> listRestaurantes;

    public ListRestaurantes(ArrayList<Restaurante> listRestaurantes)
    {
	this.listRestaurantes = listRestaurantes;
    }

    public ArrayList<Restaurante> getListRestaurantes()
    {
        return listRestaurantes;
    }

    public void setListRestaurantes( ArrayList<Restaurante> listRestaurantes )
    {
        this.listRestaurantes = listRestaurantes;
    }
    
    public void add( Restaurante restaurante )
    {
	this.listRestaurantes.add( restaurante );
    }
    
    public int size()
    {
	return this.listRestaurantes.size();
    }
    
    public String toString()
    {
	String listString = "";
	
	for( Iterator<Restaurante> i = this.listRestaurantes.iterator(); i.hasNext();)
	{
	    listString += i.next().getListMesas().toString();
	}
	
	return listString;
    }
    
} // fin de la clase ListRestaurantes
