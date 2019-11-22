/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args){
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	//System.out.println("Enter a fraction experession");
    	//String fraction = userInput.nextLine();
    	
    	//System.out.println(produceAnswer(fraction));
    	String fraction = "";
    	while (!fraction.equals("quit")) {
    		Scanner userInput = new Scanner(System.in);
    		System.out.println("Enter a fraction experession");
    		fraction = userInput.nextLine();
    		//System.out.print(fraction);
    		if (!fraction.equals ("quit")) {
    			System.out.println(produceAnswer(fraction));
    		}
    		
    	}
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	int end;
    	int lastNumStart;
    	int space;
    	int firstNumEnd;
    	int operatorIndex;
    	String lastNumber;
    	String firstNumber;
    	String operator;
    	
    	end = input.length();
    	space = input.indexOf(" ");
    	lastNumStart = space + 3;   	
    	firstNumEnd = space;   	
    	operatorIndex = input.indexOf(" ") + 1;
    	
    	operator = input.substring(operatorIndex, (operatorIndex + 1));
    	firstNumber = input.substring(0, firstNumEnd);
    	lastNumber = input.substring(lastNumStart, end);
    	
    	return SecondOperand(lastNumber);
    	//return FirstOperand(firstNumber);
        //return lastNumber;
        
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String FirstOperand(String num) {
    	String WholeNumber = "";
    	int value1 = num.indexOf("_");
    	int value2 = num.indexOf("/");
    	if (value1 == -1 && value2 == -1) {
    		WholeNumber = num; 
    	}
    	else if (value1 == -1 && value2 != -1) {
    		WholeNumber = "0";
    	}
    	else {
    		WholeNumber = num.substring(0, num.indexOf("_"));
    	}
    	
    	String Numerator = "";
    	if (value2 == -1) {
    		Numerator = "0";
    	}
    	else if (value2 != -1 && value1 == -1) {
    		Numerator = num.substring(0, num.indexOf("/"));
    	}
    	else {
    		Numerator = num.substring(num.indexOf("_") + 1, num.indexOf("/"));
    	}
    	
    	String denominator = "";
    	if ( value2 == -1) {
    		denominator = "1";
    	}
    	else {
    		denominator = num.substring(num.indexOf("/")+ 1);
    	}
    	
    	
    	String FirstNumString = "whole:" + WholeNumber + " numerator:" + Numerator + " denominator:" + denominator;
    	return FirstNumString;
    }
    
    public static String SecondOperand(String num) {
    	String WholeNumber = "";
    	int value1 = num.indexOf("_");
    	int value2 = num.indexOf("/");
    	if (value1 == -1 && value2 == -1) {
    		WholeNumber = num; 
    	}
    	else if (value1 == -1 && value2 != -1) {
    		WholeNumber = "0";
    	}
    	else {
    		WholeNumber = num.substring(0, num.indexOf("_"));
    	}
    	
    	String Numerator = "";
    	if (value2 == -1) {
    		Numerator = "0";
    	}
    	else if (value2 != -1 && value1 == -1) {
    		Numerator = num.substring(0, num.indexOf("/"));
    	}
    	else {
    		Numerator = num.substring(num.indexOf("_") + 1, num.indexOf("/"));
    	}
    	
    	String denominator = "";
    	if ( value2 == -1) {
    		denominator = "1";
    	}
    	else {
    		denominator = num.substring(num.indexOf("/")+ 1);
    	}
    	
    	
    	String SecondNumString = "whole:" + WholeNumber + " numerator:" + Numerator + " denominator:" + denominator;
    	return SecondNumString;
    }
}








;