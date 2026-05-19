package br.com.fiapride.model.biblioteca;

// AULA 6: Herança - LivroFisico É UM Livro
public class LivroFisico extends Livro {

    private String localizacao; // ex: "Estante A - Prateleira 3"

    // AULA 6: super() repassa dados essenciais para a mãe
    public LivroFisico(String titulo, String autor, int numeroPaginas, String localizacao) {
        super(titulo, autor, numeroPaginas);
        this.setLocalizacao(localizacao);
    }

    // AULA 7 + 8: @Override - implementação obrigatória do método abstrato
    @Override
    public void exibirDetalhes() {
        System.out.println("[FÍSICO] " + this.getTitulo() + " | Autor: " + this.getAutor()
                + " | " + this.getNumeroPaginas() + " págs"
                + " | Local: " + this.localizacao
                + " | " + (this.isDisponivel() ? "Disponível" : "Emprestado"));
    }

    @Override
    public String getTipoAcesso() {
        return "Retirada presencial na biblioteca";
    }

    public String getLocalizacao() { return this.localizacao; }

    private void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
