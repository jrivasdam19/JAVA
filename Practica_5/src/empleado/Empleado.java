package empleado;

import java.util.Scanner;

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

    public Empleado (Empleado e1){
        this.nombre=e1.nombre;
        this.apellido1=e1.apellido1;
        this.apellido2=e1.apellido2;
        this.nif=e1.nif;
        this.salario=e1.salario;
        this.edad=e1.edad;
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
    
    public void mostrarAtributos(){
        System.out.println("El nombre es "+this.getNombre()+".");
        System.out.println("El 1er apellido es "+this.getApellido1()+".");
        System.out.println("El 2do apellido es "+this.getApellido2()+".");
        System.out.println("El nif es "+this.getNif()+".");
        System.out.println("El salario es "+this.getSalario()+".");
        System.out.println("La edad es "+this.getEdad()+".");
    }
    
    public void pedirAlta (){
        Scanner lector=new Scanner (System.in);
        System.out.println("Escribe el nombre.");
        this.setNombre(lector.nextLine());
        System.out.println("Escribe el primer apellido.");
        this.setApellido1(lector.nextLine());
        System.out.println("Escribe el segundo apellido.");
        this.setApellido2(lector.nextLine());
        System.out.println("Escribe el nif.");
        this.setNif(lector.nextLine());
        System.out.println("Escribe el salario.");
        this.setSalario(lector.nextDouble());
        System.out.println("Escribe la edad.");
        this.setEdad(lector.nextInt());
    }
public static void main(String[] args) {

    }
    
}
