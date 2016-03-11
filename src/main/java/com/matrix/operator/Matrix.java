package com.matrix.operator;

import java.util.Arrays;

/**
 * Created by anvitha on 3/10/16.
 */
public class Matrix {

    private String[][] matrix;

    public Matrix(String[][] matrix) {
        this.matrix = matrix;
        validate();
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public int getNumberOfRows() {
        return matrix.length;
    }

    public int getNumberOfColumns() {
        return matrix[0].length;
    }

    public void print() {
        System.out.println(toString());
    }

    private void validate() {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.err.println("Matrix cannot be empty!");
            throw new IllegalArgumentException("Matrix cannot be empty!");
        }
    }

    public void transpose() {
        String[][] transpose = new String[matrix[0].length][matrix.length];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                transpose[columnIndex][rowIndex] = matrix[rowIndex][columnIndex];
            }
        }
        matrix = transpose;
    }

    public void reverse() {
        for (int indexFromStart = 0, indexFromEnd = matrix.length - 1; indexFromStart < indexFromEnd; ++indexFromStart, --indexFromEnd) {
            String[] x = matrix[indexFromStart];
            matrix[indexFromStart] = matrix[indexFromEnd];
            matrix[indexFromEnd] = x;
        }
    }

    public void rotateNinetyDegreesCounterClockwise() {
        transpose();
        reverse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        String matrixString = "";
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            String rowString = "";
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                rowString += matrix[rowIndex][columnIndex] + "\t";
            }
            matrixString += rowString + "\n";
        }
        return matrixString;
    }
}
