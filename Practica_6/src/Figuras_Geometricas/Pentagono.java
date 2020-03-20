package Figuras_Geometricas;

import java.util.*;

public class Pentagono implements FiguraBidimensional {

    private double perimetro;
    private double apotema;

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

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el perímetro.");
        this.setPerimetro(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la apotema.");
        this.setApotema(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo {
        if (i == 1) {
            double area = (this.getPerimetro() * this.getApotema()) / 2;
            System.out.println("El área del pentágono es " + area + " centímetros cruadrados.");

        } else if (i == 2) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Introduce el perímetro.");
            double perimetro = Double.parseDouble(lector.nextLine());
            System.out.println("Introduce la apotema.");
            double apotema = Double.parseDouble(lector.nextLine());
            if (perimetro <= 0 || apotema <= 0) {
                throw new ExcepcionSignoPositivo();
            }
            double area = (perimetro * apotema) / 2;
            System.out.println("El área del pentágono es " + area + " centímetros cruadrados.");
        }

    }

    @Override
    public void imprimirCaracteristicas() throws ExcepcionSignoPositivo {
        System.out.println("El perímetro es: " + this.getPerimetro() + " centímetros.");
        System.out.println("El apotema es: " + this.getApotema() + " centímetros.");
        this.calcularArea(1);
    }

    public static Pentagono anyadirPentagono() {
        Pentagono p1 = new Pentagono();
        p1.anyadirFigura();
        return p1;
    }
}
