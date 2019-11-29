package com.baizhi.service;

import com.baizhi.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> selectAreaByCityCode(String cityCode);
}
