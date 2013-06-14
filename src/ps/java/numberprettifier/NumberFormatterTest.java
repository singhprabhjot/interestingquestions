package ps.java.numberprettifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatterTest {
	NumberFormatter numberFormatter = new NumberFormatter();
	@Test
	public void test() {
		
		//test single digit results
		assertEquals("1M", numberFormatter.numberPrettifier(1000000));
		
		//test double digit results
		assertEquals("10M", numberFormatter.numberPrettifier(10000000));
		
		//test multiple digit results
		assertEquals("100M", numberFormatter.numberPrettifier(100000000));
		
		//test higher value results
		assertEquals("1.1B", numberFormatter.numberPrettifier(1123456789));
		
		//test roundoff 
		assertEquals("2.6M", numberFormatter.numberPrettifier(2550000));
		
		//test roundoff with decimal
		assertEquals("2.6M", numberFormatter.numberPrettifier(2550000.34));
		
		//test special case when round off comes to zero 
		assertEquals("2M", numberFormatter.numberPrettifier(2000000.34));
		
		//test value under million
		assertEquals("532", numberFormatter.numberPrettifier(532));
		
		//test value over quadrillion
		assertEquals("1000T", numberFormatter.numberPrettifier(1000000000000000d));		

		//test 0 case
		assertEquals("0", numberFormatter.numberPrettifier(0));
		
		//test negative case
		assertEquals("Invalid Number", numberFormatter.numberPrettifier(-50));		
	}
	
	@Test
	public void testValueBeforeDecimal(){
		assertEquals(1, numberFormatter.getWholeNumberDigits(1000000, 1000000));
		assertEquals(10, numberFormatter.getWholeNumberDigits(10000000, 1000000));
		assertEquals(100, numberFormatter.getWholeNumberDigits(100000000, 1000000));
	}
	
	@Test
	public void testValueAfterDecimal(){
		assertEquals("", numberFormatter.getDecimalRepresentation(1000000, 1000000));
		assertEquals(".2", numberFormatter.getDecimalRepresentation(1200000, 1000000));
		assertEquals(".3", numberFormatter.getDecimalRepresentation(1250000, 1000000));
	}
	
//	@Test
//	public void testSuffix(){
//		assertEquals("", numberFormatter.getSuffix(10));
//		assertEquals("M", numberFormatter.getSuffix(1000000));
//		assertEquals("M", numberFormatter.getSuffix(100000000));
//		assertEquals("B", numberFormatter.getSuffix(1000000000));
//		assertEquals("T", numberFormatter.getSuffix(1000000000000));
//	}
	
	@Test
	public void testNumberFormatter(){
		assertEquals("1M", numberFormatter.formatMaker(1000000,1000000,'M'));
		assertEquals("10M", numberFormatter.formatMaker(10000000,1000000,'M'));
		assertEquals("100M", numberFormatter.formatMaker(100000000,1000000,'M'));
		assertEquals("1.1M", numberFormatter.formatMaker(1100000,1000000,'M'));
	}

}
