import java.awt.Point;
import java.io.*;
import java.util.*;
public class Probiethree {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		int N = sc.nextInt(), K = sc.nextInt(), Abeg = sc.nextInt(), Aend = sc.nextInt(), Bbeg = sc.nextInt(), Bend = sc.nextInt();
		int[] work = new int[N];
		for(int i = 0; i < N; i++) {
			work[i] = i + 1;
		}
		int numloop = 0;
		boolean loop = true;
		for(int i = 0; i < K; i++) {
			work = reverse(work, Abeg, Aend);
			work = reverse(work, Bbeg, Bend);
			loop = true;
			for(int j = 0; j < N; j++) {
				if(!(work[j] == j + 1)) {
					loop = false;
					break;
				}
			}
			if(loop) {
				numloop = i + 1;
				break;
			}
		}
		if(loop) {
			K %= numloop;
			for(int i = 0; i < K; i++) {
				work = reverse(work, Abeg, Aend);
				work = reverse(work, Bbeg, Bend);
			}
		}
		for(int i = 0; i < N - 1; i++) {
			pw.println(work[i]);
		}
		pw.print(work[N - 1]);
		pw.close();
	}
	public static int[] reverse(int[] a, int c, int d) {
		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		for(int i = 0; i <= d-c; i++) {
			b[d - i - 1] = a[c + i - 1];
		}
		return b;
	}
}
