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
public interface Calcul1fieldLocal {
     double calculate(String input);
  }
