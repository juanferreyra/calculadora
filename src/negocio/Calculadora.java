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
	
//	public void agregarItem(String primerNumero, String segundoNumero, String operador)
//	{
//		if(_ingresado.size()==1)
//		{
//			_ingresado.get(0).setPrimerNumero(Double.parseDouble(primerNumero));
//			_ingresado.get(0).setSegundoNumero(Double.parseDouble(segundoNumero));
//			_ingresado.get(0).setOperador(operador);
//		}
//		else
//		{
//			int ultimo=  _ingresado.size()-1; 
//			_ingresado.get(ultimo).setSegundoNumero(Double.parseDouble(segundoNumero));
//			_ingresado.get(ultimo).setOperador(operador);
//		}
//		
//	}
	
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
		
		//c.agregarItem("1", "3", "+"); //1+3=4 parcial
		c.agregarNumero("1");
		c.agregarOperando("+");
		c.agregarNumero("3");
		c.agregarOperando("-");
		c.agregarNumero("4");
		
		//c.agregarItem("", "4", "-"); //4-3=1 parcial
		c.calcularTotal();
		
		System.out.println("calculadora llena: "+c.toString()+"= "+c.getTotal());
		
		
		System.out.println(c._ingresado.get(0).getResultParcial());
		//c.limpiarCalculadora();
		
		//System.out.println("calculadora limpia:"+c.toString());
		
		//System.out.println("lo guardado:"+c.getGuardado().toString());
		
	
		
	}

	
}
