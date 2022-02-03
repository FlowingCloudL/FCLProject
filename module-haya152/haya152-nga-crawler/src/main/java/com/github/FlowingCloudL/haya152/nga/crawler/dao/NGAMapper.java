package com.github.FlowingCloudL.haya152.nga.crawler.dao;

import com.github.FlowingCloudL.haya152.nga.crawler.entity.NGACommentsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface NGAMapper {
    void insertAndUpdateNGA(@Param("dto") NGACommentsEntity ngaDto);
    void updateDatetime(@Param("tableName") String buildingTableName, @Param("datetime") String datetime);
    String selectBuildingTableName(@Param("no") Integer buildingNo);
    String selectBuildingUrl(@Param("no") Integer buildingNo);
    Integer selectMaxFloor(@Param("tableName") String buildingTableName);
}
