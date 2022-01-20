import java.io.*;
import java.util.*;
public class RectangularPasture {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		int n = sc.nextInt(), ans = 0, b = 0;
		int[] a = new int[7];
		for(int i = 0; i < 7; i++) a[i] = -1;
		for(int i = 0; i < n; i++) {
			b += sc.nextInt() % 7;
			if(a[b % 7] == -1) a[b % 7] = i;
			else ans = Math.max(i - a[b % 7], ans);
		}
		out.print(ans);
		out.close();
	}
}
