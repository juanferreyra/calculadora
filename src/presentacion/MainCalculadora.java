package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.BorderFactory;

import negocio.Calculadora;

import java.awt.SystemColor;

public class MainCalculadora {

	private JFrame _frmCalculadora;
	private JTextField _jtf1;
	private JTextField _jtf2;
	private String _operandoActual;
	private Boolean _ingresoComa;
	private Calculadora _calcu;
	private boolean _ingresandoOperador; //indica si agrego al item dentro de Calculadora;
	private boolean _ingresandoNumero;//indica si agrego a la clase calculadora dentro de item el numero
	private boolean _estaResultado;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCalculadora window = new MainCalculadora();
					window._frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCalculadora() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("No encuentro en look and feel");
			e.printStackTrace();
		}
		_calcu = new Calculadora();
		_ingresoComa = false;
		_estaResultado = false;
		_ingresandoNumero = true;//inicializo como que esta agregando numero para que no agregue un operador antes;
		_ingresandoOperador = false;//inicio con que no esta agregando operador
		_operandoActual="";
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		_frmCalculadora = new JFrame();
		_frmCalculadora.setResizable(false);
		_frmCalculadora.setIconImage(Toolkit.getDefaultToolkit().getImage(MainCalculadora.class.getResource("/img/calculator-icon.jpg")));
		_frmCalculadora.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		_frmCalculadora.setTitle("Calculadora");
		_frmCalculadora.setBounds(100, 100, 409, 350);
		_frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frmCalculadora.getContentPane().setLayout(null);
		
		
		_jtf1 = new JTextField("");
		_jtf1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		_jtf1.setHorizontalAlignment(SwingConstants.RIGHT);
		_jtf1.setEditable(false);
		_jtf1.setBorder(BorderFactory.createLineBorder(Color.white));
		_jtf1.setBackground(Color.WHITE);
		_jtf1.setBounds(10, 11, 380, 26);
		_frmCalculadora.getContentPane().add(_jtf1);
		
		_jtf2 = new JTextField("0");
		_jtf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		_jtf2.setHorizontalAlignment(SwingConstants.RIGHT);
		_jtf2.setEditable(false);
		_jtf2.setBorder(BorderFactory.createLineBorder(Color.white));
		_jtf2.setBackground(Color.WHITE);
		_jtf2.setBounds(10, 38, 380, 35);
		_frmCalculadora.getContentPane().add(_jtf2);
		
		//boton Doble 0
		JButton btnDobleCero = new JButton("00");
		btnDobleCero.setBounds(162, 260, 76, 51);
		btnDobleCero.setBackground(new Color(240, 240, 240));
		btnDobleCero.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnDobleCero);
		btnDobleCero.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "00");
			}
		});
		
		//boton 0
		JButton btnNum0 = new JButton("0");
		btnNum0.setBounds(10, 260, 76, 51);
		btnNum0.setBackground(new Color(240, 240, 240));
		btnNum0.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum0);
		btnNum0.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "0");
			}
		});
		
		//boton 1
		JButton btnNum1 = new JButton("1");
		btnNum1.setBounds(10, 209, 76, 51);
		btnNum1.setBackground(new Color(240, 240, 240));
		btnNum1.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum1);
		btnNum1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "1");
			}
		});
		
		//boton 2
		JButton btnNum2 = new JButton("2");
		btnNum2.setBounds(86, 209, 76, 51);
		btnNum2.setBackground(new Color(240, 240, 240));
		btnNum2.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum2);
		btnNum2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "2");
			}
		});
		
		//boton 3
		JButton btnNum3 = new JButton("3");
		btnNum3.setBounds(162, 209, 76, 51);
		btnNum3.setBackground(new Color(240, 240, 240));
		btnNum3.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum3);
		btnNum3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "3");
			}
		});
		
		//boton 4
		JButton btnNum4 = new JButton("4");
		btnNum4.setBounds(10, 158, 76, 51);
		btnNum4.setBackground(new Color(240, 240, 240));
		btnNum4.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum4);
		btnNum4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "4");
			}
		});
		
		//boton 5
		JButton btnNum5 = new JButton("5");
		btnNum5.setBounds(86, 158, 76, 51);
		btnNum5.setBackground(new Color(240, 240, 240));
		btnNum5.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum5);
		btnNum5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "5");
			}
		});
		
		//boton 6
		JButton btnNum6 = new JButton("6");
		btnNum6.setBounds(162, 158, 76, 51);
		btnNum6.setBackground(new Color(240, 240, 240));
		btnNum6.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum6);
		btnNum6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "6");
			}
		});
		
		//boton 7
		JButton btnNum7 = new JButton("7");
		btnNum7.setBounds(10, 107, 76, 51);
		btnNum7.setBackground(new Color(240, 240, 240));
		btnNum7.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum7);
		btnNum7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "7");
			}
		});
		
		//boton 8
		JButton btnNum8 = new JButton("8");
		btnNum8.setBounds(86, 107, 76, 51);
		btnNum8.setBackground(new Color(240, 240, 240));
		btnNum8.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum8);
		btnNum8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setNumero(_jtf1, _jtf2, "8");
			}
		});
		
		//boton 9
		JButton btnNum9 = new JButton("9");
		btnNum9.setBounds(162, 107, 76, 51);
		btnNum9.setBackground(new Color(240, 240, 240));
		btnNum9.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnNum9);
		btnNum9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setNumero(_jtf1, _jtf2, "9");
			}
		});
		
		//boton +
		JButton btnMas = new JButton("+");
		btnMas.setBounds(238, 107, 76, 51);
		btnMas.setBackground(new Color(240, 240, 240));
		btnMas.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnMas);
		btnMas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setOperando(_jtf1,_jtf2,"+");
			}
		});
		
		//boton -
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(238, 158, 76, 51);
		btnMenos.setBackground(new Color(240, 240, 240));
		btnMenos.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnMenos);
		btnMenos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setOperando(_jtf1,_jtf2,"-");
			}
		});
		
		//boton Dividido
		JButton btnDividido = new JButton("/");
		btnDividido.setBounds(238, 209, 76, 51);
		btnDividido.setBackground(new Color(240, 240, 240));
		btnDividido.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnDividido);
		btnDividido.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setOperando(_jtf1,_jtf2,"/");
			}
		});
		
		//boton Multiplicado
		JButton btnPor = new JButton("X");
		btnPor.setBounds(238, 260, 76, 51);
		btnPor.setBackground(new Color(240, 240, 240));
		btnPor.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnPor);
		btnPor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setOperando(_jtf1,_jtf2,"*");
			}
		});
		
		//boton coma
		JButton btnComa = new JButton(".");
		btnComa.setBounds(86, 260, 76, 51);
		btnComa.setBackground(new Color(240, 240, 240));
		btnComa.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnComa);
		btnComa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ingresarComa(_jtf2);
			}
		});
		
		//boton Igual
		JButton btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIgual.setBounds(314, 209, 76, 102);
		_frmCalculadora.getContentPane().add(btnIgual);
		btnIgual.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				presionarIgual(_jtf1,_jtf2);
			}
		});

		//boton MC
		JButton btnMc = new JButton("MC");
		btnMc.setBounds(10, 80, 76, 26);
		btnMc.setBackground(new Color(240, 240, 240));
		btnMc.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnMc);
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton MR
		JButton btnMr = new JButton("MR");
		btnMr.setBounds(86, 80, 76, 26);
		btnMr.setBackground(new Color(240, 240, 240));
		btnMr.setFont(new Font("Arial", Font.BOLD, 14));
		_frmCalculadora.getContentPane().add(btnMr);
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		//boton MS
		JButton btnMs = new JButton("MS");
		btnMs.setFont(new Font("Arial", Font.BOLD, 14));
		btnMs.setBackground(SystemColor.menu);
		btnMs.setBounds(162, 80, 76, 26);
		_frmCalculadora.getContentPane().add(btnMs);
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton M-
		JButton btnMMenos = new JButton("M-");
		btnMMenos.setFont(new Font("Arial", Font.BOLD, 14));
		btnMMenos.setBackground(SystemColor.menu);
		btnMMenos.setBounds(314, 80, 76, 26);
		_frmCalculadora.getContentPane().add(btnMMenos);
		btnMMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton M+
		JButton btnMMas = new JButton("M+");
		btnMMas.setFont(new Font("Arial", Font.BOLD, 14));
		btnMMas.setBackground(SystemColor.menu);
		btnMMas.setBounds(238, 80, 76, 26);
		_frmCalculadora.getContentPane().add(btnMMas);
		btnMMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//boton Clear
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.BOLD, 14));
		btnC.setBackground(SystemColor.menu);
		btnC.setBounds(314, 107, 76, 51);
		_frmCalculadora.getContentPane().add(btnC);
		btnC.setForeground(Color.RED);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_calcu.limpiarCalculadora();
				_jtf1.setText("");
				_jtf2.setText("");
			}
		});
		
		//boton R
		JButton btnR = new JButton("R");
		btnR.setFont(new Font("Arial", Font.BOLD, 14));
		btnR.setBackground(SystemColor.menu);
		btnR.setBounds(314, 158, 76, 51);
		_frmCalculadora.getContentPane().add(btnR);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
	}
	
	public String getOperandoActual() 
	{
		return _operandoActual;
	}
	
	//se ultiliza para cambiar el numero solo en pantalla
	public void setNumero(JTextField arriba, JTextField abajo, String value)
	{
		_ingresandoNumero=true;
		//si termino de ingresar el operador o hay un 0 en jtf2
		if((_ingresandoOperador==true || abajo.getText().equals("0")) && _estaResultado==false)
		{
			_ingresandoOperador=false;
			abajo.setText(value);
		}
		//si termino de presionar igual y esta el resultado en pantalla
		else if(_estaResultado==true)
		{
			_ingresandoOperador=false;
			_calcu.limpiarCalculadora();
			arriba.setText("");
			abajo.setText(value);
			_estaResultado=false;
		}
		//sino siguie ingresando mas digitos al numero
		else
		{
			_ingresandoOperador=false;
			abajo.setText(abajo.getText()+value);
		}
	}

	//cuando aprento para calcular agrego el numero previo que estaba ingresando y seteo el operador
	public void setOperando(JTextField arriba,JTextField abajo ,String operandoActual) 
	{
		_ingresandoOperador=true;
		//si el resultado esta en pantalla y apreto un operador opero con el
		if(_estaResultado==true)
		{
			String totalParcial = abajo.getText();
			_calcu.limpiarCalculadora();
			_calcu.agregarNumero(totalParcial);
			_calcu.agregarOperando(operandoActual);
			arriba.setText(_calcu.toString());
			_estaResultado=false;
			_ingresandoNumero = false;
			
		}
		//si no esta el resultado opero normal
		else
		{
			if(_ingresandoNumero==true)
			{
				_calcu.agregarNumero(abajo.getText());
				_ingresandoNumero=false;
			}
			_operandoActual = operandoActual;
			_calcu.calcularTotal();
			_calcu.agregarOperando(operandoActual);
			arriba.setText(_calcu.toString());
			abajo.setText(_calcu.getTotal());
		}
	}
	
	private void ingresarComa(JTextField abajo) 
	{
		if(_ingresoComa==false || _estaResultado==false)
		{
			abajo.setText(abajo.getText()+".");
			_ingresoComa = true;
		}
	}
	
	private void presionarIgual(JTextField arriba, JTextField abajo) 
	{
		//solo hago eso si no esta el resultado en pantalla
		if(_estaResultado==false && _ingresandoOperador==false)
		{
			_calcu.agregarNumero(abajo.getText());
			_calcu.calcularTotal();
			arriba.setText(_calcu.toString());
			abajo.setText(_calcu.getTotal());
			_estaResultado=true;
			_ingresandoNumero=false;
		}
		else
		{
			_calcu.calcularTotal();
			arriba.setText(_calcu.toString());
			abajo.setText(_calcu.getTotal());
		}
	}
}
