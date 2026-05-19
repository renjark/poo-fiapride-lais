package br.com.fiapride.model;

// AULA 6: Herança - Moto É UM Veiculo
public class Moto extends Veiculo {

    private boolean isEletrica;

    // AULA 6: super() repassa placa e modelo para o construtor da mãe
    public Moto(String placa, String modelo) {
        super(placa, modelo);
        this.isEletrica = false; // padrão: combustão
    }

    public Moto(String placa, String modelo, boolean isEletrica) {
        super(placa, modelo);
        this.isEletrica = isEletrica;
    }

    // AULA 7 + 8: Sobrescrita com lógica da Moto - 35 km/L (mais econômica que o Carro)
    @Override
    public String calcularAutonomia() {
        double kmRestante = this.getNivelCombustivel() * 35.0;
        return "Autonomia da Moto: " + kmRestante + " km (consumo de 35 km/L)";
    }

    // AULA 8: Implementação obrigatória
    @Override
    public void exibirTipo() {
        String tipo = this.isEletrica ? "Moto Elétrica" : "Moto a Combustão";
        System.out.println("Sou uma " + tipo + ".");
    }

    public boolean isEletrica() {
        return this.isEletrica;
    }

    public void setIsEletrica(boolean isEletrica) {
        this.isEletrica = isEletrica;
    }
}
