package Entidades;

public class Veiculo {
    private String marca;
    private String modelo;
    private String categoria;
    private String statusLocacao;
    private String KMRodado;

    public Veiculo(String marca, String modelo, String categoria, String statusLocacao, String KMRodado) {
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
    public String getStatusLocacao() {
        return statusLocacao;
    }
    public void setStatusLocacao(String statusLocacao) {
        this.statusLocacao = statusLocacao;
    }
    public String getKMRodado() {
        return KMRodado;
    }
    public void setLugares(String KMRodado) {
        this.KMRodado = KMRodado;
    }

}
