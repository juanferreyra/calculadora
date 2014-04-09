package negocio;

public class ItemACalcular {

	private double _primerNumero;
	private double _segundoNumero;
	private String _operador;
	private double _resultadoItem;
	
	public ItemACalcular() 
	{
		_primerNumero = 0 ;
		_segundoNumero = 0 ;
		_operador = "";
		_resultadoItem =  0 ;
	}
	
	public void setPrimerNumero(double primerNumero)
	{
		_primerNumero = primerNumero;
	}
	
	public void setSegundoNumero(double segundoNumero)
	{
		_segundoNumero = segundoNumero;
	}
	
	public void setOperador(String operador)
	{
		_operador = operador;
	}
	
	public double getPrimerNumero() 
	{
		return _primerNumero;
	}

	public double getSegundoNumero() 
	{
		return _segundoNumero;
	}

	public String getOperador() 
	{
		return _operador;
	}
	
	public double getResultParcial() 
	{
		return _resultadoItem;
	}
	
	public void calcularParcial()
	{	
		
		if (_operador.equals("+"))
		{
			_resultadoItem = _primerNumero+_segundoNumero;
		}
		else if(_operador.equals("-"))
		{
			_resultadoItem = _primerNumero-_segundoNumero;
		}
		else if(_operador.equals("*"))
		{
			_resultadoItem = _primerNumero*_segundoNumero;
		}
		else if(_segundoNumero==0)
		{
			throw new NumberFormatException("la division no puede ser por 0");
		}
		else
		{
			_resultadoItem = _primerNumero/_segundoNumero;
		}
		
	}
	
	public String toString()
	{
		if(_segundoNumero==0)
			return " "+_operador+" ";
		else
			return " "+_operador+" "+_segundoNumero;
	}

}
