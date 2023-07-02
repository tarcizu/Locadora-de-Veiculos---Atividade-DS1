package Entidades;

import java.util.Scanner;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public void alugarCarro(Veiculo carro) {
        if (this.getAlugados().size() > 0) {
            System.out.println("O cliente já possui um veiculo alugado");

        } else {
            carro.alugar();
            this.getAlugados().add(carro);
            System.out.println("Carro alugado com sucesso");

        }

    }

    public static Cliente cadastrar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = sc.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        return new PessoaFisica(nome, email, telefone, cpf);

    }
}
