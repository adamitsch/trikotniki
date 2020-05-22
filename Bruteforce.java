import java.util.Scanner;

public class Bruteforce {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // število vozlišč
        int n = sc.nextInt();
        // število povezav
        int m = sc.nextInt();
        boolean[][] graf = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf[a][b]=true;
            graf[b][a]=true;
        }
        long start = System.currentTimeMillis();
        
        int count = 0;

        // 6-krat hitrejše kot spodnja
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if(graf[i][j] && graf[i][k] && graf[k][j]){
                        count++;
                    }
                }
            }
        }
        
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(graf[i][j] && graf[i][k] && graf[k][j]){
                        count++;
                    }
                }
            }
        }
        count = count / 6;
        */
        
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Stevilo trikotnikov: "+ count + ", cas: "+timeElapsed+"ms");

    }
}