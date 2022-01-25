package com.fclProject.haya152.consumer.nga.service;

import com.fclProject.haya152.consumer.nga.dao.NgaMapper;
import com.fclProject.haya152.consumer.nga.dto.NgaBuildingDto;
import com.fclProject.haya152.consumer.nga.dto.NgaCommentsDto;
import com.fclProject.haya152.consumer.nga.dto.PageRequest;
import com.fclProject.haya152.consumer.nga.dto.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NgaServiceImpl implements NgaService {

    @Autowired
    private NgaMapper ngaMapper;

    @Override
    public List<NgaCommentsDto> selectCommentsByDynamicCriteria(Map<String, Object> criteria, RowBounds rowBounds) {
        return ngaMapper.selectCommentsByDynamicCriteria(criteria, rowBounds);
    }

    @Override
    public NgaBuildingDto selectBuildingByNo(Integer building_no) {
        return ngaMapper.selectBuildingByNo(building_no);
    }

    @Override
    public String selectBuildingTableName(Integer building_no) {
        return ngaMapper.selectBuildingTableName(building_no);
    }

    @Override
    public List<NgaBuildingDto> selectBuildingList() {
        return ngaMapper.selectBuildingList();
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
