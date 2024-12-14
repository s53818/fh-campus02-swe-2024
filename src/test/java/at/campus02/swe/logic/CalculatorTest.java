package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }





    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }
    }

    @Test
    public void testModuloByZero() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        try
        {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");
        }
        catch (CalculatorException e)
        {
            assertEquals("Modulo by zero", e.getMessage());
        }
    }

    @Test
    public void testSimpleModuloCalculation() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        calc.push(6);
        calc.push(4);
        double result = calc.perform(Operation.mod);

        assertEquals(2, result, 0);
    }

    @Test
    public void testSinOne() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        calc.push(90);
        double result = calc.perform(Operation.sin);
        assertEquals(1, result, 0);
    }

    @Test
    public void testSinNull() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        calc.push(180);
        double result = calc.perform(Operation.sin);
        assertEquals(0, result, 0.0000001);
    }

    @Test
    public void testCosOne() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        calc.push(0);
        double result = calc.perform(Operation.cos);
        assertEquals(1, result, 0);
    }

    @Test
    public void testCosNull() throws Exception
    {
        Calculator calc = new CalculatorImpl();
        calc.push(90);
        double result = calc.perform(Operation.cos);
        assertEquals(0, result, 0.0000001);
    }
}