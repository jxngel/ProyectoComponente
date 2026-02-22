/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author jesus
 */
public class GUIMain extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIMain.class.getName());
    private static final String PROJECT_NAME = "Electronic Components Project";
    private static final String PROJECT_VERSION = "1.0";
    private static final String TEAM_NAMES = "Juan Bocanegra, David Perez, Daniel Hoyos";

    /**
     * Creates new form GUIMain
     */
    public GUIMain() {
        initComponents();
        configureMenu();
        setTitle("Electronic Components Project");
        setLocationRelativeTo(null);
    }

    private void configureMenu() {
        setJMenuBar(buildMenuBar());
    }

    private javax.swing.JMenuBar buildMenuBar() {
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();

        // Menú Componente Pasivo
        javax.swing.JMenu passiveMenu = new javax.swing.JMenu("Componente Pasivo");
        passiveMenu.add(createMenuItem("Añadir", this::openAddPassiveComponent));
        passiveMenu.add(createMenuItem("Consultar", this::openSearchPassiveComponent));
        passiveMenu.add(createMenuItem("Listar", this::openListPassiveComponent));
        passiveMenu.add(new javax.swing.JSeparator());
        passiveMenu.add(createMenuItem("Calcular Impedancia", this::calculatePassiveImpedance));
        passiveMenu.add(createMenuItem("Calcular Potencia", this::calculatePassivePower));

        // Menú Componente Activo
        javax.swing.JMenu activeMenu = new javax.swing.JMenu("Componente Activo");
        activeMenu.add(createMenuItem("Añadir", this::openAddActiveComponent));
        activeMenu.add(createMenuItem("Consultar", this::openSearchActiveComponent));
        activeMenu.add(createMenuItem("Listar", this::openListActiveComponent));
        activeMenu.add(new javax.swing.JSeparator());
        activeMenu.add(createMenuItem("Calcular Impedancia", this::calculateActiveImpedance));
        activeMenu.add(createMenuItem("Calcular Potencia", this::calculateActivePower));

        // Menú Ayuda
        javax.swing.JMenu helpMenu = new javax.swing.JMenu("Ayuda");
        helpMenu.add(createMenuItem("Acerca de...", this::showAboutDialog));

        menuBar.add(passiveMenu);
        menuBar.add(activeMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private javax.swing.JMenuItem createMenuItem(String text, Runnable action) {
        javax.swing.JMenuItem item = new javax.swing.JMenuItem(text);
        item.addActionListener(event -> action.run());
        return item;
    }

    // ======================== Passive Component Methods ========================
    private void openAddPassiveComponent() {
        new GUIAddPassiveComponent().setVisible(true);
    }

    private void openSearchPassiveComponent() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente pasivo:", "Buscar Componente Pasivo", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        new GUISearchPassiveComponent(id).setVisible(true);
    }

    private void openListPassiveComponent() {
        new GUIListPassiveComponent().setVisible(true);
    }

    private void calculatePassiveImpedance() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente pasivo:", "Calcular Impedancia", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO: Implementar lógica de cálculo de impedancia
        javax.swing.JOptionPane.showMessageDialog(this, "Impedancia calculada para el ID: " + id, "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void calculatePassivePower() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente pasivo:", "Calcular Potencia", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO: Implementar lógica de cálculo de potencia
        javax.swing.JOptionPane.showMessageDialog(this, "Potencia calculada para el ID: " + id, "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    // ======================== Active Component Methods ========================
    private void openAddActiveComponent() {
        new GUIAddActiveComponent().setVisible(true);
    }

    private void openSearchActiveComponent() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente activo:", "Buscar Componente Activo", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        new GUISearchActiveComponent(id).setVisible(true);
    }

    private void openListActiveComponent() {
        new GUIListActiveComponent().setVisible(true);
    }

    private void calculateActiveImpedance() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente activo:", "Calcular Impedancia", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO: Implementar lógica de cálculo de impedancia
        javax.swing.JOptionPane.showMessageDialog(this, "Impedancia calculada para el ID: " + id, "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void calculateActivePower() {
        String id = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID del componente activo:", "Calcular Potencia", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        if (!isValidId(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO: Implementar lógica de cálculo de potencia
        javax.swing.JOptionPane.showMessageDialog(this, "Potencia calculada para el ID: " + id, "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    // ======================== Utility Methods ========================
    private boolean isValidId(String id) {
        try {
            int numId = Integer.parseInt(id.trim());
            return numId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showAboutDialog() {
        String message = PROJECT_NAME
                + "\nVersion: " + PROJECT_VERSION
                + "\nIntegrantes: " + TEAM_NAMES;
        javax.swing.JOptionPane.showMessageDialog(this, message, "Acerca de...", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUIMain().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
