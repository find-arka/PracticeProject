package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.TwoPointerTechniquesApplications;

public class TestTwoPointerTechniquesApplications {
	
	TwoPointerTechniquesApplications twoPointerTechniquesApplications = new TwoPointerTechniquesApplications ();
	
	@Test
	public void doesAPairOfIntegerExist() {
		
		int [] testArray1 = {7,8,9,1,2,3,4,5,6,10,11,12};
		assertEquals((Boolean)true,(Boolean)twoPointerTechniquesApplications.doesAPairOfIntegerExist(testArray1, 22));
	
		int [] testArray2 = {8,9,10,11,1,2};
		assertEquals((Boolean)false,(Boolean)twoPointerTechniquesApplications.doesAPairOfIntegerExist(testArray2, 22));
	}

}
