/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajava1;

import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author Jose
 */
public class EjerciciosWebBasicos {
    
    public static void ex_1(){
        double variable1, variable2;
        variable1=10;
        variable2=9;
        System.out.println("Suma: "+(variable1+variable2)+".\nResta: "+
        (variable1-variable2)+".\nMultiplicación: "+(variable1*variable2)+
         ".\nDivisión: "+(variable1/variable2)+".\nMódulo: "+
         (variable1%variable2)+".");
    }
    public static void ex_2(){
        int num1, num2;
        num1=25;
        num2=35;
        if (num1>=num2){
            if (num1==num2){
                System.out.println("Las variables son iguales.");
            }
            else {
                System.out.println(num1+" es mayor que "+num2+".");
            }
        }
        else {
            System.out.println(num2+" es mayor que "+num1+".");
        }
    }
    public static void ex_3(){
        String nombre="José Miguel";
        System.out.println("¡Bienvenido "+nombre+"!");
    }
    public static void ex_4(){
        String nombre1=JOptionPane.showInputDialog("Introduce tu nombre: ");
        // Para usar el JOptionPane tenes que importar el paquete javax.swing.
        System.out.println("¡Bienvenido "+nombre1+"!");
    }
    public static void ex_5(){
        String radio=JOptionPane.showInputDialog("Introduce el radio del "
                + "círculo para calcular su área.");
        double R=Double.parseDouble(radio);
        //La clase Double forma parte de java.lang, no hay que importarlo.
        double area_circulo=Math.PI*Math.pow(R, 2);
        System.out.println("El área del círculo es: "+area_circulo+".");
    }
    public static void ex_5_1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un radio");
        sc.useLocale(Locale.US);
        // Este método nos permite introducir los decimales con un punto y no
        // con una coma. Sistema anglosajón.
        double radio=sc.nextDouble();
  
        //Formula area circulo, usamos algunos de los metodos de Math
        double area=Math.PI*Math.pow(radio, 2);
  
        System.out.println("El area del circulo es "+area);
    }
    public static void ex_6(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce un número.");
        int numero=input.nextInt();
        if (numero%2==0){
            System.out.println("El número "+numero+" es divisible entre 2.");
        }
        else {
            System.out.println("El número "+numero+" no es divisible entre 2.");
        }
    }
    public static void ex_7(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce un código de la tabla ASCII.");
        int numero=input.nextInt();
        char caracterAscii=(char)numero;
        //Cambiando el entero con (char) lo pasamos a carácter.
        System.out.println(caracterAscii);
        
    }
    public static void ex_8(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce un caracter de la tabla ASCII.");
        char numero=input.next().charAt(0);
        int codigoAscii=(int)numero;
        System.out.println(codigoAscii);
    }
    public static void ex_9(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce el precio de un producto.");
        double precio=input.nextDouble();
        double precio_iva=precio+(precio*0.21);
        System.out.println("El precio con IVA es "+precio_iva+"€.");
    }
    public static void ex_10(){
        int i=0;
        while (i<100){
            i++;
            System.out.print(i+" ");
        }
    }
    public static void ex_11(){
        for (int i=1;i<=100;i++){
            System.out.print(i+" ");
        }
    }
    public static void ex_12(){
        System.out.print("Los número divisibles entre 2 y 3 son: ");
        int numero=1;
        while (numero<=100){
            if (numero%2==0 && numero%3==0){
                System.out.print(numero+", ");
            }
            numero++;
        }
    }
    public static void ex_13(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce el número de ventas");
        int num_ventas=input.nextInt();
        int venta, sumatorio;
        sumatorio=0;
        while (num_ventas>0){
            System.out.println("Introduce la venta número "+num_ventas+".");
            venta=input.nextInt();
            sumatorio+=venta;
            num_ventas--;
        }
        System.out.println("El total de ventas es "+sumatorio+"€.");
    }
    public static void ex_14(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce el valor de las variables:a,b y c.");
        double a=input.nextDouble();
        double b=input.nextDouble();
        double c=input.nextDouble();
        /** Una ecuación de segundo grado x=(-b+-raízCuadrada(b^2-4*a*c))/2*a
         * puede tener una, dos o ninguna solución. Depende del valor del 
         * Discriminante:  D = b^2 - 4ac.
         * D>0   Dos soluciones reales distintas.
         * D=0   Dos soluciones reales iguales. (Una solución.)
         * D<0   No hay solución  real.*/
        double d=Math.pow(b, 2)-(4*a*c);
        //Mensaje de traza.
        System.out.println("->"+d);
        if (d>0){
            double x1=((b*(-1))+Math.sqrt(d))/2*a;
            double x2=((b*(-1))-Math.sqrt(d))/2*a;
            System.out.println("El valor de x1 es "+x1+" y de x2 "+x2+".");
        }
        else if (d==0){
            double x1=((b*(-1))+Math.sqrt(d))/2*a;
            System.out.println("La única solución de la ecuación es "+x1+".");
        }
        else{
            System.out.println("El discriminante es negativo, por tanto, "
                    + "la ecuación daría como resultado un número complejo.");
        }
    }
    public static void ex_15(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce un número mayor o igual que 0.");
        int numero=input.nextInt();
        if (numero>=0){
            System.out.println("El número es mayor o igual que 0.");
        }
        else{
            do{
                System.out.println("Introduce un número mayor o igual que 0.");
                numero=input.nextInt();
            }while(numero<0);
        }
    }
    public static void ex_16(){
        Scanner input=new Scanner(System.in);
        String password="hola123";
        System.out.println("Introduce la contraseña correcta.");
        for (int i=0;i<3;i++){
            String password1=input.next();
            if (password.equals(password1)==true){
                i=2;
                System.out.println("¡Contraseña correcta!");
            }
            else {
                System.out.println("Contraseña incorrecta, quedan "+(2-i)
                +" intentos.");
            }
        }
    }
    public static void ex_17(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce un día de la semana.");
        String dia=input.next();
        switch (dia){
            case "lunes":
            case "martes":
            case "miercoles":
            case "jueves":
            case "viernes":
                System.out.println("Es un día laborable.");
                break;
            case "sabado":
            case "domingo":
                System.out.println("No es un día laborable.");
                break;
            default:
                System.out.println("Error. Escriba el día sin mayúsculas.");
        }
    }
    public static void ex_18(){
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce dos números.");
        double num1=input.nextDouble();
        double num2=input.nextDouble();
        System.out.print(num1);
        for (int i=0;i<11;i++){
 
        }
    }
    public static void ex_19(){
        
    }
    public static void ex_20(){
        
    }
    public static void main(String[] args) {
        ex_17();
    }
}
