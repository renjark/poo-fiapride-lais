package br.com.fiapride.model;

// AULA 9: CarroEletrico herda de Veiculo E implementa Recarregavel
// É UM Veiculo (herança) + TEM comportamento de recarregar (interface)
public class CarroEletrico extends Veiculo implements Recarregavel {

    private int nivelBateria; // 0 a 100

    public CarroEletrico(String placa, String modelo) {
        super(placa, modelo);
        this.nivelBateria = 0;
    }

    // AULA 9: Implementação obrigatória do contrato da interface Recarregavel
    @Override
    public void recarregar(int percentual) {
        // Usando as constantes da interface
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: Percentual inválido! Deve ser entre 0 e 100.");
            return;
        }
        this.nivelBateria = percentual;
        System.out.println("Carro elétrico " + this.getModelo() + " recarregado para " + percentual + "%");
    }

    // AULA 8: calcularAutonomia baseada na bateria (5 km por % de carga)
    @Override
    public String calcularAutonomia() {
        double kmRestante = this.nivelBateria * 5.0;
        return "Autonomia do Carro Elétrico: " + kmRestante + " km (bateria: " + this.nivelBateria + "%)";
    }

    // AULA 8: identificação do tipo
    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro Elétrico. Bateria atual: " + this.nivelBateria + "%");
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }
}
