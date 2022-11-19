/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiViewModel;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author HuynhPhung
 */
public interface KhuyenMaiService {

    List<KhuyenMai> getALl();

    String add(KhuyenMai km);

    List<KhuyenMai> search(List<KhuyenMai> list, String km);

    List<KhuyenMai> searchNgayBd(List<KhuyenMai> list, String km);

    List<KhuyenMai> searchNgayKt(List<KhuyenMai> list, String km);

    String update(KhuyenMai ma);

    KhuyenMai getOne(String ma);

}