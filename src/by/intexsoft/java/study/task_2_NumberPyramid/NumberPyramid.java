package by.intexsoft.java.study.task_2_NumberPyramid;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberPyramid {

    public static void main(String[] args) {
        int matrixDimension = setMatrixSize();
        int[][] twoDimArray = new int[matrixDimension][matrixDimension];
        completeMatrix(matrixDimension, twoDimArray);
        printMatrix(twoDimArray);
    }

    private static int fillEmptyFields(int[][] twoDimArray, int currentNumber, int firstRowIndex, int lastColumnIndex, int lastRowIndex, int firstColumnIndex) {
        for (int index = firstRowIndex; index < lastColumnIndex + 1; index++) {
            if (twoDimArray[firstRowIndex][index] == 0 && twoDimArray[lastRowIndex][index] == 0) {
                twoDimArray[firstRowIndex][index] = currentNumber;
                twoDimArray[lastRowIndex][index] = currentNumber;
            }
        }

        for (int index = firstColumnIndex; index < lastRowIndex + 1; index++) {
            if (twoDimArray[index][firstRowIndex] == 0 && twoDimArray[index][lastRowIndex] == 0) {
                twoDimArray[index][firstRowIndex] = currentNumber;
                twoDimArray[index][lastRowIndex] = currentNumber;
            }
        }
        currentNumber++;
        return currentNumber;
    }

    private static int setMatrixSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the matrix size (integer): ");
        return scanner.nextInt();
    }

    private static void completeMatrix(int matrixDimension, int[][] twoDimArray) {
        int currentNumber = 1;
        int firstRowIndex = 0, firstColumnIndex = 0;
        int lastColumnIndex = matrixDimension - 1, lastRowIndex = matrixDimension - 1;

        while (firstRowIndex <= matrixDimension / 2 && lastColumnIndex >= matrixDimension / 2) {
            currentNumber = fillEmptyFields(twoDimArray, currentNumber, firstRowIndex, lastColumnIndex, lastRowIndex, firstColumnIndex);
            firstRowIndex = firstColumnIndex += 1;
            lastColumnIndex = lastRowIndex -= 1;
        }
    }

    private static void printMatrix(int[][] twoDimArray) {
        for (int[] intArray : twoDimArray) {
            String stringFromIntArray = Arrays.stream(intArray)
                    .mapToObj(item -> String.format("%02d", item))
                    .collect(Collectors.joining(","));
            System.out.println(stringFromIntArray);
        }
    }
}
