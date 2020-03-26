package Loteria;

import java.util.*;

public class Primitiva extends Apuesta {

    private int listaNum[] = new int[6];
    private int aciertos;

    public Primitiva() {
    }

    public int[] getListaNum() {
        return listaNum;
    }

    public void setListaNum(int[] listaNum) {
        this.listaNum = listaNum;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public Primitiva(int aciertos, String nombre, String apellido, int numApuesta) {
        super(nombre, apellido, numApuesta);
        this.setAciertos(aciertos);
        this.setListaNum(listaNum);
    }

    public Primitiva(Primitiva p1) {
        super((Apuesta) p1);
        this.setAciertos(p1.getAciertos());
        this.setListaNum(p1.getListaNum());
    }

    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        System.out.println("Aciertos: " + this.getAciertos()+".");
        System.out.print("Primitiva: ");
        for (int elemento : this.getListaNum()) {
            System.out.print(elemento + " ");
        }
        System.out.println("");
    }

    public static Primitiva crearApuestaPrimitiva() throws ExcepcionFaltaMayuscula {
        Scanner lector = new Scanner(System.in);
        Primitiva p1 = new Primitiva();
        p1.setNumApuesta(Apuesta.getSigNumApuesta() + 1);
        System.out.println("");
        System.out.println("Introduce tu nombre en mayúscula.");
        String nombre = lector.nextLine();
        if (!nombre.equals(nombre.toUpperCase())) {
            throw new ExcepcionFaltaMayuscula(001);
        }
        p1.setNombre(nombre);
        System.out.println("");
        System.out.println("Introduce tu apellido en mayúscula.");
        String apellido = lector.nextLine();
        if (!apellido.equals(apellido.toUpperCase())) {
            throw new ExcepcionFaltaMayuscula(002);
        }
        p1.setApellido(apellido);
        p1.setListaNum(p1.getListaNum());
        System.out.println("");
        System.out.println("Introduce los 6 números de la apuesta entre 1-49 (incluidos).");
        for (int i = 0; i < p1.getListaNum().length; i++) {
            System.out.println("Número " + (i + 1) + ":");
            boolean rangoNumero = false;
            while (!rangoNumero) {
                p1.getListaNum()[i] = Integer.parseInt(lector.nextLine());
                if ((p1.getListaNum()[i] >= 1) && (p1.getListaNum()[i] <= 49)) {
                    rangoNumero = true;
                } else {
                    System.out.println("Número fuera de rango. Vuelve a intentarlo.");
                }
            }
        }
        return p1;
    }

}
