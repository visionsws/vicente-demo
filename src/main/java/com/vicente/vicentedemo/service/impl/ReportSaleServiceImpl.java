package com.vicente.vicentedemo.service.impl;

import cn.hutool.json.JSONObject;
import com.vicente.vicentedemo.entity.ReportSale;
import com.vicente.vicentedemo.mapper.ReportSaleMapper;
import com.vicente.vicentedemo.service.ReportSaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weisen
 * @since 2020-08-17
 */
@Service
public class ReportSaleServiceImpl extends ServiceImpl<ReportSaleMapper, ReportSale> implements ReportSaleService {
    @Autowired
    private ReportSaleMapper saleMapper;


    @Override
    public List<ReportSale> getSaleData(JSONObject param) {
        int pageNum = param.getInt("pageNum",1);
        int pageSize = param.getInt("pageSize",10);
        int offset = (pageNum-1)*pageSize;
        param.putOpt("offset",offset);
        param.putOpt("pageSize",pageSize);
        List<ReportSale> list = saleMapper.getSaleData(param);
        return list;
    }
}
