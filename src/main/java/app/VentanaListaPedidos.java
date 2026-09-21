package app;

import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private DefaultTableModel modeloTabla;
    private List<Pedido> listaPedidos;

    public VentanaListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;

        setTitle("Listado de Pedidos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Tipo", "Dirección", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        refrescarTabla();
    }

    public void refrescarTabla() {
        modeloTabla.setRowCount(0);

        for (Pedido p : listaPedidos) {
            Object[] fila = {p.getIdPedido(), p.getTipoDePedido(), p.getDireccionEntrega(), p.getEstado()};
            modeloTabla.addRow(fila);
        }
    }
}
