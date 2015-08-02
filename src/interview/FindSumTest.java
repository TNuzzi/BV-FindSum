package interview;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindSumTest {

	// Test data
	private static final int[] emptyArray = {};
	private static final int[] oneEleArray = {10};
	private static final int[] inputArray = {10,24,2,45,20,56,75,56,99,53,12,-48,-20,-20};
	private static final int defaultSum = 22;
	private static final int notFoundSum = 1;
	
	
	// Tests for containsSumFirstAttempt
	@Test
	public void testContainsSumFirstAttemptEmpty() {
		assertFalse(FindSum.containsSumFirstAttempt(emptyArray, defaultSum));
	}
	
	@Test
	public void testContainsSumFirstAttemptSingleElement() {
		assertFalse(FindSum.containsSumFirstAttempt(oneEleArray, defaultSum));
	}
	
	@Test
	public void testContainsSumFirstAttemptSuccessFound() {
		assertTrue(FindSum.containsSumFirstAttempt(inputArray, defaultSum));
	}
	
	@Test
	public void testContainsSumFirstAttemptSuccessNotFound() {
		assertFalse(FindSum.containsSumFirstAttempt(inputArray, notFoundSum));
	}

	// Tests for containsSumFirstAttempt
	@Test
	public void testContainsSumSecondAttemptEmpty() {
		assertFalse(FindSum.containsSumSecondAttempt(emptyArray, defaultSum));
	}
	
	@Test
	public void testContainsSumSecondAttemptSingleElement() {
		assertFalse(FindSum.containsSumSecondAttempt(oneEleArray, defaultSum));
	}
	
	@Test
	public void testContainsSumSecondAttemptSuccessFound() {
		assertTrue(FindSum.containsSumSecondAttempt(inputArray, defaultSum));
	}
	
	@Test
	public void testContainsSumSecondAttemptSuccessNotFound() {
		assertFalse(FindSum.containsSumSecondAttempt(inputArray, notFoundSum));
	}
}
