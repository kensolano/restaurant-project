import java.awt.EventQueue;

public class EjecutarRestauranteGUI
{

    /**
     * Ejecuta la aplicacion
     */
    public static void main( String[] args )
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    RestauranteGUI frame = new RestauranteGUI();
		    frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

}
