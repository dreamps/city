package com.baizhi.service;

import com.baizhi.dao.ProviceDao;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public List<Province> selectAll() {
        ProviceDao proviceDao = MybatisUtil.getSqlSession().getMapper(ProviceDao.class);
        List<Province> provinces = proviceDao.selectAll();
        MybatisUtil.close();
        return provinces;
    }
}
