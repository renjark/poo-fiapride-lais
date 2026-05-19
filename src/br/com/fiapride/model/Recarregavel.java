package br.com.fiapride.model;

// AULA 9: Interface - define um CONTRATO de comportamento
// Qualquer classe que assinar este contrato DEVE implementar recarregar()
// Diferente da herança, múltiplas classes de hierarquias diferentes podem implementar
public interface Recarregavel {

    // AULA 9: Constantes da interface - são public static final implicitamente
    int CARGA_MAXIMA = 100;
    int CARGA_MINIMA = 0;

    // Método sem corpo - apenas a assinatura (o contrato)
    // Toda classe que implementar Recarregavel DEVE ter este método
    void recarregar(int percentual);
}
