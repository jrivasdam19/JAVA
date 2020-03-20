package Figuras_Geometricas;

public interface FiguraBidimensional {

    public static final double numeroPi = Math.PI;

    public abstract void anyadirFigura();

    public abstract void calcularArea(int i) throws RuntimeException, ExcepcionSignoPositivo;

    public abstract void imprimirCaracteristicas() throws ExcepcionSignoPositivo;

}
