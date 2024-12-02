
package entities;


public class Player {
    //назначение числа для игрока
    private int number = (int) (Math.random() * 10) + 1;
    private int num;

    public Player(int num) {
        this.num = num;
    }
    //получение числа
    public int getNumber() {
        return number;
    }

}



























