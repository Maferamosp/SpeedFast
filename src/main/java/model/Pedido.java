package model;

public class Pedido implements TareasInterface {
    private String tipoDePedido;
    private int idPedido;
    private String direccionEntrega;

    public Pedido(int idPedido, String tipoDePedido, String direccionEntrega) {
        this.tipoDePedido = tipoDePedido;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
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

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setTipoDePedido(String tipoDePedido) {
        this.tipoDePedido = tipoDePedido;
    }


    @Override
    public String toString() {
        return "Pedido de comida nro: " + idPedido + "\n" +
                "Tipo de pedido: " + tipoDePedido + "\n" +
                "Direccion de entrega: " + direccionEntrega;
    }
    @Override
    public String asignarRepartidor() {
        return "Repartidor asignado para el id del pedido: " + idPedido;
    }
}
