package com.fclProject.haya152.consumer.nga.controller;

import com.fclProject.haya152.consumer.nga.dto.NgaBuildingDto;
import com.fclProject.haya152.consumer.nga.dto.NgaCommentsDto;
import com.fclProject.haya152.consumer.nga.service.NgaServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectController {

    @Autowired
    private NgaServiceImpl ngaService;

    @ApiOperation("查询指定评论")
    @PostMapping("/select/comments")
    @ResponseBody
    public List<NgaCommentsDto> selectComments(@ApiParam(value = "楼号", example = "6", required = true) Integer no,
                                               @ApiParam(value = "用户uid", example = "61692441") Integer uid,
                                               @ApiParam(value = "用户名", example = "FlowingCloudL") String name,
                                               @ApiParam(value = "层号", example = "777") Integer floor,
                                               @ApiParam(value = "模糊搜索关键词", example = "花瓶") String fuzzy_key,
                                               @ApiParam(value = "评论类型（标签）", example = "2 (表示同传)") Integer tag,
                                               @ApiParam(value = "开始日期", example = "2022-01-01 12:00:00") String startDate,
                                               @ApiParam(value = "结束日期", example = "2022-01-02 12:00:00") String endDate,
                                               @ApiParam(value = "排序标准", example = "`like` (表示按点赞数排序)") String orderBy,
                                               @ApiParam(value = "排序顺序", example = "2 (表示降序)") Integer order,
                                               @ApiParam(value = "页码", example = "7 (注意：从1开始)") Integer pageNum,
                                               @ApiParam(value = "单页条数", example = "100") Integer pageSize) {

        Map<String,Object> map = new HashMap<>();
        map.put("no",ngaService.selectBuildingTableName(no));
        if (uid != null) map.put("uid",uid);
        if (!name.equals("")) map.put("name",name);
        if (floor != null) map.put("floor",floor);
        if (fuzzy_key != null) map.put("fuzzy_key",fuzzy_key);
        if (tag != null) map.put("tag",tag);
        if (!startDate.equals("")) map.put("startDatetime",startDate);
        if (!endDate.equals("")) map.put("endDatetime",endDate);
        if (!orderBy.equals("")) map.put("orderBy",orderBy);
        if (order != null) map.put("order",order);
        if (pageNum == null) pageNum = 0;
        if (pageSize == null) pageSize = 100;
        return ngaService.selectCommentsByDynamicCriteria(map, new RowBounds(pageNum,pageSize));
    }

    @ApiOperation("查询指定楼信息")
    @PostMapping("/select/building/{no}")
    @ResponseBody
    public NgaBuildingDto selectBuilding(@ApiParam("楼号") @PathVariable("no") Integer no) {
        return ngaService.selectBuildingByNo(no);
    }

    @ApiOperation("列出所有楼信息")
    @GetMapping ("/select/building/list")
    @ResponseBody
    public List<NgaBuildingDto> selectBuilding() {
        return ngaService.selectBuildingList();
    }

}
