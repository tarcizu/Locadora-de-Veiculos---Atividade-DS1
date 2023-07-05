package Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private ArrayList<Veiculo> alugados = new ArrayList<Veiculo>();

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;

    }

    // GETS DA CLASSE
    public ArrayList getAlugados() {
        return this.alugados;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    // GETS A SEREM SOBRESCRITOS
    public String getCPF() {
        return "";
    }

    public String getCNPJ() {
        return "";
    }

    // Método que lista os carros em posse do cliente
    public void listarAlugados() {
        if (this.alugados.size() != 0) {

            System.out.println("VEÍCULOS LOCADOS:");
            for (Veiculo veiculo : alugados) {
                System.out.printf("Veículo: %s/%s - Categoria: %s - Data de Locação: %s\n", veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.nomeDaCategoria(),
                        veiculo.getDataDeLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        } else {
            System.out.println("SEM VEÍCULOS LOCADOS");

        }
    }

    // Métodos que realiza a devolução do carro
    public void devolverCarro(Veiculo veiculo, LocalDate data, int kms) {
        System.out.println("\nVeículo devolvido com sucesso!");
        veiculo.devolver(data, kms);
        this.alugados.remove(veiculo);

    }

    public void alugarCarro(Veiculo carro, LocalDate data) {

    }

}
