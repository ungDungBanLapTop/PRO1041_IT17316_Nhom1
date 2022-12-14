/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Setter
@Getter
@Table(name = "ram")
@AllArgsConstructor
@NoArgsConstructor
public class Ram {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                @Parameter(
                        name = "uuid_gen_strategy_class",
                        value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                )
            }
    )
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID idRam;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_ram", columnDefinition = "nvarchar(100)")
    private String ten;

    @Column(name = "dung_luong")
    private int dungLuong;

    @Column(name = "megahertz")
    private int megahertz;

    @Column(name = "loai_ram")
    private EnumLoaiRam enumLoaiRam;

    public Ram(UUID idRam) {
        this.idRam = idRam;
    }

}
