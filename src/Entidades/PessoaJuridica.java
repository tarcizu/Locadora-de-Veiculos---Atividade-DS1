package Entidades;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

}
