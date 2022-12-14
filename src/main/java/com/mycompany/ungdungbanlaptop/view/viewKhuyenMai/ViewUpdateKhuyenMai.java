/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewKhuyenMai;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiKhuyenMai;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import com.mycompany.ungdungbanlaptop.service.impl.KhuyenMaiServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.io.File;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author thang
 */
public class ViewUpdateKhuyenMai extends javax.swing.JFrame {

    private KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
    private KhuyenMai khuyenMai;
    
    public ViewUpdateKhuyenMai(KhuyenMai khuyenMai) {
        initComponents();
        this.setIconImage(new ImageIcon(new File("").getAbsolutePath() + "//src//main//resources//img//icon.jpg").getImage());
        this.khuyenMai = khuyenMai;
        jLabel4.setText("thời gian");
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        txtNgayBatDau.setVisible(true);
        txtNgayKetThuc.setVisible(true);
        jLabel5.setVisible(false);
        txtSoLuong.setVisible(false);
        jLabel14.setVisible(false);
        jRadioButton1.setVisible(false);
        loadData();
    }

    private void loadData(){

        txtMa.setText(khuyenMai.getMa());
        txtTen.setText(khuyenMai.getTen());
        txtSoLuong.setText(String.valueOf(khuyenMai.getSoLuong()));
        txtMoTa.setText(khuyenMai.getMoTa());
        cboLoai.setSelectedIndex(khuyenMai.getLoaiKhuyenMai() == EnumLoaiKhuyenMai.PHAN_TRAM ? 0 :1);
        txtDieuKien.setText(String.valueOf(khuyenMai.getDieuKienGiamGia()));
        txtGiamGia.setText(String.valueOf(khuyenMai.getGiaTienGiam()));
        cboHinhThuc1.setSelectedIndex(khuyenMai.isHinhThuc() ? 0 :1);
        jRadioButton1.setSelected(khuyenMai.getTrangThai() == 0 ? true : false);
    }
    
    private EnumLoaiKhuyenMai getHinhThuc() {
        int hinhThuc = cboLoai.getSelectedIndex();
        switch (hinhThuc) {
            case 0:
                return EnumLoaiKhuyenMai.PHAN_TRAM;
            case 1:
                return EnumLoaiKhuyenMai.TIEN_MAT;
            default:
                throw new AssertionError();
        }
    }

    private KhuyenMai KhuyenMaiRequest() {

        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMa(txtMa.getText().trim());
        khuyenMai.setTen(txtTen.getText().trim());
        khuyenMai.setMoTa(txtMoTa.getText());
        khuyenMai.setHinhThuc(cboHinhThuc1.getSelectedIndex() == 0 ? true : false);
        khuyenMai.setDieuKienGiamGia( new BigDecimal(txtDieuKien.getText()));
        khuyenMai.setLoaiKhuyenMai(getHinhThuc());
        if (getHinhThuc() == EnumLoaiKhuyenMai.TIEN_MAT) {
            khuyenMai.setGiaTienGiam(new BigDecimal(txtGiamGia.getText()));
        } else {
            khuyenMai.setPhanTram(Integer.parseInt(txtGiamGia.getText()));
        }
        if (cboHinhThuc1.getSelectedIndex() == 0) {
            String ngaybatdau = new ConverDate().convertDateToString(txtNgayBatDau.getDate(), "dd/MM/yyyy");
            String ngayKetThuc = new ConverDate().convertDateToString(txtNgayKetThuc.getDate(), "dd/MM/yyyy");
            khuyenMai.setNgayBatDau(new ConverDate().dateToLong(ngaybatdau, "dd/MM/yyyy"));
            khuyenMai.setNgayKetThuc(new ConverDate().dateToLong(ngayKetThuc, "dd/MM/yyyy"));
        } else {
            khuyenMai.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            khuyenMai.setTrangThai(jRadioButton1.isSelected() ? 0 : 1);
        }

        return khuyenMai;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboLoai = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();
        errorMa = new javax.swing.JLabel();
        errorTen = new javax.swing.JLabel();
        errorSoLuong = new javax.swing.JLabel();
        erroGiamGia = new javax.swing.JLabel();
        errorDieuKien = new javax.swing.JLabel();
        errorNgaybatDau = new javax.swing.JLabel();
        errorNgayKetThuc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboHinhThuc1 = new javax.swing.JComboBox<>();
        txtGiamGia = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã ");

        txtMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaMouseClicked(evt);
            }
        });

        txtNgayBatDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayBatDauMouseClicked(evt);
            }
        });

        jLabel2.setText("Ngày bắt đầu");

        jLabel3.setText("Ngày kết thúc");

        txtNgayKetThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayKetThucMouseClicked(evt);
            }
        });

        txtSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoLuongMouseClicked(evt);
            }
        });

        jLabel5.setText("Số lượng");

        jLabel6.setText("Voucher giảm");

        jLabel8.setText("Tên: ");

        txtTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenMouseClicked(evt);
            }
        });

        jLabel9.setText("Thông tin:");

        jLabel10.setText("Mô Tả:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel11.setText("Hình Thức:");

        jLabel12.setText("Loại:");

        cboLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo phần trăm", "Theo mức tiền" }));

        jLabel4.setText("Thời gian:");

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Điều kiện: ");

        txtDieuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDieuKienMouseClicked(evt);
            }
        });

        errorMa.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorMa.setForeground(new java.awt.Color(255, 51, 51));

        errorTen.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorTen.setForeground(new java.awt.Color(255, 51, 51));

        errorSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorSoLuong.setForeground(new java.awt.Color(255, 51, 51));

        erroGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        erroGiamGia.setForeground(new java.awt.Color(255, 51, 51));

        errorDieuKien.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorDieuKien.setForeground(new java.awt.Color(255, 51, 51));

        errorNgaybatDau.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorNgaybatDau.setForeground(new java.awt.Color(255, 51, 51));

        errorNgayKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorNgayKetThuc.setForeground(new java.awt.Color(255, 51, 51));

        jLabel13.setText("Hình Thức:");

        cboHinhThuc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời gian", "Số Lượng" }));
        cboHinhThuc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboHinhThuc1MouseClicked(evt);
            }
        });
        cboHinhThuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThuc1ActionPerformed(evt);
            }
        });

        txtGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGiamGiaMouseClicked(evt);
            }
        });

        jRadioButton1.setText("OFF");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Trạng thái:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDieuKien))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(errorDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(erroGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiamGia))))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 90, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(errorSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(errorNgaybatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                            .addComponent(errorNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave)
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(errorMa, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorTen, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(erroGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorNgaybatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jRadioButton1)))
                .addGap(5, 5, 5)
                .addComponent(errorSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (check()) {
            KhuyenMai khuyenMai = KhuyenMaiRequest();
            khuyenMai.setIdKhuyenMai(this.khuyenMai.getIdKhuyenMai());
            khuyenMaiService.update(khuyenMai);
            JOptionPane.showMessageDialog(this, "sửa thành công");
            this.dispose();
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaMouseClicked
        errorMa.setText("");
    }//GEN-LAST:event_txtMaMouseClicked

    private void txtTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenMouseClicked
        errorTen.setText("");
    }//GEN-LAST:event_txtTenMouseClicked

    private void txtSoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoLuongMouseClicked
        errorSoLuong.setText("");
    }//GEN-LAST:event_txtSoLuongMouseClicked

    private void txtDieuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDieuKienMouseClicked
        errorDieuKien.setText("");
    }//GEN-LAST:event_txtDieuKienMouseClicked

    private void txtNgayBatDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayBatDauMouseClicked
        errorNgaybatDau.setText("");
    }//GEN-LAST:event_txtNgayBatDauMouseClicked

    private void txtNgayKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayKetThucMouseClicked
        errorNgayKetThuc.setText("");
    }//GEN-LAST:event_txtNgayKetThucMouseClicked

    private void txtGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiamGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaMouseClicked

    private void cboHinhThuc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboHinhThuc1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThuc1MouseClicked

    private void cboHinhThuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc1ActionPerformed
        if (cboHinhThuc1.getSelectedIndex() == 0) {
            jLabel4.setText("thời gian");
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            txtNgayBatDau.setVisible(true);
            txtNgayKetThuc.setVisible(true);
            jLabel5.setVisible(false);
            txtSoLuong.setVisible(false);
            jLabel14.setVisible(false);
            jRadioButton1.setVisible(false);
            errorSoLuong.setText("");

        } else {
            jLabel4.setText("số lượng");
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            txtNgayBatDau.setVisible(false);
            txtNgayKetThuc.setVisible(false);
            jLabel5.setVisible(true);
            txtSoLuong.setVisible(true);
            jLabel14.setVisible(true);
            jRadioButton1.setVisible(true);
            errorNgaybatDau.setText("");
            errorNgayKetThuc.setText("");
        }
    }//GEN-LAST:event_cboHinhThuc1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            jRadioButton1.setText("ON");
        } else {
            jRadioButton1.setText("OFF");
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private boolean check() {
        int check = 0;

        if (txtMa.getText().isEmpty()) {
            errorMa.setText("Vui lòng nhập mã");
            check++;
        }
        if (txtTen.getText().isEmpty()) {
            errorTen.setText("Vui lòng nhập tên");
            check++;
        }

        if (txtDieuKien.getText().isEmpty()) {
            errorDieuKien.setText("vui lòng nhập điều kiện");
            check++;
        } else if (!checkDouble(txtDieuKien)) {
            errorDieuKien.setText("vui lòng nhập số");
            check++;
        } else if (Double.parseDouble(txtDieuKien.getText()) < 0) {
            errorDieuKien.setText("vui lòng nhập số > 0");
            check++;
        }

        int hinhThuc = cboLoai.getSelectedIndex();
        if (hinhThuc == 1) {
            if (txtGiamGia.getText().isEmpty()) {
                erroGiamGia.setText("vui lòng nhập số tiền");
                check++;
            } else if (!checkDouble(txtGiamGia)) {
                erroGiamGia.setText("vui lòng nhập số");
                check++;
            } else if (Double.parseDouble(txtGiamGia.getText()) < 0) {
                erroGiamGia.setText("vui lòng nhập số > 0");
                check++;
            }
        } else {
            if (txtGiamGia.getText().isEmpty()) {
                erroGiamGia.setText("vui lòng nhập số % ");
                check++;
            } else if (!checkNumber(txtGiamGia)) {
                erroGiamGia.setText("vui lòng nhập số ");
                check++;
            } else if (Integer.parseInt(txtGiamGia.getText()) < 0 || Integer.parseInt(txtGiamGia.getText()) > 100) {

                erroGiamGia.setText("vui lòng nhập số > 0 và < 100 ");
                check++;
            }
        }

        if (cboHinhThuc1.getSelectedIndex() == 0) {
            if (!txtNgayBatDau.isEnabled()) {
                errorNgaybatDau.setText("vui long nhập ngày bắt đầu");
                check++;
            } else if (txtNgayBatDau.getDate() == null) {
                errorNgaybatDau.setText("vui long nhập ngày bắt đầu");
                check++;
            }

            if (!txtNgayKetThuc.isEnabled()) {
                errorNgayKetThuc.setText("vui lòng nhập ngày kết thúc");
                check++;
            } else if (txtNgayKetThuc.getDate() == null) {
                errorNgayKetThuc.setText("vui long nhập ngày bắt đầu");
                check++;
            } else {
                String ngaybatdau = new ConverDate().convertDateToString(txtNgayBatDau.getDate(), "dd/MM/yyyy");
                String ngayKetThuc = new ConverDate().convertDateToString(txtNgayKetThuc.getDate(), "dd/MM/yyyy");
                long converNgayBatDau = new ConverDate().dateToLong(ngaybatdau, "dd/MM/yyyy");
                long converNgayKetThuc = new ConverDate().dateToLong(ngayKetThuc, "dd/MM/yyyy");
                if (converNgayKetThuc < converNgayBatDau) {
                    errorNgayKetThuc.setText("ngày kết thúc phải lớn hơn ngày bắt đầu");
                    check++;
                }
            }
        } else {
            if (txtSoLuong.getText().isEmpty()) {
                errorSoLuong.setText("vui lòng nhập số lượng");
                check++;
            } else if (!checkNumber(txtSoLuong)) {
                errorSoLuong.setText("vui lòng nhập số ");
                check++;
            } else if (Integer.parseInt(txtSoLuong.getText()) <= 0) {
                errorSoLuong.setText("vui lòng nhập số > 0 ");
                check++;
            }
        }

        if (check != 0) {
            return false;
        }
        return true;
    }

    private boolean checkNumber(JTextField number) {
        try {
            int soLuong = Integer.parseInt(number.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkDouble(JTextField number) {
        try {
            double soLuong = Double.parseDouble(number.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look ancboLoaiing code (optional) ">
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
            java.util.logging.Logger.getLogger(ViewUpdateKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewUpdateKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboHinhThuc1;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JLabel erroGiamGia;
    private javax.swing.JLabel errorDieuKien;
    private javax.swing.JLabel errorMa;
    private javax.swing.JLabel errorNgayKetThuc;
    private javax.swing.JLabel errorNgaybatDau;
    private javax.swing.JLabel errorSoLuong;
    private javax.swing.JLabel errorTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
