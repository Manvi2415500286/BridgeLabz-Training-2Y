import java.util.Random;

public class MatrixAdvancedOps {

    public static double[][] createMatrix(int r, int c) {
        Random rand = new Random();
        double[][] m = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m[i][j] = rand.nextInt(10);
        return m;
    }

    public static double[][] transpose(double[][] m) {
        double[][] t = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                t[j][i] = m[i][j];
        return t;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) throw new IllegalArgumentException("Non-invertible matrix");
        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1]/det;
        inv[0][1] = -m[0][1]/det;
        inv[1][0] = -m[1][0]/det;
        inv[1][1] =  m[0][0]/det;
        return inv;
    }

    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] A2 = createMatrix(2,2);
        System.out.println("2×2 Matrix A:"); printMatrix(A2);
        System.out.println("Transpose:");    printMatrix(transpose(A2));
        System.out.println("Determinant: " + determinant2x2(A2));
        System.out.println("Inverse:");
        try { printMatrix(inverse2x2(A2)); } 
        catch (Exception e) { System.out.println(e.getMessage()); }

        double[][] A3 = createMatrix(3,3);
        System.out.println("\n3×3 Matrix B:"); printMatrix(A3);
        System.out.println("Transpose:"); printMatrix(transpose(A3));
        System.out.println("Determinant: " + determinant3x3(A3));
    }
}
