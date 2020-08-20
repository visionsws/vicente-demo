package com.vicente.vicentedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author weisen
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReportSale extends Model<ReportSale> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String areaName;

    private String saleName;

    private String productType;

    private String productName;

    private String saleNum;

    private String englishName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
