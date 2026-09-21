package app;

import excepciones.RepartidorInvalido;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private List<Pedido> listaPedidos = new ArrayList<>();
    private ControladorDeEnvios controladorDeEnvios = new ControladorDeEnvios();

    public VentanaPrincipal() {
        setTitle("SpeedFast - Sistema de Entregas");
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("SpeedFast", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton botonRegistrar = new JButton("Registrar pedido");
        JButton botonListar = new JButton("Listar pedidos");
        JButton botonAsignar = new JButton("Asignar repartidor / Iniciar entrega");

        botonRegistrar.addActionListener(e -> new VentanaRegistroPedido(listaPedidos).setVisible(true));
        botonListar.addActionListener(e -> new VentanaListaPedidos(listaPedidos).setVisible(true));
        botonAsignar.addActionListener(e -> asignarRepartidor());

        panelBotones.add(botonRegistrar);
        panelBotones.add(botonListar);
        panelBotones.add(botonAsignar);

        add(panelBotones, BorderLayout.CENTER);
    }

    private void asignarRepartidor() {
        if (listaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados todavia");
            return;
        }

        String idTexto = JOptionPane.showInputDialog(null, "Ingrese el ID del pedido a asignar: ");
        if (idTexto == null) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ID incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido pedidoEncontrado = null;
        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() == id) {
                pedidoEncontrado = p;
            }
        }

        if (pedidoEncontrado == null) {
            JOptionPane.showMessageDialog(null, "No se encontro un pedido con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreRepartidor = JOptionPane.showInputDialog(null, "Ingrese el nombre del repartidor:");
        if (nombreRepartidor == null || nombreRepartidor.equals("")) {
            return;
        }

        String resultado;
        try {
            if (pedidoEncontrado instanceof PedidoComida) {
                resultado = ((PedidoComida) pedidoEncontrado).asignarRepartidor(nombreRepartidor);
            } else if (pedidoEncontrado instanceof PedidoEncomienda) {
                resultado = ((PedidoEncomienda) pedidoEncontrado).asignarRepartidor(nombreRepartidor);
            } else if (pedidoEncontrado instanceof PedidoExpress) {
                resultado = ((PedidoExpress) pedidoEncontrado).asignarRepartidor(nombreRepartidor);
            } else {
                resultado = pedidoEncontrado.asignarRepartidor();
            }

            pedidoEncontrado.setEstado(EstadoPedido.EN_REPARTO);
            controladorDeEnvios.despachar(pedidoEncontrado.getIdPedido());
        } catch (RepartidorInvalido ex) {
            resultado = "No se pudo asignar el repartidor: " + ex.getMessage();
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
