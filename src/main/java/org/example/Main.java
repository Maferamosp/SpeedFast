package org.example;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        PedidoComida pedidoComida = new PedidoComida(
                100,
                "Comida",
                "Av. macul",
                "Auto"
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                101,
                "Caja",
                "Av. Apoquindo",
                15
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                102,
                "Express",
                "Av. Las Condes",
                true
        );

        System.out.println("Asignando repartidor para el pedido de comida ....");
        System.out.println(pedidoComida.asignarRepartidor("Maria")
        );

        System.out.println("===========================================");

        System.out.println("Asignando repartidor para el pedido de Encomienda ....");
        System.out.println(pedidoEncomienda.asignarRepartidor("Fernanda")
        );

        System.out.println("===========================================");

        System.out.println("Asignando repartidor para el pedido de Express ....");
        System.out.println(pedidoExpress.asignarRepartidor("Max"));
    }
}
