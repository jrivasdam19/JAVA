package vehiculos;

import java.util.*;

public class Autobus extends Vehiculo {

    private int numeroPlazas;
    private int numeroParadas;

    public Autobus() {
    }

    public Autobus(int numeroPlazas, int numeroParadas, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroPlazas = numeroPlazas;
        this.numeroParadas = numeroParadas;
    }

    public Autobus(Autobus a1) {
        super.setId(a1.getId());
        super.setMatricula(a1.getMatricula());
        super.setModelo(a1.getModelo());
        super.setPotencia(a1.getPotencia());
        this.numeroParadas = a1.numeroParadas;
        this.numeroPlazas = a1.numeroPlazas;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public int getNumeroParadas() {
        return numeroParadas;
    }

    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    @Override
    public String mostrarAtributos() {
        return super.mostrarAtributos() + "Autobus{" + "numeroPlazas=" + numeroPlazas + ", numeroParadas=" + numeroParadas + '}';
    }

    @Override
    public void darAlta() {
        Scanner lector = new Scanner(System.in);
        super.darAlta();
        System.out.println("Introduzca el número de plazas.");
        this.setNumeroPlazas(Integer.parseInt(lector.nextLine()));
        System.out.println("Introduzca el número de paradas.");
        boolean comprobarParadas = false;
        while (!comprobarParadas) {
            this.setNumeroParadas(Integer.parseInt(lector.nextLine()));
            if (this.getNumeroParadas() < 3) {
                System.out.println("El número de paradas ha de ser como mínimo de 3.");
            }
            if (this.getNumeroParadas() > 20) {
                System.out.println("El número de paradas ha de ser como máximo de 20.");
            }
            if (this.getNumeroParadas() >= 3 && this.getNumeroParadas() <= 20) {
                comprobarParadas = true;
            }
        }

    }

    public static Autobus darAltaAutobus() {
        Autobus a1 = new Autobus();
        a1.darAlta();
        return a1;
    }
}
