package com.fclProject.haya152.consumer.nga.dao;

import com.fclProject.haya152.consumer.nga.entity.NgaBuildingEntity;
import com.fclProject.haya152.consumer.nga.entity.NgaCommentsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NgaMapper {
    List<NgaCommentsEntity> selectCommentsByDynamicCriteria(Map<String,Object> criteria, RowBounds rowBounds);
    NgaBuildingEntity selectBuildingByNo(Integer buildingNo);
    String selectBuildingTableName(Integer buildingNo);
    List<NgaBuildingEntity> selectBuildingList();
}
