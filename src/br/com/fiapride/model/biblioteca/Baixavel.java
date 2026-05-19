package br.com.fiapride.model.biblioteca;

// AULA 9: Interface - contrato de comportamento
// Qualquer classe que assinar pode ser "baixada", independente da hierarquia
public interface Baixavel {

    // Constante da interface (public static final implícito)
    int LIMITE_DOWNLOADS_DIA = 5;

    // Contrato: quem implementar DEVE ter este método
    void baixar();
}
