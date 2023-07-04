package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private LocalDate dataDeDevolucao = null;

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

    public void setStatusLocacao(boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public LocalDate getDataDeLocacao() {
        return dataDeLocacao;
    }

    public void setDataDeLocacao(LocalDate dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;
    }

    public LocalDate getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void dataDeDevolucao(LocalDate dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public int getkmRodado() {
        return kmRodado;
    }

    // Método para calcular o preço por diaria
    public static double precoPorCategoriaDiaria(int categoria) {
        switch (categoria) {

            case 1: // Grupo B - Econômico
                return 157.50;
            case 2: // Grupo C - Intermediários
                return 172.20;
            case 3: // Grupo E - Utilitário
                return 225.75;
            case 4: // Grupo H - Executivo
                return 281.40;
            default:
                return 0;
        }
    }

    // Método para calcular o preço para mensalista
    public static double precoPorCategoriaMensal(int categoria) {
        switch (categoria) {
            case 1: // Grupo B - Econômico
                return 2500.00;
            case 2: // Grupo C - Intermediários
                return 2700.00;
            case 3: // Grupo E - Utilitário
                return 3200.00;
            case 4: // Grupo H - Executivo
                return 4000.00;
            default:
                return 0;
        }
    }

    public void alugar(LocalDate dataDeHoje, Cliente cliente) {
        dataDeLocacao = dataDeHoje;
        clienteEmPosse = cliente;
        statusLocacao = false;

    }

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

    public void devolver(LocalDate dataDevolucao, Cliente cliente) {
        this.statusLocacao = true;
        this.dataDeDevolucao = dataDevolucao;
        clienteEmPosse = null;
    }

    // Calcula o preço do aluguel. A data vai ser recebida como STRING
    public static double calcularPrecoAluguelDiaria(String dataInicioStr, String dataFimStr, double KMInicial,
            double KMFinal, int categoria) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Converte a data para o formato dd/MM/yyyy

        try {
            Date dataInicio = dateFormat.parse(dataInicioStr); // Converte a data para o formato Date
            Date dataFim = dateFormat.parse(dataFimStr); // Converte a data para o formato Date
            double taxaDiaria = precoPorCategoriaDiaria(categoria); // Pega o preço da categoria por DIARIA!
            long diferencaEmMilissegundos = dataFim.getTime() - dataInicio.getTime();
            long diferencaEmDias = diferencaEmMilissegundos / (24 * 60 * 60 * 1000); // Converte milissegundos em dias.

            double taxaKMExcedido = 1.20; // Taxa de KM excedido.
            double totalCustoKMExcedido = 0; // Variável para armazenar o total de KM excedido.
            if (diferencaEmDias < 3) {
                if (diferencaEmDias == 2 && KMFinal - KMInicial > 200) {
                    totalCustoKMExcedido = (KMFinal - KMInicial) * taxaKMExcedido;
                    System.out.println("Qtd de dias locados: " + diferencaEmDias + " dias");
                    System.out.println("Total da diária: R$" + taxaDiaria * diferencaEmDias);
                    System.out.println(
                            "Total de KM excedidos: " + (KMFinal - KMInicial) + "KM" + "\nValor total de KM excente: R$"
                                    + totalCustoKMExcedido);
                } else if (diferencaEmDias == 1 && KMFinal - KMInicial > 100) {
                    totalCustoKMExcedido = (KMFinal - KMInicial) * taxaKMExcedido;
                    System.out.println("Qtd de dias locado: " + diferencaEmDias + " dia");
                    System.out.println("Total da diária: R$" + taxaDiaria * diferencaEmDias);
                    System.out.println(
                            "Total de KM excedidos: " + (KMFinal - KMInicial) + "KM" + "\nValor total de KM excente: R$"
                                    + totalCustoKMExcedido);
                }
                return (taxaDiaria * diferencaEmDias) + totalCustoKMExcedido; // Retorna o valor da taxa de aluguel +
                                                                              // taxa de km excedido
            } else {
                System.out.println("Quilometragem livre a partir da 3ª diária.");
                totalCustoKMExcedido = 0;
                System.out.println("Qtd de dias locados: " + diferencaEmDias + " dias");
            }
            return (taxaDiaria * diferencaEmDias) + totalCustoKMExcedido; // Retorna o valor da taxa de aluguel.
        } catch (ParseException e) {
            System.out.println("Certifique-se de que as datas estão no formato dd/MM/yyyy"); // Erro por formatação
            return 0.0;
        }
    }

    public static Veiculo cadastrarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a Marca do Veiculo: ");
        String marca = sc.nextLine();
        System.out.print("Digite o Modelo do Veiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Digite a categoria do Veiculo: \n1 - Básico\n2- Intermediário\n\nEscolha: ");
        int categoria = sc.nextInt();
        System.out.print("Digite a Kilometragem do Veiculo: ");
        int km = sc.nextInt();
        return new Veiculo(marca, modelo, categoria, km);

    }

    public String toString() {
        if (this.statusLocacao == false) {
            return String.format("Marca: %s\nModelo: %s\nCategoria: %s\nQuilometragem: %dkm\nLocado por: %s\n\n",
                    this.marca, this.modelo, this.nomeDaCategoria(), this.kmRodado,
                    String.format(clienteEmPosse.getNome()));
        } else {
            return String.format("Marca: %s\nModelo: %s\nCategoria: %s\nQuilometragem: %dkm\nDisponibilidade: %s\n\n",
                    this.marca, this.modelo, this.nomeDaCategoria(), this.kmRodado,
                    this.statusLocacao == true ? "Disponível" : "Alugado");
        }
    }

}
