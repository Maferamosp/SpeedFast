package model;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {
    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidosPendientes.add(pedido);
        System.out.println("El pedido nro " + pedido.getIdPedido() + " ingreso a la zona de carga.");
    }

    public synchronized Pedido retirarPedido() {
        return pedidosPendientes.poll();
    }
}
