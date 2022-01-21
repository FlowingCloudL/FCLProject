package com.fclProject.haya152.consumer.nga.dao;

import com.fclProject.haya152.consumer.nga.dto.NgaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NgaMapper {
    List<NgaDto> selectByTagAndDatetime(@Param("tag") Integer tag, @Param("start") String start, @Param("end") String end);
    List<NgaDto> selectByDynamicCriteria(Map<String,Object> criteria);
}
