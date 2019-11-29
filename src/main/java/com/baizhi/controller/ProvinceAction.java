package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import com.baizhi.service.ProvinceServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction {
    public String selectAllProvince() throws IOException {
        ProvinceService ps = new ProvinceServiceImpl();
        List<Province> provinces = ps.selectAll();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String json = JSONObject.toJSONString(provinces);
        writer.print(json);
        return null;
    }
}
