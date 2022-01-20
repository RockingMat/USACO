import java.util.*;
import java.io.*;
public class DASS {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		int n = sc.nextInt();
		int[][] locs = new int[n][3];
		for(int i = 0; i < n; i++) {
			locs[i][0] = sc.nextInt();
			locs[i][1] = sc.nextInt();
			locs[i][2] = sc.nextInt();
		}
		int power = 0;
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			power = locs[i][2];
			adj[i] = new ArrayList<Integer>();
			for(int j = 0; j < n; j++) {
				if(Math.sqrt(Math.pow(locs[i][1] - locs[j][1], 2) + Math.pow(locs[i][0] - locs[j][0], 2)) <= power) {
					adj[i].add(j);
				}
			}
		}
		int ans = 1;
		for(int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			visited[i] = true;
			ans = Math.max(ans, dfs(i, adj, visited, 1));
		}
		pw.print(ans);
		//System.out.print(ans);
		pw.close();
	}

	private static int dfs(int i, ArrayList<Integer>[] adj, boolean[] visited, int currans) {
		for(int k : adj[i]) {
			if(visited[k] == false) {
				visited[k] = true;
				currans++;
				currans = dfs(k, adj, visited, currans);
			}
		}
		return currans;
	}
}
