package abstracts;

public abstract class Usuario {
    private static int contador = 0;
    private int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.id = ++contador;
        this.nome = nome;
        this.email = email;
    }

    protected abstract int getLimiteEmprestimos();

}
