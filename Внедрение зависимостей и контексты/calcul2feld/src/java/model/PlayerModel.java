/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;

@Stateless

public class PlayerModel {
    //загаданное число
     private int secretNumber = (int) (Math.random() * 10) + 1;
     //проверка, угадал ли игрок число
    public String guessNumber(int number) {
        if (number == secretNumber) {
            return "Вы угадали!";
        } else {
            return "Попробуйте еще раз";
        }
    }//получение загаданного числа
    public int getNumber() {
        return secretNumber;
    }
}

























