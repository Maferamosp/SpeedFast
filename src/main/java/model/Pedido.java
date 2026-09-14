package model;

public abstract class Pedido implements TareasInterface {
    private String tipoDePedido;
    private int idPedido;
    private String direccionEntrega;
    private int distanciaKm;
    private EstadoPedido estado;

    public Pedido(int idPedido, String tipoDePedido, String direccionEntrega, int distanciaKm) {
        this.tipoDePedido = tipoDePedido;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoDePedido() {
        return tipoDePedido;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setTipoDePedido(String tipoDePedido) {
        this.tipoDePedido = tipoDePedido;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarResumen() {
        System.out.println("-------- Resumen del pedido ----------");
        System.out.println("Pedido de comida nro: " + idPedido + "\n");
        System.out.println("Tipo de pedido: " + tipoDePedido + "\n");
        System.out.println("Direccion de entrega: " + direccionEntrega + "\n");
        System.out.println("Distancia en KM: " + distanciaKm);
    }

    @Override
    public String toString() {
        return "Pedido de comida nro: " + idPedido + "\n" +
                "Tipo de pedido: " + tipoDePedido + "\n" +
                "Direccion de entrega: " + direccionEntrega + "\n" +
                "Distancia en KM: " + distanciaKm;
    }

    @Override
    public String asignarRepartidor() {
        return "Repartidor asignado para el id del pedido: " + idPedido;
    }

    public abstract int calcularTiempoDeEntrega();
}
