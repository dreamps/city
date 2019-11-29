package com.baizhi.service;

import com.baizhi.dao.AreaDao;
import com.baizhi.entity.Area;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Override
    public List<Area> selectAreaByCityCode(String cityCode) {
        AreaDao areaDao = MybatisUtil.getSqlSession().getMapper(AreaDao.class);
        List<Area> areas = areaDao.selectAreaByCityCode(cityCode);
        return areas;
    }
}
