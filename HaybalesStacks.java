import java.io.*;
import java.util.*;
public class HaybalesStacks {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("stacking.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
		int n = sc.nextInt(), k = sc.nextInt();
		int[] bales = new int[n];
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			bales[a]++;
			if(b + 1 < n) bales[b + 1]--;
		}
		int run = 0;
		for(int i = 0; i < n; i++) {
			run += bales[i];
			bales[i] = run;
		}
		Arrays.sort(bales);
		out.print(bales[n/2]);
		out.close();
	}
}
