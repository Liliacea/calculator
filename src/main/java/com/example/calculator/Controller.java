package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static com.example.calculator.Model.*;


public class Controller {
    private Double firstNumber;
    private Double secondNumber;
    private Double msNumber;
    private Double mrNumber;
    private String mResult;
    public String mValue;
    private Double value;
    private Operation operation;
    private boolean isNewNumber = true;
    public String percentValue;
    @FXML
    TextField textField = new TextField();



    @FXML
    private void inputDigitAction (ActionEvent event) {
      /*  if (firstNumber != null) {
            textField.clear();

        }

       */


        String value = ((Button) event.getSource()).getText();


        if (textField.getText().equals("0")) {
            if (value.equals("0")) {
                return;
            }
            if (!value.equals(".")) {
                textField.clear();
            } else {
                textField.setText(textField.getText() + value);
            }


        }




        if (isNewNumber) {
            textField.setText(value.equals(".") ? "0." : value);
            isNewNumber = false;
        } else {
            if (value.equals(".") && textField.getText().contains(".")) {
                return;


            }

            textField.setText(textField.getText() + value);
        }

    }
    @FXML
    private void msAction (ActionEvent event){
        msNumber = Double.parseDouble(textField.getText());
        textField.setText("0");
    }
    @FXML
    private void mMinusAction (ActionEvent event){
      mValue = ((Button)event.getSource()).getText();
    }
    @FXML
    private void mPlusAction (ActionEvent event){
       mValue = ((Button)event.getSource()).getText();
    }
    @FXML
    private void mrAction (ActionEvent event){
        if (mValue == null||msNumber==null){
            return;
        }

        mrNumber = Double.parseDouble(textField.getText());
        if(mValue.equals("M-")){
            textField.setText(Double.toString(msNumber-mrNumber));
        }
        if (mValue.equals("M+")){
            textField.setText(Double.toString(msNumber+mrNumber));
        } else{
            return;
        }
    }

        @FXML
    private void operationAction(ActionEvent event) {

        if(firstNumber == null) {
            firstNumber = Double.parseDouble(textField.getText());
            textField.setText(firstNumber.toString());
        } else {
            secondNumber = Double.parseDouble(textField.getText());
            firstNumber = Model.calculate(firstNumber,secondNumber,operation);

            textField.setText(Double.toString(firstNumber));
        }
        String value = ((Button) event.getSource()).getText();
        operation = switch (value) {
            case "+" -> Model.Operation.addition;
            case "-" -> Model.Operation.substraction;
            case "*" -> Model.Operation.multiplication;
            case "/" -> Model.Operation.division;

            default -> null;
        };
        isNewNumber = true;


    }


    @FXML
    private void percentAction (ActionEvent event){
        if (operation == null){
            return;
        }

            secondNumber = Double.parseDouble(textField.getText());
        percentValue = ((Button) event.getSource()).getText();
    //    if (percentValue.equals("%")){
            secondNumber = secondNumber*firstNumber/100;
            textField.setText(Double.toString(secondNumber));
      //  }
    }


    @FXML
    private void resultAction (ActionEvent event){
        if (operation == null){
            return;
        }

        if(value == null){
        secondNumber = Double.parseDouble(textField.getText());} //при нажатии на равно повторном должен прибавляться второй операнд
        else
        {firstNumber = Double.parseDouble(textField.getText()); }
        value = Model.calculate(firstNumber,secondNumber,operation);//сделать вывод промежуточных значений

        String result = Double.toString(value);
        textField.setText(result);
        isNewNumber = true;
            }



            @FXML
    private void clearAction (ActionEvent event){

        textField.setText("0");
        value = null;
        firstNumber = null;
        secondNumber = null;


            }
            @FXML
    private void backspaseAction (ActionEvent event){
        String value = textField.getText().toString();
        if (value == null || value.length()==0){
            return;
        } else{
            value = value.substring(0,value.length()-1);

        }
        textField.setText(value);

            }

            @FXML
    private void mcAction(ActionEvent event){
        textField.setText("0");
        value = null;
        mrNumber = null;
        msNumber = null;
        mResult = null;
            }



    }
