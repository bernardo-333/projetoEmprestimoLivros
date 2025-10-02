package program;

import classes.Biblioteca;
import classes.Livro;
import classes.usuarios.Aluno;
import classes.usuarios.Professor;
import enums.Status;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // cadastrar usuários
        System.out.println("\n---cadastrar usuários---");
        Professor professor = new Professor("Fiamma", "fiamma11@senaisp.edu.br");
        Aluno aluno = new Aluno("Bernardo", "bernardo@email.com");
        System.out.println(biblioteca.cadastrarUsuario(professor));
        System.out.println(biblioteca.cadastrarUsuario(aluno));

        // Cadastrar livros
        System.out.println("\n---cadastrar livros---");
        Livro livro1 = new Livro("Senhor dos Aneis", "J R R Tolkien");
        Livro livro2 = new Livro("Clean Code", "Robert C Martin");
        System.out.println(biblioteca.cadastrarLivro(livro1));
        System.out.println(biblioteca.cadastrarLivro(livro2));

        // Listar todos os livros
        System.out.println("\n---listar todos os livros---");
        System.out.println(biblioteca.listarLivros(Status.DISPONIVEL));

        // Realizar empréstimo válido
        System.out.println("\n---realizar empréstimo válido---");
        System.out.println(biblioteca.realizarEmprestimo(livro1, aluno, 7));

        // Tentar emprestar o mesmo livro de novo
        System.out.println("\n---tentar emprestar o mesmo livro de novo---");
        System.out.println(biblioteca.realizarEmprestimo(livro1, professor, 7));

        // Testar limite de empréstimos do aluno
        System.out.println("\n---testar limite de empréstimos do aluno---");
        Livro livro3 = new Livro("memorias postumas de bras cubas", "machado de assis");
        System.out.println(biblioteca.cadastrarLivro(livro3));
        System.out.println(biblioteca.realizarEmprestimo(livro2, aluno, 7));
        System.out.println(biblioteca.realizarEmprestimo(livro3, aluno, 7));

        // Devolver livro
        System.out.println("\n---devolver livro---");
        System.out.println(biblioteca.registrarDevolucao(1));

        // Listar empréstimos
        System.out.println("\n---listar empréstimos---");
        System.out.println(biblioteca.listarEmprestimos());

        // Buscar usuário pelo email
        System.out.println("\n---buscar usuário pelo email---");
        System.out.println(biblioteca.buscarUsuario("fiamma11@gmail.com"));

        // Buscar livro pelo título
        System.out.println("\n---buscar livro pelo título---");
        System.out.println(biblioteca.buscarLivro("Clean Code"));
    }
}
