/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.iteksolutions;

import javax.swing.text.DefaultCaret;
import java.io.*;

/**
 *
 * @author dennis
 */
public class PrinterOutputImpl extends javax.swing.JPanel implements IPrinterOutput {

    /**
     * Creates new form PrinterPanel
     */
    public PrinterOutputImpl() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) txtDisplay.getCaret();
        caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbFile = new javax.swing.JTextField();
        chkFilterLF = new javax.swing.JCheckBox();
        chkPaperOut = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();

        jLabel1.setText("File");
        jLabel1.setName("lblFile"); // NOI18N

        tbFile.setName("tbFile"); // NOI18N

        chkFilterLF.setText("Filter LF");
        chkFilterLF.setName("chkFilterLF"); // NOI18N

        chkPaperOut.setText("Paper Out");
        chkPaperOut.setName("tbPaperOut"); // NOI18N

        btnClear.setText("Clear");
        btnClear.setName("btnClear"); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbFile))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkFilterLF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPaperOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkFilterLF)
                    .addComponent(chkPaperOut)
                    .addComponent(btnClear))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtDisplay.setEditable(false);
        txtDisplay.setColumns(20);
        txtDisplay.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtDisplay.setLineWrap(true);
        txtDisplay.setRows(5);
        txtDisplay.setName("txtDisplay"); // NOI18N
        jScrollPane1.setViewportView(txtDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtDisplay.setText("");
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JCheckBox chkFilterLF;
    private javax.swing.JCheckBox chkPaperOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tbFile;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables

    private boolean ignoreNextLF = false;

    @Override
    public void setText(String text) {
        if (text != null && !text.isEmpty()) {
            if (chkFilterLF.isSelected()) {
                if (text.equals("\n") && ignoreNextLF) {
                    return;
                }
                ignoreNextLF = false;
                if (text.equals("\n")) {
                    ignoreNextLF = true;
                }
            }
            txtDisplay.append(text);
            writeToFile(text);
//            System.out.println("PrinterForm received: " + text);
        }
    }

    private void writeToFile(String text) {
        Helper.writeToFile(tbFile.getText(), text);
    }
}
