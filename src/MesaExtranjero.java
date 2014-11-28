public class MesaExtranjero extends Mesa
{
    private String pais;
    private String provincia;
    private String direccion;

    public MesaExtranjero()
    {
	super();
	this.pais = "";
	this.provincia = "";
	this.direccion = "";
    }
    
    public MesaExtranjero(int numeroMesa, int tipoMesa, String pais, String provincia, String direccion)
    {
	super(numeroMesa, tipoMesa);
	// TODO Auto-generated constructor stub
	this.pais = pais;
	this.provincia = provincia;
	this.direccion = direccion;
    }

    public MesaExtranjero(int tipoMesa, String pais, String provincia, String direccion)
    {
	super(tipoMesa);
	// TODO Auto-generated constructor stub
	this.pais = pais;
	this.provincia = provincia;
	this.direccion = direccion;
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
    
    public String toString()
    {
	return  pais + "|" + provincia + "|" + direccion + "|" + super.getNumMesa() + "|" + super.getTipoMesa() ;
    }

} // fin de la clase MesaExtranjero
