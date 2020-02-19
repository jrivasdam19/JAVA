package empleado;

import java.util.*;

public final class Comercial extends Empleado {

    private int ventasRealizadas;
    private double comision;

    public Comercial() {
    }

    public Comercial(int ventasRealizadas, double comision, String nombre, String apellido1, String apellido2, String nif, double salario, int edad) {
        super(nombre, apellido1, apellido2, nif, salario, edad);
        this.ventasRealizadas = ventasRealizadas;
        this.comision = comision;
    }

    public Comercial(Comercial c1) {
        super.setNombre(c1.getNombre());
        super.setApellido1(c1.getApellido1());
        super.setApellido2(c1.getApellido1());
        super.setNif(c1.getNif());
        super.setSalario(c1.getSalario());
        super.setEdad(c1.getEdad());
        this.ventasRealizadas = c1.ventasRealizadas;
        this.comision = c1.comision;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Ha hecho " + this.getVentasRealizadas() + " ventas.");
        System.out.println("Tiene de comisión " + this.getComision() + ".");
    }
    public static void mostrarAtributosComercial(ArrayList<Empleado> listaEmpleados){
        for (int i=0;i<listaEmpleados.size();i++){
            if (listaEmpleados.get(i)instanceof Comercial){
                listaEmpleados.get(i).mostrarAtributos(); //Ocultación del método padre.
            }
        }
    }

    @Override
    public void pedirAlta() {
        Scanner lector = new Scanner(System.in);
        super.pedirAlta();
        System.out.println("Escribe las ventas realizadas.");
        this.setVentasRealizadas(lector.nextInt());
        System.out.println("Escribe la comisión.");
        this.setComision(lector.nextDouble());
    }

    public static Comercial pedirAltaComercial() {
        Scanner lector = new Scanner(System.in);
        Comercial c1 = new Comercial();
        c1.pedirAlta();
        return c1;
    }
}
