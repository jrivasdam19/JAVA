package Figuras_Geometricas;

import java.util.*;

public class Tetraedro implements FiguraBidimensional, FiguraTridimensional {

    private double arista;

    public double getArista() {
        return arista;
    }

    public void setArista(double arista) {
        this.arista = arista;
    }

    @Override
    public void anyadirFigura() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce la arista.");
        this.setArista(Double.parseDouble(lector.nextLine()));
    }

    @Override
    public void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo {
        if (i == 1) {
            double area = Math.sqrt(3) * Math.pow(this.getArista(), 2);
            System.out.println("El área del tetraedro es " + area + " centímetros cuadrados.");
        } else if (i == 2) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Introduce la arista.");
            double arista = Double.parseDouble(lector.nextLine());
            if (arista <= 0) {
                throw new ExcepcionSignoPositivo();
            }
            double area = Math.sqrt(3) * Math.pow(arista, 2);
            System.out.println("El área del tetraedro es " + area + " centímetros cuadrados.");
        }
    }

    @Override
    public void calcularVolumen(int i) throws ExcepcionSignoPositivo {
        if (i == 1) {
            double volumen = (Math.sqrt(2) / 12) * Math.pow(this.getArista(), 2);
            System.out.println("El volumen del tetraedro es " + volumen + " centímetros cúbicos.");
        } else if (i == 2) {
            try {
                Scanner lector = new Scanner(System.in);
                System.out.println("Introduce la arista.");
                double arista = Double.parseDouble(lector.nextLine());
                if (arista <= 0) {
                    throw new ExcepcionSignoPositivo();
                }
                double volumen = (Math.sqrt(2) / 12) * Math.pow(arista, 2);
                System.out.println("El volumen del tetraedro es " + volumen + " centímetros cúbicos.");
            } catch (RuntimeException ex) {
                System.out.println("Los valores introducidos no son "
                        + "correctos. Vuelva a intentarlo.");
                System.out.println("");
                Tetraedro t1 = new Tetraedro();
                t1.calcularVolumen(2);
            }
        }
    }

    @Override
    public void imprimirCaracteristicas() throws ExcepcionSignoPositivo {
        System.out.println("La arista es de: " + this.getArista() + " centímetros.");
        this.calcularArea(1);
        this.calcularVolumen(1);
    }

    public static Tetraedro anyadirTetraedro() {
        Tetraedro t1 = new Tetraedro();
        t1.anyadirFigura();
        return t1;
    }
}
