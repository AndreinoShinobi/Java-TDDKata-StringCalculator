package calculator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber(){
        assertEquals(5, Calculator.add("5"));
    }

    @Test
    public void shouldReturnSumOnNumbersSeparatedByComma(){
        assertEquals(5, Calculator.add("2,3"));
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void acceptNewLineAsDelimiter(){
        assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void changeDelimiterPattern() {
        assertEquals(6, Calculator.add("//;\n1;2;3"));
    }

}