package by.intexsoft.java.study.task_3_OOP.service.impl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberPyramidService extends AbstractNumberService {

    @Override
    public void fillWithFieldsMatrix(int[][] twoDimArray) {
        int currentNumber = 1;
        int firstRowIndex = 0, firstColumnIndex = 0;
        int lastColumnIndex = twoDimArray.length - 1, lastRowIndex = twoDimArray.length - 1;

        while (firstRowIndex <= twoDimArray.length / 2 && lastColumnIndex >= twoDimArray.length / 2) {
            currentNumber = fillFieldsOnPerimeter(twoDimArray, currentNumber, firstRowIndex, lastColumnIndex, lastRowIndex, firstColumnIndex);
            firstRowIndex = firstColumnIndex += 1;
            lastColumnIndex = lastRowIndex -= 1;
        }
    }

    @Override
    public void printMatrix(int[][] twoDimArray) {
        for (int[] intArray : twoDimArray) {
            String stringFromIntArray = Arrays.stream(intArray)
                    .mapToObj(item -> String.format("%02d", item))
                    .collect(Collectors.joining(","));
            System.out.println(stringFromIntArray);
        }
    }

    private static int fillFieldsOnPerimeter(int[][] twoDimArray, int currentNumber, int firstRowIndex, int lastColumnIndex, int lastRowIndex, int firstColumnIndex) {
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

}
