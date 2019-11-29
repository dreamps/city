package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.City;
import com.baizhi.service.CityServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CityAction {
    private String ProvinceCode;

    public String selectCity() throws IOException {
        CityServiceImpl cityService = new CityServiceImpl();
        List<City> cities = cityService.selectCityByProvinceCode(ProvinceCode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String json = JSONObject.toJSONString(cities);
        writer.print(json);
        return null;
    }

    public String getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        ProvinceCode = provinceCode;
    }
}
