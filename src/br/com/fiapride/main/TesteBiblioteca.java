package br.com.fiapride.main;

import br.com.fiapride.model.biblioteca.Baixavel;
import br.com.fiapride.model.biblioteca.Emprestimo;
import br.com.fiapride.model.biblioteca.Livro;
import br.com.fiapride.model.biblioteca.LivroDigital;
import br.com.fiapride.model.biblioteca.LivroFisico;
import br.com.fiapride.model.biblioteca.Usuario;
import java.util.ArrayList;
import java.util.List;

public class TesteBiblioteca {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      SISTEMA DE BIBLIOTECA DIGITAL     ");
        System.out.println("========================================\n");

        // AULA 4: Construtores obrigatórios
        Usuario maria = new Usuario("Maria Oliveira", "111.111.111-11");
        Usuario joao = new Usuario("João Pereira", "222.222.222-22");

        // AULA 6 + 4: Subclasses com construtores usando super()
        LivroFisico livro1 = new LivroFisico(
                "Clean Code", "Robert C. Martin", 464, "Estante B - Prateleira 2");

        LivroDigital livro2 = new LivroDigital(
                "O Programador Pragmático", "Andy Hunt", 352,
                "biblioteca.fiap.com.br/download/pragmatico", 8.5);

        LivroFisico livro3 = new LivroFisico(
                "Design Patterns", "Gang of Four", 395, "Estante A - Prateleira 1");

        System.out.println("--- Acervo da Biblioteca ---");

        // AULA 7: Polimorfismo - lista da superclasse aceita qualquer subclasse
        List<Livro> acervo = new ArrayList<>();
        acervo.add(livro1);
        acervo.add(livro2);
        acervo.add(livro3);

        // Mesmo método exibirDetalhes(), resultados diferentes (polimorfismo)
        for (Livro livro : acervo) {
            livro.exibirDetalhes();
        }

        System.out.println();

        // AULA 5: Associação - Emprestimo conecta Usuario e Livro
        System.out.println("--- Realizando Empréstimos ---");
        Emprestimo emp1 = new Emprestimo(maria, livro1, "25/05/2026");
        emp1.exibirResumo();

        // AULA 9: Interface - LivroDigital implementa Baixavel
        System.out.println("--- Download de Livro Digital ---");
        Baixavel[] baixaveis = new Baixavel[]{livro2};
        for (Baixavel b : baixaveis) {
            b.baixar();
        }

        System.out.println();

        // Testando regra de negócio: livro já emprestado
        System.out.println("--- Testando Regras de Negócio ---");
        Emprestimo emp2 = new Emprestimo(joao, livro1, "25/05/2026"); // livro já emprestado

        // Devolução
        System.out.println();
        System.out.println("--- Devolução ---");
        emp1.finalizar();

        // Agora João pode pegar
        System.out.println();
        Emprestimo emp3 = new Emprestimo(joao, livro1, "01/06/2026");
        emp3.exibirResumo();

        System.out.println("\n========================================");
        System.out.println("          FIM DO SISTEMA BIBLIOTECA     ");
        System.out.println("========================================");
    }
}
