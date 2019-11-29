import com.baizhi.dao.AreaDao;
import com.baizhi.dao.CityDao;
import com.baizhi.dao.ProviceDao;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        ProviceDao proviceDao = MybatisUtil.getSqlSession().getMapper(ProviceDao.class);
        List<Province> provinces = proviceDao.selectAll();
        MybatisUtil.close();
        for (Province province : provinces) {
            System.out.println(province);
        }
    }

    @org.junit.Test
    public void test1() {
        CityDao cityDao = MybatisUtil.getSqlSession().getMapper(CityDao.class);
        List<City> cities = cityDao.selectCityByProvinceCode("410000");
        MybatisUtil.close();
        for (City province : cities) {
            System.out.println(province);
        }
    }

    @org.junit.Test
    public void test2() {
        AreaDao areaDao = MybatisUtil.getSqlSession().getMapper(AreaDao.class);
        List<Area> areas = areaDao.selectAreaByCityCode("410100");
        for (Area province : areas) {
            System.out.println(province);
        }
    }
}
