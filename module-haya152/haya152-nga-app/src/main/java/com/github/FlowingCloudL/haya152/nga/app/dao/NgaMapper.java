package com.github.FlowingCloudL.haya152.nga.app.dao;

import com.github.FlowingCloudL.haya152.nga.app.entity.NgaBuildingEntity;
import com.github.FlowingCloudL.haya152.nga.app.entity.NgaCommentsEntity;
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
