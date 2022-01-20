import java.io.*;
import java.util.*;
public class MovieFestival {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] mov = new int[n][2];
		for(int i = 0; i < n; i++) {
			mov[i][0] = sc.nextInt();
			mov[i][1] = sc.nextInt();
		}
		int movies = 0, endtime = 0;
		Arrays.sort(mov, Comparator.comparingInt(o -> o[0]));
		for(int i = 0; i < n; i++) {
			if(mov[i][0] >= endtime) {
				movies++;
				endtime = mov[i][1];
			}
			endtime = Math.min(endtime, mov[i][1]);
		}
		System.out.print(movies);
	}
}
