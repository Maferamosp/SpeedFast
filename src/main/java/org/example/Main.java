package org.example;

import excepciones.RepartidorInvalido;
import model.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ControladorDeEnvios controladorDeEnvios = new ControladorDeEnvios();

        // creacion de pedidos
        PedidoComida pedidoComida = new PedidoComida(
                100,
                "Comida",
                "Av. Macul",
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

        PedidoComida pedidoComida2 = new PedidoComida(
                103,
                "Comida",
                "Av. Providencia",
                "Auto",
                8
        );

        PedidoEncomienda pedidoEncomienda2 = new PedidoEncomienda(
                104,
                "Caja",
                "Av. Irarrazaval",
                10,
                5
        );

        PedidoExpress pedidoExpress2 = new PedidoExpress(
                105,
                "Express",
                "Av. Vitacura",
                true,
                6
        );

        // mostrar resumen de los pedidos
        pedidoComida.mostrarResumen();
        pedidoEncomienda.mostrarResumen();
        pedidoExpress.mostrarResumen();
        pedidoComida2.mostrarResumen();
        pedidoEncomienda2.mostrarResumen();
        pedidoExpress2.mostrarResumen();

        // despachar pedidos
        controladorDeEnvios.despachar(pedidoComida.getIdPedido());
        controladorDeEnvios.despachar(pedidoEncomienda.getIdPedido());
        controladorDeEnvios.despachar(pedidoExpress.getIdPedido());
        controladorDeEnvios.despachar(pedidoComida2.getIdPedido());
        controladorDeEnvios.despachar(pedidoEncomienda2.getIdPedido());
        controladorDeEnvios.despachar(pedidoExpress2.getIdPedido());

        // asignar pedidos
        List<Pedido> pedidosMaria = Arrays.asList(
                pedidoComida,
                pedidoExpress
        );

        List<Pedido> pedidosFernanda = Arrays.asList(
                pedidoEncomienda,
                pedidoComida2
        );

        List<Pedido> pedidosMax = Arrays.asList(
                pedidoEncomienda2,
                pedidoExpress2
        );

        // asignar repartidores
        Repartidor maria = new Repartidor(
                "Maria",
                pedidosMaria
        );

        Repartidor fernanda = new Repartidor(
                "Fernanda",
                pedidosFernanda
        );

        Repartidor max = new Repartidor(
                "Max",
                pedidosMax
        );

        // crear los hilos
        Thread hiloMaria = new Thread(maria);
        Thread hiloFernanda = new Thread(fernanda);
        Thread hiloMax = new Thread(max);

        // iniciar los hilos
        hiloMaria.start();
        hiloFernanda.start();
        hiloMax.start();

        try {
            hiloMaria.join();
            hiloFernanda.join();
            hiloMax.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La ejecución fue interrumpida.");
        }

        // historial
        System.out.println("\n");
        System.out.println("HISTORIAL DE ENTREGAS");
        verHistorialDePedidosExitosos(controladorDeEnvios);

    }

    public static void asignacionDePedidos(PedidoComida pedidoComida, PedidoExpress pedidoExpress, PedidoEncomienda pedidoEncomienda, ControladorDeEnvios controladorDeEnvios) {
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

        try {
            System.out.println("===========================================");

            System.out.println("Asignando repartidor para el pedido de Express 2 ....");
            System.out.println(pedidoExpress.asignarRepartidor("Maria"));
            controladorDeEnvios.despachar(pedidoExpress.getIdPedido());
        } catch (RepartidorInvalido e) {
            System.out.println("El pedido falló..." + "\n");
            String pedidoCancelado = controladorDeEnvios.cancelar(pedidoExpress.getIdPedido());
            System.out.println(pedidoCancelado);
        }
    }

    public static void verHistorialDePedidosExitosos(ControladorDeEnvios controladorDeEnvios) {
        List<Integer> historial = controladorDeEnvios.verHistorial();

        for (Integer id : historial) {
            System.out.println("Id de pedido: " + id);
        }
    }
}
