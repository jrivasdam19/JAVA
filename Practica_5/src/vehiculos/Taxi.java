package vehiculos;

import java.util.*;

public class Taxi extends Vehiculo {
    
    private int numeroLicencia;
    private boolean estado;
    private String numeroTaxista;
    private static int siguienteNumeroLicencia = 1000;
    
    public Taxi() {
    }
    
    public Taxi(int numeroLicencia, boolean estado, String numeroTaxista, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.numeroTaxista = numeroTaxista;
    }
    
    public Taxi(Taxi t1) {
        super.setId(t1.getId());
        super.setMatricula(t1.getMatricula());
        super.setModelo(t1.getModelo());
        super.setPotencia(t1.getPotencia());
        this.numeroLicencia = t1.numeroLicencia;
        this.estado = t1.estado;
        this.numeroTaxista = t1.numeroTaxista;
    }
    
    public int getNumeroLicencia() {
        return numeroLicencia;
    }
    
    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getNumeroTaxista() {
        return numeroTaxista;
    }
    
    public void setNumeroTaxista(String numeroTaxista) {
        this.numeroTaxista = numeroTaxista;
    }
    
    public static int getSiguienteNumeroLicencia() {
        return siguienteNumeroLicencia;
    }
    
    public static void setSiguienteNumeroLicencia(int siguienteNumeroLicencia) {
        Taxi.siguienteNumeroLicencia = siguienteNumeroLicencia;
    }
    
    @Override
    public String mostrarAtributos() {
        return super.mostrarAtributos() + "Taxi{" + "numeroLicencia=" + numeroLicencia + ", estado=" + estado + ", numeroTaxista=" + numeroTaxista + '}';
    }
    
    @Override
    public void darAlta() {
        Scanner lector = new Scanner(System.in);
        super.darAlta();
        System.out.println("Introduzca el estado (Libre/Ocupado).");
        boolean comprobar = true;
        while (comprobar) {
            String estado = lector.nextLine();
            if (estado.equalsIgnoreCase("libre")) {
                this.setEstado(true);
                comprobar = false;
            } else if (estado.equalsIgnoreCase("ocupado")) {
                this.setEstado(false);
                comprobar = false;
            } else {
                System.out.println("Error. Vuelve a intentarlo.");
            }
        }
        this.setNumeroLicencia(Taxi.getSiguienteNumeroLicencia());
        Taxi.setSiguienteNumeroLicencia(Taxi.getSiguienteNumeroLicencia() + 1);
        System.out.println("Introduzca el número de taxista.");
        this.setNumeroTaxista(lector.nextLine());
    }
    
    public static Taxi darAltaTaxi() {
        Taxi t1 = new Taxi();
        t1.darAlta();
        return t1;
    }
    
}
