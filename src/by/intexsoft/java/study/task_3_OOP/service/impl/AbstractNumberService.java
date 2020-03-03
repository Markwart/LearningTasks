package by.intexsoft.java.study.task_3_OOP.service.impl;

import by.intexsoft.java.study.task_3_OOP.service.INumberService;

import java.util.Scanner;

public abstract class AbstractNumberService implements INumberService {

    public int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the matrix size (integer): ");
        int matrixDimension = scanner.nextInt();
        return new int[matrixDimension][matrixDimension];
    }
}
