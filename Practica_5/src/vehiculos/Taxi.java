package vehiculos;

public class Taxi extends Vehiculo {
    
    private String numeroLicencia;
    private boolean estado;
    private String numeroTaxista;

    public Taxi() {
    }

    public Taxi(String numeroLicencia, boolean estado, String numeroTaxista, int id, String matricula, String modelo, String potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.numeroTaxista = numeroTaxista;
    }
    
    public Taxi (Taxi t1){
        super.setId(t1.getId());
        super.setMatricula(t1.getMatricula());
        super.setModelo(t1.getModelo());
        super.setPotencia(t1.getPotencia());
        this.numeroLicencia=t1.numeroLicencia;
        this.estado=t1.estado;
        this.numeroTaxista=t1.numeroTaxista;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNumeroTaxista() {
        return numeroTaxista;
    }

    public void setNumeroTaxista(String numeroTaxista) {
        this.numeroTaxista = numeroTaxista;
    }
    
    
    
}
