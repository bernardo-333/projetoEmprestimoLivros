package classes;

import abstracts.Usuario;
import enums.Status;
import interfaces.Imprestavel;

// Interface
public class Livro implements Imprestavel {
    // Id gerado automaticamente
    private static int contador = 0;
    private int id;
    private String titulo;
    private String autor;
    private Status status;

    // Construtor cadastrando as principais informações e atualizando os status para disponivel
    public Livro(String titulo, String autor) {
        this.id = ++contador;
        this.titulo = titulo;
        this.autor = autor;
        this.status = Status.DISPONIVEL;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Status getStatus() {
        return status;
    }

    // ---- Métodos implementados da interface ----

    // Função para atualizar o status do livro como emprestado
    @Override
    public String emprestar() {
     if (status == Status.DISPONIVEL) {
         this.status = Status.EMPRESTADO;
         return "Livro emprestado com sucesso!!!";
     } else {
         return "Livro já está emprestado!!!";
     }
    }

    // Função para atualizar o status do livro como devolvido
    @Override
    public String devolver() {
        if (status == Status.EMPRESTADO) {
            this.status = Status.DISPONIVEL;
            return "Livro devolvido com sucesso!!!";
        } else {
            return "O livro já esta disponivel!!";
        }
    }

    // toString para mostrar informações
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", status=" + status +
                '}';
    }
}
