import java.util.*;
import java.io.*;
public class cards {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("highcard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		int c = 0, ans = 0, count = 0;
		for(int i = 1; i <= 2*n; i++) {
			if(c < n && a[c] == i) {
				c++;
				count++;
			}else if(count > 0) {
				count--;
				ans++;
			}
		}
		out.print(ans);
		out.close();
		
	}
}
