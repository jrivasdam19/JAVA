package empleado;

import java.util.*;

public final class Repartidor extends Empleado {

    private int horasTrabajadas;
    private String zona;

    public Repartidor() {
    }

    public Repartidor(int horasTrabajadas, String zona, String nombre, String apellido1, String apellido2, String nif, double salario, int edad) {
        super(nombre, apellido1, apellido2, nif, salario, edad);
        this.horasTrabajadas = horasTrabajadas;
        this.zona = zona;
    }

    public Repartidor(Repartidor r1) {
        super.setNombre(r1.getNombre());
        super.setApellido1(r1.getApellido1());
        super.setApellido2(r1.getApellido2());
        super.setNif(r1.getNif());
        super.setSalario(r1.getSalario());
        super.setEdad(r1.getEdad());
        this.horasTrabajadas = r1.horasTrabajadas;
        this.zona = r1.zona;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Ha trabajado " + this.getHorasTrabajadas() + " horas.");
        System.out.println("Trabaja en " + this.getZona() + ".");
    }

    public static void mostrarAtributosRepartidor(ArrayList<Empleado> listaEmpleados) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i) instanceof Repartidor) {
                listaEmpleados.get(i).mostrarAtributos(); //Ocultación del método padre.
            }
        }
    }

    @Override
    public void pedirAlta() {
        Scanner lector = new Scanner(System.in);
        super.pedirAlta();
        System.out.println("Introduce la zona en que trabaja");
        this.setZona(lector.nextLine());
        System.out.println("Introduce las horas trabajadas");
        this.setHorasTrabajadas(lector.nextInt());
    }

    public static Repartidor pedirAltaRepartidor() {
        Repartidor r1 = new Repartidor();
        r1.pedirAlta();
        return r1;
    }
}
