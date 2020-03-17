package Figuras_Geometricas;

import java.util.*;

public class Circulo implements FiguraBidimensional {

    private double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
    public void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo{
        if (i == 1) {
            double area = FiguraBidimensional.numeroPi * Math.pow(this.getRadio(), 2);
            System.out.println("El área del círculo es " + area + " centímetros cuadrados.");
        } else if (i == 2) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Introduce el radio.");
            double radio = Double.parseDouble(lector.nextLine());
                        if(radio<=0){
                throw new ExcepcionSignoPositivo();
            }
            double area = FiguraBidimensional.numeroPi * Math.pow(radio, 2);
            System.out.println("El área del círculo es " + area + " centímetros cuadrados.");
        }
    }

    @Override
    public void imprimirCaracteristicas() throws ExcepcionSignoPositivo  {
        System.out.println("El radio es: " + this.getRadio() + " centímetros.");
        this.calcularArea(1);
    }

    public static Circulo anyadirCirculo() {
        Circulo c1 = new Circulo();
        c1.anyadirFigura();
        return c1;
    }
}
