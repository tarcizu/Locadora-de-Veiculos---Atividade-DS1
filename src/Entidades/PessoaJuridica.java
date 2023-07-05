package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    // GETS
    @Override
    public String getCNPJ() {
        return this.cnpj;
    }

    // MÉTODO DE CADASTRO DE PESSOA JURÍDICA
    public static Cliente cadastrar(ArrayList<Cliente> clientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = sc.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        System.out.print("Digite o cnpj do cliente: ");
        String cnpj = sc.nextLine();
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || cnpj.isEmpty()) {
            System.out.println("Não foi possível cadastrar! Preencha todos os campos");
            sc.nextLine();
            return null;
        }
        for (Cliente cliente : clientes) {
            if (cliente.getCNPJ().equals(cnpj)) {
                System.out.println("Não foi possível cadastrar! Já existe um cliente com esse CNPJ");
                sc.nextLine();
                return null;
            }
        }
        return new PessoaJuridica(nome, email, telefone, cnpj);
    }

    public void alugarCarro(Veiculo carro, LocalDate data) {
        Scanner sc = new Scanner(System.in);

        carro.alugar(data, this);
        getAlugados().add(carro);
        System.out.println("\nVeículos locado com sucesso!\n");
        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
        sc.nextLine();

    }

    // Método ToString
    public String toString() {
        return String.format("PESSOA JURÍDICA\nNome: %s\nE-mail: %s\nTelefone: %s\nCNPJ: %s\n", this.getNome(),
                this.getEmail(),
                this.getTelefone(), this.getCNPJ());
    }

}
