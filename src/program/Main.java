package program;

import abstracts.Usuario;
import classes.Biblioteca;
import classes.Livro;
import classes.usuarios.Aluno;
import classes.usuarios.Professor;
import enums.Status;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n---Bem vindo ao Sistema de Biblioteca---");
            System.out.println();
            System.out.println("1- Cadastrar Usuario");
            System.out.println("2- Cadastrar Livro");
            System.out.println("3- Listar Livros");
            System.out.println("4- Buscar Livro");
            System.out.println("5- listar Usuarios");
            System.out.println("6- Buscar Usuario");
            System.out.println("7- Realizar Emprestimo");
            System.out.println("8- Registrar Devolução");
            System.out.println("9- listar Emprestimos");
            System.out.println("10- Sair");
            System.out.print("\n> ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n---Cadastrar Usuario---");
                    System.out.println("1- Aluno");
                    System.out.println("2- Professor");
                    System.out.print("> ");
                    int tipoUsuario = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    String email;
                    while (true) {
                        System.out.print("Email: ");
                        email = sc.nextLine();
                        if (email.contains("@")) break;
                        System.out.println("Email inválido, tente novamente!");
                    }

                    if (tipoUsuario == 1) {
                        Aluno aluno = new Aluno(nome, email);
                        System.out.println(biblioteca.cadastrarUsuario(aluno));
                    } else if (tipoUsuario == 2) {
                        Professor professor = new Professor(nome, email);
                        System.out.println(biblioteca.cadastrarUsuario(professor));
                    } else {
                        System.out.println("Tipo inválido!");
                    }
                    break;

                case 2:
                    System.out.println("\n---Cadastrar Livro---");
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    Livro livro = new Livro(titulo, autor);
                    System.out.println(biblioteca.cadastrarLivro(livro));
                    break;

                case 3:
                    System.out.println("\n---Listar Livros---");
                    System.out.println("Escolha o status para filtrar:");
                    System.out.println("1 - DISPONIVEL");
                    System.out.println("2 - EMPRESTADO");
                    System.out.print("> ");
                    int filtroStatus = sc.nextInt();
                    sc.nextLine();

                    Status statusFiltro = null;
                    switch (filtroStatus) {
                        case 1:
                            statusFiltro = Status.DISPONIVEL;
                            break;
                        case 2:
                            statusFiltro = Status.EMPRESTADO;
                            break;
                        default:
                            System.out.println("Opção inválida! Mostrando todos os livros.");
                            break;
                    }

                    if (statusFiltro != null) {
                        System.out.println(biblioteca.listarLivros(statusFiltro));
                    }
                    break;

                case 4:
                    System.out.println("\n---Buscar Livro---");
                    System.out.print("Digite o título: ");
                    String buscaTitulo = sc.nextLine();
                    System.out.println(biblioteca.buscarLivro(buscaTitulo));
                    break;

                case 5:
                    System.out.println("\n---Listar Usuários---");
                    for (Usuario u : biblioteca.getUsuarios()) {
                        System.out.println(u);
                    }
                    break;

                case 6:
                    System.out.println("\n---Buscar Usuário---");
                    System.out.print("Digite nome ou email: ");
                    String buscaUsuario = sc.nextLine();
                    System.out.println(biblioteca.buscarUsuario(buscaUsuario));
                    break;

                case 7:
                    System.out.println("\n---Realizar Empréstimo---");
                    System.out.print("Digite o email do usuário: ");
                    String emailEmprestimo = sc.nextLine();
                    System.out.print("Digite o título do livro: ");
                    String tituloLivroEmprestimo = sc.nextLine();

                    // aqui eu busco o usuario na biblioteca
                    Usuario usuarioEmprestimo = null;
                    for (Usuario u : biblioteca.getUsuarios()) {
                        if (u.getEmail().equalsIgnoreCase(emailEmprestimo.trim())) {
                            usuarioEmprestimo = u;
                            break;
                        }
                    }

                    // aqui busca o livro
                    Livro livroEmprestimo = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(tituloLivroEmprestimo.trim())) {
                            livroEmprestimo = l;
                            break;
                        }
                    }

                    if (usuarioEmprestimo == null) {
                        System.out.println("Usuário não encontrado!");
                        break;
                    }
                    if (livroEmprestimo == null) {
                        System.out.println("Livro não encontrado!");
                        break;
                    }

                    System.out.print("Digite o número de dias para devolução: ");
                    int diasDevolucao = sc.nextInt();
                    sc.nextLine();

                    String resultado = biblioteca.realizarEmprestimo(livroEmprestimo, usuarioEmprestimo, diasDevolucao);
                    System.out.println(resultado);
                    break;

                case 8:
                    System.out.println("\n---Registrar Devolução---");
                    System.out.print("ID do empréstimo: ");
                    int idEmprestimo = sc.nextInt();
                    sc.nextLine();
                    System.out.println(biblioteca.registrarDevolucao(idEmprestimo));
                    break;

                case 9:
                    System.out.println("\n---Listar Empréstimos---");
                    System.out.println(biblioteca.listarEmprestimos());
                    break;

                case 10:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);

        sc.close();
    }
}
