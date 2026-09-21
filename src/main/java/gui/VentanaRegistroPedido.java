package gui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {
    private JTextField campoId;
    private JTextField campoDireccion;
    private JComboBox<String> comboTipo;

    private List<Pedido> listaPedidos;

    private final int distanciaPorDefecto = 5;

    public VentanaRegistroPedido(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;

        setTitle("Registrar Pedido");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 10));

        panelFormulario.add(new JLabel("ID Pedido:"));
        campoId = new JTextField();
        panelFormulario.add(campoId);

        panelFormulario.add(new JLabel("Direccion:"));
        campoDireccion = new JTextField();
        panelFormulario.add(campoDireccion);

        panelFormulario.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});
        panelFormulario.add(comboTipo);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> guardarPedido());

        add(panelFormulario, BorderLayout.CENTER);
        add(botonGuardar, BorderLayout.SOUTH);
    }

    private void guardarPedido() {
        String direccion = campoDireccion.getText();

        if (campoId.getText().equals("") || direccion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(campoId.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() == id) {
                JOptionPane.showMessageDialog(this, "Ya existe un pedido con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String tipoSeleccionado = (String) comboTipo.getSelectedItem();
        Pedido nuevoPedido = null;

        if (tipoSeleccionado.equals("Comida")) {
            nuevoPedido = new PedidoComida(id, tipoSeleccionado, direccion, "Auto", distanciaPorDefecto);
        } else if (tipoSeleccionado.equals("Encomienda")) {
            nuevoPedido = new PedidoEncomienda(id, tipoSeleccionado, direccion, 15, distanciaPorDefecto);
        } else if (tipoSeleccionado.equals("Express")) {
            nuevoPedido = new PedidoExpress(id, tipoSeleccionado, direccion, true, distanciaPorDefecto);
        }

        listaPedidos.add(nuevoPedido);

        JOptionPane.showMessageDialog(this, "Pedido nro " + id + " registrado correctamente.");

        campoId.setText("");
        campoDireccion.setText("");
    }
}
