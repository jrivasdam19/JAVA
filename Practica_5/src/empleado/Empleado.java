package empleado;

import java.util.*;

public class Empleado {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private double salario;
    private int edad;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido1, String apellido2, String nif, double salario, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.salario = salario;
        this.edad = edad;
    }

    public Empleado(Empleado e1) {
        this.nombre = e1.nombre;
        this.apellido1 = e1.apellido1;
        this.apellido2 = e1.apellido2;
        this.nif = e1.nif;
        this.salario = e1.salario;
        this.edad = e1.edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarAtributos() {
        System.out.println("El nombre es " + this.getNombre() + ".");
        System.out.println("El 1er apellido es " + this.getApellido1() + ".");
        System.out.println("El 2do apellido es " + this.getApellido2() + ".");
        System.out.println("El nif es " + this.getNif() + ".");
        System.out.println("El salario es " + this.getSalario() + ".");
        System.out.println("La edad es " + this.getEdad() + ".");

    }

    public static void mostrarAtributosEmpleados(ArrayList<Empleado> listaEmpleados) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i) instanceof Empleado) {
                listaEmpleados.get(i).mostrarAtributos();
            }
        }
    }

    public void pedirAlta() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe el nombre.");
        this.setNombre(asegurarMayuscula(lector.nextLine()));
        System.out.println("Escribe el primer apellido.");
        this.setApellido1(asegurarMayuscula(lector.nextLine()));
        System.out.println("Escribe el segundo apellido.");
        this.setApellido2(asegurarMayuscula(lector.nextLine()));
        System.out.println("Escribe el nif.");
        this.setNif(lector.nextLine());
        System.out.println("Escribe el salario.");
        this.setSalario(lector.nextDouble());
        System.out.println("Escribe la edad.");
        boolean menorDeEdad = true;
        while (menorDeEdad) {
            this.setEdad(lector.nextInt());
            if (this.getEdad() >= 16) {
                menorDeEdad = false;
            } else if (this.getEdad() < 16) {
                System.out.println("Debes ser mayor de 16 años para darte de alta.");
                System.out.println("Vuelve a introducir tu edad.");
            }
        }

    }

    public static String asegurarMayuscula(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    } //substring divide el String desde la posición 0 a la 1.
    //en el caso de substring(1) coge desde la posición 1 hasta el final.

    public static Empleado pedirAltaEmpleado() {
        Scanner lector = new Scanner(System.in);
        Empleado e1 = new Empleado();
        e1.pedirAlta();
        return e1;
    }
}
