package Figuras_Geometricas;

import java.util.*;

public class Pentagono implements FiguraBidimensional {

    private double perimetro;
    private double apotema;
    private double area;

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getApotema() {
        return apotema;
    }

    public void setApotema(double apotema) {
        this.apotema = apotema;
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
        System.out.println("Introduce el perímetro.");
        this.setPerimetro(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la apotema.");
        this.setApotema(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea() {
        double area=(this.getPerimetro() * this.getApotema()) / 2;
        System.out.println("El área del pentágono es " + area + " centímetros cruadrados.");
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("El perímetro es: " + this.getPerimetro() + " centímetros.");
        System.out.println("El apotema es: " + this.getApotema() + " centímetros.");
        this.calcularArea();
    }
    
    public static Pentagono anyadirPentagono(){
        Pentagono p1=new Pentagono();
        p1.anyadirFigura();
        return p1;
    }
}
