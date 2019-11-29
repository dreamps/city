package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Area;
import com.baizhi.service.AreaServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AreaAction {
    private String cityCode;

    public String selectArea() throws IOException {
        AreaServiceImpl areaService = new AreaServiceImpl();
        List<Area> areas = areaService.selectAreaByCityCode(cityCode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        String json = JSONObject.toJSONString(areas);

        PrintWriter writer = response.getWriter();

        writer.println(json);
        return null;

    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
