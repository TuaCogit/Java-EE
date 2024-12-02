/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Calculator1field {

    public double calculate(String string) {
        //получение результата вычислений
        double result=calc(string);
        return result;
    }
    //расщепление строки на числа и арифметические операторы
    public double calc(String string){
        String[] arr = string.split("(?=([+\\-*/]))");
        double result = Double.parseDouble(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result = performCalculation(result, arr[i]);
        }
        return result;
    }
    //расчет результата арифметического выражения
    public double performCalculation(double currentResult, String operationAndNumber) {
        String[] operationAndNumberArr = operationAndNumber.split("");
        String operation = operationAndNumberArr[0];
        double number =  Double.parseDouble(operationAndNumberArr[1]);
        switch (operation) {
            case "+":
                return currentResult + number;
            case "-":
                return currentResult - number;
            case "*":
                return currentResult * number;
            case "/":
                return currentResult / number;
            default:
                throw new UnsupportedOperationException("");
        }
        
    }
   
}
