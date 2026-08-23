package model;

import java.util.Objects;

public class PedidoEncomienda extends Pedido {
    private int medidasEnCm;

    public PedidoEncomienda(int idPedido, String tipoDePedido, String direccionEntrega, int medidasEnCm, int disatanciaKm) {
        super(idPedido, tipoDePedido, direccionEntrega, disatanciaKm);
        this.medidasEnCm = medidasEnCm;
    }

    @Override
    public String toString() {
        return "Pedido nro" + getIdPedido() +
                "El repartidor debe contar con auto.";
    }

    public String asignarRepartidor(String nombreRepartidor) {
        if (medidasEnCm < 20 ) {
            return "Pedido nro " + getIdPedido() +
                    ": Repartidor " + nombreRepartidor +
                    " asignado correctamente.";
        }
        return "Pedido  nro" + getIdPedido() + ": No se puede asignar a " + nombreRepartidor +
                " porque el tamaño del paquete es superior al permitido";
    }

    @Override
    public int calcularTiempoDeEntrega() {
        return (int) Math.round(20 + (1.5 * getDisatanciaKm()));
    }

    public void mostrarResumen() {
        int tiempoDeEntregaEncomienda = this.calcularTiempoDeEntrega();
        System.out.println("El tiempo de entrega estimado es: " + tiempoDeEntregaEncomienda + " min");
    }
}
