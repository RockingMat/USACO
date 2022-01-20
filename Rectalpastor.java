import java.util.*;
import java.io.*;
public class Rectalpastor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] x = new int[n][2];
		int[][] y = new int[n][2];
		for(int i = 0; i < n; i++) {
			y[i][0] = i;
			x[i][0] = i;
			x[i][1] = sc.nextInt();
			y[i][1] = sc.nextInt();
		}
		Arrays.sort(x, Comparator.comparingInt(o -> o[0]));
		Arrays.sort(y, Comparator.comparingInt(o -> o[0]));
		int[][] a = new int[n + 1][n + 1];
		for(int i = 0; i < n; i++) {
			a[x[i][0]][y[i][0]] = 1;
		}
	}
}
