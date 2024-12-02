/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Calculator2field;
import javax.ejb.Stateless;

/**
 *
 * @author Ang
 */
@Stateless
public class Calculator2fieldModel implements Calcul2fieldLocal {
private Calculator2field calculator = new Calculator2field();

       @Override //сложение
       public double add(double num1, double num2) {
           return calculator.add(num1, num2);
       }
       @Override //вычитание
       public double subtract(double num1, double num2) {
           return calculator.subtract(num1, num2);
       }
       @Override //умножение
       public double multiply(double num1, double num2) {
           return calculator.multiply(num1, num2);
       }
       @Override //деление
       public double divide(double num1, double num2) {
           return calculator.divide(num1, num2);
       }
}





















