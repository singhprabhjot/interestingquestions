package ps.java.numberprettifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatterTest {

	@Test
	public void test() {
NumberFormatter numberFormatter = new NumberFormatter();
		
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

}
