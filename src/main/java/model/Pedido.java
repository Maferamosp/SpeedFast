package model;

public abstract class Pedido implements TareasInterface {
    private String tipoDePedido;
    private int idPedido;
    private String direccionEntrega;
    private int disatanciaKm;

    public Pedido(int idPedido, String tipoDePedido, String direccionEntrega, int disatanciaKm) {
        this.tipoDePedido = tipoDePedido;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.disatanciaKm = disatanciaKm;
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

    public int getDisatanciaKm() {
        return disatanciaKm;
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

    public void setDisatanciaKm(int disatanciaKm) {
        this.disatanciaKm = disatanciaKm;
    }

    public void mostrarResumen() {
        System.out.println("-------- Resumen del pedido ----------");
        System.out.println("Pedido de comida nro: " + idPedido + "\n");
        System.out.println("Tipo de pedido: " + tipoDePedido + "\n");
        System.out.println("Direccion de entrega: " + direccionEntrega + "\n");
        System.out.println("Distancia en KM: " + disatanciaKm);
    }

    @Override
    public String toString() {
        return "Pedido de comida nro: " + idPedido + "\n" +
                "Tipo de pedido: " + tipoDePedido + "\n" +
                "Direccion de entrega: " + direccionEntrega + "\n" +
                "Distancia en KM: " + disatanciaKm;
    }

    @Override
    public String asignarRepartidor() {
        return "Repartidor asignado para el id del pedido: " + idPedido;
    }

    public abstract int calcularTiempoDeEntrega();
}
