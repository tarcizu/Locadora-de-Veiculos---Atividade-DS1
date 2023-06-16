package Entidades;

public class Cliente {
    private String nome;
    private String email;
    private int telefone;

    public Cliente(String nome, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;

    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getTelefone() {
        return this.telefone;
    }

}
