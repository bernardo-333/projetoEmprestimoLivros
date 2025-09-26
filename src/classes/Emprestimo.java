package classes;

import abstracts.Usuario;
import enums.Status;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livroEmprestado;
    private Usuario usuarioResponsavel;
    private LocalDate dataEmprestada;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livroEmprestado, Usuario usuarioResponsavel) {
        this.livroEmprestado = livroEmprestado;
        this.usuarioResponsavel = usuarioResponsavel;
        this.dataEmprestada = LocalDate.now();
        this.dataDevolucao = dataEmprestada.plusDays(7);
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public LocalDate getDataEmprestada() {
        return dataEmprestada;
    }

    public void setDataEmprestada(LocalDate dataEmprestada) {
        this.dataEmprestada = dataEmprestada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

//    public void registrarDevolucao()



//    public boolean isAtivo() {
//        if (livroEmprestado.getStatus() == Status.DISPONIVEL) {
//            System.out.println("O livro "++"");
//
//        }
//    }
}
