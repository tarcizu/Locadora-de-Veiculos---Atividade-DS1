package Entidades;

public class Veiculo {
    private String marca;
    private String modelo;
    private String categoria;
    private boolean statusLocacao;
    private double KMRodado;

    public Veiculo(String marca, String modelo, String categoria, boolean statusLocacao, double KMRodado) {
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.statusLocacao = statusLocacao;
        this.KMRodado = KMRodado;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setCambio(String modelo) {
        this.modelo = modelo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public boolean getStatusLocacao() {
        return statusLocacao;
    }
    public void setStatusLocacao(boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }
    public double getKMRodado() {
        return KMRodado;
    }
    public void setLugares(double KMRodado) {
        this.KMRodado = KMRodado;
    }    


}
