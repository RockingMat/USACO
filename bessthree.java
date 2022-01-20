import java.awt.Point;
import java.io.*;
import java.util.*;
public class bessthree {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("race.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		int N = sc.nextInt(), K= sc.nextInt();
		int[] arr = new int[K];
		int[] ans = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}
		/*for(int i = 0; i < K; i++) {
			for(int t = 0; t < Integer.MAX_VALUE; t++) {
				if(arr[i] >= t) {
					if(t*(t+1)/2 >= N) {
						ans[i] = t;
						break;
					}
				}
				else if(t-arr[i] % 2 == 0) {
					if((t-arr[i])*(t-arr[i]+2)/4 + arr[i]*(arr[i]+1)/2+ (t - arr[i])*arr[i] >= N) {
						ans[i] = t;
						break;
					}
				}else {
					if((t-arr[i]-1)*(t-arr[i]+1)/4 + (t-arr[i]-1)/2 + arr[i]*(arr[i]+1)/2 + (t - arr[i])*arr[i] >= N){
						ans[i] = t;
						break;
					}
				}
			}
		}*/
		int inc = 0, adds = 0, num = 0;
		for(int i = 0; i < K; i++) {
			int x = arr[i];
			inc = 0;
			adds = 0;
			num = 0;
			for(int t = 0; t < Integer.MAX_VALUE; t++) {
				if(inc < x) {
					num += inc;
					inc++;
				}else if(adds == 0 || adds == 1) {
					num += inc;
					adds++;
				}else{
					adds = 1;
					inc++;
					num += inc;
				}
				if(num >= N) {
					ans[i] = t;
					break;
				}
			}
		}
		for(int i = 0; i < K; i++) {
			pw.println(ans[i]);
		}
		pw.close();
	}
}
