package at.campus02.swe.E2E;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class E2ETest {

    @Test
    public void testE2EModulo () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test04.xml"));

        assertEquals(2, result, 0);
    }

    @Test
    public void testE2EAdd () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test01.xml"));

        assertEquals(3, result, 0);
    }

    @Test
    public void testE2ESin () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test05.xml"));

        assertEquals(1, result, 0);
    }

    @Test
    public void testE2ECos () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test06.xml"));

        assertEquals(1, result, 0);
    }

    @Test
    public void testDotProductPostive1 () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test07.xml"));

        assertEquals(52, result, 0);
    }


    @Test
    public void testDotProductPostive2 () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test08.xml"));

        assertEquals(57, result, 0);
    }
    

    @Test(expected = CalculatorException.class)
    public void testDotProductNegative () throws CalculatorException, XMLStreamException, FileNotFoundException
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test09.xml"));

    }

}
