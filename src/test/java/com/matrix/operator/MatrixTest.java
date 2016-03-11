package com.matrix.operator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anvitha on 3/10/16.
 * <p>
 * Following the BDD pattern(Given When Then) for unit tests for better readability!
 */
public class MatrixTest {

    private Matrix matrix;

    @Test(expected = IllegalArgumentException.class)
    public void testNullMatrix() {
        givenANullMatrix();
    }

    @Test
    public void testMatrixTranspose() {
        givenAMatrix();
        whenTransposeIsCalled();
        thenTransposeMatrixIsVerified();
    }

    @Test
    public void testMatrixReverse() {
        givenAMatrix();
        whenReverseIsCalled();
        thenReverseMatrixIsVerified();
    }

    @Test
    public void testMatrixRotatedNinetyDegreeCounterClockwise() {
        givenAMatrix();
        whenRotateNinetyDegreeCounterClockwiseIsCalled();
        thenRotateNinetyDegreeCounterClockwiseMatrixIsVerified();
    }

    @Test
    public void testMatrixRotatedNinetyDegreeCounterClockwiseSquareRotation() {
        givenASquareMatrix();
        whenRotateNinetyDegreeCounterClockwiseIsCalled();
        thenRotateNinetyDegreeCounterClockwiseSquareMatrixIsVerified();
    }

    @Test
    public void testMatrixRotatedNinetyDegreeCounterClockwiseRectangleRotation() {
        givenARectangleMatrix();
        whenRotateNinetyDegreeCounterClockwiseIsCalled();
        thenRotateNinetyDegreeCounterClockwiseRectangleMatrixIsVerified();
    }

    private void givenANullMatrix() {
        String[][] matrixArray = null;
        matrix = new Matrix(matrixArray);
    }

    private void givenAMatrix() {
        String[][] matrixArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        matrix = new Matrix(matrixArray);
    }

    /*
      [0, 1, 0, 0],
      [0, 1, 1, 0],
      [0, 0, 1, 0],
      [0, 0, 0, 0]
     */
    private void givenASquareMatrix() {
        String[][] matrixArray = {
                {"0", "1", "0", "0"},
                {"0", "1", "1", "0"},
                {"0", "0", "1", "0"},
                {"0", "0", "0", "0"},
        };
        matrix = new Matrix(matrixArray);
    }

    /*
          [0, 1, 0],
          [1, 1, 1]
     */
    private void givenARectangleMatrix() {
        String[][] matrixArray = {
                {"0", "1", "0"},
                {"1", "1", "1"},
        };
        matrix = new Matrix(matrixArray);
    }

    private void whenTransposeIsCalled() {
        matrix.transpose();
    }

    private void whenReverseIsCalled() {
        matrix.reverse();
    }

    private void whenRotateNinetyDegreeCounterClockwiseIsCalled() {
        matrix.rotateNinetyDegreesCounterClockwise();
    }

    private void thenTransposeMatrixIsVerified() {
        String[][] expectedTranspose = {
                {"1", "4", "7"},
                {"2", "5", "8"},
                {"3", "6", "9"}};
        Matrix expectedTransposeMatrix = new Matrix(expectedTranspose);
        assertEquals(expectedTransposeMatrix, matrix);
    }

    private void thenReverseMatrixIsVerified() {
        String[][] expectedReverse = {
                {"7", "8", "9"},
                {"4", "5", "6"},
                {"1", "2", "3"},
        };
        Matrix expectedReverseMatrix = new Matrix(expectedReverse);
        assertEquals(expectedReverseMatrix, matrix);

    }

    private void thenRotateNinetyDegreeCounterClockwiseMatrixIsVerified() {
        String[][] expectedRotateNinetyDegreeCounterClockwise = {
                {"3", "6", "9"},
                {"2", "5", "8"},
                {"1", "4", "7"},
        };
        Matrix expectedRotateNinetyDegreeCounterClockwiseMatrix = new Matrix(expectedRotateNinetyDegreeCounterClockwise);
        assertEquals(expectedRotateNinetyDegreeCounterClockwiseMatrix, matrix);
    }

    /*
        Expected:
        [0, 0, 0, 0],
        [0, 1, 1, 0],
        [1, 1, 0, 0],
        [0, 0, 0, 0]
     */
    private void thenRotateNinetyDegreeCounterClockwiseSquareMatrixIsVerified() {
        String[][] expectedRotateNinetyDegreeCounterClockwise = {
                {"0", "0", "0", "0"},
                {"0", "1", "1", "0"},
                {"1", "1", "0", "0"},
                {"0", "0", "0", "0"},
        };
        Matrix expectedRotateNinetyDegreeCounterClockwiseMatrix = new Matrix(expectedRotateNinetyDegreeCounterClockwise);
        assertEquals(expectedRotateNinetyDegreeCounterClockwiseMatrix, matrix);
    }

    /*
        [0, 1],
        [1, 1],
        [0, 1]
     */
    private void thenRotateNinetyDegreeCounterClockwiseRectangleMatrixIsVerified() {
        String[][] expectedRotateNinetyDegreeCounterClockwise = {
                {"0", "1"},
                {"1", "1"},
                {"0", "1"},
        };
        Matrix expectedRotateNinetyDegreeCounterClockwiseMatrix = new Matrix(expectedRotateNinetyDegreeCounterClockwise);
        assertEquals(expectedRotateNinetyDegreeCounterClockwiseMatrix, matrix);
    }

}