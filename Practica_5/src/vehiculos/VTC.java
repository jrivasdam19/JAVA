package vehiculos;

public class VTC extends Vehiculo {
    
    private int numeroHorasTrabajadas;
    private int radioAccion;
    private String ciudad;

    public VTC() {
    }

    public VTC(int numeroHorasTrabajadas, int radioAccion, String ciudad, int id, String matricula, String modelo, String potencia) {
        super(id, matricula, modelo, potencia);
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
        this.radioAccion = radioAccion;
        this.ciudad = ciudad;
    }
    
    public VTC(VTC vtc1){
        super.setId(vtc1.getId());
        super.setMatricula(vtc1.getMatricula());
        super.setModelo(vtc1.getModelo());
        super.setPotencia(vtc1.getPotencia());
        this.numeroHorasTrabajadas=vtc1.numeroHorasTrabajadas;
        this.radioAccion=vtc1.radioAccion;
        this.ciudad=vtc1.ciudad;
    }

    public int getNumeroHorasTrabajadas() {
        return numeroHorasTrabajadas;
    }

    public void setNumeroHorasTrabajadas(int numeroHorasTrabajadas) {
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
    }

    public int getRadioAccion() {
        return radioAccion;
    }

    public void setRadioAccion(int radioAccion) {
        this.radioAccion = radioAccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
