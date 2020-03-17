package Figuras_Geometricas;

import java.util.*;

public class Trapecio implements FiguraBidimensional {

    private double baseMenor;
    private double baseMayor;
    private double altura;

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
    public void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo {
        if (i == 1) {
            double area = ((this.getBaseMenor() + this.getBaseMayor()) / 2) * this.getAltura();
            System.out.println("El área del trapecio es " + area + " centímetros cuadrados.");
        } else if (i == 2) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Introduce la base menor.");
            double baseMenor = Double.parseDouble(lector.nextLine());
            System.out.println("Introduce la base mayor.");
            double baseMayor = Double.parseDouble(lector.nextLine());
            System.out.println("Introduce la altura.");
            double altura = Double.parseDouble(lector.nextLine());
                        if(baseMenor<=0 || baseMayor<=0 || altura<=0){
                throw new ExcepcionSignoPositivo();
            }
            double area = ((baseMenor + baseMayor) / 2) * altura;
            System.out.println("El área del trapecio es " + area + " centímetros cuadrados.");
        }
    }

    @Override
    public void imprimirCaracteristicas() throws ExcepcionSignoPositivo {
        System.out.println("La base menor es de: " + this.getBaseMenor() + " centímetros.");
        System.out.println("La base mayor es de: " + this.getBaseMayor() + " centímetros.");
        System.out.println("La altura es de: " + this.getAltura() + " centímetros.");
        this.calcularArea(1);
    }

    public static Trapecio anyadirTrapecio() {
        Trapecio t1 = new Trapecio();
        t1.anyadirFigura();
        return t1;
    }
}
