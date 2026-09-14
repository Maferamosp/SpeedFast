package model;

public class Repartidor implements Runnable {
    private String nombreRepartidor;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombreRepartidor, ZonaDeCarga zonaDeCarga) {
        this.nombreRepartidor = nombreRepartidor;
        this.zonaDeCarga = zonaDeCarga;
    }

    public void run() {
        Pedido pedido;

        while ((pedido = zonaDeCarga.retirarPedido()) != null) {
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("Su pedido nro " + pedido.getIdPedido() + " será despachado por el repartidor: " + this.nombreRepartidor + "\n");
            System.out.println("El pedido nro: " + pedido.getIdPedido() + " esta en camino a su domicilio..." + "\n");
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoDeEntrega() + " minutos, para el pedido nro: " + pedido.getIdPedido());

            try {
                Thread.sleep(pedido.calcularTiempoDeEntrega() * 100L);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();

                System.out.println("La entrega del pedido " + pedido.getIdPedido() + " fue interrumpida."
                );
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("El pedido nro " + pedido.getIdPedido() + " fue entregado por " + nombreRepartidor);
        }
        System.out.println("El repartidor " + this.nombreRepartidor + " entregó todos sus pedidos. \n");
    }
}

