package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class MultidimensioalArray {
	// This is a provided function, Assume it works
	public Long getValue(int... indexOfDimension) {
		return 1l;
	}
}

public class SumOfMultidimensioalArray {

	public static void main(String[] args) {
		MultidimensioalArray mArray = new MultidimensioalArray();
		int[] lengthOfDeminsion = {3,3,3,1,5};
		System.out.println(sum(mArray, lengthOfDeminsion));
	}

	// lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
	public static Long sum(MultidimensioalArray mArray, int[] lengthOfDimension) {
		// Time complexity:  O(<product of lengthOfDeminsion>)
		// Space complexity: O(<number of dimensions>)
		// recSum(mArray, lengthOfDeminsion, index, indexOfDimension)
		return recSum(mArray, lengthOfDimension, 0, null);
	}
	
	// JUnit test cases
	@Test
	public void testSum() {
		MultidimensioalArray mArray = new MultidimensioalArray();
		int[] lengthOfDeminsion = {3,2,3,1,5};
		assertEquals("failure - should be same", Long.valueOf(90), sum(mArray, lengthOfDeminsion));
	}

	private static Long recSum(MultidimensioalArray mArray, int[] lengthOfDimension, int index, int[] indexOfDimension) {
		long sum = 0;
		if(index+1 == lengthOfDimension.length) {
			for(int i=0;  i<lengthOfDimension[index]; i++) {
				if(indexOfDimension == null) {
					indexOfDimension = new int[lengthOfDimension.length];
				}
				indexOfDimension[index] = i;
				sum += mArray.getValue(indexOfDimension);
			}
			return sum;
		}
		if(indexOfDimension == null)
			indexOfDimension = new int[lengthOfDimension.length];
		for(int i=0;  i<lengthOfDimension[index]; i++) {
			indexOfDimension[index] = i;
			sum += recSum(mArray, lengthOfDimension, 1+index, indexOfDimension);
		}
		return sum;
	}
}