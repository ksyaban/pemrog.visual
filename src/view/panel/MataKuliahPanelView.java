/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Othak Kosonk
 */
public class MataKuliahPanelView extends javax.swing.JPanel {

    private Connection koneksi = null;
    private String[] header = {"ID MK", "Mata Kuliah", "SKS", "Dosen", "Semester"};
    private DefaultTableModel tableModel;

    /**
     * Creates new form MataKuliahView
     */
    public MataKuliahPanelView() {
        initComponents();
        tableModel = new DefaultTableModel(header, 0);
        tblMataKuliah.setModel(tableModel);

        koneksi = DBConnection.getConnection();
        getData();
    }

    private void getData() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        String tampilQuery = "SELECT * FROM mata_kuliah";
        try {
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(tampilQuery);
            while (resultSet.next()) {
                Object[] data_table = new Object[5];
                data_table[0] = resultSet.getString(1); //kolom id
                data_table[1] = resultSet.getString(2); //kolom nama mk
                data_table[2] = resultSet.getInt(3); //kolom sks
                data_table[3] = resultSet.getString(4); //kolom nama dosen
                data_table[4] = resultSet.getInt(5); //kolom semester
                tableModel.addRow(data_table);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MataKuliahPanelView.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKodeMK = new javax.swing.JTextField();
        txtNamaMK = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSKS = new javax.swing.JTextField();
        txtDosenMK = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMataKuliah = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        cmbSemester = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setForeground(new java.awt.Color(0, 255, 153));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setText("Data Mata Kuliah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode Mata Kuliah :");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mata Kuliah :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Semester :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SKS :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Dosen Pengampu :");

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tblMataKuliah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMataKuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMataKuliahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMataKuliah);

        cmbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpan)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnUbah)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnHapus)
                    .addGap(52, 52, 52))
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCari))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNamaMK, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDosenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSKS, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(47, 47, 47)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHapus, btnSimpan, btnUbah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtDosenMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String idMK = txtKodeMK.getText();
        String namaMK = txtNamaMK.getText();
        int sks = Integer.parseInt(txtSKS.getText());
        String namaDosen = txtDosenMK.getText();
        int semester = Integer.parseInt(cmbSemester.getSelectedItem().toString());

        Statement statement = null;
        try {
            String insertQuery = "INSERT INTO mata_kuliah(id_mata_kuliah, mata_kuliah, sks, dosen_pengampu,semester) "
                    + "VALUES('" + idMK + "','" + namaMK + "','" + sks + "','" + namaDosen + "','" + semester + "')";

            statement = koneksi.createStatement();
            statement.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            Logger.getLogger(MataKuliahPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
        getData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if (tblMataKuliah.getSelectedRow() != -1) {
            JOptionPane.showMessageDialog(this, "pilih data yang ingin diubah");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Yakin ingin mengubah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String idMK = txtKodeMK.getText();
                String namaMK = txtNamaMK.getText();
                int sks = Integer.parseInt(txtSKS.getText());
                String namaDosen = txtDosenMK.getText();
                int semester = Integer.
                        parseInt(cmbSemester.getSelectedItem().
                                toString());

                Statement statement = null;
                try {
                    String updateQuery = "UPDATE mata_kuliah SET mata_kuliah = '" + namaMK + "', "
                            + "sks = '" + sks + "', "
                            + "dosen_pengampu = '" + namaDosen + "', "
                            + "semester = '" + semester + "' "
                            + "WHERE id_mata_kuliah = '" + idMK + "'";

                    statement = koneksi.createStatement();
                    statement.executeUpdate(updateQuery);
                } catch (SQLException ex) {
                    Logger.getLogger(MataKuliahPanelView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            getData();
        }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (tblMataKuliah.getSelectedRow() != -1) {
            JOptionPane.showMessageDialog(this, "pilih data yang ingin dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String idMK = txtKodeMK.getText();

                Statement statement = null;
                try {
                    String deleteQuery = "DELETE FROM mata_kuliah WHERE id_mata_kuliah = '" + idMK + "'";

                    statement = koneksi.createStatement();
                    statement.executeUpdate(deleteQuery);
                } catch (SQLException ex) {
                    Logger.getLogger(MataKuliahPanelView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            getData();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        if (txtKodeMK.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "masukkan kode mata kuliah");
        } else {
            String tampilQuery = "SELECT * FROM mata_kuliah";
            try {
                Statement statement = koneksi.createStatement();
                ResultSet resultSet = statement.executeQuery(tampilQuery);
                if (resultSet.next()) {
                    txtKodeMK.setText(resultSet.getString(1)); //kolom id
                    txtNamaMK.setText(resultSet.getString(2));
                    txtSKS.setText(resultSet.getString(3));
                    txtDosenMK.setText(resultSet.getString(4));
                    cmbSemester.setSelectedItem(resultSet.getString(5));
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataKuliahPanelView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblMataKuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMataKuliahMouseClicked
        // TODO add your handling code here:
        int row = tblMataKuliah.getSelectedRow();
        // header = {"ID MK", "Mata Kuliah", "SKS", "Dosen", "Semester"};
        txtKodeMK.setText(tblMataKuliah.getValueAt(row, 0).toString());
        txtNamaMK.setText(tblMataKuliah.getValueAt(row, 1).toString());
        txtSKS.setText(tblMataKuliah.getValueAt(row, 2).toString());
        txtDosenMK.setText(tblMataKuliah.getValueAt(row, 3).toString());
        cmbSemester.setSelectedItem(tblMataKuliah.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblMataKuliahMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblMataKuliah;
    private javax.swing.JTextField txtDosenMK;
    private javax.swing.JTextField txtKodeMK;
    private javax.swing.JTextField txtNamaMK;
    private javax.swing.JTextField txtSKS;
    // End of variables declaration//GEN-END:variables
}
