import java.util.*;
public class REE {
	public static void main(String[] args) {
		int[] A = {51, 71, 17, 42};
		//storing the maximum number with the digitsum of index in max array
		//Maximum sum of digits of a number between 1 an 1,000,000,000 is 999,999,999 whose digits sum to 81
		//Time Complexity: O(n) Memory Complexity: O(c)
		int[] max = new int[81];
		int digitsum = 0, maxsum = 0, foo = 0;
		//traversing every item in our array
		for(int i = 0; i < A.length; i++) {
			foo = A[i];
			digitsum = 0;
			//finding the sum of the digits of current number
			while(foo != 0) {
				digitsum += foo%10;
				foo/=10;
			}
			//checking if the sum of the maximum number with the same digit sum is greater than our maximum number so far
			if(max[digitsum] > 0) maxsum = Math.max(max[digitsum] + A[i], maxsum);
			//Updating our max array if our current number is larger than value of the number at the index
			if(A[i] > max[digitsum]) max[digitsum] = A[i];
		}
		if(maxsum != 0) System.out.print(maxsum);
		else System.out.print(-1);
	}
}
