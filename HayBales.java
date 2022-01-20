import java.util.*;
import java.io.*;
public class HayBales {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		int n = sc.nextInt(), k = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int f = 0, l = 0;
		for(int i = 0; i < k; i++) {
			int low = sc.nextInt(), high = sc.nextInt();
			f = Arrays.binarySearch(arr, low);
			if(f < 0) f = -f - 1;
			l = Arrays.binarySearch(arr, high);
			if(l < 0) l = -l - 2;
			out.println(l - f + 1);
		}
		out.close();
	}
}
