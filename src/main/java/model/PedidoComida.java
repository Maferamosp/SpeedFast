package model;

import java.util.Objects;

public class PedidoComida extends Pedido implements TareasInterface {
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
        return 15 + (2 * getDistanciaKm());
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