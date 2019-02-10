package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.TwoPointerTechniquesApplications;

public class TestTwoPointerTechniquesApplications {
	
	TwoPointerTechniquesApplications twoPointerTechniquesApplications = new TwoPointerTechniquesApplications ();
	int [] testArray1 = {7,8,9,1,2,3,4,5,6,10,11,12};
	int [] testArray2 = {8,9,10,11,1,2};
	
	@Test
	public void doesAPairOfIntegerExist() {
		assertEquals((Boolean)true,(Boolean)twoPointerTechniquesApplications.doesAPairOfIntegerExist(testArray1, 22));
		assertEquals((Boolean)false,(Boolean)twoPointerTechniquesApplications.doesAPairOfIntegerExist(testArray2, 22));
	}
	
	@Test
	public void shiftArrayNstepsToTheRight() {
		int i;
		
		twoPointerTechniquesApplications.shiftArrayNstepsToTheRight(testArray1,2);
		for(i=0;i<testArray1.length;i++){
			assertEquals(new int[]{11,12,7,8,9,1,2,3,4,5,6,10}[i],testArray1[i]);
		}
		
		twoPointerTechniquesApplications.shiftArrayNstepsToTheRight(testArray2,7);
		for(i=0;i<testArray2.length;i++){
			assertEquals(new int[]{2,8,9,10,11,1}[i],testArray2[i]);
		}
	}

}
