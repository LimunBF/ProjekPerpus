/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package frame;

/**
 *
 * @author Limun
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import database_mahasiswa.DatabaseConnector;
import database_mahasiswa.ReadAnggotaPerpus;
import database_mahasiswa.CreateAnggota;
import java.util.ArrayList;
import java.util.List;

public class DataAnggota extends javax.swing.JFrame {

    /**
     * Creates new form DataBuku
     */
    public DataAnggota() {
        initComponents();
        loadTableData();
    }
    
private void loadTableData() {
    try {
        List<String[]> anggotaList = ReadAnggotaPerpus.readAnggotaPerpus(new Scanner(System.in));

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        for (String[] anggota : anggotaList) {
            // Add the data to the table model
            model.addRow(anggota);
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogCreateAGt = new javax.swing.JDialog();
        LabelNama = new javax.swing.JLabel();
        LabelNIM = new javax.swing.JLabel();
        LabelProdi = new javax.swing.JLabel();
        LabelFakultas = new javax.swing.JLabel();
        LabelDataAnggota = new javax.swing.JLabel();
        InputNama = new javax.swing.JTextField();
        InputNIM = new javax.swing.JTextField();
        InputFakultas = new javax.swing.JTextField();
        InputProdi = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        Create = new javax.swing.JButton();
        Change = new javax.swing.JButton();
        Delette = new javax.swing.JButton();
        Gosearchbtton = new javax.swing.JToggleButton();
        SearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        LabelNama.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        LabelNama.setText("Nama");

        LabelNIM.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        LabelNIM.setText("NIM");

        LabelProdi.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        LabelProdi.setText("Prodi");

        LabelFakultas.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        LabelFakultas.setText("Fakultas");

        LabelDataAnggota.setFont(new java.awt.Font("GeoSlab703 Md BT", 0, 18)); // NOI18N
        LabelDataAnggota.setText("Data Anggota Baru");

        InputNama.setText("  ");
        InputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNamaActionPerformed(evt);
            }
        });

        InputNIM.setText("  ");
        InputNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNIMActionPerformed(evt);
            }
        });

        InputFakultas.setText("  ");
        InputFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFakultasActionPerformed(evt);
            }
        });

        InputProdi.setText("  ");
        InputProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputProdiActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Imprint MT Shadow", 1, 15)); // NOI18N
        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DialogCreateAGtLayout = new javax.swing.GroupLayout(DialogCreateAGt.getContentPane());
        DialogCreateAGt.getContentPane().setLayout(DialogCreateAGtLayout);
        DialogCreateAGtLayout.setHorizontalGroup(
            DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogCreateAGtLayout.createSequentialGroup()
                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogCreateAGtLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFakultas)
                            .addGroup(DialogCreateAGtLayout.createSequentialGroup()
                                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelProdi)
                                    .addComponent(LabelNama))
                                .addGap(65, 65, 65)
                                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDataAnggota)
                                    .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InputNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InputFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InputProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(LabelNIM)))
                    .addGroup(DialogCreateAGtLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(SaveButton)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        DialogCreateAGtLayout.setVerticalGroup(
            DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogCreateAGtLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LabelDataAnggota)
                .addGap(30, 30, 30)
                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNIM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelProdi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DialogCreateAGtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFakultas))
                .addGap(36, 36, 36)
                .addComponent(SaveButton)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        Create.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Change.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        Change.setText("Change");

        Delette.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        Delette.setText("Delete");
        Delette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletteActionPerformed(evt);
            }
        });

        Gosearchbtton.setFont(new java.awt.Font("Bebas Neue", 0, 14)); // NOI18N
        Gosearchbtton.setText("GO");
        Gosearchbtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GosearchbttonActionPerformed(evt);
            }
        });

        SearchField.setText("Search");
        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "NIM", "Prodi", "Fakultas", "Status Pinjam", "Judul Buku", "Tanggal Pinjam", "Tanggal Kembali", "Sisa Waktu"
            }
        ));
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Bebas Neue", 0, 13)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Gosearchbtton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delette, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 1105, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delette, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gosearchbtton)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        // TODO add your handling code here:
        DialogCreateAGt.setSize(550, 300);
        DialogCreateAGt.setVisible(true);
    }//GEN-LAST:event_CreateActionPerformed

    private void DeletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeletteActionPerformed

    private void GosearchbttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GosearchbttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GosearchbttonActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu menuFrame = new Menu();
        menuFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void InputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNamaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_InputNamaActionPerformed

    private void InputNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNIMActionPerformed

    private void InputFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputFakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputFakultasActionPerformed

    private void InputProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputProdiActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        String nama = InputNama.getText();
        String nim = InputFakultas.getText();
        String fakultas = InputFakultas.getText();
        String prodi = InputProdi.getText();
        
        CreateAnggota.createDataAnggota(nama, nim, fakultas, prodi);
    }//GEN-LAST:event_SaveButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new DataAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change;
    private javax.swing.JButton Create;
    private javax.swing.JButton Delette;
    private javax.swing.JDialog DialogCreateAGt;
    private javax.swing.JToggleButton Gosearchbtton;
    private javax.swing.JTextField InputFakultas;
    private javax.swing.JTextField InputNIM;
    private javax.swing.JTextField InputNama;
    private javax.swing.JTextField InputProdi;
    private javax.swing.JLabel LabelDataAnggota;
    private javax.swing.JLabel LabelFakultas;
    private javax.swing.JLabel LabelNIM;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelProdi;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
