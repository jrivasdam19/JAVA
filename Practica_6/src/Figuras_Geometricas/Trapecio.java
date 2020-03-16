package Figuras_Geometricas;

import java.util.*;

public class Trapecio implements FiguraBidimensional {

    private double baseMenor;
    private double baseMayor;
    private double altura;
    private double area;

    public double getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(double baseMenor) {
        this.baseMenor = baseMenor;
    }

    public double getBaseMayor() {
        return baseMayor;
    }

    public void setBaseMayor(double baseMayor) {
        this.baseMayor = baseMayor;
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

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce la base menor.");
        this.setBaseMenor(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la base mayor.");
        this.setBaseMayor(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la altura.");
        this.setAltura(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea() {
        this.setArea(((this.getBaseMenor() + this.getBaseMayor()) / 2) * this.getAltura());
        System.out.println("El área del trapecio es " + this.getArea() + " centímetros cuadrados.");
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("La base menor es de: " + this.getBaseMenor() + " centímetros.");
        System.out.println("La base mayor es de: " + this.getBaseMayor() + " centímetros.");
        System.out.println("La altura es de: " + this.getAltura() + " centímetros.");
        this.calcularArea();
    }
    
    public static Trapecio anyadirTrapecio(){
        Trapecio t1=new Trapecio();
        t1.anyadirFigura();
        return t1;
    }
}
