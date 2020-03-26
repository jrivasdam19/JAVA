package Loteria;

import java.util.*;

public class SimulacionLoteria {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Apuesta> listaApuestas = new ArrayList();
        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println("---- MENU PRINCIPAL ----");
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
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    }
                    break;
                case 2:
                    try {
                        listaApuestas.add(Quiniela.crearApuestaQuiniela());
                    } catch (ExcepcionFaltaMayuscula ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        System.out.println("");
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
            int[][] listaPrimitiva, int[] listaAciertos, Primitiva p1) {
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
                        listaAciertos[i] = aciertos;
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
                System.out.println("");
                System.out.println("No hay primitivas ganadoras.");
                System.out.println("");
            }
            i++;
        }
    }

    public static void comprobarQuiniela(ArrayList<Apuesta> listaApuestas,
            String[][] listaQuiniela, int[] listaAciertos, Quiniela q1) {
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
                        listaAciertos[i] = aciertos;
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
                System.out.println("");
                System.out.println("No hay Quinielas ganadoras.");
                System.out.println("");
            }
            i++;
        }
    }

    public static void comprobarAciertos(ArrayList<Apuesta> listaApuestas,
            int[][] listaPrimitiva, String[][] listaQuiniela,
            int[] listaAciertosPrimitivas, int[] listaAciertosQuinielas, int sorteos) {
        for (Apuesta loteria : listaApuestas) {
            if (loteria instanceof Primitiva) {
                Primitiva p1 = ((Primitiva) loteria);
                comprobarPrimitiva(listaApuestas, listaPrimitiva,
                        listaAciertosPrimitivas, p1);
            } else if (loteria instanceof Quiniela) {
                Quiniela q1 = ((Quiniela) loteria);
                comprobarQuiniela(listaApuestas, listaQuiniela,
                        listaAciertosQuinielas, q1);
            }
        }
        mostrarEstadisticas(listaApuestas, listaAciertosPrimitivas, listaAciertosQuinielas, sorteos);
    }

    public static void realizarSimulacion(ArrayList<Apuesta> listaApuestas) {
        Scanner lector = new Scanner(System.in);
        System.out.println("¿Cuántos sorteos quiere realizar de cada apuesta?");
        int sorteos = Integer.parseInt(lector.nextLine());
        int[][] listaPrimitivasGanadoras = new int[sorteos][6];
        int[] listaAciertosPrimitivas = new int[sorteos];
        for (int i = 0; i < sorteos; i++) {
            System.out.println("");
            System.out.println("");
            for (int j = 0; j < 6; j++) {
                listaPrimitivasGanadoras[i][j] = (int) Math.floor(Math.random() * (1 - 49 + 1) + 49);
                System.out.print(listaPrimitivasGanadoras[i][j] + " ");
            }
        }
        String[][] listaQuinielasGanadoras = new String[sorteos][15];
        int[] listaAciertosQuinielas = new int[sorteos];

        String[] valoresQuiniela = {"1", "x", "2"};
        for (int i = 0; i < sorteos; i++) {
            System.out.println("");
            System.out.println("");
            for (int j = 0; j < 15; j++) {
                int random = new Random().nextInt(valoresQuiniela.length);
                listaQuinielasGanadoras[i][j] = valoresQuiniela[random];
                System.out.print(listaQuinielasGanadoras[i][j] + " ");
            }

        }
        comprobarAciertos(listaApuestas, listaPrimitivasGanadoras,
                listaQuinielasGanadoras, listaAciertosPrimitivas,
                listaAciertosQuinielas, sorteos);
    }

    public static void mostrarEstadisticas(ArrayList<Apuesta> listaApuestas,
            int[] listaAciertosPrimitivas, int[] listaAciertosQuinielas, int sorteos) {

        System.out.println("Se han celebrado " + sorteos + " sorteos de primitivas.");
        System.out.println("");
        System.out.println("Resultado para Primitivas.");
        System.out.println("");
        for (Apuesta loteria : listaApuestas) {
            if (loteria instanceof Primitiva) {
                Primitiva p1 = ((Primitiva) loteria);
                p1.mostrarApuesta();

                for (int i = 0; i < listaAciertosPrimitivas.length; i++) {
                    System.out.println("Sorteo Nº" + (i + 1) + ".");
                    System.out.println("Aciertos: " + listaAciertosPrimitivas[i] + ".");
                    System.out.println("");
                    if (listaAciertosPrimitivas[i] == 3) {
                        System.out.println("Primitiva ganadora!");
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("Resultado para Quinielas.");
        for (Apuesta loteria : listaApuestas) {
            if (loteria instanceof Quiniela) {
                Quiniela q1 = ((Quiniela) loteria);
                q1.mostrarApuesta();
                for (int i = 0; i < listaAciertosQuinielas.length; i++) {
                    System.out.println("Sorteo Nº" + (i + 1) + ".");
                    System.out.println("Aciertos: " + listaAciertosQuinielas[i] + ".");
                    System.out.println("");
                    if (listaAciertosQuinielas[i] == 3) {
                        System.out.println("Quiniela ganadora!");
                        System.out.println("");
                    }
                }
            }
        }
    }
}
