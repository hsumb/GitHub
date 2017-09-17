package list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SeparateList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		System.out.println(separate(list,5));
	}

	public static boolean separate(List<Integer> list, int k){
		// Time complexity:  O(K * 2^list.size() * list.size())
		// Space complexity: O(K * 2^list.size() * list.size())
		int s = 0;
		for(int num : list)
			s += num;
		if(s % k != 0) return false;
		int groupSum = s/k;

		boolean[][] mat = new boolean[k+1][(int) Math.pow(2,list.size())];
		mat[0][0]=true;
		for(int i = 0; i < k; i++) {
			for(int mask = 0; mask<Math.pow(2,list.size()); mask++) {
				if(!mat[i][mask])
					continue;
				int sum = 0;
				for(int j = 0; j < list.size(); j++) {
					if((mask & (1 << j)) > 0)
						sum += list.get(j);
				}
				sum -= i * groupSum;
				for(int j = 0; j < list.size(); j++){
					if ((mask & (1 << j))>0)
						continue;
					int new_mask = mask | (1 << j);
					if( sum + list.get(j) == groupSum)
						mat[i + 1][new_mask] = true;
					else if(sum + list.get(j) < groupSum)
						mat[i][new_mask] = true;
				}
			}
		}
		return (mat[k][(int) (Math.pow(2,list.size()) - 1)]);
	}
	
	// JUnit test cases
	@Test
	public void testSeparatePositive() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(6);
		list.add(1);
		list.add(8);
		assertTrue("failure - should be true", separate(list, 4));
	}
	
	@Test
	public void testSeparateNegative() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		assertFalse("failure - should be false", separate(list, 4));
	}

}
