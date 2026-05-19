package br.com.fiapride.model.biblioteca;

// AULA 9: LivroDigital É UM Livro E implementa Baixavel
public class LivroDigital extends Livro implements Baixavel {

    private String urlDownload;
    private double tamanhoMb;

    public LivroDigital(String titulo, String autor, int numeroPaginas, String urlDownload, double tamanhoMb) {
        super(titulo, autor, numeroPaginas);
        this.urlDownload = urlDownload;
        this.setTamanhoMb(tamanhoMb);
    }

    // AULA 9: Implementação obrigatória da interface Baixavel
    @Override
    public void baixar() {
        if (!this.isDisponivel()) {
            System.out.println("Erro: Este livro digital não está disponível para download.");
            return;
        }
        System.out.println("Baixando '" + this.getTitulo() + "' (" + this.tamanhoMb + " MB)...");
        System.out.println("URL: " + this.urlDownload);
        System.out.println("Download concluído!");
    }

    // AULA 7 + 8: Sobrescrita dos métodos abstratos
    @Override
    public void exibirDetalhes() {
        System.out.println("[DIGITAL] " + this.getTitulo() + " | Autor: " + this.getAutor()
                + " | " + this.getNumeroPaginas() + " págs"
                + " | " + this.tamanhoMb + " MB"
                + " | " + (this.isDisponivel() ? "Disponível" : "Indisponível"));
    }

    @Override
    public String getTipoAcesso() {
        return "Download online em " + this.urlDownload;
    }

    public double getTamanhoMb() { return this.tamanhoMb; }

    private void setTamanhoMb(double tamanhoMb) {
        if (tamanhoMb > 0) {
            this.tamanhoMb = tamanhoMb;
        } else {
            System.out.println("Erro: Tamanho inválido. Usando 1 MB.");
            this.tamanhoMb = 1.0;
        }
    }
}
