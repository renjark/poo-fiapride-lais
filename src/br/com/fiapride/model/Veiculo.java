package br.com.fiapride.model;

// AULA 8: Classe abstrata - ninguém pode fazer "new Veiculo()" diretamente
// Um veículo genérico não existe no mundo real, apenas tipos específicos (Carro, Moto)
public abstract class Veiculo {

    private String placa;
    private String modelo;
    private double nivelCombustivel;

    // AULA 4: Construtor - todo veículo nasce com placa e modelo obrigatórios
    public Veiculo(String placa, String modelo) {
        this.setPlaca(placa);
        this.modelo = modelo;
        this.nivelCombustivel = 0.0;
    }

    // Método público para atualizar placa - representa um processo real (Detran)
    // AULA 4: O setPlaca() é privado; atualizarPlaca() é o método público com semântica de negócio
    public void atualizarPlaca(String novaPlaca) {
        System.out.println("Solicitada atualização de placa para o veículo " + this.modelo + "...");
        this.setPlaca(novaPlaca);
    }

    // AULA 2: Método de abastecimento
    public void abastecer(int quantidade) {
        this.nivelCombustivel += quantidade;
        System.out.println("Veículo abastecido. Nível atual: " + this.nivelCombustivel + "L");
    }

    // AULA 7 + 8: Método abstrato - define o CONTRATO que todas as filhas devem cumprir
    // O método não tem corpo aqui; cada subclasse implementa com sua própria lógica
    public abstract String calcularAutonomia();

    // AULA 8: Outro método abstrato - obriga cada filha a se identificar
    public abstract void exibirTipo();

    // Getters
    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getNivelCombustivel() {
        return this.nivelCombustivel;
    }

    // Setter privado para placa - com validação (regra de negócio)
    // AULA 4: privado porque a lógica de alterar placa passa por atualizarPlaca()
    private void setPlaca(String novaPlaca) {
        if (novaPlaca != null && !novaPlaca.trim().isEmpty()) {
            this.placa = novaPlaca;
            System.out.println("Placa registrada: " + this.placa);
        } else {
            System.out.println("Erro de Validação: Placa inválida!");
        }
    }
}
