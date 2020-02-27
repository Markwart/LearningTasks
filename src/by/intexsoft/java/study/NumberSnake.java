package by.intexsoft.java.study;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberSnake {

    public static void main(String[] args) {

        int matrixDimension = setMatrixSize();

        int[][] twoDimArray = createMatrix(matrixDimension);

        completeMatrix(matrixDimension, twoDimArray);

        printMatrix(twoDimArray);
    }

    private static int setMatrixSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the matrix size (integer): ");

        return scanner.nextInt();
    }

    private static int[][] createMatrix(int matrixDimension) {
        return new int[matrixDimension][matrixDimension];
    }

    private static void completeMatrix(int matrixDimension, int[][] twoDimArray) {

        int currentNumber = 1;
        int firstRowIndex = 0;
        int lastColumnIndex = matrixDimension - 1;
        int lastRowIndex = matrixDimension - 1;
        int firstColumnIndex = 0;

        while (firstRowIndex <= matrixDimension / 2 && lastColumnIndex >= matrixDimension / 2) {

            currentNumber = fillEmptyFields(lastColumnIndex, currentNumber, twoDimArray, firstRowIndex, lastRowIndex, firstColumnIndex);

            firstRowIndex = firstColumnIndex += 1;
            lastColumnIndex = lastRowIndex -= 1;
        }
    }

    private static int fillEmptyFields(int lastColumnIndex, int currentNumber, int[][] twoDimArray, int firstRowIndex, int lastRowIndex, int firstColumnIndex) {

        for (int index = firstRowIndex; index < lastColumnIndex + 1; index++) {

            if (twoDimArray[firstRowIndex][index] == 0) {
                twoDimArray[firstRowIndex][index] = currentNumber;
                currentNumber++;
            }
        }

        for (int index = firstColumnIndex; index < lastRowIndex + 1; index++) {

            if (twoDimArray[index][lastRowIndex] == 0) {
                twoDimArray[index][lastRowIndex] = currentNumber;
                currentNumber++;
            }
        }

        for (int index = lastColumnIndex; index >= 0; index--) {

            if (twoDimArray[lastColumnIndex][index] == 0) {
                twoDimArray[lastColumnIndex][index] = currentNumber;
                currentNumber++;
            }
        }

        for (int index = lastRowIndex; index >= 0; index--) {

            if (twoDimArray[index][firstColumnIndex] == 0) {
                twoDimArray[index][firstColumnIndex] = currentNumber;
                currentNumber++;
            }
        }
        return currentNumber;
    }

    private static void printMatrix(int[][] twoDimArray) {
        for (int[] arrayInt : twoDimArray) {

            String stringArray = Arrays.stream(arrayInt)
                    .mapToObj(item -> String.format("%03d", item))
                    .collect(Collectors.joining(","));

            System.out.println(stringArray);
        }
    }
}

