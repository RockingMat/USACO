import java.awt.Point;
import java.io.*;
import java.util.*;
public class Mildredthree {
	public static int success = 0;
	public static int[][] anschoice = new int[40320][8];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("lineup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		int pairings = sc.nextInt();
		String [] pairsinput = new String[6 * pairings];
		for(int i = 0; i < 6 * pairings; i++) {
			pairsinput[i] = sc.next();
		}
		String[] ranking = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
		int[][] pairs = new int[pairings][2];
		pairs = pairsinputconvert(pairsinput, pairings, pairs, ranking);
		int[] foo = new int[8];
		for(int i = 0; i < 8; i++) {
			foo[i] = i + 1;
		}
		int size = 8, length = 8;
		perms(pairs, foo, size, length);
		int ans = Lowest(anschoice);
		for(int i = 0; i < 8; i++) {
			pw.println(ranking[anschoice[ans][i] - 1]);
		}
		pw.close();
	}
	//Checks all possible permutations of cows and returns perms which fit constraints
	public static void perms(int[][] pairs, int[] foo, int size, int length){
		if(size == 1  & ordercheck(pairs, foo)) {
			anschoice[success] = foo.clone();
			success++;
		}else {
			for(int i = length - size; i < length; i++) {
				perms(pairs, swap(foo, length - size, i), size - 1, length);
				swap(foo, length - size, i);
			}
		}
	}
	//Swaps i and j in array foo
	private static int[] swap(int[] foo, int i, int j) {
		int temp = foo[i];
		foo[i] = foo[j];
		foo[j] = temp;
		return foo;
	}
	//returns delimited pairs of cows converted to int based on alphabetical order 
	private static int[][] pairsinputconvert(String[] pairsinput, int pairings, int[][] pairs, String[] ranking) {
		for(int i = 0; i < pairings; i++) {
			pairsinput[i].split("//s+");
			for(int j = 0; j < 8; j++) {
				if(pairsinput[6 * i].equals(ranking[j])) {
					pairs[i][0] = j + 1;
				}else if(pairsinput[6 * i + 5].equals(ranking[j])) {
					pairs[i][1] = j + 1;
				}
			}
		}
		return pairs;
	}
	//checks if foo follows constraints
	public static boolean ordercheck(int[][] pairs, int[] foo) {
		for(int i = 0; i < pairs.length; i++) {
			for(int j = 0; j < 8; j++) {
				if(foo[j] == pairs[i][0]) {
					if(j == 0) {
						if(!(foo[j + 1] == pairs[i][1])) {
							return false;
						}
					}else if(j == 7) {
						if(!(foo[j - 1] == pairs[i][1])) {
							return false;
						}
					}
					else if(!((foo[j + 1] == pairs[i][1]) || (foo[j - 1] == pairs[i][1]))) {
						return false;
					}
				}
			}
		}
		return true;
	}
	//returns index of smallest order
	public static int Lowest(int[][] ans) {
		int min = Integer.MAX_VALUE, index = 0, length = 0;
		for(int j = 0; j < 40320; j++) {
			if(ans[j][0] != 0) {
				length++;
			}else {
				break;
			}
		}
		for(int i = 0; i < length; i++) {
			int foo = 0;
			for(int j = 0; j < 8; j++) {
				foo += Math.pow(10, 8 - j) * ans[i][j];
			}
			if(foo == Math.min(min, foo)) {
				min = Math.min(min, foo);
				index = i;
			};
		}
		return index;
	}
}
