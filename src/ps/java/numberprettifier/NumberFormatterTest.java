package ps.java.numberprettifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatterTest {
	NumberPrettifier numberPrettifier = new NumberPrettifier();
	@Test
	public void test() {
		
		//test single digit results
		assertEquals("1M", numberPrettifier.pretifyNumber(1000000));
		
		//test double digit results
		assertEquals("10M", numberPrettifier.pretifyNumber(10000000));
		
		//test multiple digit results
		assertEquals("100M", numberPrettifier.pretifyNumber(100000000));
		
		//test higher value results
		assertEquals("1.1B", numberPrettifier.pretifyNumber(1123456789));
		
		//test roundoff 
		assertEquals("2.6M", numberPrettifier.pretifyNumber(2550000));
		
		//test roundoff with decimal
		assertEquals("2.6M", numberPrettifier.pretifyNumber(2550000.34));
		
		//test special case when round off comes to zero 
		assertEquals("2M", numberPrettifier.pretifyNumber(2000000.34));
		
		//test value under million
		assertEquals("532", numberPrettifier.pretifyNumber(532));
		
		//test value over quadrillion
		assertEquals("1000T", numberPrettifier.pretifyNumber(1000000000000000d));		

		//test 0 case
		assertEquals("0", numberPrettifier.pretifyNumber(0));
		
		//test negative case
		assertEquals("Invalid Number", numberPrettifier.pretifyNumber(-50));		
	}
	
	@Test
	public void testValueBeforeDecimal(){
		assertEquals(1, numberPrettifier.getWholeNumberDigits(1000000, 1000000));
		assertEquals(10, numberPrettifier.getWholeNumberDigits(10000000, 1000000));
		assertEquals(100, numberPrettifier.getWholeNumberDigits(100000000, 1000000));
	}
	
	@Test
	public void testValueAfterDecimal(){
		assertEquals(0, numberPrettifier.getDecimalNumbers(1000000, 1000000));
		assertEquals(2, numberPrettifier.getDecimalNumbers(1200000, 1000000));
		assertEquals(3, numberPrettifier.getDecimalNumbers(1250000, 1000000));
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
		assertEquals("1M", numberPrettifier.formatMaker(1000000,1000000,'M'));
		assertEquals("10M", numberPrettifier.formatMaker(10000000,1000000,'M'));
		assertEquals("100M", numberPrettifier.formatMaker(100000000,1000000,'M'));
		assertEquals("1.1M", numberPrettifier.formatMaker(1100000,1000000,'M'));
	}

}
