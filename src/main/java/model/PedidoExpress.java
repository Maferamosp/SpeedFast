package model;

import excepciones.RepartidorInvalido;

import java.util.Objects;

public class PedidoExpress extends Pedido implements TareasInterface {
    private final boolean remesaUrgente;


    public PedidoExpress(int idPedido, String tipoDePedido, String direccionEntrega, boolean remesaUrgente, int disatanciaKm) {
        super(idPedido, tipoDePedido, direccionEntrega, disatanciaKm);
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

        throw new RepartidorInvalido("Pedido inválido");
    }

    @Override
    public int calcularTiempoDeEntrega() {
        int tiempoBase = 10;

        if (getDisatanciaKm() > 5) {
            tiempoBase += 5;
        }

        return tiempoBase;
    }

    public void mostrarResumen() {
        int tiempoDeEntregaEncomienda = this.calcularTiempoDeEntrega();
        System.out.println("El tiempo de entrega estimado es: " + tiempoDeEntregaEncomienda + " min");
    }
}
