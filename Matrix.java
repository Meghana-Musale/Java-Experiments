class Matrix {
    private double[][] data;
    private int rows, cols;

     // Constructor
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                this.data[i][j] = data[i][j];
    }

    // Addition
    public Matrix add(Matrix other) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = this.data[i][j] + other.data[i][j];
        return new Matrix(result);
    }

    // Subtraction
    public Matrix subtract(Matrix other) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = this.data[i][j] - other.data[i][j];
        return new Matrix(result);
    }

    // Matrix Multiplication
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows)
            throw new IllegalArgumentException("Incompatible matrices");

        double[][] result = new double[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < other.cols; j++)
                for (int k = 0; k < this.cols; k++)
                    result[i][j] += this.data[i][k] * other.data[k][j];

        return new Matrix(result);
    }

    // Scalar Multiplication
    public Matrix scalarMultiply(double scalar) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = this.data[i][j] * scalar;
        return new Matrix(result);
    }

    // Transpose
    public Matrix transpose() {
        double[][] result = new double[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                result[i][j] = this.data[j][i];
        return new Matrix(result);
    }

   
    // Display
    public void print() {
        for (double[] row : data) {
            for (double val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }
}

// MatrixTest.java
public class MatrixTest {
    public static void main(String[] args) {
        double[][] data1 = {
            {1, 2},
            {3, 4}
        };

        double[][] data2 = {
            {5, 6},
            {7, 8}
        };

        Matrix m1 = new Matrix(data1);
        Matrix m2 = new Matrix(data2);

        System.out.println("Matrix 1:");
        m1.print();

        System.out.println("Matrix 2:");
        m2.print();

        System.out.println("Addition:");
        m1.add(m2).print();

        System.out.println("Subtraction:");
        m1.subtract(m2).print();

        System.out.println("Matrix Multiplication:");
        m1.multiply(m2).print();

        System.out.println("Scalar Multiplication (m1 * 2):");
        m1.scalarMultiply(2).print();

        System.out.println("Transpose of Matrix 1:");
        m1.transpose().print();
    }
}
