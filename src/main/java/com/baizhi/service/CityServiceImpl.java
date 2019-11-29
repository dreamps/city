package com.baizhi.service;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public List<City> selectCityByProvinceCode(String provinceCode) {
        CityDao cityDao = MybatisUtil.getSqlSession().getMapper(CityDao.class);
        List<City> cities = cityDao.selectCityByProvinceCode(provinceCode);
        MybatisUtil.close();
        return cities;
    }
}
