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
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || cpf.isEmpty()) {
            System.out.println("Não foi possível cadastrar! Preencha todos os campos");
            sc.nextLine();
            return null;
        }
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
            System.out.println("\nVeículos locado com sucesso!\n");
            System.out.print("APERTE A TECLA ENTER PARA CONTINUAR...");
            sc.nextLine();

        } else {
            System.out.println("\nNão é possível realizar a locação pois já existe um veículo locado\n");
            System.out.print("APERTE A TECLA ENTER PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public String toString() {

        return String.format("PESSOA FÍSICA\nNome: %s\nE-mail: %s\nTelefone: %s\nCPF: %s\n", this.getNome(),
                this.getEmail(),
                this.getTelefone(), this.getCPF());
    }
}
