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

        if (getDistanciaKm() > 5) {
            tiempoBase += 5;
        }

        return tiempoBase;
    }

    @Override
    public void mostrarResumen() {
        int tiempoDeEntrega = this.calcularTiempoDeEntrega();

        System.out.println("-------- RESUMEN DEL PEDIDO --------");
        System.out.println("Número de pedido: " + getIdPedido());
        System.out.println("Tipo de pedido: " + getTipoDePedido());
        System.out.println("Dirección de entrega: " + getDireccionEntrega());
        System.out.println("Distancia: " + getDistanciaKm() + " km");
        System.out.println("Tiempo de entrega estimado: " + tiempoDeEntrega + " minutos");
        System.out.println("------------------------------------");
    }
}
