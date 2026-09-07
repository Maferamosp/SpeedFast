package model;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombreRepartidor;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombreRepartidor, List<Pedido> pedidosAsignados) {
        this.nombreRepartidor = nombreRepartidor;
        this.pedidosAsignados = pedidosAsignados;
    }

    public void run() {
        for (Pedido pedido : this.pedidosAsignados) {
            System.out.println("Su pedido nro " + pedido.getIdPedido() + " será despachado por el repartidor: " + this.nombreRepartidor + "\n");
            System.out.println("El pedido nro: " + pedido.getIdPedido() + " esta en camino a su domicilio..." + "\n");
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoDeEntrega() + " minutos, para el pedido nro: " + pedido.getIdPedido());

            try {
                Thread.sleep(pedido.calcularTiempoDeEntrega() * 100L);
                System.out.println("El pedido nro " + pedido.getIdPedido() + " fue entregado por " + nombreRepartidor);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();

                System.out.println("La entrega del pedido " + pedido.getIdPedido() + " fue interrumpida."
                );
            }
        }
        System.out.println("El repartidor " + this.nombreRepartidor + " entregó todos sus pedidos. \n");
    }
}

