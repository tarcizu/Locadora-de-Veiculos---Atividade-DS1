package Entidades;

import java.util.ArrayList;
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

    public String getCPF() {
        return this.cpf;
    }

    public static Cliente cadastrar(ArrayList<Cliente> clientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = sc.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(cpf)) {
                System.out.println("Não foi possivel cadastrar o CPF");
                sc.nextLine();

                return null;

            }

        }
        return new PessoaFisica(nome, email, telefone, cpf);

    }

    public String toString() {
        return String.format("Nome: %s\nE-mail: %s\nTelefone: %s\nCPF: %s", this.getNome(), this.getEmail(),
                this.getTelefone(), this.getCPF());
    }
}
