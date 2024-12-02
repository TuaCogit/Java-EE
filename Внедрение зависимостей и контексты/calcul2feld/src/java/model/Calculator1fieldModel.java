/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Calculator1field;
import java.util.Scanner;
import javax.ejb.Stateless;


@Stateless
public class Calculator1fieldModel implements Calcul1fieldLocal {

    private Calculator1field calculator = new Calculator1field();
    //разбиение строки и вычисление резуьтата
    @Override
    public double calculate(String input) {
        return calculator.calculate(input);
    }

  
}

































