package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bo.Human;

public class HackerRankApplication {

	public static void main(String[] args) {
		List<Integer> unsorted = new ArrayList<>();
		unsorted.add(5);
		unsorted.add(2);
		unsorted.add(7);
		unsorted.add(8);
		unsorted.add(-2);
		unsorted.add(25);
		unsorted.add(25);
		System.out.println("Original"+unsorted);
		//meanderingArray(unsorted);
		printPrimeNumbers(3,5);
	}
	
    public static List<Integer> meanderingArray(List<Integer> unsorted){
    	// Sort the array
    	Collections.sort(unsorted);
    	
    	// Reverse the array
    	Comparator<Integer> intComparator = ((n1, n2) -> (n1 - n2));
    	unsorted.sort(intComparator.reversed());
    	
    	System.out.println("Reverse sorted"+unsorted);
    	
    	// iterate and replace
    	int firstPointer=1, lastPointer=unsorted.size()-1;
    	while(firstPointer<lastPointer){
	    	unsorted.add(firstPointer, unsorted.get(lastPointer));
	    	unsorted.remove(lastPointer+1);
	    	firstPointer+=2;
    	}
    	System.out.println("Meandering "+unsorted);
    	return unsorted;
    }
    
    static void printPrimeNumbers (int startNum, int endNum) {
    	while (startNum<=endNum) {
    		if (isAPrimeNumber(startNum)){
    			System.out.println(startNum);
    		}
			startNum++;
    	}
    	
    }
    
    static boolean isAPrimeNumber(int num) {
    	if (num ==1)
    		return false;
    	for (int i=2;i<num/2; i++) {
    		if(num%i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
