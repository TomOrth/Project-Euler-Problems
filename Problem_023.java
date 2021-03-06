package euler;

import java.util.HashSet;

public class Problem_023 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(nonAbundantSum(28123));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) / 1000 + " s.");
	}
	
	private static int nonAbundantSum(int upperbound) {
		HashSet<Integer> abundantNums = new HashSet<Integer>();		// data structures are important (w/ arraylist rt = 40 seconds)
		int sum = 0;
		boolean abundantSum = false;
		
		for(int i = 1; i <= upperbound; i++) {
			if(isAbundant(i)) abundantNums.add(i);
			
			for(Integer num : abundantNums) {
				if(abundantNums.contains(i - num)) {
					System.out.println(num + " + " + (i - num) + " = " + i);
					abundantSum = true;
					break;
				}
			}
			
			if(abundantSum) abundantSum = false;
			else sum += i;
		}
		
		return sum;
	}
	
	private static boolean isAbundant(int n) {
		int sum = 0;
		
		for(int i = 1; i < n; i++) {
			if(n / i == (double) n / i) {
				sum += i;
			}
		}
		
		return sum > n;
	}
	
}
