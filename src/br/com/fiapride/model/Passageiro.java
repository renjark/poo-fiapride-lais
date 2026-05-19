package br.com.fiapride.model;

// AULA 1: Classe com atributos
// AULA 3: Encapsulamento com private
// AULA 4: Construtor customizado
public class Passageiro {

    // AULA 3: Atributos privados - ninguém fora da classe acessa diretamente
    private String nome;
    private String cpf;
    private double saldo;

    // AULA 4: Construtor customizado - obriga informar nome e CPF no nascimento
    public Passageiro(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(0.0); // Todo passageiro começa com saldo zero
    }

    // AULA 2: Método adicionarSaldo com validação (regra de negócio)
    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor de recarga deve ser maior que zero.");
            return;
        }
        this.saldo += valor;
        System.out.println("Recarga realizada. Novo saldo: R$" + this.saldo);
    }

    // AULA 2: Método pagarViagem com validação de saldo
    public void pagarViagem(double custo) {
        if (custo <= 0) {
            System.out.println("Erro: O custo da viagem é inválido.");
            return;
        }
        if (this.saldo < custo) {
            System.out.println("Erro: Saldo insuficiente para realizar a viagem.");
            return;
        }
        this.saldo -= custo;
        System.out.println("Viagem paga. Saldo restante: R$" + this.saldo);
    }

    // AULA 3: Getters públicos - retornam cópia do valor, não o original
    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // AULA 3: Setters privados - só a própria classe pode usar
    // O setSaldo é privado pois o saldo só muda via adicionarSaldo() ou pagarViagem()
    private void setSaldo(double valor) {
        if (valor >= 0) {
            this.saldo = valor;
        } else {
            System.out.println("Erro de Segurança: Tentativa de definir saldo negativo bloqueada!");
        }
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
