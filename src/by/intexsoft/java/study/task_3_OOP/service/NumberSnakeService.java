package by.intexsoft.java.study.task_3_OOP.service;

import by.intexsoft.java.study.task_3_OOP.api.INumberService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberSnakeService implements INumberService {

    @Override
    public int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("To get \"The snake of numbers\" enter the matrix size (integer): ");
        int matrixDimension = scanner.nextInt();
        return new int[matrixDimension][matrixDimension];
    }

    @Override
    public void fillWithFieldsMatrix(int[][] twoDimArray) {
        int currentNumber = 1;
        int firstRowIndex = 0, firstColumnIndex = 0;
        int lastColumnIndex = twoDimArray.length - 1, lastRowIndex = twoDimArray.length - 1;

        while (firstRowIndex <= twoDimArray.length / 2 && lastColumnIndex >= twoDimArray.length / 2) {
            currentNumber = fillFieldsOnPerimeter(lastColumnIndex, currentNumber, twoDimArray, firstRowIndex, lastRowIndex, firstColumnIndex);
            firstRowIndex = firstColumnIndex += 1;
            lastColumnIndex = lastRowIndex -= 1;
        }
    }

    @Override
    public void printMatrix(int[][] twoDimArray) {
        for (int[] intArray : twoDimArray) {
            String stringFromIntArray = Arrays.stream(intArray)
                    .mapToObj(item -> String.format("%03d", item))
                    .collect(Collectors.joining(","));
            System.out.println(stringFromIntArray);
        }
    }

    private int fillFieldsOnPerimeter(int lastColumnIndex, int currentNumber, int[][] twoDimArray, int firstRowIndex, int lastRowIndex, int firstColumnIndex) {
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
}
