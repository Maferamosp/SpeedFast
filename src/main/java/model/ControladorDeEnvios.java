package model;

import excepciones.PedidoDuplicado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorDeEnvios implements DespachableInterface, CancelableInterface, RastreableInterface {
    private List<Integer> idsPedidosExitosos = new ArrayList<>();

    public void agregarIdDePedidosExitosos(int idPedido) {
        for (Integer id : this.idsPedidosExitosos) {
            if (Objects.equals(id, idPedido)) {
                throw new PedidoDuplicado("Ya el pedido nro: " + idPedido + " está en curso");
            }
        }

        this.idsPedidosExitosos.add(idPedido);
    }
    @Override
    public String despachar(int idPedido) {
        agregarIdDePedidosExitosos(idPedido);

        return "Pedido nro " + idPedido +
                " despachado correctamente.";
    }

    @Override
    public String cancelar(int idPedido) {
        return "Pedido nro " + idPedido +
                " cancelado correctamente.";
    }

    @Override
    public List<Integer> verHistorial() {
        return this.idsPedidosExitosos;
    }
}
