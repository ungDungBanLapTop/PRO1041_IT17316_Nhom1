/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface DoiTraRepository {
    
    List<DoiTRa> gelAll();
    
    DoiTRa add(DoiTRa doiTRa);
    
}
