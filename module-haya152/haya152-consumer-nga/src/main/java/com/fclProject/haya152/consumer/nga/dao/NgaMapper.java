package com.fclProject.haya152.consumer.nga.dao;

import com.fclProject.haya152.consumer.nga.dto.NgaBuildingDto;
import com.fclProject.haya152.consumer.nga.dto.NgaCommentsDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NgaMapper {
    List<NgaCommentsDto> selectCommentsByDynamicCriteria(Map<String,Object> criteria);
    NgaBuildingDto selectBuildingByNo(Integer building_no);
    String selectBuildingTableName(Integer building_no);
    List<NgaBuildingDto> selectBuildingList();
}
