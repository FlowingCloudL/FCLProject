package com.fclProject.haya152.consumer.nga.controller;

import com.fclProject.haya152.consumer.nga.dao.NgaMapper;
import com.fclProject.haya152.consumer.nga.dto.NgaBuildingDto;
import com.fclProject.haya152.consumer.nga.dto.NgaCommentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectController {

    @Autowired
    private NgaMapper ngaMapper;

    @RequestMapping("/select/comments")
    public String selectComments(Integer no, Integer uid, String name, Integer floor, String fuzzy_key, Integer tag,
                         String startDate, String endDate, String orderBy, Integer order, Integer limit,
                         Integer type, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        map.put("no",ngaMapper.selectBuildingTableName(no));
        System.out.println(map.get("no"));
        if (uid != null) map.put("uid",uid);
        if (!name.equals("")) map.put("name",name);
        if (floor != null) map.put("floor",floor);
        if (fuzzy_key != null) map.put("fuzzy_key",fuzzy_key);
        if (tag != null) map.put("tag",tag);
        if (!startDate.equals("")) map.put("startDatetime",startDate);
        if (!endDate.equals("")) map.put("endDatetime",endDate);
        if (!orderBy.equals("")) map.put("orderBy",orderBy);
        if (order != null) map.put("order",order);
        if (limit != null) map.put("limit",limit);
        else map.put("limit",100);
        List<NgaCommentsDto> list = ngaMapper.selectCommentsByDynamicCriteria(map);
        request.setAttribute("list",list);
        if (type == 2) return "forward:/select/comments/json";
        else return "show";
    }

    @PostMapping ("/select/comments/json")
    @ResponseBody
    public List<NgaCommentsDto> selectComments(HttpServletRequest request) {
        return (List<NgaCommentsDto>) request.getAttribute("list");
    }

    @RequestMapping("/select/building/{no}")
    @ResponseBody
    public NgaBuildingDto selectBuilding(@PathVariable("no") Integer no) {
        return ngaMapper.selectBuildingByNo(no);
    }

    @RequestMapping("/select/building/list")
    @ResponseBody
    public List<NgaBuildingDto> selectBuilding() {
        return ngaMapper.selectBuildingList();
    }

}
