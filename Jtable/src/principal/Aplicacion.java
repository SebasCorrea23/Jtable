package principal;

import ventanas.VentanaCombo;

public class Aplicacion {
    public static void main(String[] args) {
        // Inicia la ventana principal
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaCombo ventana = new VentanaCombo();
            ventana.setVisible(true);
        });
    }
}

