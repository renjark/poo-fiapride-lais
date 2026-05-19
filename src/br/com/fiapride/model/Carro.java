package br.com.fiapride.model;

// AULA 6: Herança - Carro É UM Veiculo (teste do "É UM" passa)
public class Carro extends Veiculo {

    // Atributo exclusivo do Carro (a mãe Veiculo não tem isso)
    private int capacidadePassageiros;

    // AULA 6: Construtor da filha - usa super() para repassar dados à mãe
    public Carro(String placa, String modelo) {
        super(placa, modelo); // Chama o construtor de Veiculo
        this.setCapacidadePassageiros(4); // Padrão: 4 passageiros
    }

    // Construtor com capacidade personalizada
    public Carro(String placa, String modelo, int capacidadePassageiros) {
        super(placa, modelo);
        this.setCapacidadePassageiros(capacidadePassageiros);
    }

    // AULA 7 + 8: @Override - sobrescreve o método abstrato da mãe com lógica do Carro
    // Carro consome 10 km por litro
    @Override
    public String calcularAutonomia() {
        double kmRestante = this.getNivelCombustivel() * 10.0;
        return "Autonomia do Carro: " + kmRestante + " km (consumo de 10 km/L)";
    }

    // AULA 8: Implementação obrigatória do método abstrato exibirTipo()
    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro com " + this.capacidadePassageiros + " lugares.");
    }

    public int getCapacidadePassageiros() {
        return this.capacidadePassageiros;
    }

    private void setCapacidadePassageiros(int capacidadePassageiros) {
        if (capacidadePassageiros > 0) {
            this.capacidadePassageiros = capacidadePassageiros;
        } else {
            System.out.println("Erro: Capacidade inválida. Usando valor padrão (4).");
            this.capacidadePassageiros = 4;
        }
    }
}
