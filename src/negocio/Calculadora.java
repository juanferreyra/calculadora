package negocio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Calculadora
{
	private ArrayList<ItemACalcular> _ingresado;
	private double _resultadoTotal;

	public Calculadora() 
	{
		_ingresado = new ArrayList<ItemACalcular>();
		ItemACalcular nuevo = new ItemACalcular();
		_ingresado.add(nuevo);
		_resultadoTotal = 0;
	}
	
	public void agregarItem(String primerNumero, String segundoNumero, String operador)
	{
		if(_ingresado.size()==1)
		{
			_ingresado.get(0).setPrimerNumero(Double.parseDouble(primerNumero));
			_ingresado.get(0).setSegundoNumero(Double.parseDouble(segundoNumero));
			_ingresado.get(0).setOperador(operador);
		}
		else
		{
			int ultimo=  _ingresado.size()-1; 
			_ingresado.get(ultimo).setSegundoNumero(Double.parseDouble(segundoNumero));
			_ingresado.get(ultimo).setOperador(operador);
		}
		
		ItemACalcular nuevo = new ItemACalcular();
		_ingresado.add(nuevo);
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
		String impresion = Double.toString(_ingresado.get(0).getPrimerNumero());
		for (int i = 0; i < _ingresado.size(); i++) 
		{
			impresion+=_ingresado.get(i).toString();
		}
		return impresion;
	}
	
	public static void main(String[] args) {
Calculadora c = new Calculadora();
		
		c.agregarItem("1", "3", "+"); //1+3=4 parcial
		c.agregarItem("", "3", "-"); //4-3=1 parcial
		c.calcularTotal();
		
		System.out.println(c.toString()+"= "+c.getTotal());
	}

}
