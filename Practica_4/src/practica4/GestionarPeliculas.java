package practica4;

import java.util.*;

public class GestionarPeliculas {

    public static void main(String[] args) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        boolean interruptor = true;
        while (interruptor) {
            Scanner lector = new Scanner(System.in);
            System.out.println("1.- Añadir película.");
            System.out.println("2.- Listar películas.");
            System.out.println("3.- Mostrar datos.");
            System.out.println("4.- Reservar película.");
            System.out.println("5.- Buscar película.");
            System.out.println("6.- Salir");
            int opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    if (Pelicula.getCopiasTotalesId() >= 3000) {
                        System.out.println("El videoclub no puede almacenar más copias");
                    } else {
                        listaPeliculas.add(Pelicula.anyadirPelicula());
                    }
                    break;
                case 2:
                    Pelicula.listarPeliculas(listaPeliculas);
                    break;
                case 3:
                    Pelicula.mostrarDatos(listaPeliculas);
                    break;
                case 4:
                    Pelicula.reservarPelicula(listaPeliculas);
                    break;
                case 5:
                    Pelicula.buscarPelicula(listaPeliculas);
                    break;
                case 6:
                    interruptor = false;
                    break;
                default:
                    System.out.println("Error. Opción incorrecta");
                    break;
            }
        }
    }

}
