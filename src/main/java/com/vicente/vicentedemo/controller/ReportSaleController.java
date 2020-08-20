package com.vicente.vicentedemo.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.vicente.vicentedemo.entity.ReportSale;
import com.vicente.vicentedemo.service.ReportSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weisen
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/reportSale")
public class ReportSaleController {
    @Autowired
    private ReportSaleService saleService;

    @RequestMapping("/getData")
    public String getData(@RequestBody String param){
        JSONObject jsonObj = JSONUtil.parseObj(param);
        List<ReportSale> list = saleService.getSaleData(jsonObj);
        return JSONUtil.toJsonStr(list);
    }

}
