package br.com.fiapride.main;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.CarroEletrico;
import br.com.fiapride.model.Celular;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Recarregavel;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;
import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      SISTEMA FIAPRIDE - AULAS 1-9     ");
        System.out.println("========================================\n");

        // ================================================================
        // AULA 1 + 2 + 3 + 4: Classes, Métodos, Encapsulamento, Construtores
        // ================================================================
        System.out.println("--- AULAS 1-4: Passageiros ---");

        // AULA 4: Construtor obriga informar nome e CPF (não nasce "em branco")
        Passageiro ana = new Passageiro("Ana Silva", "222.222.222-22");
        Passageiro carlos = new Passageiro("Carlos Souza", "333.333.333-33");

        // AULA 2: Métodos com regra de negócio
        ana.adicionarSaldo(100.0);
        carlos.adicionarSaldo(15.0);

        // AULA 3: Acesso por Getters (não diretamente ao atributo)
        System.out.println("Passageiro: " + ana.getNome() + " | Saldo: R$" + ana.getSaldo());
        System.out.println("Passageiro: " + carlos.getNome() + " | Saldo: R$" + carlos.getSaldo());

        // AULA 3: Prova do encapsulamento - linha abaixo causaria erro de compilação:
        // ana.saldo = 99999; // ❌ ERRO: saldo é private

        System.out.println();

        // ================================================================
        // AULA 5: Associação - Viagem TEM UM Passageiro e TEM UM Veiculo
        // ================================================================
        System.out.println("--- AULA 5: Associação (Viagem) ---");

        Carro carroDoJoao = new Carro("ABC-1234", "Toyota Corolla", 4);
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", ana, carroDoJoao);
        viagemDaAna.exibirResumo();

        // Prova de referência: mudança no objeto original reflete na viagem
        ana.adicionarSaldo(50.0);
        System.out.println("Saldo da Ana via referência na Viagem: R$"
                + viagemDaAna.getSolicitante().getSaldo());

        // Finaliza a viagem (cobra do passageiro usando o objeto associado)
        viagemDaAna.finalizar(30.0);
        System.out.println("Saldo da Ana após viagem: R$" + ana.getSaldo());

        System.out.println();

        // ================================================================
        // AULA 6: Herança - Carro e Moto herdam de Veiculo
        // ================================================================
        System.out.println("--- AULA 6: Herança ---");

        Carro onix = new Carro("XYZ-5678", "Chevrolet Onix");
        Moto mottu = new Moto("MOT-9999", "Honda CG 160", false);

        // Filhas acessam métodos herdados da mãe Veiculo (getPlaca, getModelo)
        System.out.println("Carro (herdado da mãe): " + onix.getModelo() + " | Placa: " + onix.getPlaca());
        System.out.println("Vagas: " + onix.getCapacidadePassageiros()); // atributo próprio
        System.out.println("Moto (herdado da mãe): " + mottu.getModelo() + " | Placa: " + mottu.getPlaca());

        System.out.println();

        // ================================================================
        // AULA 7: Polimorfismo de Sobrescrita - mesmo método, resultados diferentes
        // ================================================================
        System.out.println("--- AULA 7: Polimorfismo ---");

        List<Veiculo> frota = new ArrayList<>();
        frota.add(new Carro("CAR-0001", "Honda Civic"));
        frota.add(new Moto("MOT-0002", "Yamaha Fazer"));

        for (Veiculo veiculo : frota) {
            veiculo.abastecer(50); // método da mãe
            // POLIMORFISMO: mesmo comando "calcularAutonomia()", resultado diferente!
            System.out.println(veiculo.calcularAutonomia());
        }

        System.out.println();

        // ================================================================
        // AULA 8: Classes Abstratas - Veiculo não pode ser instanciado
        // ================================================================
        System.out.println("--- AULA 8: Classes Abstratas ---");

        // Linha abaixo causaria erro de compilação:
        // Veiculo v = new Veiculo("AAA-0000", "Genérico"); // ❌ ERRO: Veiculo is abstract

        Veiculo taxi = new Carro("TAX-1111", "Fiat Uno");
        Veiculo mototaxi = new Moto("MTX-2222", "Honda Biz");

        // exibirTipo() é método abstrato implementado por cada filha
        taxi.exibirTipo();
        mototaxi.exibirTipo();

        System.out.println();

        // ================================================================
        // AULA 9: Interfaces - Recarregavel implementado por classes diferentes
        // ================================================================
        System.out.println("--- AULA 9: Interfaces ---");

        CarroEletrico tesla = new CarroEletrico("TES-9999", "Tesla Model 3");
        Celular iphone = new Celular("iPhone 15");

        // POLIMORFISMO DE INTERFACE: objetos de hierarquias diferentes tratados como Recarregavel
        Recarregavel[] recarregaveis = new Recarregavel[]{tesla, iphone};

        System.out.println("Recarregando todos os dispositivos:");
        for (Recarregavel r : recarregaveis) {
            r.recarregar(85); // mesmo método, cada objeto sabe o que fazer
        }

        System.out.println();
        System.out.println("Verificando tipos com instanceof:");
        System.out.println("Tesla é Veiculo? " + (tesla instanceof Veiculo));
        System.out.println("Tesla é Recarregavel? " + (tesla instanceof Recarregavel));
        System.out.println("Celular é Veiculo? false (Celular não pertence à hierarquia de Veiculo)");
        System.out.println("Celular é Recarregavel? " + (iphone instanceof Recarregavel));

        System.out.println();
        System.out.println(tesla.calcularAutonomia());

        System.out.println("\n========================================");
        System.out.println("          FIM DO SISTEMA FIAPRIDE       ");
        System.out.println("========================================");
    }
}
