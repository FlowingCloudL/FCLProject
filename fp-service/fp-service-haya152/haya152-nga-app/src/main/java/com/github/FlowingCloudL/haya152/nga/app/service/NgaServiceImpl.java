package com.github.FlowingCloudL.haya152.nga.app.service;

import com.github.FlowingCloudL.haya152.nga.app.dao.NgaMapper;
import com.github.FlowingCloudL.haya152.nga.app.entity.NgaCommentsEntity;
import com.github.FlowingCloudL.haya152.nga.app.service.domain.CommentsQueryDTO;
import com.github.FlowingCloudL.haya152.nga.app.dto.ResponseDTO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NgaServiceImpl implements NgaService {

    @Autowired
    private NgaMapper ngaMapper;

    @Override
    public ResponseDTO queryComments(CommentsQueryDTO queryDto) {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("no", queryBuildingTableName(queryDto.getNo()));
        if (queryDto.getUid() != null) queryMap.put("uid",queryDto.getUid());
        if (!queryDto.getName().equals("")) queryMap.put("name",queryDto.getName());
        if (queryDto.getFloor() != null) queryMap.put("floor",queryDto.getFloor());
        if (queryDto.getFuzzyKey() != null) queryMap.put("fuzzyKey",queryDto.getFuzzyKey());
        if (queryDto.getTag() != null) queryMap.put("tag",queryDto.getTag());
        if (!queryDto.getStartDatetime().equals("")) queryMap.put("startDatetime",queryDto.getStartDatetime());
        if (!queryDto.getEndDatetime().equals("")) queryMap.put("endDatetime",queryDto.getEndDatetime());
        if (!queryDto.getOrderBy().equals("")) queryMap.put("orderBy","`"+queryDto.getOrderBy()+"`");
        if (queryDto.getOrder() != null) queryMap.put("order",queryDto.getOrder());
        Integer pageNum = queryDto.getPageNum();
        Integer pageSize = queryDto.getPageSize();
        if (pageNum == null) pageNum = 0;
        if (pageSize == null) pageSize = 100;
        ResponseDTO response = new ResponseDTO();
        try {
            response.setData(ngaMapper.selectCommentsByDynamicCriteria(queryMap, new RowBounds(pageNum, pageSize)));
            response.setCode(200);
            response.setMessage("查询成功");
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("查询失败，可能是参数错误");
        }
        return response;
    }

    @Override
    public ResponseDTO queryBuildingByNo(Integer buildingNo) {
        ResponseDTO response = new ResponseDTO();
        response.setCode(200);
        response.setMessage("目标楼信息");
        response.setData(ngaMapper.selectBuildingByNo(buildingNo));
        return response;
    }

    @Override
    public String queryBuildingTableName(Integer buildingNo) {
        return ngaMapper.selectBuildingTableName(buildingNo);
    }

    @Override
    public ResponseDTO queryBuildingList() {
        ResponseDTO response = new ResponseDTO();
        response.setCode(200);
        response.setMessage("楼信息列表");
        response.setData(ngaMapper.selectBuildingList());
        return response;
    }

//    @Override
//    public PageResult getPages(PageRequest pageRequest) {
//        return null;
//    }
//
//    private PageInfo<NgaCommentsDto> getPageInfo(PageRequest pageRequest) {
//        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
//        List<NgaCommentsDto> commentsDtoList = ngaMapper.selectCommentsByDynamicCriteria()
//    }
}
