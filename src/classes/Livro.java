package classes;

import abstracts.Usuario;
import enums.Status;
import interfaces.Imprestavel;

public class Livro implements Imprestavel {
    private static int contador = 0;
    private int id;
    private String titulo;
    private String autor;
    private Status status;

    public Livro(String titulo, String autor) {
        this.id = ++contador;
        this.titulo = titulo;
        this.autor = autor;
        this.status = Status.DISPONIVEL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return status;
    }

    // Métodos implementados da interface
    @Override
    public boolean emprestar(Usuario u) {
     if (status == Status.DISPONIVEL) {
         this.status = Status.EMPRESTADO;
         System.out.println("O livro "+this.titulo+" foi emprestado com sucesso!!!");
         return true;
     } else {
         System.out.println("Não foi possivel devolver o livro "+this.titulo+" pois ele já está emprestado!!!");
         return false;
     }
    }

    @Override
    public void devolver() {
        if (status == Status.EMPRESTADO) {
            this.status = Status.DISPONIVEL;
            System.out.println("O livro "+this.titulo+" foi devolvido com sucesso!!!");
        } else {
            System.out.println("Não foi possivel devolver o livro "+this.titulo+" pois ele já está disponivel!!!");
        }
    }
}
