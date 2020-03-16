package Loteria;
import java.util.*;
public class Quiniela extends Apuesta {
    private String listaOpciones[]=new String [15];
    private int aciertos;

    public Quiniela() {
    }

    public String[] getListaOpciones() {
        return listaOpciones;
    }

    public void setListaOpciones(String[] listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    

    public Quiniela(String nombre, String apellido, int numApuesta, String []listaOpciones, int aciertos) {
        super(nombre, apellido, numApuesta);
        this.setListaOpciones(listaOpciones);
        this.setAciertos(aciertos);
    }
    
    public Quiniela(Quiniela q1){
        super((Apuesta)q1);
        this.setListaOpciones(q1.getListaOpciones());
        this.setAciertos(q1.getAciertos());
    }
    
    @Override
    public void mostrarApuesta(){
        super.mostrarApuesta();
        System.out.println("Aciertos: "+this.getAciertos());
        }
        
    
    public static Quiniela crearApuestaQuiniela(){
        Scanner lector=new Scanner (System.in);
        Quiniela q1 = new Quiniela();
        q1.setNumApuesta(Apuesta.getSigNumApuesta()+1);
        System.out.println("Introduce tu nombre.");
        q1.setNombre(lector.nextLine());
        System.out.println("Introduce tu apellido.");
        q1.setNombre(lector.nextLine());
        q1.setListaOpciones(q1.getListaOpciones());
        System.out.println("Introduce los 15 resultados de los partidos.\n"
                + "1 Si ganará el equipo local.\nx Si empatarán.\n2 Si ganará"
                + " el equipo visitante.");
        for (int i=0;i<q1.getListaOpciones().length;i++){
            System.out.println("Partido "+(i+1)+":");
            boolean valorCorrecto=false;
            while(!valorCorrecto){
                String valor=lector.nextLine();
                if (valor.equalsIgnoreCase("1")){
                    q1.getListaOpciones()[i]=valor;
                    valorCorrecto=true;
                }
                else if(valor.equalsIgnoreCase("2")){
                    q1.getListaOpciones()[i]=valor;
                    valorCorrecto=true;
                }
                else if(valor.equalsIgnoreCase("x")){
                    q1.getListaOpciones()[i]=valor;
                    valorCorrecto=true;
                }
                else{
                    System.out.println("Valor incorrecto. Elige 1, 2 o x.");
                }
            }
            
        }
        return q1;
    }
    
    
}
