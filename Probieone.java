import java.awt.Point;
import java.io.*;
import java.util.*;
public class Probieone {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		int n = sc.nextInt();
		ArrayList<Point> a = new ArrayList<Point>();
		for(int i = 0; i < n; i++) {
			Point b = new Point();
			b.x = sc.nextInt();
			b.y = sc.nextInt();
			a.add(b);
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				Point b = new Point();
				b.x = a.get(i).x;
				b.y = a.get(j).y;
				Point c = new Point();
				c.x = a.get(j).x;
				c.y = a.get(i).y;
				if(a.get(i).x != a.get(j).x & a.get(i).y != a.get(j).y & (a.contains(b)||a.contains(c))) {
					max = Math.max(max, Math.abs((a.get(i).x - a.get(j).x)*(a.get(i).y - a.get(j).y)));
				}
			}
		}
		pw.print(max);
		pw.close();
	}
}
