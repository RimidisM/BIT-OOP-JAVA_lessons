package matrixdet;

/**
 *
 * @author rimid
 */
public class MatrixDet {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int [][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        //Print the answer
        System.out.println("Determinant of the matrix: "); 
        printM(m, 4, 4);
        System.out.println("");
        System.out.println("is : " + det(m, m.length)); 
        
    }
      
    static int det(int m[][], int n) { 
        
        int D = 0; 
      
        // If matix contains single element 
        if (n == 1) 
            return m[0][0]; 
          
        // To store cofactors 
        int temp[][] = new int[m.length][m.length];  
          
        // To store sign multiplier 
        int sign = 1;  
      
        // Iterate for each element of first row 
        for (int f = 0; f < n; f++) { 
            // Getting Cofactor of m[0][f] 
            getCofactor(m, temp, 0, f, n); 
            D += sign * m[0][f]  
               * det(temp, n - 1); 
      
            // terms are to be added with alternate sign 
            sign = -sign; 
        } 
      
        return D; 
    } 
      
    /* function for displaying the matrix */
    static void printM(int mat[][], int row, int col) {
        
        for (int i = 0; i < row; i++) { 
            for (int j = 0; j < col; j++) 
                System.out.print(mat[i][j] + ",  "); 
                System.out.print("\n"); 
        } 
    } 
    
    // Function to get cofactor of  
    // m[p][q] in temp[][]. 
    //n is current dimension of mat[][] 
    static void getCofactor(int mat[][], int temp[][], int p, int q, int n) {
        
        int i = 0, j = 0; 
      
        // Looping for each element of the matrix 
        for (int row = 0; row < n; row++) { 
            for (int col = 0; col < n; col++) { 
                  
                // Copying into temporary matrix only those element which are  
                // not in given row and column 
                if (row != p && col != q) { 
                    temp[i][j++] = mat[row][col]; 
      
                    // Row is filled, so increase  
                    // row index and reset col index 
                    if (j == n - 1) { 
                        j = 0; 
                        i++; 
                    } 
                } 
            } 
        } 
    } 
}
