/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface BaoHanhRepository {

    List<BaoHanh> getAll();

    BaoHanh add(BaoHanh baoHanh);

    BaoHanh getOne(String maBh);

    BaoHanh getById(UUID id);
    
    List<BaoHanh> searchByMa(String ma);
    

}
