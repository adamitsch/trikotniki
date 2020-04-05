import java.util.*;

public class Strassen {
    public static int velikostMatrik;

    static int[][] sestejMatriki( int [][] mat1, int [][] mat2){
        int vel = mat1.length;
        int [][] opa = new int[vel][vel];
        for(int i=0; i<vel; i++){
            for(int j=0; j<vel; j++){
                opa[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        return opa;
    }
    
    static int [][] odstejMatriki( int [][] mat1, int [][] mat2){
        int vel = mat1.length;
        int [][] opa = new int[vel][vel];
        for(int i=0; i<vel; i++){
            for(int j=0; j<vel; j++){
                opa[i][j]=mat1[i][j]-mat2[i][j];
            }
        }
        return opa;
    }

    static int[][] strassen(int [][] mat1, int [][] mat2){
            
        int dimenzija=mat1.length;
        int tempDimenzija=dimenzija/2;

        if(dimenzija == 1){
            int [][] zaReturnat = new int[1][1];
            zaReturnat[0][0] = mat1[0][0] * mat2[0][0];
            return zaReturnat;
        }
        
        int [][] a11 = new int[tempDimenzija][tempDimenzija];
        int [][] b11 = new int[tempDimenzija][tempDimenzija];
        int [][] a12 = new int[tempDimenzija][tempDimenzija];
        int [][] b12 = new int[tempDimenzija][tempDimenzija];
        int [][] a21 = new int[tempDimenzija][tempDimenzija];
        int [][] b21 = new int[tempDimenzija][tempDimenzija];
        int [][] a22 = new int[tempDimenzija][tempDimenzija];
        int [][] b22 = new int[tempDimenzija][tempDimenzija];
        
        for(int i=0; i<tempDimenzija; i++){
            for(int j=0; j<tempDimenzija; j++){
                a11[i][j]=mat1[i][j];
                b11[i][j]=mat2[i][j];
                a12[i][j]=mat1[i][j+tempDimenzija];
                b12[i][j]=mat2[i][j+tempDimenzija];
                a21[i][j]=mat1[i+tempDimenzija][j];
                b21[i][j]=mat2[i+tempDimenzija][j];
                a22[i][j]=mat1[i+tempDimenzija][j+tempDimenzija];
                b22[i][j]=mat2[i+tempDimenzija][j+tempDimenzija];
            }
        }
        
        int [][] p1 = strassen(a11, odstejMatriki(b12,b22) );
        int [][] p2 = strassen(sestejMatriki(a11,a12), b22 );
        int [][] p3 = strassen(sestejMatriki(a21,a22), b11 );
        int [][] p4 = strassen(a22, odstejMatriki(b21,b11) );
        int [][] p5 = strassen(sestejMatriki(a11,a22), sestejMatriki(b11,b22));
        int [][] p6 = strassen(odstejMatriki(a12,a22), sestejMatriki(b21,b22));
        int [][] p7 = strassen(odstejMatriki(a11,a21),sestejMatriki(b11,b12));
       
        int [][] zaReturnat = new int[dimenzija][dimenzija];
        
        for(int i=0; i<tempDimenzija; i++){
            for(int j=0; j<tempDimenzija; j++){
            
                zaReturnat[i][j]=p5[i][j]+p4[i][j]-p2[i][j]+p6[i][j];
                zaReturnat[i][j+tempDimenzija]=p1[i][j]+p2[i][j];
                zaReturnat[i+tempDimenzija][j]=p3[i][j]+p4[i][j];
                zaReturnat[i+tempDimenzija][j+tempDimenzija]=p1[i][j]+p5[i][j]-p3[i][j]-p7[i][j];
            }
        }    
        return zaReturnat;        
}
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        // vozlisc
        int n = sc.nextInt();
        // povezav
        int m = sc.nextInt();

        double potenca = Math.log(n)/Math.log(2);
        velikostMatrik =(int) Math.pow(2, Math.ceil(potenca)); 

        int[][] graf = new int[velikostMatrik][velikostMatrik];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf[a][b]=1;
            graf[b][a]=1;
        }

        
        int [][] tretja = strassen(strassen(graf,graf),graf);
        int sum = 0;
        for (int i = 0; i < velikostMatrik; i++) {
            sum += tretja[i][i];
        }
        System.out.println("vseh trikotnikov je: "+sum/6);
        // System.out.println(Arrays.deepToString(strassen(strassen(graf,graf),graf)));

    }

}