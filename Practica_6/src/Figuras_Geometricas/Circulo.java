package Figuras_Geometricas;

import java.util.*;

public class Circulo implements FiguraBidimensional {

    private double radio;
    private double area;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Circulo() {
    }

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el radio del círculo.");
        this.setRadio(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea() {
        this.setArea(FiguraBidimensional.numeroPi * Math.pow(this.getRadio(), 2));
        System.out.println("El área del círculo es " + this.getArea() + " centímetros cuadrados.");
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("El radio es: " + this.getRadio() + " centímetros.");
        this.calcularArea();
    }
    
    public static Circulo anyadirCirculo(){
        Circulo c1=new Circulo();
        c1.anyadirFigura();
        return c1;
    }
}
