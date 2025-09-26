package classes;

import abstracts.Usuario;

public class Professor extends Usuario {
    private int LimiteEmprestimos = 5;

    public Professor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return LimiteEmprestimos;
    }
}
