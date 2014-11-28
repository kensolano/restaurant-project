import java.util.Formatter;


public class CreadorArchivo
{
    private Formatter restaurante;
    private Formatter cliente;
    private Formatter reserva;

    public CreadorArchivo()
    {
	super();
    }    

    public CreadorArchivo( ListRestaurantes listRestaurantes )
    {
	abrirArchivo();
	guardar( listRestaurantes );	
	cerrarArchivo();
    } 

    public void abrirArchivo()
    {
	try
	{
	    restaurante = new Formatter("Restaurante.txt");

	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
    } 

    // guarda la informacion de la agenda en un archivo de texto
    public void guardar( ListRestaurantes listRestaurantes )
    {
	try
	{
	    restaurante = restaurante.format( "%s", listRestaurantes.toString() );
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
    } // fin del metodo guardar

    public void cerrarArchivo()
    {
	if (restaurante != null)
	{
	    restaurante.close();
	}
    }

}
