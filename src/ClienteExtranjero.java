import java.util.GregorianCalendar;

public class ClienteExtranjero extends Cliente
{
    private String email;
    private GregorianCalendar fechaNacimiento;

    public ClienteExtranjero()
    {
	// TODO Auto-generated constructor stub
	super();
	this.email = "";
	this.fechaNacimiento = new GregorianCalendar();
    } // fin del metodo constructor

    public ClienteExtranjero(int numComensales, int numMesa, String nombre, String telefono, String email, GregorianCalendar fechaNacimiento)
    {
	super(numComensales, numMesa, nombre, telefono);
	// TODO Auto-generated constructor stub
	this.email = email;
	this.fechaNacimiento = fechaNacimiento;
    } // fin del metodo constructor

    public ClienteExtranjero(int numComensales, String nombre, String telefono,
	    String email, GregorianCalendar fechaNacimiento)
    {
	super(numComensales, nombre, telefono);
	// TODO Auto-generated constructor stub
	this.email = email;
	this.fechaNacimiento = fechaNacimiento;

    } // fin del metodo constructor

    public String getEmail()
    {
	return email;
    }

    public void setEmail( String email )
    {
	this.email = email;
    }

    public GregorianCalendar getFechaNacimiento()
    {
	return fechaNacimiento;
    }

    public void setFechaNacimiento( GregorianCalendar fechaNacimiento )
    {
	this.fechaNacimiento = fechaNacimiento;
    }

} // fin de la clase ClienteExtranjero
