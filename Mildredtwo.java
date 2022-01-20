import java.awt.Point;
import java.io.*;
import java.util.*;
public class Mildredtwo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("whereami.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		int length = sc.nextInt();
		String a = sc.next();
		for(int i = 0; i < length; i++) {
			if(works(i, length, a)) {
				pw.print(i);
				pw.close();
			}
		}
	}

	private static boolean works(int k, int length, String a) {
		for(int i = 0; i < length - k; i++) {
			for(int j = i + 1; j < length - k; j++) {
				if(a.substring(i, i+k).equals(a.substring(j, j + k))) {
					return false;
				}
			}if(a.substring(i, i+k).equals(a.substring(length - k))) {
				return false;
			}
		}
		return true;
	}
}
