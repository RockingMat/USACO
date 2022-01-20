import java.io.*;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] north = new int[n][4];
		int[][] east = new int[n][4];
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			if(a.equals("N")) {
				north[i][0] = sc.nextInt();
				north[i][1] = sc.nextInt();
				north[i][3] = i;
				east[i][3] = Integer.MAX_VALUE;
				east[i][0] = Integer.MAX_VALUE;
				east[i][1] = Integer.MAX_VALUE;
			}else {
				east[i][0] = sc.nextInt();
				east[i][1] = sc.nextInt();
				east[i][3] = i;
				north[i][3] = Integer.MAX_VALUE;
				north[i][0] = Integer.MAX_VALUE;
				north[i][1] = Integer.MAX_VALUE;
			}
			north[i][2] = Integer.MAX_VALUE;
			east[i][2] = Integer.MAX_VALUE;
		}
		sortbyColumn(east, 2 - 1);
		sortbyColumn(north, 1 - 1);
		int[][] b = new int[n][2];
		int blength = 0;
		int a = -1;
		for(int i = 0; i < n; i++) {
			if(a != north[i][0]) {
				sortbyColumn(b, 1);
				for(int j = 0; j < blength - 1; j++) {
					north[b[j][0]][2] = b[j + 1][1] - b[j][1];
				}
				a = north[i][0];
				blength = 0;
				b[blength][0] = i; 
				b[blength][1] = north[i][1];
				blength++;
			}else {
				b[blength][0] = i; 
				b[blength][1] = north[i][1];
				blength++;
			}
		}
		sortbyColumn(b, 1);
		for(int j = 0; j < blength - 1; j++) {
			north[b[j][0]][2] = b[j + 1][1] - b[j][1];
		}
		blength = 0;
		a = -1;
		for(int i = 0; i < n; i++) {
			if(a != east[i][0]) {
				sortbyColumn(b, 1);
				for(int j = 0; j < blength - 1; j++) {
					east[b[j][0]][2] = b[j + 1][1] - b[j][1];
				}
				a = east[i][0];
				blength = 0;
				b[blength][0] = i; 
				b[blength][1] = east[i][1];
				blength++;
			}else {
				b[blength][0] = i; 
				b[blength][1] = east[i][1];
				blength++;
			}
		}
		sortbyColumn(b, 1);
		for(int j = 0; j < blength - 1; j++) {
			east[b[j][0]][2] = b[j + 1][1] - b[j][1];
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(north[i][1] <= east[j][1] && north[i][0] >= east[j][0] && east[j][2] >= north[i][0] - east[j][0] && north[i][2]>east[j][1] - north[i][1]) {
					if(north[i][0] - east[j][0] < east[j][1] - north[i][1]) {
						north[i][2] = east[j][1] - north[i][1];
						break;
					}else if(north[i][0] - east[j][0] > east[j][1] - north[i][1]) {
						east[i][2] = north[i][0] - east[j][0];
					}
				}
			}
		}
		System.out.print("");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(north[j][3] == i) {
					if(north[j][2] == Integer.MAX_VALUE && north[j][1] != Integer.MAX_VALUE) {
						System.out.println("Infinity");
						break;
					}else {
						System.out.println(north[j][2]);
						break;
					}
				}else if(east[j][3] == i) {
					if(east[j][2] == Integer.MAX_VALUE && east[j][1] != Integer.MAX_VALUE) {
						System.out.println("Infinity");
						break;
					}else {
						System.out.println(east[j][2]);
						break;
					}
				}
			}
		}
	}
	
	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) {
                return 1; 
            }
            else {
                return -1; 
            }
          } 
        });  // End of function call sort(). 
    } 
}
