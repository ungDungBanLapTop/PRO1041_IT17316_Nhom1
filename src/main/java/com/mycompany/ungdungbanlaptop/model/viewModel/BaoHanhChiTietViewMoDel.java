/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diệm DZ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaoHanhChiTietViewMoDel {
    private String ma;
    private long ngayBatDau;
    private long ngayKetThuc;
    private String trangThai;
    private HoaDonChiTiet hoaDonChiTiet;

}
