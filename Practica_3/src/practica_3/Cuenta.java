/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuenta {

    private String numeroCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;
    private int pin;

    public Cuenta() {
    }

    public Cuenta(String numeroCliente, String numeroCuenta, double tipoInteres, double saldo, int pin) {
        this.numeroCliente = numeroCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
        this.pin = pin;
    }

    public Cuenta(Cuenta c1) {
        this.numeroCliente = c1.numeroCliente;
        this.numeroCuenta = c1.numeroCuenta;
        this.tipoInteres = c1.tipoInteres;
        this.saldo = c1.saldo;
        this.pin = c1.pin;
    }

    public String getNumeroCliente() {
        return this.numeroCliente;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public double getTipoInteres() {
        return this.tipoInteres;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void crearCuenta() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el nombre de la cuenta");
        String nombre = lector.next();
        System.out.println("Escribe el numero del cliente:");
        this.setNumeroCliente(lector.nextLine());
        System.out.println("Escribe el numero de cuenta: ");
        this.setNumeroCuenta(lector.nextLine());
        System.out.println("Escribe el tipo de interés: ");
        this.setTipoInteres(lector.nextDouble());
        System.out.println("Introduce un saldo: ");
        this.setSaldo(lector.nextDouble());
        System.out.println("Introduce un número pin");
        this.setPin(lector.nextInt());
    }

    public static Cuenta crearCuenta2() {
        Scanner lector = new Scanner(System.in);
        Cuenta c1 = new Cuenta();
        System.out.println("Escribe el numero del cliente:");
        c1.setNumeroCliente(lector.nextLine());
        System.out.println("Escribe el numero de cuenta: ");
        c1.setNumeroCuenta(lector.nextLine());
        System.out.println("Escribe el tipo de interés: ");
        c1.setTipoInteres(lector.nextDouble());
        System.out.println("Introduce un saldo: ");
        c1.setSaldo(lector.nextDouble());
        System.out.println("Introduce un número pin");
        c1.setPin(lector.nextInt());
        return c1;
    }

    public void mostrarDatos(Cuenta index) {
        System.out.println("El número de la cuenta es " + index.getNumeroCliente()
                + ".");
        System.out.println("El número de cliente es " + index.getNumeroCliente()
                + ".");
        System.out.println("El tipo de interés es " + index.getTipoInteres()
                + ".");
        System.out.println("El saldo actual es de " + index.getSaldo() + "€.");
        System.out.println("El número pin es " + index.getPin() + ".");
    }

    public boolean ingreso(Cuenta index) {
        Scanner lector = new Scanner(System.in);
        boolean resultado;
        System.out.println("Indique la cantidad ingresada");
        double cantidadIngresada = lector.nextDouble();
        if (cantidadIngresada < 0) {
            System.out.println("La cantidad debe ser positiva");
            resultado = false;
        } else {
            index.setSaldo(index.getSaldo() + cantidadIngresada);
            System.out.println("Su saldo actual es de " + index.getSaldo() + ".");
            resultado = true;
        }
        return resultado;
    }

    public boolean reintegro(Cuenta index) {
        Scanner lector = new Scanner(System.in);
        boolean resultado;
        System.out.println("El saldo disponible es de " + index.getSaldo()
                + " ¿Qué cantidad desea retirar?");
        double cantidadRetirada = lector.nextDouble();
        if (cantidadRetirada > index.getSaldo()) {
            System.out.println("La cantidad es superior al saldo disponible"
                    + ", vuelva a intentarlo");
            resultado = false;
        } else {
            this.setSaldo(index.getSaldo() - cantidadRetirada);
            System.out.println("Su saldo actual es de " + index.getSaldo() + ".");
            resultado = true;
        }
        return resultado;
    }

    public void transferencia(Cuenta cuentaDestino, double importe) {
        this.setSaldo(this.getSaldo() - importe);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + importe);
        System.out.println("El saldo actual de " + this.getNumeroCliente() + " es de "
                + this.getSaldo() + ".");
        System.out.println("El saldo actual de " + cuentaDestino.getNumeroCliente() + " es de "
                + cuentaDestino.getSaldo() + ".");
    }

    public static boolean validarCuenta(ArrayList<Cuenta> listaCuentas, int i) {
        Scanner lector = new Scanner(System.in);
        boolean validado = false;
        int j = 3;
        while (j > 0) {
            System.out.println("Introduce el número pin. Te quedan " + j
                    + " intentos.");
            int intentoPin = lector.nextInt();
            if (listaCuentas.get(i).getPin() == intentoPin) {
                System.out.println("¡Bienvenido " + listaCuentas.get(i).getNumeroCliente()
                        + "!");
                validado = true;
                j = 0;
            } else {
                System.out.println("Pin Incorrecto.");
                j--;
            }
        }
        return validado;
    }
    
    public static int buscarCuenta (ArrayList<Cuenta> listaCuentas){
        Scanner lector = new Scanner(System.in);
        boolean encontrado = false;
        int index = -1;
        int i = 0;
        System.out.println("Indroduzca el número de la cuenta destino");
        String numeroCuenta=lector.next();
        while (encontrado == false) {
            if (i==listaCuentas.size()){
                System.out.println("No existe ninguna cuenta con ese número.");
                encontrado = true;
            }
            else {
                boolean comparar = listaCuentas.get(i).getNumeroCuenta().equals(numeroCuenta);
                if (comparar==true){
                    encontrado = true;
                    index = i;
                }
                else {
                    i++;
                }
            }
        }
        return index;
    }
}
