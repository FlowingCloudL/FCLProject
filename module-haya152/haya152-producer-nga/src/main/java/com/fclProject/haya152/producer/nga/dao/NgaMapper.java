package com.fclProject.haya152.producer.nga.dao;

import com.fclProject.haya152.producer.nga.dto.NgaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface NgaMapper {
    void insertNga(@Param("dto") NgaDto ngaDto, @Param("no") String no);
    void updateNga(@Param("dto") NgaDto ngaDto, @Param("no") String no);
    Integer selectMaxFloor(@Param("no") String no);
}
