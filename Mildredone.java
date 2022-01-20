import java.awt.Point;
import java.io.*;
import java.util.*;
public class Mildredone {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("gymnastics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		int a = sc.nextInt(), b = sc.nextInt(), ansnum = 0;
		int[] data = new int[a*b];
		ArrayList<Point> ans = new ArrayList<Point>();
		for(int i = 0; i < a * b; i++) {
			data[i] = sc.nextInt();
		}
		boolean works = true;
		for(int i = 1; i <= b; i++) {
			for(int j = 1; j <= b; j++) {
				works = true;
				if(i == j) {
					works = false;
				}
				for(int k = 0; k < a; k++){
					for(int l = 0; l < b; l++) {
						if(data[b * k + l] == i) {
							break;
						}else if(data[b * k + l] == j) {
							works = false;
							break;
						}
					}
					if(works == false) {
						break;
					}
				}
				if(works == true) {
					Point foo = new Point();
					foo.x = Math.min(i, j);
					foo.y = Math.max(i, j);
					ans.add(foo);		
				}
			}
		}
		for(int i = 0; i < ans.size(); i++) {
			pw.print(ans.size());
			pw.close();
		}
	}
}
