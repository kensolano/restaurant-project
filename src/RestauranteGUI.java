/**
 * @author Kenneth Solano Gonzalez
 * 
 * ESTA CLASE GESTIONA GESTIONA LA INTERFAZ GRAFICA DE USUARIO (GUI)
 * ESTA CLASE CONTIENE UN OBJETO DE TIPO RESTAURANTE EL CUAL GESTIONA LA INFORMACION
 * ESTE METODO ENVIA Y RECIBE DATOS DE LA CLASE RESTAURANTE
 * EL USUARIO INGRESA DATOS, LOS CUALES CON PROCESADOS POR EL OBJETO INTERNO DE LA CLASE RESTAURANTE
 * Y LUEGO LOS RESULTADOS SON PRESENTADOS POR ESTA CLASE
 *
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class RestauranteGUI extends JFrame
{
    Restaurante rest = new Restaurante();
    private int tipoMesa = 2;
    private JPanel contentPane;
    private JRadioButton rdbtnTipoA;
    private JRadioButton rdbtnTipoB;
    private JRadioButton rdbtnTipoC;
    private JRadioButton rdbtnTipoD;
    private JButton btnAgregarMesa;
    private JButton btnLimpiar;
    private JButton btnReservar;
    private JTable tableMesas;
    private JTable tableReservaciones;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox cmbNumComensales;
    private JComboBox cmbMesasOcupadas;
    private JLabel lblNoHayMesas;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JLabel lblNombre;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblFecha;
    private JLabel lblDia;
    private JLabel lblMes;
    private JLabel lblAno;
    private JScrollPane scrollPaneReservaciones;
    private JTextField txtEmail;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAno;

    /**
     * Crea el frame
     */
    public RestauranteGUI()
    {
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 729, 501);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	btnAgregarMesa = new JButton("Agregar");
	btnAgregarMesa.addActionListener(new ManejadorBtn());
	btnAgregarMesa.setBounds(614, 440, 89, 23);
	contentPane.add(btnAgregarMesa);

	ManejadorRdBtn manejadorRdBtn = new ManejadorRdBtn();

	rdbtnTipoA = new JRadioButton("Tipo A");
	rdbtnTipoA.setSelected(true);
	buttonGroup.add(rdbtnTipoA);
	rdbtnTipoA.addActionListener(manejadorRdBtn);
	rdbtnTipoA.setBounds(614, 305, 109, 23);
	contentPane.add(rdbtnTipoA);

	rdbtnTipoB = new JRadioButton("Tipo B");
	buttonGroup.add(rdbtnTipoB);
	rdbtnTipoB.addActionListener(manejadorRdBtn);
	rdbtnTipoB.setBounds(615, 331, 109, 23);
	contentPane.add(rdbtnTipoB);

	rdbtnTipoC = new JRadioButton("Tipo C");
	buttonGroup.add(rdbtnTipoC);
	rdbtnTipoC.addActionListener(manejadorRdBtn);
	rdbtnTipoC.setBounds(615, 357, 109, 23);
	contentPane.add(rdbtnTipoC);

	rdbtnTipoD = new JRadioButton("Tipo D");
	buttonGroup.add(rdbtnTipoD);
	rdbtnTipoD.addActionListener(manejadorRdBtn);
	rdbtnTipoD.setBounds(615, 383, 109, 23);
	contentPane.add(rdbtnTipoD);

	JScrollPane scrollPaneMesas = new JScrollPane();
	scrollPaneMesas.setBounds(426, 29, 277, 214);
	contentPane.add(scrollPaneMesas);

	tableMesas = new JTable();
	tableMesas.setEnabled(false);
	tableMesas.setRowSelectionAllowed(false);
	tableMesas.setModel(new DefaultTableModel(rest.getListMesas().getStringListMesas(), new String[] { "Mesa", "Capacidad",
		"Disponible" }));
	scrollPaneMesas.setViewportView(tableMesas);

	btnLimpiar = new JButton("Limpiar");
	btnLimpiar.addActionListener(new ManejadorBtn());
	btnLimpiar.setEnabled(false);
	btnLimpiar.setBounds(483, 440, 89, 23);
	contentPane.add(btnLimpiar);

	JSeparator separator = new JSeparator();
	separator.setOrientation(SwingConstants.VERTICAL);
	separator.setBounds(414, 0, 2, 463);
	contentPane.add(separator);

	scrollPaneReservaciones = new JScrollPane();
	scrollPaneReservaciones.setBounds(10, 29, 394, 214);
	contentPane.add(scrollPaneReservaciones);

	tableReservaciones = new JTable();
	tableReservaciones.setRowSelectionAllowed(false);
	tableReservaciones.setEnabled(false);
	tableReservaciones.setModel(new DefaultTableModel(rest.getListClientes().getStringListReservaciones(), new String[] {
		"Nombre", "Telefono", "Mesa", "Comensales" }));
	scrollPaneReservaciones.setViewportView(tableReservaciones);

	btnReservar = new JButton("Reservar");
	btnReservar.setEnabled(false);
	btnReservar.setBounds(69, 440, 89, 23);
	btnReservar.addActionListener(new ManejadorBtn());
	contentPane.add(btnReservar);

	cmbMesasOcupadas = new JComboBox(rest.getListMesas().getListMesasOcupadas());
	cmbMesasOcupadas.setEnabled(false);
	cmbMesasOcupadas.addActionListener(new ManejadorComboBox());
	cmbMesasOcupadas.setBounds(422, 264, 40, 20);
	contentPane.add(cmbMesasOcupadas);

	String numComensales[] = { "1", "2", "3", "4", "5", "6", "7", "8" };

	cmbNumComensales = new JComboBox(numComensales);
	cmbNumComensales.setEnabled(false);
	cmbNumComensales.addActionListener(new ManejadorComboBox());
	cmbNumComensales.setBounds(10, 264, 40, 20);
	contentPane.add(cmbNumComensales);

	lblNoHayMesas = new JLabel("<HTML>NO HAY ESPACIO DISPONIBLE<BR>\r\nSELECCIONE OTRA CANTIDAD<HTML>");
	lblNoHayMesas.setHorizontalAlignment(SwingConstants.CENTER);
	lblNoHayMesas.setBounds(131, 254, 178, 28);
	lblNoHayMesas.setVisible(false);
	contentPane.add(lblNoHayMesas);

	txtNombre = new JTextField();
	txtNombre.setBounds(135, 293, 198, 20);
	txtNombre.setColumns(10);
	txtNombre.getDocument().addDocumentListener(new ManejadorTextField());
	txtNombre.setVisible(false);
	contentPane.add(txtNombre);

	txtTelefono = new JTextField();
	txtTelefono.setBounds(135, 320, 198, 20);
	txtTelefono.setColumns(10);
	txtTelefono.getDocument().addDocumentListener(new ManejadorTextField());
	txtTelefono.setVisible(false);
	contentPane.add(txtTelefono);

	lblNombre = new JLabel("Nombre:");
	lblNombre.setBounds(70, 296, 109, 14);
	lblNombre.setVisible(false);
	contentPane.add(lblNombre);

	lblTelefono = new JLabel("Telefono:");
	lblTelefono.setBounds(70, 331, 109, 14);
	lblTelefono.setVisible(false);
	contentPane.add(lblTelefono);
	
	lblEmail = new JLabel("Email:");
	lblEmail.setBounds(70, 361, 110, 14);
	lblEmail.setVisible(false);
	contentPane.add(lblEmail);
	
	txtEmail = new JTextField();
	txtEmail.setBounds(135, 351, 198, 20);
	txtEmail.getDocument().addDocumentListener(new ManejadorTextField());
	txtEmail.setColumns(10);
	txtEmail.setVisible(false);
	contentPane.add(txtEmail);
	
	lblFecha = new JLabel("Fecha:");
	lblFecha.setBounds(70, 387, 109, 14);
	lblFecha.setVisible(false);
	contentPane.add(lblFecha);
	
	txtDia = new JTextField();
	txtDia.setBounds(133, 384, 40, 20);
	txtDia.getDocument().addDocumentListener(new ManejadorTextField());
	txtDia.setColumns(10);
	txtDia.setVisible(false);
	contentPane.add(txtDia);
	
	txtMes = new JTextField();
	txtMes.setBounds(184, 384, 40, 20);
	txtMes.getDocument().addDocumentListener(new ManejadorTextField());
	txtMes.setColumns(10);
	txtMes.setVisible(false);
	contentPane.add(txtMes);
	
	txtAno = new JTextField();
	txtAno.setBounds(247, 384, 86, 20);
	txtAno.getDocument().addDocumentListener(new ManejadorTextField());
	txtAno.setColumns(10);
	txtAno.setVisible(false);
	contentPane.add(txtAno);
	
	lblDia = new JLabel("dia");
	lblDia.setBounds(135, 412, 46, 14);
	lblDia.setVisible(false);
	contentPane.add(lblDia);
	
	lblMes = new JLabel("mes");
	lblMes.setBounds(184, 412, 46, 14);
	lblMes.setVisible(false);
	contentPane.add(lblMes);
	
	lblAno = new JLabel("a\u00F1o");
	lblAno.setBounds(257, 412, 46, 14);
	lblAno.setVisible(false);
	contentPane.add(lblAno);
    }

    class ManejadorBtn implements ActionListener
    {
	public void actionPerformed( ActionEvent e )
	{

	    // Controla lo que sucede cuando se presiona el boton btnAgregarMesa
	    if (e.getSource() == btnAgregarMesa)
	    {
		rest.getListMesas().add(new MesaExtranjero(  (rest.getListMesas().size() + 1), tipoMesa, rest.getPais(), rest.getProvincia(), rest.getDireccion() ) );

		// hace update a la tabla de mesas
		tableMesas.setModel(new DefaultTableModel(rest.getListMesas().getStringListMesas(), 
			new String[] { "Mesa", "Capacidad", "Disponible" }));

		if (!cmbNumComensales.isEnabled())
		    cmbNumComensales.setEnabled(true);

		cmbNumComensales.setSelectedIndex(cmbNumComensales.getSelectedIndex());
	    } // fin de la estructura if

	    // Controla lo que sucede cuando se presiona el boton btnReservar
	    if (e.getSource() == btnReservar)
	    {
		rest.asignarReservacion(new ClienteExtranjero((cmbNumComensales.getSelectedIndex() + 1), txtNombre.getText(), txtTelefono.getText(), txtEmail.getText(), new GregorianCalendar(Integer.parseInt( txtAno.getText() ), Integer.parseInt( txtMes.getText() ), Integer.parseInt( txtDia.getText() ) ) ) );

		// hace update a la tabla de mesas
		tableMesas.setModel(new DefaultTableModel(rest.getListMesas().getStringListMesas(), new String[] { "Mesa","Capacidad", "Disponible" }));

		// hace update a la tabla de reservaciones
		tableReservaciones.setModel(new DefaultTableModel(rest.getListClientes().getStringListReservaciones(),
			new String[] { "Nombre", "Telefono", "Mesa",
				"Comensales" }));

		if (!btnLimpiar.isEnabled())
		{
		    btnLimpiar.setEnabled(true);
		    cmbMesasOcupadas.setEnabled(true);
		}

		txtNombre.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtDia.setText("");
		txtMes.setText("");
		txtAno.setText("");

		// Se hace un update del contenido del combo box
		// cmbMesasOcupadas
		cmbMesasOcupadas.removeAllItems();
		String mesasOcupadas[] = rest.getListMesas().getListMesasOcupadas();
		for (int i = 0; i < mesasOcupadas.length; i++)
		    cmbMesasOcupadas.addItem(mesasOcupadas[i]);

		cmbMesasOcupadas.setSelectedIndex(cmbMesasOcupadas.getSelectedIndex());
		cmbNumComensales.setSelectedIndex(cmbNumComensales.getSelectedIndex());

	    } // fin de la estructura if

	    // Controla lo que sucede cuando se presiona el boton btnLimpiar
	    if (e.getSource() == btnLimpiar)
	    {
		rest.liberarReservacion(Integer.parseInt((String) cmbMesasOcupadas.getSelectedItem()));

		// hace update a la tabla de mesas
		tableMesas.setModel(new DefaultTableModel(rest.getListMesas().getStringListMesas(), new String[] { "Mesa",
			"Capacidad", "Disponible" }));

		// hace update a la tabla de reservaciones
		tableReservaciones.setModel(new DefaultTableModel(rest.getListClientes().getStringListReservaciones(),
			new String[] { "Nombre", "Telefono", "Mesa",
				"Comensales" }));

		// hace un update del combo box cmbMesasOcupadas
		cmbMesasOcupadas.removeAllItems();
		String mesasOcupadas[] = rest.getListMesas().getListMesasOcupadas();
		for (int i = 0; i < mesasOcupadas.length; i++)
		    cmbMesasOcupadas.addItem(mesasOcupadas[i]);

		cmbMesasOcupadas.setSelectedIndex(cmbMesasOcupadas.getSelectedIndex());
		cmbNumComensales.setSelectedIndex(cmbNumComensales.getSelectedIndex());

		if (mesasOcupadas.length == 0)
		{
		    cmbMesasOcupadas.setEnabled(false);
		    btnLimpiar.setEnabled(false);
		} // fin de la estructura if

	    }// fin de la estructura if

	} // fin del metodo actionPerformed
    } // fin de la clase interna ManejadorBtn

    // Maneja las acciones de los combo box
    class ManejadorComboBox implements ActionListener
    {
	public void actionPerformed( ActionEvent e )
	{

	    if (e.getSource() == cmbNumComensales)
	    {
		int numComensales = (cmbNumComensales.getSelectedIndex() + 1);

		if (rest.getListMesas().buscarMesaDisponible(numComensales) != 0)
		{
		    lblNoHayMesas.setVisible(false);
		    lblNombre.setVisible(true);
		    txtNombre.setVisible(true);
		    lblTelefono.setVisible(true);
		    txtTelefono.setVisible(true);
		    lblEmail.setVisible(true);
		    txtEmail.setVisible(true);
		    lblFecha.setVisible(true);
		    lblDia.setVisible(true);
		    txtDia.setVisible(true);
		    lblMes.setVisible(true);
		    txtMes.setVisible(true);
		    lblAno.setVisible(true);
		    txtAno.setVisible(true);
		    new ManejadorTextField().manejarBtnReservar();
		} else
		{
		    lblNoHayMesas.setVisible(true);
		    lblNombre.setVisible(false);
		    txtNombre.setVisible(false);
		    lblTelefono.setVisible(false);
		    txtTelefono.setVisible(false);
		    lblEmail.setVisible(true);
		    txtEmail.setVisible(true);
		    lblFecha.setVisible(true);
		    lblDia.setVisible(true);
		    txtDia.setVisible(true);
		    lblMes.setVisible(true);
		    txtMes.setVisible(true);
		    lblAno.setVisible(true);
		    txtAno.setVisible(true);		    
		    btnReservar.setEnabled(false);
		}

	    } // fin de la estructura if

	} // fin del metodo actionPerformed
    } // fin de la clase ManejadorComboBox

    // Maneja los eventos de los JTextField mediante un DocumentListener
    class ManejadorTextField implements DocumentListener
    {
	public void changedUpdate( DocumentEvent e )
	{
	    manejarBtnReservar();
	}

	public void removeUpdate( DocumentEvent e )
	{
	    manejarBtnReservar();
	}

	public void insertUpdate( DocumentEvent e )
	{
	    manejarBtnReservar();
	}

	// habilita el boton reservar si los campos de texto estan llenados
	public void manejarBtnReservar()
	{
	    if (txtNombre.getDocument().getLength() != 0 && txtTelefono.getDocument().getLength() != 0 && txtEmail.getDocument().getLength() != 0 && txtAno.getDocument().getLength() != 0 && txtMes.getDocument().getLength() != 0 && txtDia.getDocument().getLength() != 0)
		btnReservar.setEnabled(true);
	    if (txtNombre.getDocument().getLength() == 0 || txtTelefono.getDocument().getLength() == 0 || txtEmail.getDocument().getLength() == 0 || txtAno.getDocument().getLength() == 0 || txtMes.getDocument().getLength() == 0 || txtDia.getDocument().getLength() == 0)
		btnReservar.setEnabled(false);
	} // fin del metodo manejarBtnReservar

    } // fin de la clae ManejadorTextField

    class ManejadorRdBtn implements ActionListener
    {
	public void actionPerformed( ActionEvent e )
	{

	    if (e.getSource() == rdbtnTipoA)
	    {
		tipoMesa = 2;
	    } // fin de la estructura if

	    if (e.getSource() == rdbtnTipoB)
	    {
		tipoMesa = 4;
	    } // fin de la estructura if

	    if (e.getSource() == rdbtnTipoC)
	    {
		tipoMesa = 6;
	    } // fin de la estructura if

	    if (e.getSource() == rdbtnTipoD)
	    {
		tipoMesa = 8;
	    } // fin de la estructura if

	} // fin del metodo actionPerformed
    } // fin de la clase interna ManejadorBtn
} // fin de la clase RestauranteGUI