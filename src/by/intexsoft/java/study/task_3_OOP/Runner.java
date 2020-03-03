package by.intexsoft.java.study.task_3_OOP;

import by.intexsoft.java.study.task_3_OOP.service.INumberService;
import by.intexsoft.java.study.task_3_OOP.service.impl.NumberPyramidService;
import by.intexsoft.java.study.task_3_OOP.service.impl.NumberSnakeService;

public class Runner {

    public static void main(String[] args) {
        INumberService numberSnakeService = new NumberSnakeService();
        int[][] firstTwoDimArray = numberSnakeService.createMatrix();
        numberSnakeService.fillWithFieldsMatrix(firstTwoDimArray);
        numberSnakeService.printMatrix(firstTwoDimArray);
        System.out.println();
        INumberService numberPyramidService = new NumberPyramidService();
        int[][] secondTwoDimArray = numberPyramidService.createMatrix();
        numberPyramidService.fillWithFieldsMatrix(secondTwoDimArray);
        numberPyramidService.printMatrix(secondTwoDimArray);
    }
}
