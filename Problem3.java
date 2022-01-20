import java.io.*;
import java.util.*;
public class Problem3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[7];
		int sum = 0;
		for(int i = 0; i < 7; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		sum = sum/4;
		Arrays.sort(a);
		if(a[0] + a[1] == a[2]) {
			System.out.print(a[0]+" "+ a[1]+" "+a[3]);
		}else {
			System.out.print(a[0]+" "+ a[1]+" "+a[2]);
		}
	}
}
