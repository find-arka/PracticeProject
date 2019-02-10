package application;

import java.util.Arrays;

public class TwoPointerTechniquesApplications {
	
	/**
	 * 1. Finding if an array of integers consists a pair of integers which sums up to our test value "n"
	 * @param testArray
	 * @param n
	 * @return
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
	
	/**
	 * 2. Shifting an array of integers to "n" number of steps
	 * @param arr
	 * @param n
	 * @return
	 */
	public int[] shiftArrayNstepsToTheRight(int arr[], int n ) {
		n %= (arr.length);
		reverse(arr,0,arr.length -1);
		reverse(arr,0,n-1);
		reverse(arr,n,arr.length-1);
		return arr;
	}
	/**
	 * Reversing an Integer array
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 */
	public void reverse(int arr[], int startIndex, int endIndex ) {
		while (startIndex<endIndex) {
			int temp = arr[startIndex];
			arr[startIndex]=arr[endIndex];
			arr[endIndex]= temp;
			startIndex++;
			endIndex--;
		}
	}
}
