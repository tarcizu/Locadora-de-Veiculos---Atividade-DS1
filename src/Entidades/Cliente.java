package Entidades;

import java.time.LocalDate;
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

    public void devolverCarro(Veiculo veiculo, LocalDate data) {
        if (this.alugados.contains(veiculo)) {
            veiculo.devolver(data);
            this.alugados.remove(veiculo);
            System.out.println("Veículo devolvido com sucesso!");
        } else {
            System.out.println("Esse cliente não possui o veículo informado alugado.");
        }
    }

    public String getCPF() {
    }

    public void alugarCarro(Veiculo carro, LocalDate data) {

    }

}
