package empleado;

import java.util.*;

public class GestionarEmpleados {

    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        boolean interruptor = true;
        while (interruptor) {
            Scanner lector = new Scanner(System.in);
            System.out.println("1.- Añadir empleado.");
            System.out.println("2.- Añadir comercial.");
            System.out.println("3.- Añadir repartidor.");
            System.out.println("4.- Mostrar atributos.");
            System.out.println("5.- Salir.");
            int opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    listaEmpleados.add(Empleado.pedirAltaEmpleado());
                    break;
                case 2:
                    listaEmpleados.add(Comercial.pedirAltaComercial());
                    break;
                case 3:
                    listaEmpleados.add(Repartidor.pedirAltaRepartidor());
                    break;
                case 4:
                    boolean interruptor2 = true;
                    while (interruptor2) {
                        System.out.println("1.- Empleados.");
                        System.out.println("2.- Comerciales.");
                        System.out.println("3.- Repartidores.");
                        System.out.println("4.- Salir.");
                        int opcion2 = lector.nextInt();
                        switch (opcion2) {
                            case 1:
                                Empleado.mostrarAtributosEmpleados(listaEmpleados);
                                break;
                            case 2:
                                Comercial.mostrarAtributosComercial(listaEmpleados);
                                break;
                            case 3:
                                Repartidor.mostrarAtributosRepartidor(listaEmpleados);
                                break;
                            case 4:
                                interruptor2 = false;
                                break;
                            default:
                                System.out.println("Error. Opción incorrecta");
                                break;

                        }
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
}
