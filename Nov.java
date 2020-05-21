import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Nov {

    public static boolean [] visited;
    public static int trikotnikov;
    public static int vozlisc;
    public static boolean [][] graf;

    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in);
        vozlisc = sc.nextInt();
        int povezav = sc.nextInt();
        graf = new boolean [vozlisc][vozlisc];

        for (int i = 0; i < povezav; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf[a][b]=true;
            graf[b][a]=true;
        }

        visited = new boolean[vozlisc];
        trikotnikov = 0;
        funkcija(0);
        System.out.println("trikotnikov: "+trikotnikov);
    }

    public static void funkcija(int vozlisce){
        //visited[vozlisce] = true;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < vozlisc; i++) {
            //1
            if(graf[vozlisce][i] && !visited[i]){
                stack.push(i);
                //2
                
                String pot = Integer.toString(vozlisce);
                if(dfs(i, 0, vozlisce, pot+i)){
                    trikotnikov++;
                }
            }
        }
        //3
        visited[vozlisce] = true;
        //4
        while(!stack.isEmpty()){
            int a = stack.pop();
            funkcija(a);
            if(!visited[a]){
                
            }
        }
    }
    public static boolean dfs(int vozlisce, int globina, int zacetno, String pot){
        
        if(globina==2){
            if(vozlisce == zacetno){
                System.out.println(pot+ " je trikotnik");
                return true;
            }
            else {
                return false;
            }
        }
        
        for (int i = 0; i < vozlisc; i++) {
            if( graf[vozlisce][i] && ( !visited[i] ) ){

                if(dfs(i,globina+1,zacetno,pot+Integer.toString(i))){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
https://stackoverflow.com/questions/7396570/what-is-an-efficient-algorithm-for-counting-the-number-of-triangles-in-a-graph

You will need depth first search. The algorithm will be:

1) For the current node ask all unvisited adjacent nodes

2) for each of those nodes run depth two check to see if a node at depth 2 is your current node from step one

3) mark current node as visited

4) on make each unvisited adjacent node your current node (1 by 1) and run the same algorithm
*/
