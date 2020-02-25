package vehiculos;

import java.util.*;

public class GestionarVehiculos {

    public static Vehiculo realizarCasting(Vehiculo v1) {
        Vehiculo clase = new Vehiculo();
        if (v1 instanceof Taxi) {
            clase = (Taxi) v1;
        }
        if (v1 instanceof VTC) {
            clase = (VTC) v1;
        }
        if (v1 instanceof Autobus) {
            clase = (Autobus) v1;
        }
        return clase;
    }

    public static void mostrarDatos(ArrayList<Vehiculo> listaVehiculos) {
        for (Vehiculo v : listaVehiculos) {
            System.out.println(realizarCasting(v).mostrarAtributos());
            System.out.println("");
        }
    }
    //Esto es lo que se llama hacer un casting. Transformamos la clase Vehiculo en Taxi.
    //No mostraba nada antes porque el método mostrarAtributos() devuelve String. 
    //Si fuera un metodo con void no haría falta el sout.

    public static void buscarId(ArrayList<Vehiculo> listaVehiculos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un Id");
        int busqueda = Integer.parseInt(lector.nextLine());
        if (busqueda >= listaVehiculos.size()) {
            System.out.println("No se ha encontrado nada.");
        } else if (busqueda < listaVehiculos.size()) {
            System.out.println("-> " + realizarCasting(listaVehiculos.get(busqueda)).mostrarAtributos());
        }
    }

    public static void buscarMatricula(ArrayList<Vehiculo> listaVehiculos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce una matrícula.");
        String busqueda = lector.nextLine();
        int comprobarBusqueda = 0;
        //En el caso que las matrículas no se puedan repetir.
        /*boolean encontrado = false;
        int i = 0;
        while (!encontrado) {
            if (busqueda.equals(listaVehiculos.get(i).getMatricula())) {
                System.out.println("-> " + realizarCasting(listaVehiculos.get(i)).mostrarAtributos());
                encontrado = true;
                comprobarBusqueda++;
            }
        }*/

        for (Vehiculo v : listaVehiculos) {
            if (busqueda.equals(v.getMatricula())) {
                System.out.println("-> " + realizarCasting(v).mostrarAtributos());
                comprobarBusqueda++;
            }
        }
        if (comprobarBusqueda == 0) {
            System.out.println("No se ha encontrado nada.");
        }
    }

    public static void buscarTaxiLibre(ArrayList<Vehiculo> listaVehiculos) {
        boolean encontrado = false;
        boolean noEncontrado = false;
        int i = 0;
        while (!encontrado) {
            if (i < listaVehiculos.size()) {
                if (listaVehiculos.get(i) instanceof Taxi) {
                    if (((Taxi) listaVehiculos.get(i)).isEstado()) {
                        System.out.println("Id: " + listaVehiculos.get(i).getId());
                        ((Taxi) listaVehiculos.get(i)).setEstado(false);
                        encontrado = true;
                    }
                }
            }
            if (i >= listaVehiculos.size()) {
                encontrado = true;
                noEncontrado = true;
            }
            i++;
        }
        if (noEncontrado) {
            System.out.println("No se ha encontrado ningún Taxi libre.");
        }
    }

    public static void buscarTaxiConcreto(ArrayList<Vehiculo> listaVehiculos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce del Id del taxi que buscas.");
        int busqueda = Integer.parseInt(lector.nextLine());
        boolean encontrado = false;
        boolean noEncontrado = false;
        int i = 0;
        while (!encontrado) {
            if (i < listaVehiculos.size()) {
                if (listaVehiculos.get(i) instanceof Taxi) {
                    if (listaVehiculos.get(i).getId() == busqueda) {
                        if (!((Taxi) listaVehiculos.get(i)).isEstado()) {
                            ((Taxi) listaVehiculos.get(i)).setEstado(true);
                            System.out.println("El Taxi ahora está libre.");
                        } else {
                            System.out.println("El Taxi ya estaba libre.");
                        }
                        encontrado = true;
                    }
                }
            }
            if (i >= listaVehiculos.size()) {
                encontrado = true;
                noEncontrado = true;
            }
            i++;
        }
        if (noEncontrado) {
            System.out.println("No se ha encontrado este Taxi en concreto");
        }
    }

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList();
        boolean interruptor = true;
        while (interruptor) {
            Scanner lector = new Scanner(System.in);
            System.out.println(".-MENU PRINCIPAL-.");
            System.out.println("1.- Dar de alta.");
            System.out.println("2.- Buscar por Id.");
            System.out.println("3.- Buscar por matrícula.");
            System.out.println("4.- Buscar primer taxi libre y establecer ocupado.");
            System.out.println("5.- Buscar taxi por Id y establecer libre.");
            System.out.println("6.- Mostrar todos los vehículos.");
            System.out.println("7.- Salir.");
            int opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                    boolean interruptor2 = true;
                    while (interruptor2) {
                        System.out.println("1.- Taxi.");
                        System.out.println("2.- VTC.");
                        System.out.println("3.- Autobus.");
                        System.out.println("4.- Salir.");
                        int opcion2 = Integer.parseInt(lector.nextLine());
                        switch (opcion2) {
                            case 1:
                                listaVehiculos.add(Taxi.darAltaTaxi());
                                break;
                            case 2:
                                listaVehiculos.add(VTC.darAltaVTC());
                                break;
                            case 3:
                                listaVehiculos.add(Autobus.darAltaAutobus());
                                break;
                            case 4:
                                interruptor2 = false;
                                break;
                            default:
                                System.out.println("Opción incorrecta. Intente de nuevo.");
                                break;
                        }
                    }
                    break;
                case 2:
                    buscarId(listaVehiculos);
                    break;
                case 3:
                    buscarMatricula(listaVehiculos);
                    break;
                case 4:
                    buscarTaxiLibre(listaVehiculos);
                    break;
                case 5:
                    buscarTaxiConcreto(listaVehiculos);
                    break;
                case 6:
                    mostrarDatos(listaVehiculos);
                    break;
                case 7:
                    interruptor = false;
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    break;
            }

        }
    }
}
