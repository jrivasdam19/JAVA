package vehiculos;

import java.util.*;

public class Vehiculo {

    private int id;
    private String matricula;
    private String modelo;
    private int potencia;
    private static int siguienteId = 0;

    public Vehiculo() {
    }

    public Vehiculo(int id, String matricula, String modelo, int potencia) {
        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public Vehiculo(Vehiculo v1) {
        this.id = v1.id;
        this.matricula = v1.matricula;
        this.modelo = v1.matricula;
        this.potencia = v1.potencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public static int getSiguienteId() {
        return siguienteId;
    }

    public static void setSiguienteId(int siguienteId) {
        Vehiculo.siguienteId = siguienteId;
    }

    public String mostrarAtributos() {
        return "Vehiculo{" + "id=" + id + ", matricula=" + matricula + ", modelo=" + modelo + ", potencia=" + potencia + '}';
    }

    public void darAlta() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca la matrícula");
        this.setMatricula(lector.nextLine().toUpperCase());
        System.out.println("Introduzca el modelo");
        this.setModelo(primeraLetraMayuscula(lector.nextLine()));
        System.out.println("Introduzca la potencia");
        boolean potenciaPositiva = false;
        while (!potenciaPositiva) {
            this.setPotencia(Integer.parseInt(lector.nextLine()));
            if (this.getPotencia() <= 0) {
                System.out.println("La potencia debe ser mayor que 0.");
            }
            if (this.getPotencia() > 0) {
                potenciaPositiva = true;
            }
        }
        this.setId(Vehiculo.getSiguienteId());
        Vehiculo.setSiguienteId(Vehiculo.getSiguienteId() + 1);
    }

    public static String primeraLetraMayuscula(String str) {
        str.toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
