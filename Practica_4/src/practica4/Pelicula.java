package practica4;

import java.util.*;

public class Pelicula {

    private static int idSiguiente = 1;
    private int id;
    private String titulo;
    private String director;
    private int duracion;
    private String genero;
    private int anyo;
    private boolean disponibilidad;
    private static int copiasTotalesId;
    private static int copiasReservadasId;

    public Pelicula() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public static int getCopiasTotalesId() {
        return copiasTotalesId;
    }

    public static void setCopiasTotalesId(int copiasTotalesId) {
        Pelicula.copiasTotalesId = copiasTotalesId;
    }

    public static int getCopiasReservadasId() {
        return copiasReservadasId;
    }

    public static void setCopiasReservadasId(int copiasReservadasId) {
        Pelicula.copiasReservadasId = copiasReservadasId;
    }

    public static int getIdSiguiente() {
        return idSiguiente;
    }

    public static void setIdSiguiente(int idSiguiente) {
        Pelicula.idSiguiente = idSiguiente;
    }

    public static Pelicula anyadirPelicula() {

        Scanner lector = new Scanner(System.in);
        Pelicula p1 = new Pelicula();
        System.out.println("Introduce el título");
        p1.setTitulo(lector.nextLine());
        System.out.println("Introduce el director");
        p1.setDirector(lector.nextLine());
        System.out.println("Introduce la duración");
        p1.setDuracion(lector.nextInt());
        System.out.println("Introduce el género");
        p1.setGenero(lector.next());
        System.out.println("Introduce el año");
        p1.setAnyo(lector.nextInt());
        p1.setDisponibilidad(true);
        Pelicula.setCopiasTotalesId(Pelicula.getCopiasTotalesId() + 1);
        Pelicula.setCopiasReservadasId(0);
        p1.setId(Pelicula.getIdSiguiente());
        Pelicula.setIdSiguiente(Pelicula.getIdSiguiente() + 1);
        return p1;
    }

    public static void mostrarDatos(ArrayList<Pelicula> listaPeliculas) {

        listarPeliculas(listaPeliculas);
        System.out.println("Indica el id de la película.");
        Scanner lector = new Scanner(System.in);
        int idPelicula = lector.nextInt();

        System.out.println("Título " + listaPeliculas.get(idPelicula - 1).getTitulo());
        System.out.println("Director " + listaPeliculas.get(idPelicula - 1).getDuracion());
        System.out.println("Duración " + listaPeliculas.get(idPelicula - 1).getDuracion());
        System.out.println("Género " + listaPeliculas.get(idPelicula - 1).getGenero());
        System.out.println("Año " + listaPeliculas.get(idPelicula - 1).getAnyo());
        System.out.println("Disponibilidad " + listaPeliculas.get(idPelicula - 1).isDisponibilidad());
        System.out.println("Cantidad de copias total " + Pelicula.getCopiasTotalesId());
        System.out.println("Cantidad de copias reservadas " + Pelicula.getCopiasReservadasId());
    }

    public static void listarPeliculas(ArrayList<Pelicula> listaPeliculas) {

        for (int i = 0; i < listaPeliculas.size(); i++) {
            System.out.println("Id " + listaPeliculas.get(i).getId());
            System.out.println("Título " + listaPeliculas.get(i).getTitulo());
            System.out.println("Director " + listaPeliculas.get(i).getDuracion());
            System.out.println("Duración " + listaPeliculas.get(i).getDuracion());
            System.out.println("Género " + listaPeliculas.get(i).getGenero());
            System.out.println("Disponibilidad " + listaPeliculas.get(i).isDisponibilidad());
        }
    }

    public static void reservarPelicula(ArrayList<Pelicula> listaPeliculas) {

        Scanner lector = new Scanner(System.in);
        listarPeliculas(listaPeliculas);
        boolean proceder = false;
        while (proceder == false) {
            System.out.println("Indica el id de la película que quieres reservar.");
            int idPelicula = lector.nextInt();
            if (idPelicula - 1 >= listaPeliculas.size()) {
                System.out.println("El número introducido no es correcto.");
            } else if (listaPeliculas.get(idPelicula - 1).isDisponibilidad()) {
                System.out.println("La película " + listaPeliculas.get(idPelicula - 1).getTitulo()
                        + " ha sido reservada.");
                listaPeliculas.get(idPelicula - 1).setDisponibilidad(false);
                Pelicula.setCopiasReservadasId(Pelicula.getCopiasReservadasId() + 1);
                Pelicula.setCopiasTotalesId(Pelicula.getCopiasTotalesId() - 1);
                proceder = true;
            } else if (listaPeliculas.get(idPelicula - 1).isDisponibilidad() == false) {
                System.out.println("La película " + listaPeliculas.get(idPelicula - 1).getTitulo()
                        + " no está disponible.");
            }
        }

    } 

    public static void buscarPelicula(ArrayList<Pelicula> listaPeliculas) {
        Scanner lector = new Scanner(System.in);
        boolean proceder = false;
        while (proceder == false) {
            System.out.println("¿Qué tipo de búsqueda quieres realizar?");
            System.out.println("1.- Id.");
            System.out.println("2.- Año.");
            System.out.println("3.- Duración.");
            System.out.println("4.- Título.");
            System.out.println("5.- Director.");
            System.out.println("6.- Género.");
            System.out.println("7.- Salir.");
            int opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                    System.out.println("Introduce un número.");
                    String cadenaPrevia = lector.nextLine();
                    int busqueda = Integer.parseInt(cadenaPrevia);
                    if (opcion == 1) {
                        if (busqueda - 1 >= listaPeliculas.size()) {
                            System.out.println("No se ha encontrado nada.");
                        } else {
                            System.out.println("-> " + listaPeliculas.get(busqueda).getTitulo());
                        }
                    } else if (opcion == 3) {
                        int contador = 0;
                        for (int i = 0; i < listaPeliculas.size(); i++) {
                            if (busqueda == listaPeliculas.get(i).getDuracion()) {
                                System.out.println("-> " + listaPeliculas.get(i).getTitulo());
                                contador++;
                            }

                        }
                        if (contador == 0) {
                            System.out.println("No se ha encontrado nada.");
                        }
                    } else if (opcion == 2) {
                        int contador = 0;
                        for (int i = 0; i < listaPeliculas.size(); i++) {
                            if (busqueda == listaPeliculas.get(i).getAnyo()) {
                                System.out.println("-> " + listaPeliculas.get(i).getTitulo());
                                contador++;
                            }

                        }
                        if (contador == 0) {
                            System.out.println("No se ha encontrado nada.");
                        }
                    }
                    break;
                case 4:
                case 5:
                case 6:
                    System.out.println("Introduce la búsqueda");
                    String cadena = lector.nextLine().toLowerCase();
                    Pelicula p2 = new Pelicula();
                    int contador = 0;
                    for (int i = 0; i < listaPeliculas.size(); i++) {
                        p2 = listaPeliculas.get(i);
                        String buscaPeli = p2.peliculaCompleta(listaPeliculas, i);
                        if (buscaPeli.contains(cadena)) {
                            System.out.println(p2.resultadoBusqueda(listaPeliculas, i));
                            contador++;
                        }

                    }
                    if (contador == 0) {
                        System.out.println("No se ha encontrado nada");
                    }
                    break;
                case 7:
                    proceder = true;
                    break;

            }

        }
    }

    public String peliculaCompleta(ArrayList<Pelicula> listaPeliculas, int i) {
        return listaPeliculas.get(i).getTitulo().toLowerCase()
                + listaPeliculas.get(i).getDirector().toLowerCase()
                + listaPeliculas.get(i).getGenero().toLowerCase();
    }

    public String resultadoBusqueda(ArrayList<Pelicula> listaPeliculas, int i) {
        return (i + 1) + " " + listaPeliculas.get(i).getTitulo();
    }
}
