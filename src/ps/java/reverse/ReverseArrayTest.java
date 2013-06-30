package ps.java.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseArrayTest {

	ReverseArray reverseArray = new ReverseArray();
	
	@Test
	public void testAllUpperCase(){
		char inputArray[] = {'A','B','C','D','E'};
		char[] resultArray ={'E','d','c','b','A'};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testAllLowerCase(){
		char inputArray[] = {'a','b','c','d','e'};
		char[] resultArray ={'E','d','c','b','A'};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testMixCaseElements(){
		char inputArray[] = {'a','B','C','d','e'};
		char[] resultArray ={'E','d','c','b','A'};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testOddNumberOfElements(){
		char inputArray[] = {'a','b','C','d','e'};
		char[] resultArray ={'E','d','c','b','A'};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testEvenNumberOfElements(){
		char inputArray[] = {'a','b','C','d','e','F'};
		char[] resultArray ={'f','E','d','c','b','A'};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testNullArray(){
		char inputArray[] = null;
		char[] resultArray = null;
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
	
	@Test
	public void testEmptyArray(){
		char inputArray[] = {};
		char[] resultArray ={};
		assertArrayEquals(resultArray, reverseArray.reverseCharArray(inputArray));
	}
}
