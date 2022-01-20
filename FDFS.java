import java.util.*;
import java.io.*;
public class FDFS {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		//Store adjacency's and run dfs for one item
		int n = sc.nextInt(), m = sc.nextInt(), a = 0, b = 0;
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		boolean[] removed = new boolean[n + 1];
		int ans = 0;
		boolean start = true;
		int[] remord = new int[n];
		for(int i = 0; i < n; i++) remord[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			ans = 1;
			if(!start) {
				removed[remord[i - 1]] = true;
			}else {
				start = false;
			}
			boolean[] visited = new boolean[n + 1];
			visited[remord[n - 1]] = true;
			ans = dfs(removed, visited, adj, ans, remord[n - 1]);
			if(ans + i == n) pw.println("YES");
			else pw.println("NO");
			System.out.println(Arrays.toString(visited) + " " + Arrays.toString(removed) + " " + i + " " + ans);
		}
		pw.close();
	}

	private static int dfs(boolean[] removed, boolean[] visited, ArrayList<Integer>[] adj, int ans, int current) {
		for(int i : adj[current]) {
			if(!visited[i] && !removed[i]) {
				visited[i] = true;
				ans = dfs(removed, visited, adj, ans + 1, i);
			}
		}
		return ans;
	}
}
