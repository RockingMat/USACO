import java.awt.Point;
import java.io.*;
import java.util.*;
public class Besstwo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("photo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		int N = sc.nextInt();
		int[] arr = new int[N - 1];
		for(int i = 0; i < N - 1; i++) {
			arr[i] = sc.nextInt();
		}
		int curr = 0, parity = 1, foo = 0;
		boolean work = true, equals = false;
		for(int i = 1; i <= N; i++) {
			int[] ans = new int[N];
			ans[N - 1] = i;
			curr = 0;
			parity = 1;
			work = true;
			equals = false;
			for(int j = N - 2; j >= 0; j--) {
				curr += parity * arr[j];
				foo = parity*(curr - i);
				for(int k = N - 1; k > j; k--) {
					if(ans[k] == foo) {
						equals = true;
					}
				}
				if(equals || (1 > foo) || (N < foo)) {
					work = false;
					break;
				}
				ans[j] = foo;
				parity *= -1;
			}
			if(work) {
				for(int a = 0; a < N - 1; a++) {
					pw.print(ans[a] + " ");
				}
				pw.print(ans[N - 1]);
				pw.close();
				break;
			}
		}
	}
}
