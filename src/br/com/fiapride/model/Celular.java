package br.com.fiapride.model;

// AULA 9: Celular NÃO é um Veiculo, mas TAMBÉM é Recarregavel
// Isso demonstra que interfaces permitem compartilhar comportamentos entre hierarquias diferentes
public class Celular implements Recarregavel {

    private String marca;
    private int nivelBateria;

    public Celular(String marca) {
        this.marca = marca;
        this.nivelBateria = 0;
    }

    // AULA 9: Implementação do contrato Recarregavel - lógica específica do Celular
    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: Percentual inválido!");
            return;
        }
        this.nivelBateria = percentual;
        System.out.println("Celular " + this.marca + " carregado para " + percentual + "%");
    }

    public String getMarca() {
        return this.marca;
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }
}
