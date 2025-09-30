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
        // Verifica se atingiu o limite destinado ao aluno e ao professor
//        if (usuario instanceof Aluno) {
//            Aluno aluno = (Aluno) usuario;
//            if (emprestimosAtivos >= aluno.getLimiteEmprestimos()) {
//                return "Aluno atingiu o limite de empréstimos ativos.";
//            }
//        } else if (usuario instanceof Professor) {
//            Professor professor = (Professor) usuario;
//            if (emprestimosAtivos >= professor.getLimiteEmprestimos()) {
//                return "Professor atingiu o limite de empréstimos ativos.";
//            }
//        }

        if (emprestimosAtivos >= usuario.getLimiteEmprestimos()) {
            return "Usuário atingiu o limite de empréstimos ativos.";
        }







        Emprestimo emprestimo = new Emprestimo(livro, usuario, dataPrevistaDevolucao);
        if (emprestimo.isAtivo() == false) {
            livro.emprestar();
            emprestimos.add(emprestimo);
            return "Emprestimo realizado com sucesso";
        } else {
            return "O emprestimo deste livro ja esta ativo";
        }
    }


}
