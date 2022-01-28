package com.fclProject.haya152.producer.nga.dao;

import com.fclProject.haya152.producer.nga.dto.NgaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface NgaMapper {
    void insertNga(@Param("tableName") String buildingTableName, @Param("dto") NgaDto ngaDto);
    void updateNga(@Param("tableName") String buildingTableName, @Param("dto") NgaDto ngaDto);
    void updateDatetime(@Param("tableName") String buildingTableName, @Param("datetime") String datetime);
    String selectBuildingTableName(@Param("no") Integer buildingNo);
    String selectBuildingUrl(@Param("no") Integer buildingNo);
    Integer selectMaxFloor(@Param("tableName") String buildingTableName);
}
