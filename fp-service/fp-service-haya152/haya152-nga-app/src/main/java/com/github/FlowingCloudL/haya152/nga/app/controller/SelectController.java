package com.github.FlowingCloudL.haya152.nga.app.controller;

import com.github.FlowingCloudL.haya152.nga.app.dto.ResponseDTO;
import com.github.FlowingCloudL.haya152.nga.app.service.NgaServiceImpl;
import com.github.FlowingCloudL.haya152.nga.app.service.domain.CommentsQueryDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SelectController {

    @Autowired
    private NgaServiceImpl ngaService;

    @ApiOperation("查询指定评论")
    @PostMapping("/select/comments")
    @ResponseBody
    public ResponseDTO selectComments(@RequestBody CommentsQueryDTO queryDTO) {

        return ngaService.queryComments(queryDTO);
    }

    @ApiOperation("查询指定楼信息")
    @GetMapping("/select/building/{no}")
    @ResponseBody
    public ResponseDTO selectBuilding(@RequestBody @ApiParam(value = "楼号", example = "6") @PathVariable("no") Integer no) {
        return ngaService.queryBuildingByNo(no);
    }

    @ApiOperation("列出所有楼信息")
    @GetMapping ("/select/building/list")
    @ResponseBody
    public ResponseDTO selectBuilding() {
        return ngaService.queryBuildingList();
    }

}
