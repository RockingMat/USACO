import java.util.*;
import java.io.*;
public class Censor {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("censor.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
		StringBuilder a = new StringBuilder(sc.next());
		String b = sc.next();
		int c = a.length(), d = b.length(), e = 1;
		for(int i = 0; i < c - d*e; i++) {
			if(a.substring(i, i + d).equals(b)) {
				a.delete(i, i + d);
				i -= d;
				if(i < 0) i = -1;
				e++;
			}
		}
		out.print(a.toString());
		out.close();
	}
}
