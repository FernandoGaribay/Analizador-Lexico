package analizador_lexico;

import componentes.FileChooserFrame;
import componentes.TextLineNumber;
import java.awt.event.KeyEvent;

public class AnalizadorLexicoUI extends javax.swing.JFrame {

    public AnalizadorLexicoUI() {
        initComponents();

        TextLineNumber tln = new TextLineNumber(txtEditorCodigo);
        scrollEditorCodigo.setRowHeaderView(tln);
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
        tableResultadoAnalizador = new javax.swing.JTable();
        btnClear = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JLabel();
        pnlAnalizadorLexico = new javax.swing.JPanel();
        scrollAnalizadorLexico = new javax.swing.JScrollPane();
        tableAnalizadorLexico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        pnlEditorCodigo.setBackground(new java.awt.Color(255, 255, 255));

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

        tableResultadoAnalizador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "LINEA", "SINTAXIS", "DETALLE"
            }
        ));
        scrollResultadoAnalizador.setViewportView(tableResultadoAnalizador);

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
                .addGap(16, 16, 16)
                .addGroup(pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorCodigoLayout.createSequentialGroup()
                        .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollEditorCodigo)
                        .addComponent(scrollResultadoAnalizador, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
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
                .addGap(18, 18, 18)
                .addComponent(scrollResultadoAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );

        getContentPane().add(pnlEditorCodigo);
        pnlEditorCodigo.setBounds(0, 0, 900, 600);

        tableAnalizadorLexico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LEXEMA", "TOKEN", "LINEA", "PALABRA"
            }
        ));
        scrollAnalizadorLexico.setViewportView(tableAnalizadorLexico);

        javax.swing.GroupLayout pnlAnalizadorLexicoLayout = new javax.swing.GroupLayout(pnlAnalizadorLexico);
        pnlAnalizadorLexico.setLayout(pnlAnalizadorLexicoLayout);
        pnlAnalizadorLexicoLayout.setHorizontalGroup(
            pnlAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnalizadorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAnalizadorLexico, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAnalizadorLexicoLayout.setVerticalGroup(
            pnlAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnalizadorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAnalizadorLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAnalizadorLexico);
        pnlAnalizadorLexico.setBounds(900, 0, 300, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEditorCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();

            int cursorPosicion = txtEditorCodigo.getCaretPosition();
            String textoCursorPosicion = txtEditorCodigo.getText();

            String newTextoCursorPosicion = textoCursorPosicion.substring(0, cursorPosicion) + "     " + textoCursorPosicion.substring(cursorPosicion);

            txtEditorCodigo.setText(newTextoCursorPosicion);
            txtEditorCodigo.setCaretPosition(cursorPosicion + 5);
        }
    }//GEN-LAST:event_txtEditorCodigoKeyPressed

    private void btnAbrirArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirArchivoMousePressed
        // Crear un hilo secundario para esperar la seleccion del archivo
        Thread hiloFileChooser = new Thread(() -> {
            String archivoPath = new FileChooserFrame().showFileChooserFrame();
            if (archivoPath != null) {
                System.out.println("Archivo seleccionado: " + archivoPath);
            } 
        });
        hiloFileChooser.start();
    }//GEN-LAST:event_btnAbrirArchivoMousePressed

    private void btnGuardarArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarArchivoMousePressed

    }//GEN-LAST:event_btnGuardarArchivoMousePressed

    private void btnAnalizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalizarMousePressed

    }//GEN-LAST:event_btnAnalizarMousePressed

    private void btnClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMousePressed

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
    private javax.swing.JTable tableResultadoAnalizador;
    private javax.swing.JTextPane txtEditorCodigo;
    // End of variables declaration//GEN-END:variables
}
