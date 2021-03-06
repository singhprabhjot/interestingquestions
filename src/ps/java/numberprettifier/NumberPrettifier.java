package ps.java.numberprettifier;
/*
 * Write tested code (in any language) that accepts a numeric type and returns a truncated, "prettified" string version. 
 * The prettified version should include one number after the decimal when the truncated number is not an integer. 
 * It should prettify numbers greater than 6 digits and support millions, billions and trillions.
 * 
 * Examples:
  	input: 1000000
    output: 1M
 
    input: 2500000.34
    output: 2.5M
 
    input: 532
    output: 532
 
    input: 1123456789
    output: 1.1B 
 */

public class NumberPrettifier {
	
	final long million = 1000000L;
	final long billion = 1000000000L;
	final long trillion = 1000000000000L;
	final int noOfDecimalPlaces = 1;
	
	public String pretifyNumber (double inputNumber) {
		String prettiedNumber;
		if (inputNumber < 0) {
			return "Invalid Number";
		}
		
		if (inputNumber < million){
			prettiedNumber = formatMaker (inputNumber , 1, ' ');
		}
		else if (inputNumber < billion){
			prettiedNumber = formatMaker (inputNumber , million, 'M');
		} 
		else if (inputNumber < trillion ){
			prettiedNumber = formatMaker (inputNumber , billion, 'B');
		}
		else {
			prettiedNumber = formatMaker (inputNumber , trillion, 'T');
		}
		
		return prettiedNumber;

	}

	// Return String after formating the number.
	 String formatMaker(double inputNumber, long divisor, char suffix ){
		StringBuilder prettyNumber = new StringBuilder();
		
		int wholeNumberDigits = getWholeNumberDigits(inputNumber, divisor);
		prettyNumber.append(wholeNumberDigits);
		
		int decimalNumber = getDecimalNumbers(inputNumber, divisor);
		if (decimalNumber > 0){
			prettyNumber.append("." + decimalNumber);
		}
		
		prettyNumber.append(suffix);

		return prettyNumber.toString().trim();
		
	} 
	
	//Returns the digits prior to decimal value
	 int getWholeNumberDigits(double inputNumber, long divisor){
		int wholeNumberDigits = (int) (inputNumber/divisor);
		return wholeNumberDigits;
	}
	
	// Returns decimal and digits after that. 
	 int getDecimalNumbers(double inputNumber, long divisor){
		double remainder = inputNumber % divisor;
		if (remainder != 0){
			remainder = (remainder / divisor);
			int decimalDigit=(int) Math.round(remainder * 10 * noOfDecimalPlaces);			
			return decimalDigit;		
		}	
		return 0;
	}
}
