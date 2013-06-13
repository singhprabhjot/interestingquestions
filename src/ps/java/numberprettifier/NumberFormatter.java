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

public class NumberFormatter {
	
	final long million = 1000000L;
	final long billion = 1000000000L;
	final long trillion = 1000000000000L;
	final int noOfDecimalPlaces = 1;
	
	public String numberPrettifier (double inputNumber) {
		String prettiedNumber;
		if (inputNumber < 0) {
			return "Invalid Number";
		}
		
		if (inputNumber < million){
			prettiedNumber = formatNumber (inputNumber , 1, ' ');
		}
		else if (inputNumber < billion){
			prettiedNumber = formatNumber (inputNumber , million, 'M');
		} 
		else if (inputNumber < trillion ){
			prettiedNumber = formatNumber (inputNumber , billion, 'B');
		}
		else {
			prettiedNumber = formatNumber (inputNumber , trillion, 'T');
		}
		
		return prettiedNumber;

	}

	// Return number in form of prettified string.
	private String formatNumber(double inputNumber, long divisor, char suffix ){
		StringBuilder prettyNumber = new StringBuilder();
		
		int wholeNumberDigits = getWholeNumberDigits(inputNumber, divisor);
		prettyNumber.append(wholeNumberDigits);
		
		String decimalRepresentation = getDecimalRepresentation(inputNumber, divisor);
		prettyNumber.append(decimalRepresentation);

		prettyNumber.append(suffix);

		return prettyNumber.toString().trim();
		
	} 
	
	//Returns the digits prior to decimal value
	private int getWholeNumberDigits(double inputNumber, long divisor){
		int wholeNumberDigits = (int) (inputNumber/divisor);
		return wholeNumberDigits;
	}
	
	// Returns decimal and digits after that. 
	private String getDecimalRepresentation(double inputNumber, long divisor){
		double remainder = inputNumber % divisor;
		if (remainder != 0){
			remainder = (remainder / divisor);
			int decimalDigit=(int) Math.round(remainder * 10 * noOfDecimalPlaces);
			
			// Special case when after round off result comes to 0;
			if (decimalDigit == 0){
				return "";
			}
			
			return "." + decimalDigit;		
		}	
		return "";
	}
	
}
