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

        Cliente clienteAtual = null;

        // Menu
        while (true)

        {
            limparTela();
            System.out.printf(
                    "JavaCar\nData de Hoje: %s\n\n1 - Realizar Locação/Devolução\n\n2 - Cadastrar Veiculo\n3 - Cadastrar Cliente\n\n4 - Listar Frota\n5 - Listar Clientes\n\n6 - Avançar Data\n\nEscolha: ",
                    dataDeHoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            int escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:

                    System.out.print("Qual o CPF do cliente buscado: ");

                    String cpf = sc.nextLine();

                    for (Cliente cliente : clientes) {
                        // System.out.println(cliente.getCPF());

                        if (cliente.getCPF().equals(cpf)) {
                            System.out.println("Achou!!");

                            clienteAtual = cliente;
                        }
                    }
                    if (clienteAtual != null) {
                        menuDoCliente(clienteAtual, veiculos);
                    }
                    clienteAtual = null;

                    break;
                case 2:
                    veiculos.add(Veiculo.cadastrarVeiculo());
                    break;
                case 3:
                    System.out.print(
                            "Qual tipo de Cliente quer Cadastrar:\n\n1 - Pessoa Física\n2 - Pessoa Jurídica\n\nEscolha: ");
                    int escolha2 = sc.nextInt();
                    if (escolha2 == 1) {
                        Cliente cadastrado = PessoaFisica.cadastrar(clientes);
                        if (cadastrado != null) {

                            clientes.add(cadastrado);
                        }

                    } else if (escolha2 == 2) {
                        System.out.println("FALTA FAZER");

                    }
                    ;

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

        cliente.add(new PessoaFisica("Michelle", "michelle@senai.com.br", "(71) 9988-7766", "123"));
        veiculos.add(new Veiculo("Tesla", "Model T", 2, 2000));
        veiculos.add(new Veiculo("Ford", "Fiesta", 1, 45781));
    }

    public static void menuDoCliente(Cliente cliente, ArrayList<Veiculo> veiculos) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            limparTela();
            System.out.printf("-----%s-----", cliente.getNome());

            System.out.print("\n\n1 - Alugar Carro\n2 - Devolver Carro\n3 - Consultar Débito\n\n4 - Sair\n\nEscolha: ");
            int escolha = sc.nextInt();
            System.out.println("");
            switch (escolha) {
                case 1:
                    for (Veiculo carro : veiculos) {
                        if (carro.getStatusLocacao()) {
                            int posicao = veiculos.indexOf(carro);
                            System.out.println("ID: " + posicao + "\n" + carro);
                        }
                        System.out.println("Digite o ID do veículo que deseja locar: ");
                        int escolhaVeiculoLocacao = sc.nextInt();
                        veiculos.get(escolhaVeiculoLocacao).setStatusLocacao(false);
                        veiculos.get(escolhaVeiculoLocacao).setDataDeLocacao(LocalDate.now());
                        System.out.println("Carro Locado com Sucesso!");
                        sc.nextLine();
                        sc.nextLine();

                //NÃO ESTÁ LISTANDO TODOS OS CARROS DISPONÍVEIS PARA LOCAÇÃO;

                        continue;
                    }
                    sc.nextLine();
                    sc.nextLine();

                    continue;
                case 4:
                    break;
                default:
                    continue;
            }
            break;
        }

    }

}
