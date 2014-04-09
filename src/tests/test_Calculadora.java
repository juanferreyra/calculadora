package tests;

import static org.junit.Assert.*;
import negocio.Calculadora;

import org.junit.Test;

public class test_Calculadora {

	@Test
	public void testearConstructor()
	{
		Calculadora c = new Calculadora();
		
		c.agregarItem("1", "3", "+"); //1+3=4 parcial
		c.agregarItem("", "3", "-"); //4-3=1 parcial
		c.calcularTotal();
		
		assertEquals("1.0",c.getTotal());
		
	}

}
