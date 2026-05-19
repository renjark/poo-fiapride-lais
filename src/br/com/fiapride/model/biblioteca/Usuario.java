package br.com.fiapride.model.biblioteca;

// AULA 1-4: Classe com encapsulamento e construtor
public class Usuario {

    private String nome;
    private String cpf;
    private int emprestimosAtivos;

    // AULA 4: Construtor - usuário nasce com nome e CPF obrigatórios
    public Usuario(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.emprestimosAtivos = 0;
    }

    // AULA 2: Métodos com regra de negócio
    public void registrarEmprestimo() {
        if (this.emprestimosAtivos >= 3) {
            System.out.println("Erro: " + this.nome + " já possui 3 empréstimos ativos (limite máximo).");
            return;
        }
        this.emprestimosAtivos++;
        System.out.println("Empréstimo registrado para " + this.nome
                + ". Ativos: " + this.emprestimosAtivos + "/3");
    }

    public void registrarDevolucao() {
        if (this.emprestimosAtivos <= 0) {
            System.out.println("Erro: " + this.nome + " não possui empréstimos ativos.");
            return;
        }
        this.emprestimosAtivos--;
        System.out.println("Devolução registrada para " + this.nome
                + ". Ativos: " + this.emprestimosAtivos + "/3");
    }

    // AULA 3: Getters públicos
    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
    public int getEmprestimosAtivos() { return this.emprestimosAtivos; }

    // AULA 3: Setters privados
    private void setNome(String nome) { this.nome = nome; }
    private void setCpf(String cpf) { this.cpf = cpf; }
}
