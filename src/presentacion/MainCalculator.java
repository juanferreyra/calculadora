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

public class MainCalculator {

	private JFrame frmCalculadora;
	private JTextField jtf1;
	private JTextField jtf2;
	private String operandoActual;
	private Boolean ingresoComa;
	private Calculadora calcu;
	private Double numero1;
	private Double numero2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCalculator window = new MainCalculator();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCalculator() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("No encuentro en look and feel");
			e.printStackTrace();
		}
		ingresoComa = false;
		setOperandoActual("");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calcu = new Calculadora();
		frmCalculadora = new JFrame();
		frmCalculadora.setResizable(false);
		frmCalculadora.setIconImage(Toolkit.getDefaultToolkit().getImage(MainCalculator.class.getResource("/img/calculator-icon.jpg")));
		frmCalculadora.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 409, 350);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		
		jtf1 = new JTextField("");
		jtf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jtf1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtf1.setHorizontalAlignment(SwingConstants.RIGHT);
		jtf1.setEditable(false);
		jtf1.setBorder(BorderFactory.createLineBorder(Color.white));
		jtf1.setBackground(Color.WHITE);
		jtf1.setBounds(10, 11, 380, 35);
		frmCalculadora.getContentPane().add(jtf1);
		
		jtf2 = new JTextField("0");
		jtf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtf2.setHorizontalAlignment(SwingConstants.RIGHT);
		jtf2.setEditable(false);
		jtf2.setBorder(BorderFactory.createLineBorder(Color.white));
		jtf2.setBackground(Color.WHITE);
		jtf2.setBounds(10, 38, 380, 35);
		frmCalculadora.getContentPane().add(jtf2);
		
		//boton Doble 0
		JButton btnDobleCero = new JButton("00");
		btnDobleCero.setBounds(162, 260, 76, 51);
		btnDobleCero.setBackground(new Color(240, 240, 240));
		btnDobleCero.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnDobleCero);
		btnDobleCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("00"));
			}
		});
		
		//boton 0
		JButton btnNum0 = new JButton("0");
		btnNum0.setBounds(10, 260, 76, 51);
		btnNum0.setBackground(new Color(240, 240, 240));
		btnNum0.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum0);
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("0"));
			}
		});
		
		//boton 1
		JButton btnNum1 = new JButton("1");
		btnNum1.setBounds(10, 209, 76, 51);
		btnNum1.setBackground(new Color(240, 240, 240));
		btnNum1.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum1);
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("1"));
			}
		});
		
		//boton 2
		JButton btnNum2 = new JButton("2");
		btnNum2.setBounds(86, 209, 76, 51);
		btnNum2.setBackground(new Color(240, 240, 240));
		btnNum2.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum2);
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("2"));
			}
		});
		
		//boton 3
		JButton btnNum3 = new JButton("3");
		btnNum3.setBounds(162, 209, 76, 51);
		btnNum3.setBackground(new Color(240, 240, 240));
		btnNum3.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum3);
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("3"));
			}
		});
		
		//boton 4
		JButton btnNum4 = new JButton("4");
		btnNum4.setBounds(10, 158, 76, 51);
		btnNum4.setBackground(new Color(240, 240, 240));
		btnNum4.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum4);
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("4"));
			}
		});
		
		//boton 5
		JButton btnNum5 = new JButton("5");
		btnNum5.setBounds(86, 158, 76, 51);
		btnNum5.setBackground(new Color(240, 240, 240));
		btnNum5.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum5);
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("5"));
			}
		});
		
		//boton 6
		JButton btnNum6 = new JButton("6");
		btnNum6.setBounds(162, 158, 76, 51);
		btnNum6.setBackground(new Color(240, 240, 240));
		btnNum6.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum6);
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("6"));
			}
		});
		
		//boton 7
		JButton btnNum7 = new JButton("7");
		btnNum7.setBounds(10, 107, 76, 51);
		btnNum7.setBackground(new Color(240, 240, 240));
		btnNum7.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum7);
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("7"));
			}
		});
		
		//boton 8
		JButton btnNum8 = new JButton("8");
		btnNum8.setBounds(86, 107, 76, 51);
		btnNum8.setBackground(new Color(240, 240, 240));
		btnNum8.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum8);
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf2.setText(setearNumero("8"));
			}
		});
		
		//boton 9
		JButton btnNum9 = new JButton("9");
		btnNum9.setBounds(162, 107, 76, 51);
		btnNum9.setBackground(new Color(240, 240, 240));
		btnNum9.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnNum9);
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf2.setText(setearNumero("9"));
			}
		});
		
		//boton +
		JButton btnMas = new JButton("+");
		btnMas.setBounds(238, 107, 76, 51);
		btnMas.setBackground(new Color(240, 240, 240));
		btnMas.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnMas);
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperandoActual("+");
			}
		});
		
		//boton -
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(238, 158, 76, 51);
		btnMenos.setBackground(new Color(240, 240, 240));
		btnMenos.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnMenos);
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperandoActual("-");
			}
		});
		
		//boton Dividido
		JButton btnDividido = new JButton("/");
		btnDividido.setBounds(238, 209, 76, 51);
		btnDividido.setBackground(new Color(240, 240, 240));
		btnDividido.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnDividido);
		btnDividido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperandoActual("/");
			}
		});
		
		//boton Multiplicado
		JButton btnPor = new JButton("X");
		btnPor.setBounds(238, 260, 76, 51);
		btnPor.setBackground(new Color(240, 240, 240));
		btnPor.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnPor);
		btnPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperandoActual("*");
			}
		});
		
		//boton coma
		JButton btnComa = new JButton(".");
		btnComa.setBounds(86, 260, 76, 51);
		btnComa.setBackground(new Color(240, 240, 240));
		btnComa.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnComa);
		btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ingresoComa==false)
				{
					jtf2.setText(jtf2.getText()+",");
					ingresoComa = true;
				}
			}
		});
		
		//boton Igual
		JButton btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIgual.setBounds(314, 209, 76, 102);
		frmCalculadora.getContentPane().add(btnIgual);
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		//boton MC
		JButton btnMc = new JButton("MC");
		btnMc.setBounds(10, 80, 76, 26);
		btnMc.setBackground(new Color(240, 240, 240));
		btnMc.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnMc);
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton MR
		JButton btnMr = new JButton("MR");
		btnMr.setBounds(86, 80, 76, 26);
		btnMr.setBackground(new Color(240, 240, 240));
		btnMr.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculadora.getContentPane().add(btnMr);
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		//boton MS
		JButton btnMs = new JButton("MS");
		btnMs.setFont(new Font("Arial", Font.BOLD, 14));
		btnMs.setBackground(SystemColor.menu);
		btnMs.setBounds(162, 80, 76, 26);
		frmCalculadora.getContentPane().add(btnMs);
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton M-
		JButton btnMMenos = new JButton("M-");
		btnMMenos.setFont(new Font("Arial", Font.BOLD, 14));
		btnMMenos.setBackground(SystemColor.menu);
		btnMMenos.setBounds(314, 80, 76, 26);
		frmCalculadora.getContentPane().add(btnMMenos);
		btnMMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//boton M+
		JButton btnMMas = new JButton("M+");
		btnMMas.setFont(new Font("Arial", Font.BOLD, 14));
		btnMMas.setBackground(SystemColor.menu);
		btnMMas.setBounds(238, 80, 76, 26);
		frmCalculadora.getContentPane().add(btnMMas);
		btnMMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//boton Clear
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.BOLD, 14));
		btnC.setBackground(SystemColor.menu);
		btnC.setBounds(314, 107, 76, 51);
		frmCalculadora.getContentPane().add(btnC);
		btnC.setForeground(Color.RED);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("");
				jtf2.setText("0");
			}
		});
		
		//boton R
		JButton btnR = new JButton("R");
		btnR.setFont(new Font("Arial", Font.BOLD, 14));
		btnR.setBackground(SystemColor.menu);
		btnR.setBounds(314, 158, 76, 51);
		frmCalculadora.getContentPane().add(btnR);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
	}
	
	public String setearNumero(String value)
	{
		if(jtf2.getText().equals("0"))
			return value;
		else
			return jtf2.getText()+value;
	}

	public String getOperandoActual() {
		return operandoActual;
	}

	public void setOperandoActual(String operandoActual) {
		this.operandoActual = operandoActual;
	}
}
