/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajava1;

import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */ 
    public static void mismo_orden(){
        Scanner input=new Scanner(System.in);
        int [] mismo_orden=new int [5];
        System.out.println("Escribe 5 números");
        for (int i=0;i<5;i++) {
            int numero=input.nextInt();
            mismo_orden[i]=numero;
        }
        for (int i=0;i<5;i++){
            System.out.print(mismo_orden[i]+" ");
        }
    }
    public static void orden_inverso(){
        Scanner input=new Scanner(System.in);
        int [] orden_inverso;
        orden_inverso = new int [5];
        System.out.println("Escribe 5 números");
        for (int i=0;i<5;i++) {
            int numero=input.nextInt();
            orden_inverso[i]=numero;
        }
        for (int i=4;i>-1;i--){
            System.out.print(orden_inverso[i]+" ");
        }
    }
    public static void media_aritmetica(){
        Scanner input=new Scanner(System.in);
        System.out.println("Escribe 5 números");
        int positivos=0;
        int negativos=0;
        int pos=0;
        int neg=0;
        int ceros=0;
        for (int i=0;i<5;i++) {
            int numero=input.nextInt();
            if (numero>0){
                positivos+=numero;
                pos++;
            }
            else if (numero==0) {
                ceros++;
            }
            else {
                negativos+=numero;
                neg++;
            }
        }
        if (pos!=0){
            positivos=positivos/pos;
        }
        if (neg!=0){
            negativos=negativos/neg;
        }
        System.out.println("La media de los números positivos es "+positivos+
                " y de los negativos "+negativos+". El número de ceros es "
                +ceros+".");
    }
    public static void orden_alterno(){
        Scanner input=new Scanner(System.in);
        System.out.println("Escribe 10 números");
        int [] orden_alternado;
        orden_alternado=new int [10];
        for (int i=0;i<10;i++) {
            int numero=input.nextInt();
            orden_alternado[i]=numero;
        }
        for (int i=0;i<10;i++){
            System.out.print(orden_alternado[i]+" ");
            System.out.print(orden_alternado[9-i]+" ");
        }
    }
    public static void mezcla_tablas(){
        Scanner input=new Scanner(System.in);
        System.out.println("Escribe 10 números que se insertarán en A");
        int [] tabla_a;
        tabla_a=new int [10];
        for (int i=0;i<10;i++) {
            int numero=input.nextInt();
            tabla_a[i]=numero;
        }
        System.out.println("Escribe 10 números que se insertarán en B");
        int [] tabla_b;
        tabla_b=new int [10];
        for (int i=0;i<10;i++) {
            int numero=input.nextInt();
            tabla_b[i]=numero;
        }
        int [] tabla_c;
        tabla_c=new int [20];
        int aux=0;
        for (int i=0;i<20;i++){
            tabla_c[i]=tabla_a[aux];
            i++;
            tabla_c[i]=tabla_b[aux];
            aux++;
        }
        for (int i=0;i<20;i++){
            System.out.print(tabla_c[i]+" ");
        }
    }
    public static void mezcla_tablas_2(){
        Scanner input=new Scanner(System.in);
        System.out.println("Escribe 12 números que se insertarán en A");
        int [] tabla_a;
        tabla_a=new int [12];
        for (int i=0;i<12;i++) {
            int numero=input.nextInt();
            tabla_a[i]=numero;
        }
        System.out.println("Escribe 12 números que se insertarán en B");
        int [] tabla_b;
        tabla_b=new int [12];
        for (int i=0;i<12;i++) {
            int numero=input.nextInt();
            tabla_b[i]=numero;
        }
        int [] tabla_c;
        tabla_c=new int [24];
        int aux_a=0;
        int aux_b=0;
        for (int i=0;i<24;i+=0){
            for (int j=0;j<3;j++){
                tabla_c[i]=tabla_a[aux_a];
                i++;
                aux_a++;
            }
            for (int j=0;j<3;j++){
                tabla_c[i]=tabla_b[aux_b];
                i++;
                aux_b++;
            }
        }
        for (int i=0;i<24;i++){
            System.out.print(tabla_c[i]+" ");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        System.out.println("Elige una opción:\n1. Ejercicio 1\n2. Ejercicio 2"
                + "\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n"
                + "6. Ejercicio 6");
        int opcion=input.nextInt();//   
        switch (opcion){
            case 1:
                mismo_orden();
                break;
            case 2:
                orden_inverso();
                break;
            case 3:
                media_aritmetica();
                break;
            case 4:
                orden_alterno();
                break;
            case 5:
                mezcla_tablas();
                break;
            case 6:
                mezcla_tablas_2();
                break;
            default:
                System.out.println("Error. Opción incorrecta.");
        }
    }
}
