package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Veiculo {
    private String marca;
    private String modelo;
    private int categoria;
    private boolean statusLocacao;
    private double KMRodado;

    public Veiculo(String marca, String modelo, int categoria, double KMRodado) {
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.statusLocacao = true;
        this.KMRodado = KMRodado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCambio(String modelo) {
        this.modelo = modelo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public boolean getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public double getKMRodado() {
        return KMRodado;
    }

    public void setLugares(double KMRodado) {
        this.KMRodado = KMRodado;
    }

    public static Veiculo cadastrar(String marca, String modelo, int categoria, Double km) {

        Veiculo carro = new Veiculo(marca, modelo, categoria, km);
        return carro;
    }

    // Método para calcular o preço por diaria
    public static double precoPorCategoriaDiaria(int categoria) {
        switch (categoria) {
            case 1: // Grupo A - Básico
                return 131.25;
            case 2: // Grupo B - Econômico
                return 157.50;
            case 3: // Grupo C - Intermediários
                return 172.20;
            case 4: // Grupo D - Intermediário Automático
                return 194.25;
            case 5: // Grupo E - Utilitário
                return 225.75;
            case 6: // Grupo E+ - Picape Compacta
                return 330.12;
            case 7: // Grupo F - SUV Manual
                return 283.50;
            case 8: // Grupo F - SUV Automático
                return 330.12;
            case 9: // Grupo G - Minivan Manual
                return 282.66;
            case 10: // Grupo G - Minivan Automático
                return 327.01;
            case 11: // Grupo H - Executivo
                return 281.40;
            case 12: // Grupo I - Pick-Up 4x4
                return 562.80;
            default:
                return 0;
        }
    }

    // Método para calcular o preço para mensalista
    public static double precoPorCategoriaMensal(int categoria) {
        switch (categoria) {
            case 1: // Grupo A - Básico
                return 2300.00;
            case 2: // Grupo B - Econômico
                return 2500.00;
            case 3: // Grupo C - Intermediários
                return 2700.00;
            case 4: // Grupo D - Intermediário Automático
                return 3200.00;
            case 5: // Grupo E - Utilitário
                return 3200.00;
            case 6: // Grupo E+ - Picape Compacta
                return 4000.00;
            case 7: // Grupo F - SUV Manual
                return 3700.00;
            case 8: // Grupo F - SUV Automático
                return 4200.00;
            case 9: // Grupo G - Minivan Manual
                return 3500.00;
            case 10: // Grupo G - Minivan Automático
                return 3800.00;
            case 11: // Grupo H - Executivo
                return 4000.00;
            case 12: // Grupo I - Pick-Up 4x4
                return 8400.00;
            default:
                return 0;
        }
    }

    public void alugar() {
        if (statusLocacao == true) {
            // System.out.println("Veículo alugado com sucesso!");
            this.statusLocacao = false;
        } else {
            // System.out.println("Desculpe, o veículo já se encontra locado.");
        }
    }

    public void devolver() {
        if (statusLocacao == false) {
            // System.out.println("Veículo devolvido com sucesso!");
            this.statusLocacao = true;
        } else {
            // System.out.println("O veículo já se encontra disponível.");
        }
    }

    // Calcula o preço do aluguel. A data vai ser recebida como STRING
    public static double calcularPrecoAluguelDiaria(String dataInicioStr, String dataFimStr, double KMInicial,
            double KMFinal, int categoria) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Converte a data para o formato dd/MM/yyyy

        try {
            Date dataInicio = dateFormat.parse(dataInicioStr); // Converte a data para o formato Date
            Date dataFim = dateFormat.parse(dataFimStr); // Converte a data para o formato Date
            double taxaDiaria = precoPorCategoriaDiaria(categoria); // Pega o preço da categoria por DIARIA!
            long diferencaEmMilissegundos = dataFim.getTime() - dataInicio.getTime(); // Calculando a diferença em
                                                                                      // milissegundos entre a data de
                                                                                      // término e a data de início. A
                                                                                      // função getTime() retorna o
                                                                                      // número de milissegundos desde
                                                                                      // 1º de janeiro de 1970 até a
                                                                                      // data especificada.
            long diferencaEmDias = diferencaEmMilissegundos / (24 * 60 * 60 * 1000); // Converte milissegundos em dias.
                                                                                     // Dividimos a diferença em
                                                                                     // milissegundos pelo valor obtido
                                                                                     // para obter o número de dias
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
                                                                                             // incorreta da
                                                                                             // data(string)
            return 0.0;
        }
    }

    public String toString() {
        return String.format("Marca: %s\nModelo: %s\nCategoria: %d\nKilometragem: %.0f\nDisponibilidade: %s\n\n",
                this.marca, this.modelo, this.categoria, this.KMRodado,
                this.statusLocacao == true ? "Disponivel" : "Alugado");
    }

}
