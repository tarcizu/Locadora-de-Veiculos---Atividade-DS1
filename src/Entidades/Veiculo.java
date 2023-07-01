package Entidades;

public class Veiculo {
    private String marca;
    private String modelo;
    private int categoria;
    private boolean statusLocacao;
    private double KMRodado;

    public Veiculo(String marca, String modelo, int categoria, double KMRodado) {
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.statusLocacao = true;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
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

    public static Veiculo cadastrar(String marca, String modelo, int categoria, Double km) {

        Veiculo carro = new Veiculo(marca, modelo, categoria, km);
        return carro;
    }

    public void alugar() {
        this.statusLocacao = false;
    }

    public String toString() {
        return String.format("Marca: %s\nModelo: %s\nCategoria: %d\nKilometragem: %.0f\nDisponibilidade: %s\n\n",
                this.marca, this.modelo, this.categoria, this.KMRodado,
                this.statusLocacao == true ? "Disponivel" : "Alugado");
    }

}
