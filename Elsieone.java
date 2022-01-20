import java.awt.Point;
import java.io.*;
import java.util.*;
public class Elsieone {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("buckets.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		String[] arr = new String[10];
		int Bx = 0, By = 0, Rx = 0, Ry = 0, Lx = 0, Ly = 0;
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.next();
			for(int j = 0; j < 10; j++) {
				if(arr[i].charAt(j) == 'B') {
					Bx = j;
					By = i;
				}else if(arr[i].charAt(j) == 'R') {
					Rx = j;
					Ry = i;
				}else if(arr[i].charAt(j) == 'L') {
					Lx = j;
					Ly = i;
				}
			}
		}
		int ans = 0;
		if(Bx == Lx & Bx == Rx) {
			if(((By > Ry & Ry > Ly)||(Ly > Ry & Ry > By))) {
				ans = Math.abs(By - Ly) + 1;
			}else {
				ans = Math.abs(By - Ly) - 1;
			}
		}else if(By == Ly & By == Ry) {
			if(((Bx > Rx & Rx > Lx)||(Lx > Rx & Rx > Bx))) {
				ans = Math.abs(Bx - Lx) + 1;
			}else {
				ans = Math.abs(Bx - Lx) - 1;
			}
		}else {
			ans = Math.abs(Bx - Lx) + Math.abs(By - Ly) - 1;
		}
		pw.print(ans);
		pw.close();
	}
}
