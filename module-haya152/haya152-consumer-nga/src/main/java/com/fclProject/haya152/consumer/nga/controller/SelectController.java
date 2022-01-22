package com.fclProject.haya152.consumer.nga.controller;

import com.fclProject.haya152.consumer.nga.dao.NgaMapper;
import com.fclProject.haya152.consumer.nga.dto.NgaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectController {

    @Autowired
    private NgaMapper ngaMapper;

    @PostMapping("/select/default")
    public String select(Integer no, Integer uid, String name, Integer floor, Integer tag,
                               String startDate, String endDate, String orderBy, Integer order, Integer limit,
                               Integer type, Model model) {
        if (type == 2) return "forward:/select";
        Map<String,Object> map = new HashMap<>();
        map.put("no","nga0"+no);
        if (uid != null) map.put("uid",uid);
        if (!name.equals("")) map.put("name",name);
        if (floor != null) map.put("floor",floor);
        if (tag != null) map.put("tag",tag);
        if (!startDate.equals("")) map.put("startDate",startDate);
        if (!endDate.equals("")) map.put("endDate",endDate);
        if (!orderBy.equals("")) map.put("orderBy",orderBy);
        if (order != null) map.put("order",order);
        if (limit != null) map.put("limit",limit);
        else map.put("limit",100);
        List<NgaDto> list = ngaMapper.selectByDynamicCriteria(map);
        model.addAttribute("list",list);
        return "show";
    }

    @PostMapping ("/select")
    @ResponseBody
    public List<NgaDto> select(Integer no, Integer uid, String name, Integer floor, Integer tag,
                         String startDate, String endDate, String orderBy, Integer order, Integer limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("no","nga0"+no);
        if (uid != null) map.put("uid",uid);
        if (!name.equals("")) map.put("name",name);
        if (floor != null) map.put("floor",floor);
        if (tag != null) map.put("tag",tag);
        if (!startDate.equals("")) map.put("startDate",startDate);
        if (!endDate.equals("")) map.put("endDate",endDate);
        if (!orderBy.equals("")) map.put("orderBy",orderBy);
        if (order != null) map.put("order",order);
        if (limit != null) map.put("limit",limit);
        else map.put("limit",100);
        List<NgaDto> list = ngaMapper.selectByDynamicCriteria(map);
        return list;
    }

}
