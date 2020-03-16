package Figuras_Geometricas;

import java.util.*;

public class GestionarFiguras {

    public static void imprimirFiguras(ArrayList<FiguraBidimensional> listaFiguras) {
        for (FiguraBidimensional f: listaFiguras){
            if(f instanceof Circulo){
                ((Circulo)f).imprimirCaracteristicas();
            }
            if(f instanceof Cilindro){
                ((Cilindro)f).imprimirCaracteristicas();
            }
            if(f instanceof Pentagono){
                ((Pentagono)f).imprimirCaracteristicas();
            }
            if(f instanceof Trapecio){
                ((Trapecio)f).imprimirCaracteristicas();
            }
            if(f instanceof Tetraedro){
                ((Tetraedro)f).imprimirCaracteristicas();
            }
            System.out.println("");
        }
    }

    

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<FiguraBidimensional> listaFiguras = new ArrayList();
        boolean interruptor = true;
        while (interruptor) {
            System.out.println("*****MENU PRINCIPAL*****");
            System.out.println("");
            System.out.println("1.- Añadir figura.");
            System.out.println("2.- Calcular área.");
            System.out.println("3.- Calcular volumen");
            System.out.println("4.- Imprimir características.");
            System.out.println("5.- Salir.");
            int opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                case 2:
                    boolean interruptor2 = true;
                    while (interruptor2) {
                        System.out.println("1.- Cículo.");
                        System.out.println("2.- Pentágono.");
                        System.out.println("3.- Trapecio.");
                        System.out.println("4.- Cilindro.");
                        System.out.println("5.- Tetraedro.");
                        System.out.println("6.- Salir.");
                        int opcion2 = Integer.parseInt(lector.nextLine());
                        switch (opcion2) {
                            case 1:
                                if (opcion == 1) {
                                    listaFiguras.add(Circulo.anyadirCirculo());
                                }
                                if (opcion == 2) {

                                }
                                break;
                            case 2:
                                listaFiguras.add(Pentagono.anyadirPentagono());
                                break;
                            case 3:
                                listaFiguras.add(Trapecio.anyadirTrapecio());
                                break;
                            case 4:
                                listaFiguras.add(Cilindro.anaydirCilindro());
                                break;
                            case 5:
                                listaFiguras.add(Tetraedro.anyadirTetraedro());
                                break;
                            case 6:
                                interruptor2 = false;
                                break;
                            default:
                                System.out.println("Error. Opción incorrecta");
                                break;

                        }
                    }
                    break;
                case 3:
                    boolean interruptor3 = true;
                    while (interruptor3) {
                        System.out.println("1.- Cilindro.");
                        System.out.println("2.- Tetraedro.");
                        System.out.println("3.- Salir.");
                        int opcion3 = Integer.parseInt(lector.nextLine());
                        switch (opcion3) {
                            case 1:

                        }
                    }
                case 4:
                    System.out.println("Calculadora de José Rivas.");
                    imprimirFiguras(listaFiguras);
                    break;
                case 5:
                    interruptor = false;
                    break;
                default:
                    System.out.println("Error. Opción incorrecta");
                    break;

            }
        }
    }
}
