package analizador_lexico;

import componentes.FileChooserFrame;
import componentes.LectorArchivos;
import componentes.TextLineNumber;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import modelos_tablas.ModeloAnalizadorLexico;
import modelos_tablas.ModeloResultadoAnalizado;

public class AnalizadorLexicoUI extends javax.swing.JFrame {

    public AnalizadorLexicoUI() {
        initComponents();
        clearCampos();

        TextLineNumber tln = new TextLineNumber(txtEditorCodigo);
        scrollEditorCodigo.setRowHeaderView(tln);
    }

    private void clearCampos() {
        txtEditorCodigo.setText("");
        tableAnalizadorLexico.setModel(new ModeloAnalizadorLexico());
        tableResultadoAnalizado.setModel(new ModeloResultadoAnalizado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditorCodigo = new javax.swing.JPanel();
        scrollEditorCodigo = new javax.swing.JScrollPane();
        txtEditorCodigo = new javax.swing.JTextPane();
        lblTitulo = new javax.swing.JLabel();
        btnGuardarArchivo = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JLabel();
        scrollResultadoAnalizador = new javax.swing.JScrollPane();
        tableResultadoAnalizado = new javax.swing.JTable();
        btnClear = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JLabel();
        pnlAnalizadorLexico = new javax.swing.JPanel();
        scrollAnalizadorLexico = new javax.swing.JScrollPane();
        tableAnalizadorLexico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 635));
        setMinimumSize(new java.awt.Dimension(1200, 635));
        setPreferredSize(new java.awt.Dimension(1200, 635));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 635));
        getContentPane().setLayout(null);

        pnlEditorCodigo.setBackground(new java.awt.Color(255, 255, 255));

        txtEditorCodigo.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txtEditorCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEditorCodigoKeyPressed(evt);
            }
        });
        scrollEditorCodigo.setViewportView(txtEditorCodigo);

        lblTitulo.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Analizador Léxico");

        btnGuardarArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/saveFile.png"))); // NOI18N
        btnGuardarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarArchivoMousePressed(evt);
            }
        });

        btnAbrirArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAbrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/openFile.png"))); // NOI18N
        btnAbrirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAbrirArchivoMousePressed(evt);
            }
        });

        tableResultadoAnalizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableResultadoAnalizado.setRowHeight(21);
        scrollResultadoAnalizador.setViewportView(tableResultadoAnalizado);

        btnClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clear.png"))); // NOI18N
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClearMousePressed(evt);
            }
        });

        btnAnalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAnalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/analizar.png"))); // NOI18N
        btnAnalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnalizarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditorCodigoLayout = new javax.swing.GroupLayout(pnlEditorCodigo);
        pnlEditorCodigo.setLayout(pnlEditorCodigoLayout);
        pnlEditorCodigoLayout.setHorizontalGroup(
            pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEditorCodigoLayout.createSequentialGroup()
                        .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollEditorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollResultadoAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlEditorCodigoLayout.setVerticalGroup(
            pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizar)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollEditorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollResultadoAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        getContentPane().add(pnlEditorCodigo);
        pnlEditorCodigo.setBounds(0, 0, 900, 640);

        pnlAnalizadorLexico.setMaximumSize(new java.awt.Dimension(300, 635));
        pnlAnalizadorLexico.setMinimumSize(new java.awt.Dimension(300, 635));
        pnlAnalizadorLexico.setPreferredSize(new java.awt.Dimension(300, 635));

        tableAnalizadorLexico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableAnalizadorLexico.setRowHeight(22);
        scrollAnalizadorLexico.setViewportView(tableAnalizadorLexico);

        javax.swing.GroupLayout pnlAnalizadorLexicoLayout = new javax.swing.GroupLayout(pnlAnalizadorLexico);
        pnlAnalizadorLexico.setLayout(pnlAnalizadorLexicoLayout);
        pnlAnalizadorLexicoLayout.setHorizontalGroup(
            pnlAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnalizadorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAnalizadorLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlAnalizadorLexicoLayout.setVerticalGroup(
            pnlAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnalizadorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAnalizadorLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAnalizadorLexico);
        pnlAnalizadorLexico.setBounds(900, 0, 300, 635);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEditorCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();

            int cursorPosicion = txtEditorCodigo.getCaretPosition();
            Document doc = txtEditorCodigo.getDocument();

            try {
                if (evt.isShiftDown()) {
                    String text = doc.getText(cursorPosicion - 4, 4);
                    if (text.equals("    ")) {
                        doc.remove(cursorPosicion - 4, 4);
                        txtEditorCodigo.setCaretPosition(cursorPosicion - 4);
                    }
                } else {
                    doc.insertString(cursorPosicion, "    ", null);
                    txtEditorCodigo.setCaretPosition(cursorPosicion + 4);
                }
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_TAB && evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            evt.consume();
            System.out.println("dadasd");
            int cursorPosicion = txtEditorCodigo.getCaretPosition();
            Document doc = txtEditorCodigo.getDocument();

            try {
                doc.remove(cursorPosicion, 4);
                txtEditorCodigo.setCaretPosition(cursorPosicion - 4);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtEditorCodigoKeyPressed

    private void btnAbrirArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirArchivoMousePressed
        // Crear un hilo secundario para esperar la seleccion del archivo
        Thread hiloFileChooser = new Thread(() -> {
            String archivoPath = new FileChooserFrame().abrirArchivo();
            if (archivoPath != null) {
                try {
                    System.out.println("Archivo seleccionado: " + archivoPath);
                    txtEditorCodigo.setText(LectorArchivos.leerArchivo(archivoPath));
                } catch (IOException ex) {
                    Logger.getLogger(AnalizadorLexicoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        hiloFileChooser.start();


    }//GEN-LAST:event_btnAbrirArchivoMousePressed

    private void btnGuardarArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarArchivoMousePressed
        // Crear un hilo secundario para esperar la seleccion del archivo
        Thread hiloFileChooser = new Thread(() -> {
            String archivoPath = new FileChooserFrame().seleccionarRuta();
            if (archivoPath != null) {
                System.out.println("Ruta seleccionada: " + archivoPath);
            }
        });
        hiloFileChooser.start();
    }//GEN-LAST:event_btnGuardarArchivoMousePressed

    private void btnAnalizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalizarMousePressed
        JOptionPane.showMessageDialog(null, "* evento para iniciar el analisis del archivo *");
    }//GEN-LAST:event_btnAnalizarMousePressed

    private void btnClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMousePressed
        JOptionPane.showMessageDialog(null, "* evento para vaciar los componentes *");

        clearCampos();
    }//GEN-LAST:event_btnClearMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAbrirArchivo;
    private javax.swing.JLabel btnAnalizar;
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnGuardarArchivo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAnalizadorLexico;
    private javax.swing.JPanel pnlEditorCodigo;
    private javax.swing.JScrollPane scrollAnalizadorLexico;
    private javax.swing.JScrollPane scrollEditorCodigo;
    private javax.swing.JScrollPane scrollResultadoAnalizador;
    private javax.swing.JTable tableAnalizadorLexico;
    private javax.swing.JTable tableResultadoAnalizado;
    private javax.swing.JTextPane txtEditorCodigo;
    // End of variables declaration//GEN-END:variables
}
