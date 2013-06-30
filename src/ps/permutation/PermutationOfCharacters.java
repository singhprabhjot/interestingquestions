
package ps.permutation;
public class PermutationOfCharacters {
	public static void main(String args[]){
		permutation("","abcd");
	}

		 private static void permutation(String prefix, String str) {
		    int lengthOfString = str.length();
		    if (lengthOfString == 0) System.out.println(prefix);
		    else {
		        for (int i = 0; i < lengthOfString; i++){
//		           printValues(i,lengthOfString,prefix,str);
		           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, lengthOfString));
		         }
		    }

		}
		 
/*
		private static void printValues(int i, int lengthOfString, String prefix, String str) {
        	System.out.println("Substring(0,"+lengthOfString+")  :"+ str.substring(0, lengthOfString));
        	System.out.println("i:"+i+"  0-i: "+str.substring(0, i));
        	System.out.println("i+1, lengthOfString: " +str.substring(i+1,lengthOfString));
        	System.out.println("Prefix: "+prefix + str.charAt(i));		
		}
*/	
}