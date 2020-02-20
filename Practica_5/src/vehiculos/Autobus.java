package vehiculos;

public class Autobus extends Vehiculo {
    
    private int numeroPlazas;
    private int numeroParadas;

    public Autobus() {
    }

    public Autobus(int numeroPlazas, int numeroParadas, int id, String matricula, String modelo, String potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroPlazas = numeroPlazas;
        this.numeroParadas = numeroParadas;
    }
    
    public Autobus(Autobus a1){
        super.setId(a1.getId());
        super.setMatricula(a1.getMatricula());
        super.setModelo(a1.getModelo());
        super.setPotencia(a1.getPotencia());
        this.numeroParadas=a1.numeroParadas;
        this.numeroPlazas=a1.numeroPlazas;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public int getNumeroParadas() {
        return numeroParadas;
    }

    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }
    
}
