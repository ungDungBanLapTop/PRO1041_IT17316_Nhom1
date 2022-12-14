/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.service.ManHinhService;
import com.mycompany.ungdungbanlaptop.service.impl.ManHinhServiceImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diệm DZ
 */
public class AdQuanLiManHinh extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private ManHinhService manHinhService = new ManHinhServiceImpl();
    private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm3 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm4 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm5 = new DefaultComboBoxModel();
    private List<ManHinh> list = manHinhService.getAll();

    /**
     * Creates new form AdQuanLiManHinh
     */
    public AdQuanLiManHinh() {
        initComponents();
        jTableManHinh.setModel(dtm);
        String[] a = {"Mã Màn Hình", "Độ phân giải", "Kích thước", "Tần số", "Loại cảm ứng", "Công nghệ"};
        dtm.setColumnIdentifiers(a);
        showData(manHinhService.getAll());

        
        cbbDoPhanGiai.setModel(dcm1);
        for (ManHinh x : list) {
            dcm1.addElement(x.getDoPhanGiaMan());
        }
        cbbKichThuoc.setModel(dcm2);
        for (ManHinh x : list) {
            dcm2.addElement(x.getKichThuoc());
        }
        cbbTanSo.setModel(dcm3);
        for (ManHinh x : list) {
            dcm3.addElement(x.getTanSo());
        }
       
        cbbLoaiCamUng.setModel(dcm4);
        for (ManHinh x : list) {
            dcm4.addElement(x.getLoaiCamUng());
        }
         cbbCongNghe.setModel(dcm5);
        for (ManHinh x : list) {
            dcm5.addElement(x.getCongNgheMH());
        }
    }

    private void showData(List<ManHinh> list) {
        dtm.setRowCount(0);
        for (ManHinh x : list) {
            dtm.addRow(new Object[]{x.getMa(), x.getDoPhanGiaMan(), x.getKichThuoc(), x.getTanSo(), x.getLoaiCamUng(), x.getCongNgheMH()});
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaManHinh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableManHinh = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        errorMa = new javax.swing.JLabel();
        errorTen = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        cbbDoPhanGiai = new javax.swing.JComboBox<>();
        cbbKichThuoc = new javax.swing.JComboBox<>();
        cbbTanSo = new javax.swing.JComboBox<>();
        cbbLoaiCamUng = new javax.swing.JComboBox<>();
        cbbCongNghe = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(996, 683));

        jLabel1.setText("Mã màn hình:");

        jLabel2.setText("Độ phân giải:");

        txtMaManHinh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaManHinh.setText("Mã tự tạo");
        txtMaManHinh.setEnabled(false);

        jTableManHinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableManHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManHinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableManHinh);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        errorMa.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorMa.setForeground(new java.awt.Color(255, 51, 51));

        errorTen.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorTen.setForeground(new java.awt.Color(255, 51, 51));

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 3)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Kích thước:");

        jLabel4.setText("Tần số:");

        jLabel5.setText("Loại cảm ứng:");

        jLabel6.setText("Công nghệ:");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        cbbDoPhanGiai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbTanSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbLoaiCamUng.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbCongNghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtId))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(errorMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(errorTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbDoPhanGiai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98)
                                        .addComponent(btnThem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbTanSo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLamMoi)
                                        .addGap(33, 33, 33))
                                    .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoaiCamUng, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCongNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorMa)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(cbbDoPhanGiai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorTen)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnLamMoi)
                    .addComponent(cbbTanSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbLoaiCamUng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbCongNghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableManHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManHinhMouseClicked
        int index = jTableManHinh.getSelectedRow();
        ManHinh mh = manHinhService.getAll().get(index);
        txtMaManHinh.setText(mh.getMa());
        cbbCongNghe.setSelectedItem(mh.getCongNgheMH());
        cbbDoPhanGiai.setSelectedItem(mh.getDoPhanGiaMan());
        cbbKichThuoc.setSelectedItem(mh.getKichThuoc());
        cbbLoaiCamUng.setSelectedItem(mh.getLoaiCamUng());
        cbbTanSo.setSelectedItem(mh.getTanSo());
    }//GEN-LAST:event_jTableManHinhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ManHinh mh = new ManHinh();
        mh.setMa(new TaoChuoiNgauNhien().getMaManHinh("MH", 3));
        mh.setCongNgheMH(cbbCongNghe.getSelectedItem().toString());
        mh.setDoPhanGiaMan(cbbDoPhanGiai.getSelectedItem().toString());
        mh.setKichThuoc(cbbKichThuoc.getSelectedItem().toString());
        mh.setLoaiCamUng(cbbLoaiCamUng.getSelectedItem().toString());
        mh.setTanSo(cbbTanSo.getSelectedItem().toString());
        ViewSanPham.addManHinh(mh);
        JOptionPane.showMessageDialog(this, manHinhService.add(mh));
        showData(manHinhService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        ManHinh mh = new ManHinh();
        mh.setMa(txtMaManHinh.getText());
        mh.setCongNgheMH(cbbCongNghe.getSelectedItem().toString());
        mh.setDoPhanGiaMan(cbbDoPhanGiai.getSelectedItem().toString());
        mh.setKichThuoc(cbbKichThuoc.getSelectedItem().toString());
        mh.setLoaiCamUng(cbbLoaiCamUng.getSelectedItem().toString());
        mh.setTanSo(cbbTanSo.getSelectedItem().toString());

        int row = jTableManHinh.getSelectedRow();
        mh.setIdManHinh(manHinhService.getOne(jTableManHinh.getValueAt(row, 0).toString()).getIdManHinh());
        JOptionPane.showMessageDialog(this, manHinhService.update(mh));
        ViewSanPham.editManHinh(row, mh);
        showData(manHinhService.getAll());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMaManHinh.setText("");
        cbbCongNghe.setSelectedIndex(0);
        cbbDoPhanGiai.setSelectedIndex(0);
        cbbKichThuoc.setSelectedIndex(0);
        cbbLoaiCamUng.setSelectedIndex(0);
        cbbTanSo.setSelectedIndex(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbCongNghe;
    private javax.swing.JComboBox<String> cbbDoPhanGiai;
    private javax.swing.JComboBox<String> cbbKichThuoc;
    private javax.swing.JComboBox<String> cbbLoaiCamUng;
    private javax.swing.JComboBox<String> cbbTanSo;
    private javax.swing.JLabel errorMa;
    private javax.swing.JLabel errorTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableManHinh;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtMaManHinh;
    // End of variables declaration//GEN-END:variables
}
