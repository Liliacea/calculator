package com.example.calculator;

public class Model {


    public enum Operation{
        addition,
        substraction,
        multiplication,
        division



    }
    public static double calculate(double firstNumber, double secondNumber, Operation operation){
        return switch (operation){
            case addition -> firstNumber + secondNumber;
            case substraction -> firstNumber - secondNumber;
            case multiplication -> firstNumber * secondNumber;
            case division -> firstNumber/secondNumber;


        };

    }

}
