/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.*;

public class Practica2 {

    public static void mostrarMatrizBidimensional(){
        int [][] tabla=new int[5][5];
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                tabla[i][j]=i+j;
                System.out.print("("+tabla[i][j]+") ");
            }
            System.out.println(" ");
        }
    }
    public static void comprobarMatrizSimetrica(){
        Scanner input=new Scanner(System.in);
        int [][] tabla=new int [4][4];
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                System.out.print("Matriz ["+i+"]["+j+"]: ");
                tabla[i][j]=input.nextInt();
            }
        }
        boolean simetrica = true;
        int k,l;
        k=0;
        while (k<tabla.length && simetrica==true){
            l=0;
            while(l<tabla[k].length && simetrica==true){
                if (tabla[k][l]!=tabla[l][k]){ /*Vamos comprobando valor a valor
                    con la matriz traspuesta para comprobar si son iguales.
                    */
                    simetrica=false;
                }
                l++;
            }
            k++;
        }
        if (simetrica==true){
            System.out.println("La matriz es simétrica");
        }
        else {
            System.out.println("La matriz no es simétrica");
        }
    }
    public static void sumarMatrices(){
        Scanner input=new Scanner(System.in);
        int [][] tabla1=new int [3][3];
        int [][] tabla2=new int [3][3];
        
        for (int i=0;i<tabla1.length;i++){
            for (int j=0;j<tabla1[i].length;j++){
                System.out.print("Matriz 1 ["+i+"]["+j+"]: ");
                tabla1[i][j]=input.nextInt();
            }
        }
        
        for (int k=0;k<tabla2.length;k++){
            for (int l=0;l<tabla2[k].length;l++){
                System.out.print("Matriz 2 ["+k+"]["+l+"]: ");
                tabla2[k][l]=input.nextInt();
            }
        }
        for (int m=0;m<tabla1.length;m++){
            System.out.println();
            for (int n=0;n<tabla1[m].length;n++){
                System.out.print(tabla1[m][n]+tabla2[m][n]+" ");
            }
        }
    }
    public static void crearMatriz01(){
        int [][] matriz=new int [7][7];
        
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (i==j){
                    matriz[i][j]=1;
                }
                else {
                    matriz[i][j]=0;
                }
            }
        }
        for (int [] tabla:matriz){
            System.out.println();
            for (int elemento:tabla){
                System.out.print(elemento+" ");
            }
        }
        
    }
    public static void crearMatrizMarco(){
        int [][] matriz=new int [8][6];
        
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (i==matriz.length-1 || i==0 || j==matriz[i].length-1
                        || j==0){
                    matriz[i][j]=1;
                }
                else {
                    matriz[i][j]=0;
                }
            }
        }
        for (int [] tabla:matriz){
            System.out.println();
            for (int elemento:tabla){
                System.out.print(elemento+" ");
            }
        }
        
    }
    public static void cargarMatrizMarco(){
        Scanner input=new Scanner(System.in);
        int matriz[][],numeroFilas,numeroColumnas;
        System.out.println("Introduce el número de filas.");
        numeroFilas=input.nextInt();
        System.out.println("Introduce el número de columnas.");
        numeroColumnas=input.nextInt();
        matriz=new int [numeroFilas][numeroColumnas];
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (i==matriz.length-1 || i==0 || j==matriz[i].length-1
                        || j==0){
                    matriz[i][j]=1;
                }
                else {
                    matriz[i][j]=0;
                }
            }
        }
        for (int [] tabla:matriz){
            System.out.println();
            for (int elemento:tabla){
                System.out.print(elemento+" ");
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Elige una opción:\n1. mostrarMatrizBidimensional");
        System.out.println("2. comprobarMatrizSimetrica");
        System.out.println("3. sumarMatrices");
        System.out.println("4. crearMatriz01");
        System.out.println("5. crearMatrizMarco");
        System.out.println("5. cargarMatrizMarco");
        int opcion=input.nextInt();//   
        switch (opcion){
            case 1:
                mostrarMatrizBidimensional();
                break;
            case 2:
                comprobarMatrizSimetrica();
                break;
            case 3:
                sumarMatrices();
                break;
            case 4:
                crearMatrizMarco();
                break;
            case 5:
                cargarMatrizMarco();
                break;
            default:
                System.out.println("Error. Opción incorrecta.");
        }
    }
    
}
