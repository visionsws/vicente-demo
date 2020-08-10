package com.vicente.vicentedemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vicente.vicentedemo.entity.SysUser;
import com.vicente.vicentedemo.mapper.SysUserMapper;
import com.vicente.vicentedemo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author weisen
 * @since 2020-08-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser findUserByName(String userName){
        SysUser user = baseMapper.selectOne(new QueryWrapper<SysUser>().eq("login_name", userName).last("limit 1"));
        return user;

    }

}
