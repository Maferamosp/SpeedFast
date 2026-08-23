package model;

import java.util.Objects;

public class PedidoComida extends Pedido {
    private final String tipoDeTransporte;

    public PedidoComida(int idPedido, String tipoDePedido, String direccionEntrega, String tipoDeTransporte, int disatanciaKm) {
        super(idPedido, tipoDePedido, direccionEntrega, disatanciaKm);
        this.tipoDeTransporte = tipoDeTransporte;
    }

    @Override
    public String toString() {
        return "Pedido de comida nro" + getIdPedido() +
                "El repartidor debe contar con auto.";
    }

    public String asignarRepartidor(String nombreRepartidor) {
        if (Objects.equals(tipoDeTransporte, "Auto")) {
            return "Pedido de comida nro " + getIdPedido() +
                    ": Repartidor " + nombreRepartidor +
                    " asignado correctamente.";
        }
        return "Pedido de comida nro" + getIdPedido() + ": No se puede asignar a " + nombreRepartidor +
                " porque no cuenta con Auto.";
    }

    @Override
    public int calcularTiempoDeEntrega() {
        return 15 + (2 * getDisatanciaKm());
    }

}