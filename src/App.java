import java.util.ArrayList;

import Entidades.Cliente;
import Entidades.PessoaFisica;
import Entidades.Veiculo;

public class App {

    public static void main(String[] args) throws Exception {
        // Arrys Banco de Dados
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        // System.out.println(Veiculo.precoPorCategoriaDiaria(2));
        System.out.println("O valor da locação é: R$"
                + Veiculo.calcularPrecoAluguelDiaria("01/06/2023", "02/06/2023", 10000, 10800, 2));
        veiculos.add(Veiculo.cadastrar("Ford", "Ka", 1, 10000.0));
        veiculos.add(Veiculo.cadastrar("Audi", "A3", 2, 10000.0));
        clientes.add(PessoaFisica.cadastrar());
        clientes.get(0).alugarCarro(veiculos.get(0));
        clientes.get(0).alugarCarro(veiculos.get(1));
        System.out.print(clientes.get(0).getAlugados().get(0));

        // veiculos.add(Veiculo.cadastrar("Tesla", "Model S", 3, 10000.0));
        // veiculos.get(0).alugar();
        // for (Veiculo carro : veiculos) {
        // System.out.print(carro);
        // }

    }

    // Testando
}
