package Entidades;

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

    public void devolverCarro() {
        if (this.alugados.size() == 0) {
            System.out.println("Esse cliente não possui carros alugados");

        } else if (this.alugados.size() == 1) {
            this.alugados.get(0).devolver();
            this.alugados.remove(0);
            System.out.println("Veiculo");

        }
    }

    public String getCPF() {
    }

    public void alugarCarro(Veiculo carro) {
        
    }

}
