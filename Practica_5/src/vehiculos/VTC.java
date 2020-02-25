package vehiculos;

import java.util.*;

public class VTC extends Vehiculo {

    private int numeroHorasTrabajadas;
    private int radioAccion;
    private String ciudad;

    public VTC() {
    }

    public VTC(int numeroHorasTrabajadas, int radioAccion, String ciudad, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
        this.radioAccion = radioAccion;
        this.ciudad = ciudad;
    }

    public VTC(VTC vtc1) {
        super.setId(vtc1.getId());
        super.setMatricula(vtc1.getMatricula());
        super.setModelo(vtc1.getModelo());
        super.setPotencia(vtc1.getPotencia());
        this.numeroHorasTrabajadas = vtc1.numeroHorasTrabajadas;
        this.radioAccion = vtc1.radioAccion;
        this.ciudad = vtc1.ciudad;
    }

    public int getNumeroHorasTrabajadas() {
        return numeroHorasTrabajadas;
    }

    public void setNumeroHorasTrabajadas(int numeroHorasTrabajadas) {
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
    }

    public int getRadioAccion() {
        return radioAccion;
    }

    public void setRadioAccion(int radioAccion) {
        this.radioAccion = radioAccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String mostrarAtributos() {
        return super.mostrarAtributos() + "VTC{" + "numeroHorasTrabajadas=" + numeroHorasTrabajadas + ", radioAccion=" + radioAccion + ", ciudad=" + ciudad + '}';
    }

    @Override
    public void darAlta() {
        Scanner lector = new Scanner(System.in);
        super.darAlta();
        System.out.println("Introduza el número de horas trabajadas.");
        boolean comprobarHoras = false;
        while (!comprobarHoras) {
            this.setNumeroHorasTrabajadas(Integer.parseInt(lector.nextLine()));
            if (this.getNumeroHorasTrabajadas() > 24) {
                System.out.println("No se pueden superar las 24 h trabajadas.");
            }
            if (this.getNumeroHorasTrabajadas() <= 24) {
                comprobarHoras = true;
            }
        }

        System.out.println("Introduza el radio de acción.");
        boolean comprobarRadio = false;
        while (!comprobarRadio) {
            this.setRadioAccion(Integer.parseInt(lector.nextLine()));
            if (this.getRadioAccion() > 50) {
                System.out.println("No se puede superar un radio de 50 km.");
            }
            if (this.getRadioAccion() <= 50) {
                comprobarRadio = true;
            }
        }

        System.out.println("Introduzca la ciudad.");
        this.setCiudad(lector.nextLine());
    }

    public static VTC darAltaVTC() {
        VTC vtc1 = new VTC();
        vtc1.darAlta();
        return vtc1;
    }
}
