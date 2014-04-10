package tests;

import static org.junit.Assert.*;

import negocio.ItemACalcular;

import org.junit.Test;

public class test_ItemACalcular 
{

	@Test
	public void testearConstructor() 
	{
		//testeo que cuando instancio el item inicio sus variables en 0
		ItemACalcular i = new ItemACalcular();
		
		assertEquals(0.0 , i.getPrimerNumero(),0);
		assertEquals(0.0 , i.getSegundoNumero(),0);
		assertEquals("+", i.getOperador());
		assertEquals(0.0 , i.getResultParcial(),0);
		
	}
	
	@Test
	public void testearSuma()
	{
		ItemACalcular i = new ItemACalcular();
		i.setPrimerNumero(40.4);
		i.setSegundoNumero(5.4);
		i.setOperador("+");
		i.calcularParcial();
		
		assertEquals(45.8, i.getResultParcial(), 45.8 );
		
		i.setPrimerNumero(15);
		i.setSegundoNumero(2);
		i.calcularParcial();
		
		assertEquals(17, i.getResultParcial(), 17);
	}
	
	@Test
	public void testearResta()
	{
		ItemACalcular i = new ItemACalcular();
		i.setPrimerNumero(40);
		i.setSegundoNumero(55);
		i.setOperador("-");
		i.calcularParcial();
		
		assertEquals(-15,i.getResultParcial(),-15);
		
		i.setPrimerNumero(2.435);
		i.setSegundoNumero(2);
		i.calcularParcial();
		
		assertEquals(0.435,i.getResultParcial(),0.435);
	}
	
	@Test
	public void testearMultiplicacion()
	{
		ItemACalcular i = new ItemACalcular();
		i.setPrimerNumero(4);
		i.setSegundoNumero(10);
		i.setOperador("*");
		i.calcularParcial();
		
		assertEquals(40,i.getResultParcial(),40);
		
		i.setPrimerNumero(2.5);
		i.setSegundoNumero(2);
		i.calcularParcial();
		
		assertEquals(5,i.getResultParcial(),5);
	}
	
	@Test
	public void testearDivisionComun()
	{
		ItemACalcular i = new ItemACalcular();
		i.setPrimerNumero(5);
		i.setSegundoNumero(2);
		i.setOperador("/");
		i.calcularParcial();
		
		assertEquals(2.5, i.getResultParcial(),2.5);
	}
	
	
	@Test(expected = Exception.class)
	public void testearDivisionPor0()
	{
		ItemACalcular i = new ItemACalcular();

		
		i.setPrimerNumero(5);
		i.setSegundoNumero(0);
		i.setOperador("/");
		i.calcularParcial();
		
		assertEquals("la division no puede ser por 0", i.getResultParcial());
		
	}

}
