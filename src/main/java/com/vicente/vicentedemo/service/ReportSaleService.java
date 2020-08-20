package com.vicente.vicentedemo.service;

import cn.hutool.json.JSONObject;
import com.vicente.vicentedemo.entity.ReportSale;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weisen
 * @since 2020-08-17
 */
public interface ReportSaleService extends IService<ReportSale> {

    List<ReportSale> getSaleData(JSONObject param);

}
