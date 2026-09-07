package model;

public class PedidoEncomienda extends Pedido  implements TareasInterface {
    private final int medidasEnCm;

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
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
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
