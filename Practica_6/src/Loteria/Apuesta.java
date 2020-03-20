package Loteria;

public abstract class Apuesta {

    private String nombre;
    private String apellido;
    private int numApuesta;
    private static int sigNumApuesta;

    public Apuesta() {
        this.setNumApuesta(sigNumApuesta++);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumApuesta() {
        return numApuesta;
    }

    public void setNumApuesta(int numApuesta) {
        this.numApuesta = numApuesta;
    }

    public static int getSigNumApuesta() {
        return sigNumApuesta;
    }

    public static void setSigNumApuesta(int sigNumApuesta) {
        Apuesta.sigNumApuesta = sigNumApuesta;
    }

    public Apuesta(String nombre, String apellido, int numApuesta) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumApuesta(sigNumApuesta++);
    }

    public Apuesta(Apuesta a1) {
        this.setNombre(a1.getNombre());
        this.setApellido(a1.getApellido());
        this.setNumApuesta(a1.getNumApuesta());
    }

    public void mostrarApuesta() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("Número de apuesta: " + this.getNumApuesta());
    }

}
