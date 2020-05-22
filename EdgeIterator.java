import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class EdgeIterator { 
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int vozlisc = sc.nextInt();
        int povezav = sc.nextInt();

        ArrayList<HashSet<Integer>> graf = new ArrayList<HashSet<Integer>>(vozlisc);

        int [][] povezave = new int[povezav][2];

        //vsako vozlisce sosede v hashsetu
        for (int i = 0; i < vozlisc; i++) {
            graf.add(new HashSet<Integer>());
        }
        
        int a,b;
        for (int i = 0; i < povezav; i++) {
            a=sc.nextInt();
            b=sc.nextInt();

            /*
            za štetje uporabimo izboljšavo iz algoritma "forward"
                -> topološko urejen graf (implicitno)
            graf.get(a).add(b);
            graf.get(b).add(a);
            */
            if(a<b){
                graf.get(a).add(b);
            }
            else{
                graf.get(b).add(a);
            }

            povezave[i][0] = a;
            povezave[i][1] = b;
        }
        sc.close();

        int count = 0;
        for (int i = 0; i < povezav; i++) {
            a = povezave[i][0];
            b = povezave[i][1];
            
            //čez manjšega
            if(graf.get(a).size() > graf.get(b).size()){
               int temp = a;
               a = b;
               b = temp; 
            }
            
            HashSet<Integer> hsa = graf.get(a);
            HashSet<Integer> hsb = graf.get(b);

            Iterator<Integer> it = hsa.iterator();
            while(it.hasNext()){
                if(hsb.contains(it.next())) {
                    count++;
                }
            }
            
        }

        System.out.println(count+ " je število trikotnikov");

    }

}