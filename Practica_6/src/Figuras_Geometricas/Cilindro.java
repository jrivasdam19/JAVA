package Figuras_Geometricas;

import java.util.*;

public class Cilindro implements FiguraBidimensional, FiguraTridimensional {

    private double radio;
    private double altura;
    private double area;
    private double volumen;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el radio.");
        this.setRadio(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la altura.");
        this.setAltura(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea() {
        this.setArea(2 * FiguraBidimensional.numeroPi * this.getRadio() * (this.getRadio() + this.getAltura()));
        System.out.println("El área del cilindro es " + this.getArea() + " centímetros cuadrados.");
    }

    @Override
    public void calcularVolumen() {
        this.setVolumen(FiguraBidimensional.numeroPi * Math.pow(this.getRadio(), 2) * this.getAltura());
        System.out.println("El volumen del cilindro es " + this.getVolumen() + " centímetros cúbicos.");
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("El radio es: " + this.getRadio() + " centímetros.");
        System.out.println("La altura es: " + this.getAltura() + " centímetros.");
        this.calcularArea();
        this.calcularVolumen();
    }
    
    public static Cilindro anaydirCilindro(){
        Cilindro c1=new Cilindro();
        c1.anyadirFigura();
        return c1;
    }
}
