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
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(graf[i][j] && graf[i][k] && graf[k][j]){
                        count++;
                    }
                }
            }
        }
        System.out.println(count/6);

    }
}