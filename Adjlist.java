import java.util.Scanner;
import java.util.ArrayList;

public class Adjlist {

	static void dodajPovezavo(ArrayList<ArrayList<Integer>> graf, int i, int j ) {
		graf.get(i).add(j);
		graf.get(j).add(i);
	}

	static void print(ArrayList<ArrayList<Integer>> graf){
		for (int i = 0; i < graf.size(); i++) { 
            System.out.println(i+" : "); 
            for (int j = 0; j < graf.get(i).size(); j++) { 
                System.out.print(graf.get(i).get(j)+", "); 
            } 
            System.out.println(); 
        } 
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graf = new ArrayList<ArrayList<Integer>>(n); 

		for (int i = 0; i < n; i++) {
			graf.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dodajPovezavo(graf,a,b);
		}

		//System.out.println(graf.toString());
		//print(graf);

		int sum = 0;
		for (int i = 0; i < graf.size(); i++) {
			for(int j : graf.get(i)){
				for (int k : graf.get(j)) {
					if(graf.get(i).contains(k)){
						sum++;
					}
				}
			}
		}

		System.out.println(sum / 6);

		//*
		
		/*/
		
		//*/
	}
}
