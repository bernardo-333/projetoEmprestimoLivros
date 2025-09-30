package classes;

import abstracts.Usuario;
import classes.usuarios.Aluno;
import classes.usuarios.Professor;
import enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    // Metodos para cadastrar
    public String cadastrarLivro(Livro livro) {
        livros.add(livro);
        return "Livro cadastrado com sucesso!!!";
    }

    public String cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return "Usuario cadastrado com sucesso!!!";
    }

    // Realizar um emprestimo
    public String realizarEmprestimo(Livro livro, Usuario usuario, int dataPrevistaDevolucao) {
        // Aqui dentro temos 3 verificações

        // Verifica se o livro está disponivel
        if (livro.getStatus() != Status.DISPONIVEL) {
            return "O livro já está emprestado!!!";
        }

        // Verifica se o usuario já atingiu o limite de emprestimos ativos

        // Aqui ele está alimentando a variavel emprestimosAtivos percorrendo a lista de emprestimos
        int emprestimosAtivos = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getUsuarioResponsavel().equals(usuario) && e.getDataDevolvida() == null) {
                emprestimosAtivos++;
            }
        }
        // Verifica se atingiu o limite de emprestimos do usuario
        if (emprestimosAtivos >= usuario.getLimiteEmprestimos()) {
            return "Usuário atingiu o limite de empréstimos ativos.";
        }

        // Por fim se tudo estiver correto ele cadastra o emprestimo
        Emprestimo emprestimo = new Emprestimo(livro, usuario, dataPrevistaDevolucao);
        livro.emprestar();
        emprestimos.add(emprestimo);
        return "Emprestimo realizado com sucesso";
    }

    // Realizar uma devolução buscando pelo Id do emprestimo
    public String registrarDevolucao(int id_emprestimo) {
        for (Emprestimo e : emprestimos) {
            if (e.getId() == id_emprestimo) {
                e.registrarDevolucao();
                return "Devolução registrada com sucesso!!!";
            }
        }
        return "Id não encontrado na lista de emprestimos!!";
    }

    // Métodos para listar os livros separando por disponiveis ou emprestados pelo filtro
    public String listarLivros(Status statusFiltro){
        String resultado = "";
        for (Livro l : livros) {
            if (statusFiltro == null || l.getStatus() == statusFiltro) {
                resultado += l + "\n";
            }
        }
        if (livros.isEmpty()) {
            return "Nenhum livro cadastrado!!!";
        }
        return resultado;
    }

    // Metodos para listar os emprestimos
    public String listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            return "Nenhum emprestimo cadastrado!!!";
        }

        String resultado = "";
        for (Emprestimo e : emprestimos) {
            resultado += e + "\n";
        }
        return resultado;
    }
}
