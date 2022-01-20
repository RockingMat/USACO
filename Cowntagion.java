import java.util.*;
import java.io.*;
import java.awt.*;
public class Cowntagion {
	public static void main(String[] args) throws IOException {
		HashMap<Integer, ArrayList<Integer>> a = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 1; i < 256; i++) {
			int pr = i, ord = 1;
			while(pr != 1) {
				pr *= i;
				pr %= 257;
				ord++;
			}
			ArrayList<Integer> pl = a.getOrDefault(ord, new ArrayList<Integer>());
			pl.add(i);
			a.put(ord, pl);
		}
		for(int i = 0; i <= 256; i++) {
			if(a.containsKey(i)) {
				ArrayList<Integer> pl = a.get(i);
				System.out.print(i + ": ");
				for(int j : pl) System.out.print(j + " ");
				System.out.println();
			}
		}
		//Scanner sc = new Scanner(System.in);
		/*int[] a = new int[sc.nextInt()];
		for(int i = 0; i < a.length; i++) a[i] = sc.nextInt();
		selectionSort(a);
		for(int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		int n = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		System.out.print(dfs(visited, adj, 1));*/
	}

	private static int dfs(boolean[] visited, ArrayList<Integer>[] adj, int curr) {
		int ad = 1, ans = 0;
		for(int i : adj[curr]) {
			if(visited[i] == false) {
				visited[i] = true;
				ans += dfs(visited, adj, i);
				ad++;
				ans++;
			}
		}
		//System.out.println(curr + " " + ad);
		int g = 1;
		while(g < ad) {
			ans++;
			g *= 2;
		}
		return ans;
	}
	public static void bubbleSort(int[] a) {
		boolean swapping = false;
		int i = 0;
		while(swapping || !(i == a.length - 1)) {
			if(i == a.length - 1) {
				i = 0;
				swapping = false;
			}
			if(a[i] > a[i + 1]) {
				int foo = a[i];
				a[i] = a[i + 1];
				a[i + 1] = foo;
				swapping = true;
			}
			i++;
		}
	}
	public static void selectionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int min = Integer.MAX_VALUE;
			int loc = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < min) {
					min = a[j];
					loc = j;
				}
			}
			int foo = a[i];
			a[i] = a[loc];
			a[loc] = foo;
		}
	}
}
