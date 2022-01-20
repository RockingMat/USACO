import java.awt.Point;
import java.io.*;
import java.util.*;
public class Elsietwo {
	public static int[] foo = new int[100];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		int N = sc.nextInt();
		int[] a = new int[N - 1];
		int[] b = new int[N - 1];
		for(int i = 0; i < N - 1; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}for(int i = 1; i <= N; i++) {
			foo[i - 1] = i;
			surround(a, b, N, i);
			if(works(N)) {
				pw.print(i);
				pw.close();
			}else {
				clear(N);
			}
		}
		pw.print(-1);
		pw.close();
	}
	private static void clear(int N) {
		for(int i = 0; i < N; i++) {
			foo[i] = 0;
		}
	}
	private static boolean works(int N) {
		for(int i = 0; i < N; i++) {
			if(foo[i] != i + 1) {
				return false;
			}
		}
		return true;
	}
	private static void surround(int[] a, int[] b, int n, int j) {
		for(int i = 0; i < n - 1; i++) {
			if(b[i] == j) {
				if(foo[a[i] - 1] != a[i]) {
					foo[a[i] - 1] = a[i];
					surround(a, b, n, a[i]);
				}
			}
		}
	}
}
