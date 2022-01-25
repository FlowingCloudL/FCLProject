package com.fclProject.haya152.consumer.nga.service;


import com.fclProject.haya152.consumer.nga.dto.NgaBuildingDto;
import com.fclProject.haya152.consumer.nga.dto.NgaCommentsDto;
import com.fclProject.haya152.consumer.nga.dto.PageRequest;
import com.fclProject.haya152.consumer.nga.dto.PageResult;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface NgaService {

    List<NgaCommentsDto> selectCommentsByDynamicCriteria(Map<String,Object> criteria, RowBounds rowBounds);

    NgaBuildingDto selectBuildingByNo(Integer building_no);

    String selectBuildingTableName(Integer building_no);

    List<NgaBuildingDto> selectBuildingList();

//    PageResult getPages(PageRequest pageRequest);
}
