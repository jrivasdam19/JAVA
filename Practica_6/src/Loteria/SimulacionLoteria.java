package Loteria;

import java.util.*;

public class SimulacionLoteria {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Apuesta> listaApuestas = new ArrayList();
        boolean salir = false;
        while (!salir) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1.- Crear apuesta Primitiva.");
            System.out.println("2.- Crear apuesta Quiniela.");
            System.out.println("3.- Realizar simulación.");
            System.out.println("4.- Salir.");
            int opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                    try {
                        listaApuestas.add(Primitiva.crearApuestaPrimitiva());
                    } catch (ExcepcionFaltaMayuscula ex) {
                        ex.getMessage();
                    }
                    break;
                case 2:
                    try {
                        listaApuestas.add(Quiniela.crearApuestaQuiniela());
                    } catch (ExcepcionFaltaMayuscula ex) {
                        ex.getMessage();
                    }
                    break;
                case 3:
                    realizarSimulacion(listaApuestas);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Error. Opción incorrecta.");
                    break;
            }

        }
    }

    public static void comprobarPrimitiva(ArrayList<Apuesta> listaApuestas,
            int[][] listaPrimitiva, Primitiva p1) {
        int i = 0;
        int j = 0;
        boolean comprobarAcierto = false;
        while (!comprobarAcierto) {
            if (i < listaPrimitiva.length) {
                boolean comprobarLista = false;
                int aciertos = 0;
                while (!comprobarLista) {
                    if (p1.getListaNum()[j] == listaPrimitiva[i][j]) {
                        aciertos++;
                        p1.setAciertos(p1.getAciertos() + 1);
                    } else {
                        comprobarLista = true;
                    }
                    if (aciertos == 6) {
                        comprobarLista = true;
                        comprobarAcierto = true;
                    }
                    j++;
                }
            }
            if (i >= listaPrimitiva.length) {
                comprobarAcierto = true;
                System.out.println("No hay primitivas ganadoras.");
            }
            i++;
        }
    }

    public static void comprobarQuiniela(ArrayList<Apuesta> listaApuestas,
            String[][] listaQuiniela, Quiniela q1) {
        int i = 0;
        int j = 0;
        boolean comprobarAcierto = false;
        while (!comprobarAcierto) {
            if (i < listaQuiniela.length) {
                boolean comprobarLista = false;
                int aciertos = 0;
                while (!comprobarLista) {
                    if (q1.getListaOpciones()[j].equals(listaQuiniela[i][j])) {
                        aciertos++;
                        q1.setAciertos(q1.getAciertos() + 1);
                    } else {
                        comprobarLista = true;
                    }
                    if (aciertos == 15) {
                        comprobarLista = true;
                        comprobarAcierto = true;
                    }
                    j++;
                }
            }
            if (i >= listaQuiniela.length) {
                comprobarAcierto = true;
                System.out.println("No hay Quinielas ganadoras.");
            }
            i++;
        }
    }

    public static void comprobarAciertos(ArrayList<Apuesta> listaApuestas,
            int[][] listaPrimitiva, String[][] listaQuiniela) {
        for (Apuesta loteria : listaApuestas) {
            if (loteria instanceof Primitiva) {
                Primitiva p1 = ((Primitiva) loteria);
                comprobarPrimitiva(listaApuestas, listaPrimitiva, p1);
            } else if (loteria instanceof Quiniela) {
                Quiniela q1 = ((Quiniela) loteria);
                comprobarQuiniela(listaApuestas, listaQuiniela, q1);
            }
        }
    }

    public static void realizarSimulacion(ArrayList<Apuesta> listaApuestas) {
        Scanner lector = new Scanner(System.in);
        System.out.println("¿Cuántos sorteos quiere realizar de cada apuesta?");
        int sorteos = Integer.parseInt(lector.nextLine());
        int[][] listaPrimitivasGanadoras = new int[sorteos][6];
        for (int i = 0; i < sorteos; i++) {
            for (int j = 0; j < 6; j++) {
                listaPrimitivasGanadoras[i][j] = (int) Math.floor(Math.random() * (1 - 49 + 1) + 49);
                System.out.print(listaPrimitivasGanadoras[i][j] + " ");
            }
            System.out.println("");
        }
        String[][] listaQuinielasGanadoras = new String[sorteos][15];
        String[] valoresQuiniela = {"1", "x", "2"};
        for (int i = 0; i < sorteos; i++) {
            for (int j = 0; j < 15; j++) {
                int random = new Random().nextInt(valoresQuiniela.length);
                listaQuinielasGanadoras[i][j] = valoresQuiniela[random];
                System.out.print(listaQuinielasGanadoras[i][j] + " ");
            }
            System.out.println("");
        }
        comprobarAciertos(listaApuestas, listaPrimitivasGanadoras, listaQuinielasGanadoras);
    }
}
