import java.io.*;
import java.util.*;
public class maxcross {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		int N = sc.nextInt(), K = sc.nextInt(), B = sc.nextInt();
		int[] locs = new int[N + 1];
		int[] c = new int[B];
		int curr = 0, loc = 0, max = Integer.MAX_VALUE;
		for(int i = 0; i < B; i++) c[i] = sc.nextInt();
		Arrays.sort(c);
		boolean done = false;
		for(int i = 1; i <= N; i++) {
			if(!done && i == c[curr]) curr++;
			if(curr == B) done = true;
			locs[i] = curr;
		} 
		//System.out.print(Arrays.toString(locs));
		for(int i = 0; i <= N - K; i++) max = Math.min(max, locs[i + K] - locs[i]);
		out.print(max);
		out.close();
	}
}
