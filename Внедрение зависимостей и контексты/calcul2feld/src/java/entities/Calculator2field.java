package entities;

public class Calculator2field {
    //сложение
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    //вычитание
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    //умножение
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    //деление
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("");
        }
    }
}
