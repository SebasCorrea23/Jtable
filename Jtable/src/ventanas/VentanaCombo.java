package ventanas;

import principal.Coordinador;
import vo.TrabajadorVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaCombo extends JFrame {

    private JTextField txtNombre, txtDocumento, txtCargo, txtSueldo;
    private JButton btnGuardar, btnListar, btnEliminar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private Coordinador coordinador;

    public VentanaCombo() {
        setTitle("Registro de Trabajadores");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== PANEL SUPERIOR =====
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del trabajador"));

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panelDatos.add(txtDocumento);

        panelDatos.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        panelDatos.add(txtCargo);

        panelDatos.add(new JLabel("Sueldo:"));
        txtSueldo = new JTextField();
        panelDatos.add(txtSueldo);

        add(panelDatos, BorderLayout.NORTH);

        // ===== PANEL CENTRAL =====
        modelo = new DefaultTableModel(new String[]{"Nombre", "Documento", "Cargo", "Sueldo"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // ===== PANEL INFERIOR =====
        JPanel panelBotones = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnListar = new JButton("Listar");
        btnEliminar = new JButton("Eliminar");

        // Estilo personalizado
        panelBotones.setBackground(new Color(230, 240, 250));
        Font fuenteBoton = new Font("Segoe UI", Font.BOLD, 14);

        JButton[] botones = {btnGuardar, btnListar, btnEliminar};
        Color[] colores = {new Color(51, 102, 153), new Color(51, 102, 153), new Color(153, 0, 0)};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setBackground(colores[i]);
            botones[i].setForeground(Color.WHITE);
            botones[i].setFont(fuenteBoton);
            panelBotones.add(botones[i]);
        }

        add(panelBotones, BorderLayout.SOUTH);

        // ===== LÓGICA =====
        coordinador = new Coordinador();

        btnGuardar.addActionListener(this::guardarTrabajador);
        btnListar.addActionListener(this::listarTrabajadores);
        btnEliminar.addActionListener(this::eliminarTrabajador);
    }

    private void guardarTrabajador(ActionEvent e) {
        try {
            TrabajadorVo t = new TrabajadorVo();
            t.setNombre(txtNombre.getText());
            t.setDocumento(txtDocumento.getText());
            t.setCargo(txtCargo.getText());
            t.setSueldo(Double.parseDouble(txtSueldo.getText()));

            coordinador.registrarTrabajador(t);
            JOptionPane.showMessageDialog(this, "Trabajador registrado correctamente");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sueldo inválido");
        }
    }

    private void listarTrabajadores(ActionEvent e) {
        modelo.setRowCount(0);
        List<TrabajadorVo> lista = coordinador.listarTrabajadores();
        for (TrabajadorVo t : lista) {
            modelo.addRow(new Object[]{t.getNombre(), t.getDocumento(), t.getCargo(), t.getSueldo()});
        }
    }

    private void eliminarTrabajador(ActionEvent e) {
        String documento = JOptionPane.showInputDialog(this, "Ingrese el documento del trabajador a eliminar:");
        if (documento != null && !documento.trim().isEmpty()) {
            coordinador.eliminarTrabajador(documento);
            JOptionPane.showMessageDialog(this, "Trabajador eliminado");
        }
    }
}
