import java.io.*;
import java.util.*;
public class Problem2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int currsum = 0, ans = 0;
		for(int i = 0; i < n; i++) {
			currsum = 0;
			for(int j = i; j < n; j++) {
				currsum += a[j];
				for(int k = i; k <=j; k++) {
					if((double)a[k] == (double)currsum/(double)(j - i + 1)) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.print(ans);
	}
}
