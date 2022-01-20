import java.util.*;
import java.io.*;
public class hoovepaperscissors {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int n = sc.nextInt();
		int[] r = new int[n];
		int[] p = new int[n];
		int[] h = new int[n];
		int b = 0, c = 0, d = 0;
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			if(a.equals("H")) b += 1;
			else if(a.equals("P")) c += 1;
			else if(a.equals("S")) d += 1;
			r[i] = b;
			p[i] = c;
			h[i] = d;
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, Math.max(r[i], Math.max(p[i], h[i])) + Math.max(b - r[i], Math.max(c - p[i], d - h[i])));
			
		}
		out.print(ans);
		out.close();
	}
}
