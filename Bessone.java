import java.awt.Point;
import java.io.*;
import java.util.*;
public class Bessone {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("word.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		int N = sc.nextInt(), k = sc.nextInt();
		String[] a = new String[N];
		int curr = 0;
		for(int i = 0; i < N; i++) {
			a[i] = sc.next();
			curr += a[i].length();
			if(i == 0) {
				pw.print(a[i]);
			}else if(curr > k) {
				pw.println();
				pw.print(a[i]);
				curr = a[i].length();
			}else {
				pw.print(" " + a[i]);
			}
		}
		pw.close();
	}
}
