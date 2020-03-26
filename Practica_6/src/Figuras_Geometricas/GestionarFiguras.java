package Figuras_Geometricas;

import java.util.*;

public class GestionarFiguras {

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
                    boolean interruptor2 = true;
                    while (interruptor2) {
                        int opcion2 = menuFigurasBidimensionales();
                        switch (opcion2) {
                            case 1:
                                Circulo.anyadirCirculo();
                                break;
                            case 2:
                                Pentagono.anyadirPentagono();
                                break;
                            case 3:
                                Trapecio.anyadirTrapecio();
                                break;
                            case 4:
                                Cilindro.anaydirCilindro();
                                break;
                            case 5:
                                Tetraedro.anyadirTetraedro();
                                break;
                            case 6:
                                interruptor = false;
                                break;
                            default:
                                System.out.println("Error. Opción incorrecta.");
                                break;
                        }
                    }
                    break;
                case 2:
                    try {
                        boolean interruptor3 = true;
                        while (interruptor3) {
                            int opcion3 = menuFigurasBidimensionales();
                            switch (opcion3) {
                                case 1:
                                    Circulo c1 = new Circulo();
                                    c1.calcularArea(2);
                                    break;
                                case 2:
                                    Pentagono p1 = new Pentagono();
                                    p1.calcularArea(2);
                                    break;
                                case 3:
                                    Trapecio t1 = new Trapecio();
                                    t1.calcularArea(2);
                                    break;
                                case 4:
                                    Cilindro cil1 = new Cilindro();
                                    cil1.calcularArea(2);
                                    break;
                                case 5:
                                    Tetraedro tet1 = new Tetraedro();
                                    tet1.calcularArea(2);
                                    break;
                                case 6:
                                    interruptor3 = false;
                                    break;
                                default:
                                    System.out.println("Error. Opción incorrecta");
                                    break;
                            }
                        }
                    } catch (RuntimeException ex) {
                        System.out.println("Los valores introducidos no son "
                                + "correctos. Vuelva a intentarlo.");
                        System.out.println("");
                        ex.printStackTrace();
                    } catch (ExcepcionSignoPositivo ex) {
                        System.out.println("Las variables no pueden ser negativas.");
                        System.out.println("");
                        ex.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        boolean interruptor4 = true;
                        while (interruptor4) {
                            int opcion4 = menuFigurasTridimensionales();
                            switch (opcion4) {
                                case 1:
                                    Cilindro c1 = new Cilindro();
                                    c1.calcularVolumen(2);
                                    break;
                                case 2:
                                    Tetraedro t1 = new Tetraedro();
                                    t1.calcularVolumen(2);
                                    break;
                                case 3:
                                    interruptor4 = false;
                                    break;
                                default:
                                    System.out.println("Error. Opción incorrecta.");
                                    break;
                            }
                        }
                    } catch (ExcepcionSignoPositivo ex) {
                        System.out.println("Las variables no pueden ser negativas.");
                        System.out.println("");
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Calculadora de José Rivas.");
                        imprimirFiguras(listaFiguras);
                    } catch (ExcepcionSignoPositivo ex) {
                        System.out.println("Las variables no pueden ser negativas.");
                        System.out.println("");
                        ex.printStackTrace();
                    }
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

    public static void imprimirFiguras(ArrayList<FiguraBidimensional> listaFiguras) throws ExcepcionSignoPositivo {
        for (FiguraBidimensional f : listaFiguras) {
            if (f instanceof Circulo) {
                ((Circulo) f).imprimirCaracteristicas();
            }
            if (f instanceof Cilindro) {
                ((Cilindro) f).imprimirCaracteristicas();
            }
            if (f instanceof Pentagono) {
                ((Pentagono) f).imprimirCaracteristicas();
            }
            if (f instanceof Trapecio) {
                ((Trapecio) f).imprimirCaracteristicas();
            }
            if (f instanceof Tetraedro) {
                ((Tetraedro) f).imprimirCaracteristicas();
            }
            System.out.println("");
        }
    }

    public static int menuFigurasBidimensionales() {
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("Elige una figura.");
        System.out.println("");
        System.out.println("1.- Círculo.");
        System.out.println("2.- Pentágono.");
        System.out.println("3.- Trapecio.");
        System.out.println("4.- Cilindro.");
        System.out.println("5.- Tetraedro.");
        System.out.println("6.- Salir.");
        int opcion = Integer.parseInt(lector.nextLine());
        return opcion;
    }

    public static int menuFigurasTridimensionales() {
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("Elige una figura.");
        System.out.println("");
        System.out.println("1.- Cilindro.");
        System.out.println("2.- Tetraedro.");
        System.out.println("3.- Salir.");
        int opcion = Integer.parseInt(lector.nextLine());
        return opcion;
    }
}
