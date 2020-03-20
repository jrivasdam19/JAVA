package Loteria;

public class ExcepcionFaltaMayuscula extends Exception {

    private int codigoError;

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public ExcepcionFaltaMayuscula() {
    }

    public ExcepcionFaltaMayuscula(int codigoError) {
        super();
        this.setCodigoError(codigoError);
    }

    @Override
    public String getMessage() {
        String mensaje;
        switch (this.getCodigoError()) {
            case 001:
                mensaje = "Error. El nombre debe estar en mayúscula.";
                break;
            case 002:
                mensaje = "Error. El apellido debe estar en mayúscula.";
                break;
            default:
                mensaje = "Error. Vuelve a intentarlo.";
                break;
        }
        return mensaje;
    }
}
