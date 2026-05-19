package br.com.fiapride.model.biblioteca;

// AULA 5: Associação (TEM-UM)
// Emprestimo TEM UM Usuario e TEM UM Livro
public class Emprestimo {

    // AULA 5: Atributos de associação - objetos complexos
    private Usuario solicitante;  // papel do Usuario neste contexto
    private Livro livroRetirado;  // papel do Livro neste contexto
    private String dataDevolucaoPrevista;
    private boolean finalizado;

    // AULA 5: Construtor exige os objetos inteiros (não só Strings com nomes)
    // Motivo: precisa chamar métodos de Usuario e Livro durante o empréstimo
    public Emprestimo(Usuario solicitante, Livro livroRetirado, String dataDevolucaoPrevista) {
        this.solicitante = solicitante;
        this.livroRetirado = livroRetirado;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.finalizado = false;

        // Ao criar o empréstimo, aciona os métodos dos objetos associados
        this.livroRetirado.emprestar();
        this.solicitante.registrarEmprestimo();
    }

    public void finalizar() {
        if (this.finalizado) {
            System.out.println("Empréstimo já foi finalizado.");
            return;
        }
        this.livroRetirado.devolver();
        this.solicitante.registrarDevolucao();
        this.finalizado = true;
    }

    public void exibirResumo() {
        System.out.println("\n--- RESUMO DO EMPRÉSTIMO ---");
        // AULA 5: Navegando pelos objetos associados
        System.out.println("Usuário: " + this.solicitante.getNome());
        System.out.println("Livro: " + this.livroRetirado.getTitulo());
        System.out.println("Autor: " + this.livroRetirado.getAutor());
        System.out.println("Tipo de acesso: " + this.livroRetirado.getTipoAcesso());
        System.out.println("Devolução prevista: " + this.dataDevolucaoPrevista);
        System.out.println("Status: " + (this.finalizado ? "Finalizado" : "Em andamento"));
        System.out.println("----------------------------\n");
    }

    public boolean isFinalizado() { return this.finalizado; }
    public Usuario getSolicitante() { return this.solicitante; }
    public Livro getLivroRetirado() { return this.livroRetirado; }
}
