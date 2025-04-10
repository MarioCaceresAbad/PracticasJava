package defensa2;

import java.util.ArrayList;
import java.util.List;

import entrega2.*;

class ClientesPorAntiguedad extends ListaOrdenada<Cliente> {
    public ClientesPorAntiguedad() {
        super((c1, c2) -> Integer.compare(c2.antiguedad(), c1.antiguedad()));
    }

    public List<Cliente> topClientes(int n) {
        List<Cliente> top = new ArrayList<>();
        for (int i = 0; i < Math.min(n, size()); i++) {
            top.add(elements().get(i));
        }
        return top;
    }
}