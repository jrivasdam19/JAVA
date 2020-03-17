package Figuras_Geometricas;

import java.util.*;

public class Cilindro implements FiguraBidimensional, FiguraTridimensional {

    private double radio;
    private double altura;

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

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el radio.");
        this.setRadio(Double.parseDouble(lector.nextLine()));
        System.out.println("Introduce la altura.");
        this.setAltura(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo {
        if (i == 1) {
            double area = 2 * FiguraBidimensional.numeroPi * this.getRadio() * (this.getRadio() + this.getAltura());
            System.out.println("El área del cilindro es " + area + " centímetros cuadrados.");
        } else if (i == 2) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Introduce el radio.");
            double radio = Double.parseDouble(lector.nextLine());
            System.out.println("Introduce la altura.");
            double altura = Double.parseDouble(lector.nextLine());
            if(radio<=0 || altura<=0){
                throw new ExcepcionSignoPositivo();
            }
            double area = 2 * FiguraBidimensional.numeroPi * radio * (radio + altura);            
            System.out.println("El área del cilindro es " + area + " centímetros cuadrados.");
        }

    }

    @Override
    public void calcularVolumen(int i) throws ExcepcionSignoPositivo {
        if (i == 1) {
            double volumen = FiguraBidimensional.numeroPi * Math.pow(this.getRadio(), 2) * this.getAltura();
            System.out.println("El volumen del cilindro es " + volumen + " centímetros cúbicos.");
        } else if (i == 2) {
            try {
                Scanner lector = new Scanner(System.in);
                System.out.println("Introduce el radio.");
                double radio = Double.parseDouble(lector.nextLine());
                System.out.println("Introduce la altura.");
                double altura = Double.parseDouble(lector.nextLine());
                if(radio<=0 || altura<=0){
                throw new ExcepcionSignoPositivo();
            }
                double volumen = FiguraBidimensional.numeroPi * Math.pow(radio, 2) * altura;
                System.out.println("El volumen del cilindro es " + volumen + " centímetros cúbicos.");
            } catch (RuntimeException ex) {
                System.out.println("Los valores introducidos no son "
                                + "correctos. Vuelva a intentarlo.");
                System.out.println("");
                Cilindro c1=new Cilindro();
                c1.calcularVolumen(2);
            }
        }
    }

    @Override
    public void imprimirCaracteristicas() throws ExcepcionSignoPositivo  {
        System.out.println("El radio es: " + this.getRadio() + " centímetros.");
        System.out.println("La altura es: " + this.getAltura() + " centímetros.");
        this.calcularArea(1);
        this.calcularVolumen(1);
    }

    public static Cilindro anaydirCilindro() {
        Cilindro c1 = new Cilindro();
        c1.anyadirFigura();
        return c1;
    }
}
