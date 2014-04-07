package negocio;

import java.util.ArrayList;

import javax.swing.JFrame;

import presentacion.MainCalculator;

public class calculadora
{
	private ArrayList<String> _numeros;
	private ArrayList<String> _operadores;
	private float resultParcial;

	public calculadora() 
	{
		_numeros = new ArrayList<String>();
		_operadores = new ArrayList<String>();
		resultParcial = 0;
	}
	
	public void agregarCalcular(ArrayList<String> numeros, ArrayList<String> operaciones ,String numero2)
	{
		
	}
	
	public void verResultParcial()
	{
		for (int i = 0; i < _numeros.size(); i++) {
			
		}
	}

}
