package negocio;

import java.util.ArrayList;

public class Calculadora
{
	private ArrayList<ItemACalcular> _ingresado;
	private double _resultadoTotal;
	private ArrayList<ItemACalcular> _guardado;
	

	public Calculadora() 
	{
		_ingresado = new ArrayList<ItemACalcular>();
		ItemACalcular nuevo = new ItemACalcular();
		_ingresado.add(nuevo);
		setGuardado(new ArrayList<ItemACalcular>());
		_resultadoTotal = 0;
	}
	
	public void agregarNumero(String numero)
	{
		_ingresado.get(_ingresado.size()-1).setSegundoNumero(Double.parseDouble(numero));
		ItemACalcular nuevo = new ItemACalcular();
		_ingresado.add(nuevo);
	}
	
	public void agregarOperando(String operador)
	{
		_ingresado.get(_ingresado.size()-1).setOperador(operador);
	}
	
	public void calcularTotal()
	{
		for (int i = 0; i < _ingresado.size()-1; i++) 
		{
			_ingresado.get(i).calcularParcial();
			_resultadoTotal =_ingresado.get(i).getResultParcial();
			_ingresado.get(i+1).setPrimerNumero(_resultadoTotal);
		}
	}
	
	public String getTotal()
	{
		return Double.toString(_resultadoTotal);
	}
	
	public String toString()
	{
		String impresion = "";
		for (int i = 0; i < _ingresado.size(); i++) 
		{
			impresion+=_ingresado.get(i).toString();
		}
		return impresion;
	}
	
	@SuppressWarnings("unchecked")
	public void limpiarCalculadora()
	{
		setGuardado((ArrayList<ItemACalcular>) _ingresado.clone());
		_ingresado.clear();
		ItemACalcular nuevo = new ItemACalcular();
		_ingresado.add(nuevo);
	}
	
	public ArrayList<ItemACalcular> getGuardado() 
	{
		return _guardado;
	}

	public void setGuardado(ArrayList<ItemACalcular> _guardado) 
	{
		this._guardado = _guardado;
	}

	public static void main(String[] args) {
		
		Calculadora c = new Calculadora();
		
		c.agregarNumero("1");
		
		c.agregarOperando("+");
		
		c.agregarNumero("3");
		
		c.agregarOperando("-");
		
		c.agregarNumero("4");
		
		c.calcularTotal();
		
		System.out.println("calculadora llena: "+c.toString()+"= "+c.getTotal());
		
		c.limpiarCalculadora();
		
		System.out.println("calculadora limpia:"+c.toString());
		
		System.out.println("lo guardado:"+c.getGuardado().toString());
		
	}
	
	
	//ejemplo
//	public void mostrarNumero(JTextField cuadroTexto, String numeroApretado)  //Muestra los numeros en la pantalla.
//	{
//		if(estaTipeandoNumero)
//			cuadroTexto.setText(cuadroTexto.getText() + numeroApretado); //Concatena los digitos.
//		else
//			cuadroTexto.setText(numeroApretado); //Pone la pantalla en blanco para empezar a escribir otro numero.
//	}

}
