package br.gui.aula12so;

public class Controller {
    public double calculaDelta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    public double calculaX1(double a, double b, double delta) {
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double calculaX2(double a, double b, double delta) {
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

}
