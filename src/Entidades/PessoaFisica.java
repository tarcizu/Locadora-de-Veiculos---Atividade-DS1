package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    // GETS
    @Override
    public String getCPF() {
        return this.cpf;
    }

    // MÉTODO DE CADASTRO DE PESSOA FÍSICA
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
                System.out.println("Não foi possível cadastrar! Já existe um cliente com esse CPF");
                sc.nextLine();

                return null;
            }
        }
        return new PessoaFisica(nome, email, telefone, cpf);
    }

    // MÉTODO QUE ALUGA O VEICULO PARA PESSOA FÍSICA
    public void alugarCarro(Veiculo carro, LocalDate data) {
        Scanner sc = new Scanner(System.in);

        if (this.getAlugados().size() == 0) {
            carro.alugar(data, this);
            getAlugados().add(carro);
        } else {
            System.out.println("Não é possível realizar a locação pois já existe um carro locado");
            sc.nextLine();
        }
    }

    public String toString() {

        return String.format("PESSOA FÍSICA\nNome: %s\nE-mail: %s\nTelefone: %s\nCPF: %s\n", this.getNome(),
                this.getEmail(),
                this.getTelefone(), this.getCPF());
    }
}
