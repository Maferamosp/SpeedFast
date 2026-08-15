package model;

import java.util.Objects;

public class PedidoEncomienda extends Pedido {
    private int medidasEnCm;

    public PedidoEncomienda(int idPedido, String tipoDePedido, String direccionEntrega, int medidasEnCm) {
        super(idPedido, tipoDePedido, direccionEntrega);
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
}
