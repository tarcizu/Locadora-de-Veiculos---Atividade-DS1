import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Cliente;
import Entidades.PessoaFisica;
import Entidades.Veiculo;

public class App {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        // Variável com a data Atual
        LocalDate dataDeHoje = LocalDate.now();

        // Arrys Banco de Dados
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        cadastroPadrao(clientes, veiculos);

        // Menu
        while (true) {
            limparTela();
            System.out.printf(
                    "JavaCar\nData de Hoje: %s\n\n1 - Realizar Locação/Devolução\n\n2 - Cadastrar Veiculo\n3 - Cadastrar Cliente\n\n4 - Listar Frota\n5 - Listar Clientes\n\n6 - Avançar Data\n\nEscolha: ",
                    dataDeHoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            int escolha = sc.nextInt();
            switch (escolha) {
                case 2:
                    veiculos.add(Veiculo.cadastrarVeiculo());
                    break;
                case 3:
                    System.out.print(
                            "Qual tipo de Cliente quer Cadastrar:\n\n1 - Pessoa Fisica\n2 - Pessoa Juridica\n\nEscolha: ");
                    int escolha2 = sc.nextInt();
                    if (escolha2 == 1) {
                        clientes.add(PessoaFisica.cadastrar());

                    } else if (escolha2 == 2) {
                        System.out.println("FALTA FAZER");

                    }

                    break;
                case 4:
                    for (Veiculo carro : veiculos) {
                        System.out.println(carro);
                    }
                    sc.nextLine();
                    sc.nextLine();

                    break;
                case 5:
                    System.out.println("LISTA DE CLIENTES\n");

                    for (Cliente cliente : clientes) {
                        System.out.println(cliente);
                        System.out.println("");

                    }
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 6:
                    System.out.print("Quantos dias quer avançar? ");
                    int dias = sc.nextInt();
                    dataDeHoje = dataDeHoje.plusDays(dias);

                default:
                    continue;
            }

        }

        // veiculos.add(Veiculo.cadastrarVeiculo());
        // clientes.add(PessoaFisica.cadastrar());

    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");

    }

    public static void cadastroPadrao(ArrayList cliente, ArrayList veiculos) {

        cliente.add(new PessoaFisica("Michelle", "michelle@senai.com.br", "(71) 9988-7766", "923.283.292-45"));
        veiculos.add(new Veiculo("Tesla", "Model T", 2, 2000));
    }

}
