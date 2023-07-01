import java.util.ArrayList;

import Entidades.Cliente;
import Entidades.Veiculo;

public class App {

    public static void main(String[] args) throws Exception {
        // Arrys Banco de Dados
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        veiculos.add(Veiculo.cadastrar("Ford", "Ka", 1, 10000.0));
        veiculos.add(Veiculo.cadastrar("Audi", "A3", 2, 10000.0));
        veiculos.add(Veiculo.cadastrar("Tesla", "Model S", 3, 10000.0));
        veiculos.get(0).alugar();
        for (Veiculo carro : veiculos) {
            System.out.print(carro);

        }

    }

    // Testando
}
