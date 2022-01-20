import java.util.*;
import java.io.*;
public class mootube {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("mootube.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] locs = new int[n + 1][n + 1];
		// Storing connection in two dimensional array
		int a = 0, b = 0, c = 0;
		for(int i = 0; i < n - 1; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			locs[a][b] = c;
			locs[b][a] = c;
		}
		long minrel = 0;
		int curr = 0;
		long[][] rel = new long[n+1][n+1];
		for(int i = 1; i < n + 1; i++) {
			minrel = 1000000000;
			curr = i;
			boolean[] visited = new boolean[n+1];
			visited[curr] = true;
			dfshelper(i, curr, locs, visited, minrel, rel);
		}
		int value = 0, node = 0, ans = 0;
		for(int i = 0; i < m; i++) {
			value = sc.nextInt();
			node = sc.nextInt();
			ans = 0;
			for(int j = 1; j < n + 1; j++) {
				if(rel[node][j] >= value) ans++;
			}
			out.println(ans);
		}
		/*for(long[] i : rel) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
		for(int[] i : locs) {
			System.out.println(Arrays.toString(i));
		}
		
		for(int i = 0; i < m; i++) {
			boolean[] visited = new boolean[n + 1];
			value = sc.nextInt();
			node = sc.nextInt();
			visited[node] = true;
			out.println(dfs(node, value, visited, locs));
		}*/
		out.close();
	}

	private static void dfshelper(int i, int curr, int[][] locs, boolean[] visited, long minrel, long[][] rel) {
		long temp = 0;
		for(int j = 1; j < locs[i].length; j++) {
			if(locs[curr][j] != 0 && visited[j] == false) {
				visited[j] = true;
				temp = minrel;
				minrel = Math.min(locs[curr][j], minrel);
				rel[i][j] = minrel;
				//if(i == 4 || i==2)System.out.println(temp+ " " + rel[i][j] + " " +i + " " + j);
				dfshelper(i, j, locs, visited, minrel, rel);
				minrel = temp;
			}
		}
		
	}

	private static int dfs(int node, int value, boolean[] visited, int[][] locs) {
		int ans = 0;
		for(int i = 1; i < locs[node].length; i++) {
			if(locs[node][i] >= value && locs[node][i] != 0 && visited[i] == false) {
				//System.out.println(locs[node][i] + " "+ node + " " + i);
				ans++;
				visited[i] = true;
				ans += dfs(i, value, visited, locs);
			}
		}
		//System.out.println(node + " " + Arrays.toString(visited));
		return ans;
	}
}
