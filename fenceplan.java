import java.util.*;
import java.io.*;
public class fenceplan {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("fenceplan.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] locs = new int[n][2];
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			locs[i][0] = sc.nextInt();
			locs[i][1] = sc.nextInt();
			adj[i] = new ArrayList();
		}
		int a = 0, b = 0;
		for(int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			adj[a - 1].add(b - 1);
			adj[b - 1].add(a - 1);
		}
		boolean[] visited = new boolean[n];
		int[] edges = new int[4];
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(visited[i] == false) {
				edges[0] = Integer.MAX_VALUE;
				edges[1] = Integer.MAX_VALUE;
				edges[2] = Integer.MIN_VALUE;
				edges[3] = Integer.MIN_VALUE;
				visited[i] = true;
				if(locs[i][1] < edges[1]) {
					edges[1] = locs[i][1];
				}
				if(locs[i][1] > edges[3]) {
					 edges[3] = locs[i][1];
				}
				if(locs[i][0] < edges[0]) {
					edges[0] = locs[i][0];
				}
				if(locs[i][0] > edges[2]) {
					edges[2] = locs[i][0];
				}
				edges = dfs(i, edges, visited, locs, adj);
				ans = Math.min(ans, 2 * (edges[2] - edges[0]) + 2 * (edges[3] - edges[1]));
			}
		}
		//System.out.println(Arrays.toString(edges));
		//System.out.print(ans);
		out.print(ans);
		out.close();
	}

	private static int[] dfs(int i, int[] edges, boolean[] visited, int[][] locs, ArrayList<Integer>[] adj) {
		for(int k : adj[i]) {
			if(visited[k] == false) {
				visited[k] = true;
				if(locs[k][1] < edges[1]) {
					edges[1] = locs[k][1];
				}
				if(locs[k][1] > edges[3]) {
					 edges[3] = locs[k][1];
				}
				if(locs[k][0] < edges[0]) {
					edges[0] = locs[k][0];
				}
				if(locs[k][0] > edges[2]) {
					edges[2] = locs[k][0];
				}
				edges = dfs(k, edges, visited, locs, adj);
			}
		}
		return edges;
	}
}
