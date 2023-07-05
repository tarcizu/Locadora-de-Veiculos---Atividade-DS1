package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Veiculo {
    private String marca;
    private String modelo;
    private int categoria;
    private boolean statusLocacao;
    private int kmRodado;
    private Cliente clienteEmPosse = null;
    private LocalDate dataDeLocacao = null;

    public Veiculo(String marca, String modelo, int categoria, int kmRodado) {
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.statusLocacao = true;
        this.kmRodado = kmRodado;
    }

    // GETS
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCategoria() {
        return categoria;
    }

    public boolean getStatusLocacao() {
        return statusLocacao;
    }

    public LocalDate getDataDeLocacao() {
        return dataDeLocacao;
    }

    public int getkmRodado() {
        return kmRodado;
    }

    // Método que calcula e exibe a Nota Fiscal da locação do carro
    public void gerarNotaFiscal(LocalDate dataDeDevolucao, int kms) {
        Scanner sc = new Scanner(System.in);
        final Double kmExcedente = 1.20;
        Double total = 0.0;
        long NdeDiarias = ChronoUnit.DAYS.between(dataDeLocacao, dataDeDevolucao);
        int kmsRodados = kms - this.kmRodado;
        if (NdeDiarias == 0) {
            NdeDiarias = 1;
        }
        System.out.println("\n-----------NOTA FISCAL-----------");
        if (NdeDiarias >= 30) {
            int NdeMensal = (int) NdeDiarias / 30;
            int NdeDiariasExcedentes = (int) NdeDiarias % 30;
            System.out.printf("Numero de Mensais: %d x R$%.2f (%s) = R$%.2f\n", NdeMensal, precoPorCategoriaMensal(),
                    nomeDaCategoria(),
                    NdeMensal * precoPorCategoriaMensal());
            if (NdeDiariasExcedentes > 0) {
                System.out.printf("Diarias Excedidas: %d x R$%.2f (%s) = R$%.2f\n", NdeDiariasExcedentes,
                        precoPorCategoriaDiaria(),
                        nomeDaCategoria(),
                        NdeDiariasExcedentes * precoPorCategoriaDiaria());

                total += NdeDiariasExcedentes * precoPorCategoriaDiaria();

            }

            total += NdeMensal * precoPorCategoriaMensal();

            if (kmsRodados > 5000) {
                System.out.printf("Quilômetros Excedidos: %dkm x R$%.2f = R$%.2f\n", kmsRodados - 5000, kmExcedente,
                        (kmsRodados - 5000) * kmExcedente);
                total += (kmsRodados - 5000) * kmExcedente;

            }

        } else {
            System.out.printf("Numero de diarias: %d x R$%.2f (%s) = R$%.2f\n", NdeDiarias, precoPorCategoriaDiaria(),
                    nomeDaCategoria(),
                    NdeDiarias * precoPorCategoriaDiaria());
            total += NdeDiarias * precoPorCategoriaDiaria();
            if (NdeDiarias == 1) {
                if (kmsRodados > 100) {
                    System.out.printf("Quilômetros Excedidos: %dkm x R$%.2f = R$%.2f\n", kmsRodados - 100, kmExcedente,
                            (kmsRodados - 100) * kmExcedente);
                    total += (kmsRodados - 100) * kmExcedente;

                }

            }
            if (NdeDiarias == 2) {
                if (kmsRodados > 200) {
                    System.out.printf("Quilômetros Excedidos: %dkm x R$%.2f = R$%.2f\n", kmsRodados - 200, kmExcedente,
                            (kmsRodados - 200) * kmExcedente);
                    total += (kmsRodados - 200) * kmExcedente;

                }

            }

        }
        System.out.printf("\nTOTAL: R$%.2f\n", total);
        System.out.println("\n--------------FIM----------------\n\n");
        System.out.print("APERTE QUALQUER TECLA PARA CONTINUAR...");
        sc.nextLine();

    }

    // Método que retorna o preço da diária da categoria do carro
    public double precoPorCategoriaDiaria() {
        switch (this.categoria) {

            case 1: // Grupo 1 - Econômico
                return 157.50;
            case 2: // Grupo 2 - Intermediários
                return 172.20;
            case 3: // Grupo 3 - Utilitário
                return 225.75;
            case 4: // Grupo 4 - Executivo
                return 281.40;
            default:
                return 0;
        }
    }

    // Método que retorna o preço mensal da categoria do carro
    public double precoPorCategoriaMensal() {
        switch (this.categoria) {
            case 1: // Grupo 1 - Econômico
                return 2500.00;
            case 2: // Grupo 2 - Intermediários
                return 2700.00;
            case 3: // Grupo 3 - Utilitário
                return 3200.00;
            case 4: // Grupo 4 - Executivo
                return 4000.00;
            default:
                return 0;
        }
    }

    // Metodo que retorna o nome da categoria do carro
    public String nomeDaCategoria() {

        switch (this.getCategoria()) {
            case 1:
                return "Econômico";
            case 2:
                return "Intermediário";
            case 3:
                return "Executivo";
            case 4:
                return "Utilitário";
        }
        return "Categoria não encontrada";

    }

    // Método que realiza o aluguel do carro
    public void alugar(LocalDate dataDeHoje, Cliente cliente) {
        dataDeLocacao = dataDeHoje;
        clienteEmPosse = cliente;
        statusLocacao = false;

    }

    // Método que realiza a devolução do carro
    public void devolver(LocalDate dataDevolucao, int kms) {
        this.statusLocacao = true;
        clienteEmPosse = null;
        this.gerarNotaFiscal(dataDevolucao, kms);
        this.kmRodado = kms;
    }

    // Método que cadastra um novo veiculo
    public static Veiculo cadastrarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a Marca do Veiculo: ");
        String marca = sc.nextLine();
        System.out.print("Digite o Modelo do Veiculo: ");
        String modelo = sc.nextLine();
        System.out.print(
                "Digite a categoria do Veiculo: \n1 - Econômico\n2 - Intermediário\n3 - Executivo\n4 - Utilitário\n\nEscolha: ");
        int categoria = 0;
        while (true) {
            categoria = sc.nextInt();
            if (categoria > 0 && categoria <= 4) {
                break;
            }
            System.out.println("Opção digitada invalida");
            sc.nextLine();
        }

        System.out.print("Digite a Quilometragem do Veiculo: ");
        int km = sc.nextInt();
        return new Veiculo(marca, modelo, categoria, km);

    }

    public String toString() {
        if (this.statusLocacao == false) {
            return String.format(
                    "Marca: %s\nModelo: %s\nCategoria: %s\nQuilometragem: %dkm\nDisponibilidade: Locado por %s em %s\n\n",
                    this.marca, this.modelo, this.nomeDaCategoria(), this.kmRodado,
                    String.format(clienteEmPosse.getNome()),
                    this.getDataDeLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            return String.format(
                    "Marca: %s\nModelo: %s\nCategoria: %s\nQuilometragem: %dkm\nDisponibilidade: Disponível\n\n",
                    this.marca, this.modelo, this.nomeDaCategoria(), this.kmRodado);
        }
    }

}