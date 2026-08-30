package org.example;

import excepciones.RepartidorInvalido;
import model.ControladorDeEnvios;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.List;

public class Main {

    public void main(String[] args) {
        ControladorDeEnvios controladorDeEnvios = new ControladorDeEnvios();

        PedidoComida pedidoComida = new PedidoComida(
                100,
                "Comida",
                "Av. macul",
                "Auto",
                14
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                101,
                "Caja",
                "Av. Apoquindo",
                15,
                3
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                102,
                "Express",
                "Av. Las Condes",
                true,
                3
        );

        // asignar repartidores
        this.asignacionDePedidos(pedidoComida, pedidoExpress, pedidoEncomienda, controladorDeEnvios);

        // historial
        System.out.println("\n");
        System.out.println("HISTORIAL DE ENTREGAS");
        this.verHistorialDePedidosExitosos(controladorDeEnvios);

    }

    public void asignacionDePedidos(PedidoComida pedidoComida, PedidoExpress pedidoExpress, PedidoEncomienda pedidoEncomienda, ControladorDeEnvios controladorDeEnvios) {
        try {
            System.out.println("Asignando repartidor para el pedido de comida ....");
            System.out.println(pedidoComida.asignarRepartidor("Maria"));
            int tiempoDeEntregaComida = pedidoComida.calcularTiempoDeEntrega();
            System.out.println("El tiempo de entrega estimado es: " + tiempoDeEntregaComida + " min");
            controladorDeEnvios.despachar(pedidoComida.getIdPedido());
        } catch (RepartidorInvalido e) {
            System.out.println("El pedido falló" + "\n");
            String pedidoCancelado = controladorDeEnvios.cancelar(pedidoComida.getIdPedido());
            System.out.println(pedidoCancelado);
        }

        try {
            System.out.println("===========================================");
            System.out.println("Asignando repartidor para el pedido de Encomienda ....");
            System.out.println(pedidoEncomienda.asignarRepartidor("Fernanda"));
            int tiempoDeEntregaEncomienda = pedidoEncomienda.calcularTiempoDeEntrega();
            System.out.println("El tiempo de entrega estimado es: " + tiempoDeEntregaEncomienda + " min");
            controladorDeEnvios.despachar(pedidoEncomienda.getIdPedido());
        } catch (RepartidorInvalido e) {
            System.out.println("El pedido falló" + "\n");
            String pedidoCancelado = controladorDeEnvios.cancelar(pedidoEncomienda.getIdPedido());
            System.out.println(pedidoCancelado);
        }

        try {
            System.out.println("===========================================");

            System.out.println("Asignando repartidor para el pedido de Express ....");
            System.out.println(pedidoExpress.asignarRepartidor("Max"));
            controladorDeEnvios.despachar(pedidoExpress.getIdPedido());
        } catch (RepartidorInvalido e) {
            System.out.println("El pedido falló..." + "\n");
            String pedidoCancelado = controladorDeEnvios.cancelar(pedidoExpress.getIdPedido());
            System.out.println(pedidoCancelado);
        }
    }

    public void verHistorialDePedidosExitosos(ControladorDeEnvios controladorDeEnvios) {
        List<Integer> historial = controladorDeEnvios.verHistorial();

        for (Integer id : historial) {
            System.out.println("Id de pedido: " + id);
        }
    }
}
