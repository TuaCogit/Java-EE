/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Local;

/**
 *
 * @author Ang
 */
@Local
public interface Calcul2fieldLocal {
     double add(double num1, double num2);
     double subtract(double num1, double num2);
     double multiply(double num1, double num2);
     double divide(double num1, double num2);
  }
