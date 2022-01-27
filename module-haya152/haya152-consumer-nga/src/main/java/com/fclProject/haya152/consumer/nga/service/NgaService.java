package com.fclProject.haya152.consumer.nga.service;


import com.fclProject.haya152.consumer.nga.dto.ResponseDTO;
import com.fclProject.haya152.consumer.nga.service.domain.CommentsQueryDTO;

public interface NgaService {

    ResponseDTO queryComments(CommentsQueryDTO queryDto);

    ResponseDTO queryBuildingByNo(Integer buildingNo);

    String queryBuildingTableName(Integer buildingNo);

    ResponseDTO queryBuildingList();

//    PageResult getPages(PageRequest pageRequest);
}
