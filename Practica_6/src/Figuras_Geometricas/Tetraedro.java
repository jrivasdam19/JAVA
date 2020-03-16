package Figuras_Geometricas;

import java.util.*;

public class Tetraedro implements FiguraBidimensional, FiguraTridimensional {

    private double arista;
    private double area;
    private double volumen;

    public double getArista() {
        return arista;
    }

    public void setArista(double arista) {
        this.arista = arista;
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
        System.out.println("Introduce la arista.");
        this.setArista(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea() {
        this.setArea(Math.sqrt(3) * Math.pow(this.getArista(), 2));
        System.out.println("El área del tetraedro es " + this.getArea() + " centímetros cuadrados.");
    }

    @Override
    public void calcularVolumen() {
        this.setVolumen((Math.sqrt(2) / 12) * Math.pow(this.getArista(), 2));
        System.out.println("El volumen del tetraedro es " + this.getVolumen() + " centímetros cúbicos.");
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("La arista es de: " + this.getArista() + " centímetros.");
        this.calcularArea();
        this.calcularVolumen();
    }
    
    public static Tetraedro anyadirTetraedro(){
        Tetraedro t1=new Tetraedro();
        t1.anyadirFigura();
        return t1;
    }
}
