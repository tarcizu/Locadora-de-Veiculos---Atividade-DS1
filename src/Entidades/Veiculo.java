package Entidades;

public class Veiculo {
    private String motor;
    private String cambio;
    private String portas;
    private String direcao;
    private String lugares;

    public Veiculo(String motor, String cambio, String portas, String direcao, String lugares) {
        this.motor = motor;
        this.cambio = cambio;
        this.portas = portas;
        this.direcao = direcao;
        this.lugares = lugares;
    }

    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public String getCambio() {
        return cambio;
    }
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    public String getPortas() {
        return portas;
    }
    public void setPortas(String portas) {
        this.portas = portas;
    }
    public String getDirecao() {
        return direcao;
    }
    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
    public String getLugares() {
        return lugares;
    }
    public void setLugares(String lugares) {
        this.lugares = lugares;
    }

}
