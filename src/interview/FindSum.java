package interview;

import java.util.HashMap;
import java.util.Map;

public class FindSum {

	// Brute force O(n^2) time complexity but no additional space complexity
	// The caveat being O(n^2) is the worse case scenario because we short cut the algorithm
	public static boolean containsSumFirstAttempt(int[] arrayOfInts, int sum) {
		if(arrayOfInts.length <= 1) {
			return false;
		}
		
		int pointerInt;
		for(int i = 0; i < arrayOfInts.length; i++) {
			pointerInt = arrayOfInts[i];
			
			for(int j = 0; j < arrayOfInts.length; j++) {
				// Don't compare the same number in the array with it self
				if(j == i) {
					continue;
				}
				
				if(((pointerInt + arrayOfInts[j]) == sum) ||
				   arrayOfInts[j] + pointerInt == sum) {
//					System.out.println(pointerInt + " " + arrayOfInts[j]);
					return true;
				}
			}
		}
		
		return false;
	}
	
	// O(2n) time complexity and O(n) space complexity (because of the creation of the Hashmap)
	// By putting the Array in the Map
	public static boolean containsSumSecondAttempt(int[] arrayOfInts, int sum) {
		// Fail fast of array is equal to or less than 1
		if(arrayOfInts.length <= 1) {
			return false;
		}
		
		// Map that will contain the array values
		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		
		// Iterate over the array and put them into the map
		for (int i = 0; i < arrayOfInts.length; i++) {
			
			// if value does not exist in the map put it in there
			if(values.get(arrayOfInts[i]) == null) {
				values.put(arrayOfInts[i], arrayOfInts[i]);
			}
			else {
				// Short cut the algorithm if a duplicate is found and is equal to the sum
				if((arrayOfInts[i] * 2) == sum) {
//					System.out.println("Duplicate of " + arrayOfInts[i] + " equals sum (" + sum + ")");
					return true;
				}
			}
		}

		// Second iteration will check the result of array value - sum against the map values
		for (int i = 0; i < arrayOfInts.length; i++) {
			Integer value = values.get(sum - arrayOfInts[i]);
			
			// Check to make sure we are not finding the same value in the map as the current array value
			if(value != null && value * 2 != sum)  {
//				System.out.println(values.get(sum - arrayOfInts[i]) + " " + arrayOfInts[i]);
				return true;
			}
		}

		// No matches found
		return false;
	}
	
	public static void main(String[] args) {
		int[] input = {24,2,45,20,56,75,56,99,53,12, -48, -20, -20};
		System.out.println(FindSum.containsSumSecondAttempt(input, -40));
	}
}
