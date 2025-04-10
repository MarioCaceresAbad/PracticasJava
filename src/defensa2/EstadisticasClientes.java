package defensa2;
import java.util.*;
import java.util.stream.Collectors;
class EstadisticasClientes {
    public static Map<Cliente, List<Compra>> agruparComprasPorClienteImperativo(List<Compra> compras) {
        Map<Cliente, List<Compra>> mapa = new HashMap<>();
        for (Compra c : compras) {
            mapa.computeIfAbsent(c.cliente(), k -> new ArrayList<>()).add(c);
        }
        return mapa;
    }

    public static Map<Cliente, List<Compra>> agruparComprasPorClienteFuncional(List<Compra> compras) {
        return compras.stream().collect(Collectors.groupingBy(Compra::cliente));
    }
}