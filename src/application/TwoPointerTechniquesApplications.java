package application;

import java.util.Arrays;

public class TwoPointerTechniquesApplications {
	
	/** 
	 *  1. Finding if an array of integers consists a pair of integers which sums up to our test value "n"
	 */
	public boolean doesAPairOfIntegerExist(int [] testArray, int n) {
		int forwardPointer = 0;
		int backwardPointer = testArray.length-1;
		
		Arrays.parallelSort(testArray);
		
		while (forwardPointer<backwardPointer) {
			if (n == testArray[forwardPointer]+ testArray[backwardPointer]) {
				return true;
			}
			else if(n > (testArray[forwardPointer]+ testArray[backwardPointer]) ) {
				forwardPointer++;
			}
			else {
				backwardPointer--;
			}
		}
		return false;
	}
}
