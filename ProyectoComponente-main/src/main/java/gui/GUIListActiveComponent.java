package gui;

import model.ActiveComponent;
import com.mycompany.electroniccomponentsproject.service.ElectronicComponentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GUIListActiveComponent extends javax.swing.JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public GUIListActiveComponent() {
        initComponents();
        setTitle("Listar Componentes Activos");
        setLocationRelativeTo(null);
        loadActiveComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "ID", "Brand", "Package", "Voltage", "Current", "Gain", "Pins"
        });

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnRefresh = new JButton("Actualizar");
        btnRefresh.addActionListener(e -> loadActiveComponents());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                        .addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addGap(10)
                                .addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(20))
        );

        pack();
    }

    private void loadActiveComponents() {

        tableModel.setRowCount(0); // limpiar tabla

        List<ActiveComponent> list =
                ElectronicComponentService.findComponentByType(ActiveComponent.class);

        for (ActiveComponent component : list) {
            tableModel.addRow(new Object[]{
                    component.getId(),
                    component.getBrand(),
                    component.getPackageType(),
                    component.getVoltage(),
                    component.getCurrent(),
                    component.getGainFactor(),
                    component.getPinNames()
            });
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GUIListActiveComponent().setVisible(true));
    }
}