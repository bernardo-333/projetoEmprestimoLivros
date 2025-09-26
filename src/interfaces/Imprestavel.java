package interfaces;

import abstracts.Usuario;

public interface Imprestavel {
    boolean emprestar(Usuario u);
    void devolver();
}
