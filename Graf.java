import java.util.Arrays;
import java.util.Scanner;

public class Graf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // število vozlišč
        int n = sc.nextInt();
        // število povezav
        int m = sc.nextInt();
        
        int[][] graf = new int[n][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf[a][b]=1;
            graf[b][a]=1;
        }


        long start = System.currentTimeMillis();

        int[][] mnozenje = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mnozenje[i][j] += graf[i][k]*graf[k][j];
                }
            }
        }

        int[][] mnozenje2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mnozenje2[i][j] += mnozenje[i][k]*graf[k][j];
                }
            }
        }

        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += mnozenje2[i][i];
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Stevilo trikotnikov: "+ sum/6 + ", cas: "+timeElapsed+"ms");

        // System.out.println(Arrays.deepToString(graf));
        // System.out.println(Arrays.deepToString(mnozenje));
        // System.out.println(Arrays.deepToString(mnozenje2));
    }
}