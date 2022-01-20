import java.awt.Point;
import java.io.*;
import java.util.*;
public class Probietwo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("breedflip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		int n = sc.nextInt(), ans = 0;
		String a = sc.next();
		String b = sc.next();
		for(int i = 0; i < n - 1; i++) {
			if((a.charAt(i) == b.charAt(i)) & !(a.charAt(i + 1) == b.charAt(i + 1))) {
				ans += 1;
			}
		}
		if((a.charAt(0) != b.charAt(0))) {
			ans += 1;
		}
		pw.print(ans);
		pw.close();
	}
}
