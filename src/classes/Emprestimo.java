package classes;

import abstracts.Usuario;
import enums.Status;

import java.time.LocalDate;

public class Emprestimo {
    // Id gerado automaticamente
    private static int contador = 1;
    private int id;
    private Livro livroEmprestado;
    private Usuario usuarioResponsavel;
    private LocalDate dataEmprestada;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolvida;

    // Construtor inicializando as informações principais e registrando o emprestimo
    public Emprestimo(Livro livroEmprestado, Usuario usuarioResponsavel, int dataPrevistaDevolucao) {
        this.id = ++contador;
        this.livroEmprestado = livroEmprestado;
        this.usuarioResponsavel = usuarioResponsavel;
        this.dataEmprestada = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestada.plusDays(dataPrevistaDevolucao);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public LocalDate getDataEmprestada() {
        return dataEmprestada;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDate dataDevolvida) {
        this.dataDevolvida = dataDevolvida;
    }

    // Função no qual registra a devolução e a data
    public String registrarDevolucao() {
        if (dataDevolvida == null) {
            dataDevolvida = LocalDate.now();
            return "Devolução registrada com sucesso!!";
        } else {
            return "Este empréstimo já foi devolvido!!!";
        }
    }

    // Verifica se o emprestimo está ativo
    public String isAtivo() {
        if (dataDevolvida == null) {
            return "Emprestimo está ativo";
        } else {
            return "Emprestimo não está ativo";
        }
    }

    // Verifica se o emprestimo está atrasado, entregue ou nao entregue
    public String isAtrasado() {
        if (dataDevolvida == null) {
            if (LocalDate.now().isAfter(dataPrevistaDevolucao)) {
                return "Está atrasado!!";
            } else {
                return "Não está atrasado";
            }
        } else {
            if (dataDevolvida.isAfter(dataPrevistaDevolucao)) {
                return "Está atrasado!!";
            } else {
                return "Não está atrasado";
            }
        }
    }

    // Calcula os dias de atraso, entregue ou não entregue
    public int getDiasAtraso() {
        if (dataDevolvida != null && dataDevolvida.isAfter(dataPrevistaDevolucao)) {
            return (int) (dataDevolvida.toEpochDay() - dataPrevistaDevolucao.toEpochDay());
        } else if (dataDevolvida == null && LocalDate.now().isAfter(dataPrevistaDevolucao)) {
            return (int) (LocalDate.now().toEpochDay() - dataPrevistaDevolucao.toEpochDay());
        } else {
            return 0;
        }
    }

    // toString para mostrar informações
    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livroEmprestado=" + livroEmprestado +
                ", usuarioResponsavel=" + usuarioResponsavel +
                ", dataEmprestada=" + dataEmprestada +
                ", dataPrevistaDevolucao=" + dataPrevistaDevolucao +
                ", dataDevolvida=" + dataDevolvida +
                '}';
    }
}
