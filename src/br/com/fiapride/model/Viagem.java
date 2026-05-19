package br.com.fiapride.model;

// AULA 5: Associação (TEM-UM)
// Viagem TEM UM Passageiro e TEM UM Veiculo
// Os atributos não são primitivos (String, int), são objetos de outras classes
public class Viagem {

    private String destino;
    private double valor;

    // AULA 5: Atributos de associação - objetos complexos como peças de Lego
    // Os nomes indicam o PAPEL que cada objeto desempenha na Viagem (Clean Code)
    private Passageiro solicitante;
    private Veiculo veiculoUtilizado;

    // AULA 5: Construtor exige o objeto inteiro (não só a String do nome)
    // Motivo: a Viagem precisa acessar métodos do Passageiro (ex: pagarViagem)
    public Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado) {
        this.destino = destino;
        this.solicitante = solicitante;
        this.veiculoUtilizado = veiculoUtilizado;
        this.valor = 0.0;
        System.out.println("Nova viagem criada para: " + this.destino);
    }

    // AULA 5: Método que navega entre os objetos associados
    public void exibirResumo() {
        System.out.println("\n--- RESUMO DA VIAGEM ---");
        System.out.println("Destino: " + this.destino);
        // Acessando dados do Passageiro através da associação
        System.out.println("Passageiro: " + this.solicitante.getNome());
        System.out.println("CPF: " + this.solicitante.getCpf());
        // Acessando dados do Veiculo através da associação
        System.out.println("Veículo: " + this.veiculoUtilizado.getModelo()
                + " | Placa: " + this.veiculoUtilizado.getPlaca());
        System.out.println("Valor: R$" + this.valor);
        System.out.println("------------------------\n");
    }

    // Finaliza a viagem e cobra do passageiro
    public void finalizar(double valorCorrida) {
        this.valor = valorCorrida;
        System.out.println("Finalizando viagem... cobrando R$" + valorCorrida);
        // A Viagem acessa o método do Passageiro diretamente (por isso precisamos do objeto inteiro)
        this.solicitante.pagarViagem(valorCorrida);
    }

    // Getters
    public String getDestino() {
        return this.destino;
    }

    public Passageiro getSolicitante() {
        return this.solicitante;
    }

    public Veiculo getVeiculoUtilizado() {
        return this.veiculoUtilizado;
    }

    public double getValor() {
        return this.valor;
    }
}
