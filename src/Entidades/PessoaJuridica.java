package Entidades;

import java.time.LocalDate;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    public void alugarCarro(Veiculo carro, LocalDate data) {

        carro.alugar(data, this);
        getAlugados().add(carro);

    }

}
