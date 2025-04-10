package defensa2;
import java.util.stream.Collectors;
import entrega2.*;
import java.util.List;
class ColaComprasPendientes extends Cola<Compra> {
    public Compra buscarCompraPorDescripcion(String desc) {
        for (Compra c : elements()) {
            if (c.descripcion().contains(desc)) {
                return c;
            }
        }
        return null;
    }

    public List<Compra> filtrarPorClienteYProducto(Cliente cliente, String producto) {
        return elements().stream()
                .filter(c -> c.cliente().equals(cliente) && c.descripcion().contains(producto))
                .collect(Collectors.toList());
    }
}