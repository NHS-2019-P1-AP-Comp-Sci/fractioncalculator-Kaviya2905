/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args){
        // TODO: Read the input from the user and call produceAnswer with an equation
    	String fraction = "";
    	while (!fraction.equals("quit")) {
    		Scanner userInput = new Scanner(System.in);
    		System.out.println("Enter a fraction expression");
    		fraction = userInput.nextLine();
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
    	//declaring variables to separate first term, second term and operator. 
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
    	if(space == -1) {
    		return "ERROR: Input is in an invalid format";
    	}
    	lastNumStart = space + 3;   	
    	firstNumEnd = space;
    	operatorIndex = input.indexOf(" ") + 1;
    	
    	// separated operator, first term and second term
    	operator = input.substring(operatorIndex, (operatorIndex + 1));
    	firstNumber = input.substring(0, firstNumEnd);
    	lastNumber = input.substring(lastNumStart, end);
    	
    	
    	//FIRST TERM SEPERATION
    	//Separating first term into numerator, denominator and wholeNumber 
    	String firstWholeNumberStr = "";
    	int firstWholeNumberInt = 0;
    	int firstNumUnderScore = firstNumber.indexOf("_");
    	int firstNumSlash = firstNumber.indexOf("/");
    	
    	if (firstNumUnderScore == -1 && firstNumSlash == -1) {
    		firstWholeNumberStr = firstNumber;
    		firstWholeNumberInt = Integer.parseInt(firstWholeNumberStr);
    	}
    	else if (firstNumUnderScore == -1 && firstNumSlash != -1) {
    		firstWholeNumberStr = "0";
    		firstWholeNumberInt = Integer.parseInt(firstWholeNumberStr);
    	}
    	else {
    		firstWholeNumberStr = firstNumber.substring(0, firstNumber.indexOf("_"));
    		firstWholeNumberInt = Integer.parseInt(firstWholeNumberStr);
    	}
    	
    	String firstNumNumeratorStr= "";
    	int firstNumNumeratorInt = 0;
    	if (firstNumSlash == -1) {
    		firstNumNumeratorStr = "0";
    		firstNumNumeratorInt = 0;
    	}
    	if (firstNumSlash != -1 && firstNumUnderScore == -1) {
    		firstNumNumeratorStr = firstNumber.substring(0, firstNumber.indexOf("/"));
    		firstNumNumeratorInt = Integer.parseInt(firstNumNumeratorStr);
    	}
    	else if(firstNumSlash != -1 && firstNumUnderScore != -1){
    		firstNumNumeratorStr = firstNumber.substring(firstNumber.indexOf("_") + 1, firstNumber.indexOf("/"));
    		firstNumNumeratorInt = Integer.parseInt(firstNumNumeratorStr);
    	}
    	
    	String firstNumDenominatorStr= "";
    	int firstNumDenominatorInt = 0;
    	if ( firstNumSlash == -1) {
    		firstNumDenominatorStr = "1";
    		firstNumDenominatorInt = Integer.parseInt(firstNumDenominatorStr);
    	}
    	else {
    		firstNumDenominatorStr = firstNumber.substring(firstNumber.indexOf("/")+ 1);
    		firstNumDenominatorInt = Integer.parseInt(firstNumDenominatorStr);
    	} 	
    	// converting from mixed to normal fraction 
    	if (firstWholeNumberInt >= 0) {
    		firstNumNumeratorInt = (firstNumDenominatorInt * firstWholeNumberInt) + firstNumNumeratorInt;
    	}
    	else if(firstWholeNumberInt < 0) {
    		firstNumNumeratorInt = ((Math.abs(firstNumDenominatorInt * firstWholeNumberInt)) + firstNumNumeratorInt) * -1;
    	}
    	
    	
    	/*
    	 * Notes: 
    	 * firstNumNumeratorInt: First term's Numerator
    	 * firstNumDenominatorInt: First term's denominator 
    	 * firstWholeNumberint: First term's Whole Number
    	 */
    	
    	
    	// SECOND TERM SEPERATION 
    	String SecondNumWholeNumberStr = "";
    	int SecondNumWholeNumberInt= 0;
    	int SecondNumUnderScore = lastNumber.indexOf("_");
    	int SecondNumSlash = lastNumber.indexOf("/");
    	if (SecondNumUnderScore == -1 && SecondNumSlash == -1) {
    		SecondNumWholeNumberStr = lastNumber;
    		SecondNumWholeNumberInt = Integer.parseInt(SecondNumWholeNumberStr);
    	}
    	else if (SecondNumUnderScore == -1 && SecondNumSlash != -1) {
    		SecondNumWholeNumberStr = "0";
    		SecondNumWholeNumberInt = Integer.parseInt(SecondNumWholeNumberStr);
    	}
    	else {
    		SecondNumWholeNumberStr = lastNumber.substring(0, lastNumber.indexOf("_"));
    		SecondNumWholeNumberInt = Integer.parseInt(SecondNumWholeNumberStr);
    	}
    	
    	String SecondNumNumeratorStr = "";
    	int SecondNumNumeratorInt = 0;
    	if (SecondNumSlash == -1) {
    		SecondNumNumeratorStr = "0";
    		SecondNumNumeratorInt = 0;
    	}
    	if (SecondNumSlash != -1 && SecondNumUnderScore == -1) {
    		SecondNumNumeratorStr = lastNumber.substring(0, lastNumber.indexOf("/"));
    		SecondNumNumeratorInt = Integer.parseInt(SecondNumNumeratorStr);
    	}
    	else if(SecondNumSlash != -1 && SecondNumUnderScore != -1){
    		SecondNumNumeratorStr = lastNumber.substring(lastNumber.indexOf("_") + 1, lastNumber.indexOf("/"));
    		SecondNumNumeratorInt = Integer.parseInt(SecondNumNumeratorStr);
    	}
    	
    	String SecondNumDenominatorStr = "";
    	int SecondNumDenominatorInt = 1;
    	if (SecondNumSlash == -1) {
    		SecondNumDenominatorStr = "1";
    		SecondNumDenominatorInt = Integer.parseInt(SecondNumDenominatorStr);
    	}
    	else {
    		SecondNumDenominatorStr = lastNumber.substring(lastNumber.indexOf("/")+ 1);
    		SecondNumDenominatorInt = Integer.parseInt(SecondNumDenominatorStr);
    	}
    	
    	// converting from mixed fraction to normal fraction 
    	if (SecondNumWholeNumberInt >= 0) {
    		SecondNumNumeratorInt = (SecondNumDenominatorInt * SecondNumWholeNumberInt) + SecondNumNumeratorInt;
    	}
    	else if(SecondNumWholeNumberInt < 0) {
    		SecondNumNumeratorInt = ((Math.abs(SecondNumDenominatorInt * SecondNumWholeNumberInt)) + SecondNumNumeratorInt) * -1;
    	}   	
    	
    	

    	/*
    	 * Notes: 
    	 * SecondNumNumeratorInt: Second term's numerator
    	 * SecondNumWholeNumberInt = Second term's whole number 
    	 * SecondNumDenominatorInt = Second term's denominator 
    	 */
    	
    	
    	
    	//CALCULATIONS
    	
    	String answer = "";
    	
    	//Extra credit? 
    	if(firstNumDenominatorInt == 0 || SecondNumDenominatorInt == 0) {
    		answer = "ERROR: Cannot divide by zero";
    		return answer;
    	}
    	
    	int intAnsNumerator = 0;
    	int intAnsDenominator = 0; 
    	
    	// multiplication 
    	if(operator.equals("*")) {	    	
    			intAnsNumerator = firstNumNumeratorInt * SecondNumNumeratorInt;   	
    			intAnsDenominator = firstNumDenominatorInt * SecondNumDenominatorInt;   		
    	}
    	
    	// division 
    	else if(operator.contentEquals("/")) {
    		intAnsNumerator = 0;
		    intAnsNumerator = firstNumNumeratorInt * SecondNumDenominatorInt;
		    intAnsDenominator = firstNumDenominatorInt * SecondNumNumeratorInt;
		       		
    		
    	}
    	
    	//addition 
    	
    	else if(operator.equals("+") || operator.equals("-")) {
    		intAnsDenominator = firstNumDenominatorInt * SecondNumDenominatorInt;
    		firstNumNumeratorInt =  firstNumNumeratorInt * SecondNumDenominatorInt;
    		SecondNumNumeratorInt = SecondNumNumeratorInt * firstNumDenominatorInt;
    		if(operator.equals("+")) {
    			intAnsNumerator = firstNumNumeratorInt + SecondNumNumeratorInt;
    			
    		}
    		else if(operator.equals("-")) {
    			intAnsNumerator = firstNumNumeratorInt - SecondNumNumeratorInt;
    		}
    	}
    	 
    	
    	//REDUCING ANSWER   	
    	int intAnsNumeratorAbs = Math.abs(intAnsNumerator);
    	int intAnsDenominatorAbs = Math.abs(intAnsDenominator);	
    	
    	// finding if negative of positive 
    	String ansSign = "";
    	if(intAnsNumerator < 0 && intAnsDenominator < 0 ) {
    		ansSign = "";
    	}
    	else if(intAnsNumerator < 0 || intAnsDenominator < 0) {
    		ansSign = "-";
    	}
    	
    	
    	// if simple divisible to give a whole number. example: 6/3 = 2
    	if(intAnsNumeratorAbs % intAnsDenominatorAbs == 0) {
    		int ans = intAnsNumeratorAbs / intAnsDenominatorAbs;
    		answer = "" + ans;
    	}
    	
    	// reducing answer using GCF
    	else if(intAnsNumeratorAbs < intAnsDenominatorAbs) {
    		for(int i = intAnsNumeratorAbs; i > 0; i-- ) {
    			if(intAnsNumeratorAbs % i == 0 && intAnsDenominatorAbs % i == 0) {
    			
	    			intAnsNumeratorAbs /= i;
	    	    	intAnsDenominatorAbs /= i;
    			}
    		}
    		answer = intAnsNumeratorAbs + "/" + intAnsDenominatorAbs;
    	}
    	//reducing answer and converting into mixed fraction
    	else if(intAnsNumeratorAbs > intAnsDenominatorAbs) {
    		for(int i = intAnsDenominatorAbs; i > 0; i-- ) {
    			if(intAnsNumeratorAbs % i == 0 && intAnsDenominatorAbs % i == 0) {
    			
	    			intAnsNumeratorAbs /= i;
	    	    	intAnsDenominatorAbs /= i;
    			}
    		}
    		int intAnsWholeNum = 0;
    		intAnsWholeNum = intAnsNumeratorAbs / intAnsDenominatorAbs;
    		intAnsNumeratorAbs = Math.abs(intAnsNumeratorAbs % intAnsDenominatorAbs);
    		answer = intAnsWholeNum + "_" + intAnsNumeratorAbs + "/" + intAnsDenominatorAbs;
    	}
    
    	// assigning answer to correct sign 
    	answer = ansSign + answer;
    	
    	if (answer.equals("-0")) {
    		answer = "0";
    	}

    	return answer;
    	 
    	
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
}


    
 








