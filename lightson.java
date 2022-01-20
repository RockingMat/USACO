import java.io.*;
import java.util.*;
public class lightson {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("lightson.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		int n = sc.nextInt(), k = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[(n + 1) * (n + 1)];
		for(int i = 0; i < (n + 1) * (n + 1); i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
			adj[a * n + b].add(c * n + d);
		}
		boolean[][] visited = new boolean[n + 1][n + 1];
		visited[1][1] = true;
		out.print(dfs(adj, n + 1, visited, n) + 1);
		out.close();
	}

	private static int dfs(ArrayList<Integer>[] adj, int curr, boolean[][] visited, int n) {
		int ans = 0;
		for(int i : adj[curr]) {
			if(visited[i / n][i % n] == false) {
				visited[i / n][i % n] = true;
				ans++;
				ans += dfs(adj, i, visited, n);
			}
		}
		return ans;
	}
}
