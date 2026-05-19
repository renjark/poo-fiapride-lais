package br.com.fiapride.model.biblioteca;

// AULA 8: Classe abstrata - um "Livro genérico" não existe sozinho
// Todo livro é Digital ou Fisico
public abstract class Livro {

    // AULA 3: Atributos privados (encapsulamento)
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean disponivel;

    // AULA 4: Construtor obriga informar dados essenciais no nascimento
    public Livro(String titulo, String autor, int numeroPaginas) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setNumeroPaginas(numeroPaginas);
        this.disponivel = true; // todo livro começa disponível
    }

    // AULA 2: Métodos com regra de negócio
    public void emprestar() {
        if (!this.disponivel) {
            System.out.println("Erro: O livro '" + this.titulo + "' já está emprestado.");
            return;
        }
        this.disponivel = false;
        System.out.println("Livro '" + this.titulo + "' emprestado com sucesso.");
    }

    public void devolver() {
        if (this.disponivel) {
            System.out.println("Erro: O livro '" + this.titulo + "' já está disponível.");
            return;
        }
        this.disponivel = true;
        System.out.println("Livro '" + this.titulo + "' devolvido com sucesso.");
    }

    // AULA 8: Método abstrato - cada tipo de livro exibe informações diferentes
    public abstract void exibirDetalhes();

    // AULA 7: Método que será sobrescrito pelas subclasses
    public abstract String getTipoAcesso();

    // AULA 3: Getters públicos
    public String getTitulo() { return this.titulo; }
    public String getAutor() { return this.autor; }
    public int getNumeroPaginas() { return this.numeroPaginas; }
    public boolean isDisponivel() { return this.disponivel; }

    // AULA 3: Setters privados com validação
    private void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("Erro: Título inválido.");
            this.titulo = "Sem título";
        }
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    private void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas > 0) {
            this.numeroPaginas = numeroPaginas;
        } else {
            System.out.println("Erro: Número de páginas inválido. Usando 1.");
            this.numeroPaginas = 1;
        }
    }
}
