package com.matrix.operator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by anvitha on 3/10/16.
 */
public class MatrixOperator {

    public static void main(String[] args) {
        Matrix matrix = matrixBuilder();

        System.out.println("The original matrix is:");
        matrix.print();

        matrix.rotateNinetyDegreesCounterClockwise();
        System.out.println("The resultant matrix is:");
        matrix.print();
    }

    private static Matrix matrixBuilder() {
        System.out.println("Please enter the following inputs to build your matrix!");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int numberOfRows = getNextInputValue(input);

        System.out.println("Enter the number of columns");
        int numberOfColumns = getNextInputValue(input);

        String[][] matrix = new String[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.printf("Enter an element to fill the matrix at position (%d, %d): ", i, j);
                matrix[i][j] = input.next();
            }
        }
        return new Matrix(matrix);
    }

    private static int getNextInputValue(Scanner input) {
        int inputValue = 0;
        try {
            inputValue = input.nextInt();
        } catch (InputMismatchException ime) {
            System.err.println("To construct the matrix only accepts numbers, please enter numbers and try again!");
            ime.printStackTrace();
            System.exit(-1);
        }
        return inputValue;
    }

}
