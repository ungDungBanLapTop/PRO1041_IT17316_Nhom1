/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.resquest.ChiTietSanPhamImportResquest;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface SanPhamRepository {

    List<SanPham> getAll();

    List<SanPham> getAllByTrangThai(int trangThai);

    SanPham add(SanPham sanPham);

    SanPham update(SanPham sanPham);

    SanPham delete(SanPham sanPham);

    SanPham getOne(String maSp);

    SanPham getByTen(String ten);

    List<SanPham> search(String maSp);

    List<SanPham> searchByTen(String tenSp);

    List<SanPham> searchFill(SanPhamSearchRequest request);

    List<SanPhamBanHangViewModel> getSanPhamBanHang();

    List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max);

    List<SanPhamBanHangViewModel> searchByTenBanHang(String tenSp);

    void updateSoLuongSanPham(Map<UUID, SanPham> list);

    SanPham getById(UUID id);

    List<SanPhamCustomRespone> getListSanPham();
    
    boolean saveAllSanPham(Map<String, ChiTietSanPhamImportResquest> list);

    long countSanPham(long begin, long end);

    long soSanPhamTheoNgay(long toDay);

    long soSanPham();

    List<Top10SanPhamBanChayViewModel> top10SanPhamBanChay();
}
