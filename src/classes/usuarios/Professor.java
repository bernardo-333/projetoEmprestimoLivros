package classes.usuarios;

import abstracts.Usuario;

// Herança
public class Professor extends Usuario {
    private int LimiteEmprestimos = 5;

    public Professor(String nome, String email) {
        super(nome, email);
    }

    // Metodo abstrato assinado
    @Override
    public int getLimiteEmprestimos() {
        return LimiteEmprestimos;
    }
}
