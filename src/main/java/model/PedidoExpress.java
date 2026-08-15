package model;

import java.util.Objects;

public class PedidoExpress extends Pedido {
    private boolean remesaUrgente;


    public PedidoExpress(int idPedido, String tipoDePedido, String direccionEntrega, boolean remesaUrgente) {
        super(idPedido, tipoDePedido, direccionEntrega);
        this.remesaUrgente = remesaUrgente;
    }

    @Override
    public String toString() {
        return "Pedido nro" + getIdPedido() +
                "El repartidor debe contar con auto.";
    }

    public String asignarRepartidor(String nombreRepartidor) {
        if (remesaUrgente && Objects.equals(nombreRepartidor, "Maria")) {
            return "Pedido nro " + getIdPedido() +
                    ": Repartidor " + nombreRepartidor +
                    " asignado correctamente.";
        }
        return "Pedido  nro " + getIdPedido() + ":" + " Falló" + "\n" +
                "No se puede asignar a " + nombreRepartidor +
                " porque no tiene disponibilidad inmediata.";
    }
}
