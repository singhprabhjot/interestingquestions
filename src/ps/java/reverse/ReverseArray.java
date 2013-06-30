package ps.java.reverse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseArray {
	 Set<Character> vowelSet;
	 
	 public ReverseArray(){
		 vowelSet = getVowelSet();
	 }
	 
	 public char[] reverseCharArray(char[] inputArray){

		 if(inputArray == null ) {
			 return inputArray;
		 }

		int charArrayLength = inputArray.length;		
		for (int i = 0; i < charArrayLength/2; i++) {
			char charToSwap = getCharWithRequiredCase(inputArray[i]);
			char charToSwapWith = getCharWithRequiredCase(inputArray[charArrayLength-i-1]);
			swapCharacter(charToSwap, charToSwapWith , i, inputArray);
		}
		
		// change case of center element in case the of old no of elements
		if (charArrayLength % 2 != 0){
			int indexOfMiddleElement = charArrayLength/2;
			char charWithCase = getCharWithRequiredCase(inputArray[indexOfMiddleElement]);
			setCharacterInArray(inputArray, charWithCase, indexOfMiddleElement);
		}
		
		return inputArray;
	 } 

	private void swapCharacter(char charToSwap, char charToSwapWith,
			int indexofCharToSwap, char[] inputArray) {
		setCharacterInArray(inputArray, charToSwapWith,indexofCharToSwap);	
		int indexOfCharToSwapWith = inputArray.length - indexofCharToSwap -1;
		setCharacterInArray(inputArray, charToSwap,indexOfCharToSwapWith);		
	}

	private void setCharacterInArray(char[] inputArray, char charToSet, int indexofChar) {
		inputArray[indexofChar] = charToSet;
	}

	private char getCharWithRequiredCase(char c) {
		boolean isVowel = checkForVowel(c);
		if (isVowel){
			c = Character.toUpperCase(c);
		}
		else {
			c = Character.toLowerCase(c);
		}
		return c;
	}

	
	private boolean checkForVowel(char c) {
		if (vowelSet.contains(c)){
			return true;
		}
		return false;
	}

	private Set<Character> getVowelSet() {
		 Set<Character> vowelSet  = new HashSet<Character>(10);
		 vowelSet.add('a');
		 vowelSet.add('e');
		 vowelSet.add('i');
		 vowelSet.add('o');
		 vowelSet.add('u');
		 vowelSet.add('A');
		 vowelSet.add('E');
		 vowelSet.add('I');
		 vowelSet.add('O');
		 vowelSet.add('U');
		return vowelSet;
	}
	
	public void hi(){
		List<String> abc= new ArrayList();
		
	}
}
