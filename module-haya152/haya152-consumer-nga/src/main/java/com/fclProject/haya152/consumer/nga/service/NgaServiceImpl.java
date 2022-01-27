package com.fclProject.haya152.consumer.nga.service;

import com.fclProject.haya152.consumer.nga.dao.NgaMapper;
import com.fclProject.haya152.consumer.nga.entity.NgaCommentsEntity;
import com.fclProject.haya152.consumer.nga.service.domain.CommentsQueryDTO;
import com.fclProject.haya152.consumer.nga.entity.NgaBuildingEntity;
import com.fclProject.haya152.consumer.nga.dto.ResponseDTO;
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
        if (queryDto.getUid() != null) queryMap.put("uid",queryDto.getUid());
        if (!queryDto.getName().equals("")) queryMap.put("name",queryDto.getName());
        if (queryDto.getFloor() != null) queryMap.put("floor",queryDto.getFloor());
        if (queryDto.getFuzzyKey() != null) queryMap.put("fuzzyKey",queryDto.getFuzzyKey());
        if (queryDto.getTag() != null) queryMap.put("tag",queryDto.getTag());
        if (!queryDto.getStartDatetime().equals("")) queryMap.put("startDatetime",queryDto.getStartDatetime());
        if (!queryDto.getEndDatetime().equals("")) queryMap.put("endDatetime",queryDto.getEndDatetime());
        if (!queryDto.getOrderBy().equals("")) queryMap.put("orderBy",queryDto.getOrderBy());
        if (queryDto.getOrder() != null) queryMap.put("order",queryDto.getOrder());
        Integer pageNum = queryDto.getPageNum();
        Integer pageSize = queryDto.getPageSize();
        if (pageNum == null) pageNum = 0;
        if (pageSize == null) pageSize = 100;
        ResponseDTO response = new ResponseDTO();
        response.setCode(200);
        response.setMessage("评论查询结果");
        Map<String, Object> resultMap = new HashMap<>();
        for (Integer no : queryDto.getNoList()) {
            queryMap.put("no", queryBuildingTableName(no));
            List<NgaCommentsEntity> entityList = ngaMapper.selectCommentsByDynamicCriteria(queryMap, new RowBounds(pageNum, pageSize));
            resultMap.put(no.toString(), entityList);
            queryMap.remove("no");
        }
        response.setData(resultMap);
        return response;
    }

    @Override
    public ResponseDTO queryBuildingByNo(Integer buildingNo) {
        ResponseDTO response = new ResponseDTO();
        NgaBuildingEntity ngaBuildingEntity = ngaMapper.selectBuildingByNo(buildingNo);
        response.setCode(200);
        response.setMessage("目标楼信息");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("BuildingInfo", ngaBuildingEntity);
        response.setData(resultMap);
        return response;
    }

    @Override
    public String queryBuildingTableName(Integer buildingNo) {
        return ngaMapper.selectBuildingTableName(buildingNo);
    }

    @Override
    public ResponseDTO queryBuildingList() {
        ResponseDTO response = new ResponseDTO();
        List<NgaBuildingEntity> result = ngaMapper.selectBuildingList();
        response.setCode(200);
        response.setMessage("楼信息列表");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("BuildingInfoList", result);
        response.setData(resultMap);
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
