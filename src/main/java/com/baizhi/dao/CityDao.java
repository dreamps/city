package com.baizhi.dao;


import com.baizhi.entity.City;

import java.util.List;

public interface CityDao {
    List<City> selectCityByProvinceCode(String provinceCode);
}
