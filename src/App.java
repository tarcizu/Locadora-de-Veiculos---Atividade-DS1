import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Cliente;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;
import Entidades.Veiculo;

public class App {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        // Cria Variável com a data Atual
        LocalDate dataDeHoje = LocalDate.now();

        // Cria os Arrays de Banco de Dados
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        // Chama a Função que já inicia o código com coisas cadastradas
        cadastroPadrao(clientes, veiculos);

        // Cria o objeto que recebera o cliente que se esta gerenciando
        Cliente clienteAtual = null;

        // Inicia o Menu
        while (true) {
            limparTela();
            System.out.printf(
                    "JavaCar\nData de Hoje: %s\n\n1 - Realizar Locação/Devolução\n\n2 - Cadastrar Veiculo\n3 - Cadastrar Cliente\n\n4 - Listar Veículos\n5 - Listar Clientes\n\n6 - Avançar Data\n\nEscolha: ",
                    dataDeHoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            int escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("Qual o Tipo de Cliente\n\n1 - Pessoa Fisica\n2 - Pessoa Jurídica\n\nEscolha: ");
                    int escolha3 = sc.nextInt();
                    if (escolha3 == 1) {
                        System.out.print("Qual o CPF do cliente buscado: ");
                        sc.nextLine();
                        String cpf = sc.nextLine();

                        for (Cliente cliente : clientes) {
                            if (cliente.getCPF().equals(cpf) && cpf != "") {
                                clienteAtual = cliente;
                            }
                        }
                        if (clienteAtual != null) {
                            menuDoCliente(clienteAtual, veiculos, dataDeHoje);
                        } else {
                            System.out.println("\nCPF não encontrado!\n");
                            System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                            sc.nextLine();

                        }

                    } else if (escolha3 == 2) {
                        System.out.print("Qual o CNPJ do cliente buscado: ");
                        sc.nextLine();
                        String cnpj = sc.nextLine();

                        for (Cliente cliente : clientes) {
                            if (cliente.getCNPJ().equals(cnpj) && cnpj != "") {
                                clienteAtual = cliente;
                            }
                        }
                        if (clienteAtual != null) {
                            menuDoCliente(clienteAtual, veiculos, dataDeHoje);
                        } else {
                            System.out.println("\nCNPJ não encontrado!\n");
                            System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                            sc.nextLine();

                        }

                    } else {
                        System.out.println("\nOpção digitada invalida\n");
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        sc.nextLine();

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
                        Cliente cadastrado = PessoaJuridica.cadastrar(clientes);
                        if (cadastrado != null) {
                            clientes.add(cadastrado);
                        }

                    }
                    break;
                case 4:
                    if (veiculos.size() != 0) {

                        System.out.println("\nLISTA DE VEÍCULOS\n");
                        for (Veiculo carro : veiculos) {
                            int posicao = veiculos.indexOf(carro);
                            System.out.println("ID: " + posicao + "\n" + carro);
                        }
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                    } else {
                        System.out.println("\nNão existe veículos cadastrados\n");
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                    }
                    break;
                case 5:
                    if (clientes.size() != 0) {
                        System.out.println("\nLISTA DE CLIENTES\n");

                        for (Cliente cliente : clientes) {
                            System.out.print(cliente);
                            cliente.listarAlugados();
                            System.out.println("\n");

                        }
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();

                    } else {
                        System.out.println("\nNão existe clientes cadastrados\n");
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();

                    }
                    break;
                case 6:
                    System.out.print("Quantos dias quer avançar? ");
                    int dias = sc.nextInt();
                    dataDeHoje = dataDeHoje.plusDays(dias);

                default:
                    continue;
            }
        }
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");

    }

    public static void menuDoCliente(Cliente cliente, ArrayList<Veiculo> veiculos, LocalDate data) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            limparTela();
            System.out.printf("------------------\n%s------------------",
                    cliente);

            System.out.print("\n\n1 - Alugar Carro\n2 - Devolver Carro\n3 - Consultar Débito\n\n4 - Sair\n\nEscolha: ");
            int escolha = sc.nextInt();
            System.out.println("");
            switch (escolha) {
                case 1:
                    ArrayList<Veiculo> carrosexibicao = new ArrayList<Veiculo>();
                    for (Veiculo carro : veiculos) {
                        if (carro.getStatusLocacao() == true) {
                            carrosexibicao.add(carro);
                        }
                    }
                    int indice = 0;
                    if (carrosexibicao.size() != 0) {

                        System.out.println("VEÍCULOS DISPONÍVEIS\n");

                        for (Veiculo carro : carrosexibicao) {
                            System.out.printf("ID: %d\n", indice++);
                            System.out.println(carro);

                        }
                        System.out.print("Digite o ID do veículo que deseja locar: ");
                        int IDVeiculoLocacao = sc.nextInt();
                        if (IDVeiculoLocacao < carrosexibicao.size()) {
                            Veiculo veiculoLocado = carrosexibicao.get(IDVeiculoLocacao);

                            cliente.alugarCarro(veiculoLocado, data);

                        } else {
                            System.out.println("\nID digitado invalido\n");
                            System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                            sc.nextLine();
                            sc.nextLine();
                            continue;

                        }
                    } else {
                        System.out.println("Não existe Veículos Disponíveis\n");

                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        sc.nextLine();
                    }

                    continue;
                case 2:
                    ArrayList<Veiculo> alugados = cliente.getAlugados();
                    if (alugados.size() != 0) {

                        int indice2 = 0;
                        System.out.println("VEÍCULOS LOCADOS\n");
                        for (Veiculo veiculo : alugados) {
                            System.out.printf("ID: %d\nCarro: %s/%s - Categoria: %s - Data de Locação: %s\n", indice2++,
                                    veiculo.getMarca(),
                                    veiculo.getModelo(),
                                    veiculo.nomeDaCategoria(),
                                    veiculo.getDataDeLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        }
                        System.out.print("\n\nDigite o ID do veículo que deseja devolver: ");
                        int IDVeiculoDevolucao = sc.nextInt();
                        if (IDVeiculoDevolucao < alugados.size()) {
                            System.out.print("Digite a quilometragem atual do veiculo: ");
                            int kmAtual = sc.nextInt();
                            if (kmAtual < alugados.get(IDVeiculoDevolucao).getkmRodado()) {
                                System.out.println("\nQuilometragem informada invalida\n");
                                System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                                sc.nextLine();
                                sc.nextLine();
                                continue;
                            } else {

                                Veiculo veiculoDevolvido = alugados.get(IDVeiculoDevolucao);
                                cliente.devolverCarro(veiculoDevolvido, data, kmAtual);
                            }

                        } else {
                            System.out.println("\nID digitado invalido\n");
                            System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                            sc.nextLine();
                            sc.nextLine();
                            continue;

                        }

                    } else {
                        System.out.println("Cliente não possui Veículos locados\n");
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        sc.nextLine();
                        continue;

                    }
                    sc.nextLine();
                    continue;
                case 3:
                    ArrayList<Veiculo> alugados2 = cliente.getAlugados();
                    if (alugados2.size() != 0) {

                        int indice3 = 0;
                        System.out.println("VEÍCULOS LOCADOS\n");

                        for (Veiculo veiculo : alugados2) {
                            System.out.printf("ID: %d\nCarro: %s/%s - Categoria: %s - Data de Locação: %s\n", indice3++,
                                    veiculo.getMarca(),
                                    veiculo.getModelo(),
                                    veiculo.nomeDaCategoria(),
                                    veiculo.getDataDeLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        }
                        System.out.print("\n\nDigite o ID do veículo que deseja consultar: ");
                        int IDVeiculoDevolucao = sc.nextInt();
                        if (IDVeiculoDevolucao < alugados2.size()) {
                            System.out.print("Digite a quilometragem atual do veiculo: ");
                            int kmAtual = sc.nextInt();
                            if (kmAtual < alugados2.get(IDVeiculoDevolucao).getkmRodado()) {
                                System.out.println("\nQuilometragem informada invalida\n");
                                System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                                sc.nextLine();
                                sc.nextLine();
                                continue;
                            } else {

                                alugados2.get(IDVeiculoDevolucao).gerarNotaFiscal(data, kmAtual);
                            }

                        } else {
                            System.out.println("\nID digitado invalido\n");
                            System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                            sc.nextLine();
                            sc.nextLine();
                            continue;

                        }

                    } else {
                        System.out.println("Cliente não possui Veículos locados\n");
                        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        sc.nextLine();
                        continue;

                    }
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

    // Função inicia o programa com dados cadastrados
    public static void cadastroPadrao(ArrayList cliente, ArrayList veiculos) {

        // Clientes Pessoa Física
        cliente.add(new PessoaFisica("Caio", "caio@ba.estudante.senai.br", "(71) 9988-7123", "123"));
        cliente.add(new PessoaFisica("Iolanda", "iolanda@ba.estudante.senai.br", "(71) 9988-7456", "456"));
        cliente.add(new PessoaFisica("Tarcizo", "tarcizo@ba.estudante.senai.br", "(71) 9988-7789", "789"));
        cliente.add(new PessoaFisica("Washington", "washington@ba.estudante.senai.br", "(71) 9988-7101", "052"));
        // Clientes Pessoa Jurídica
        cliente.add(new PessoaJuridica("Embasa", "agua@embasa.com.br", "(71) 3132-1212", "123"));
        cliente.add(new PessoaJuridica("Senai", "coordenacao@senai.com.br", "(71) 3534-8090", "456"));
        // Veículos
        veiculos.add(new Veiculo("Chevrolet", "Onix", 1, 3580));
        veiculos.add(new Veiculo("Fiat", "Mobi", 1, 6711));
        veiculos.add(new Veiculo("Renaut", "Duster", 2, 0));
        veiculos.add(new Veiculo("Fiat", "Ducato", 4, 7114));
        veiculos.add(new Veiculo("Tesla", "Model S", 3, 4900));

    }
}
