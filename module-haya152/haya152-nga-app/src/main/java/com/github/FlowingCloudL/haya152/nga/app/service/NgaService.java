package com.github.FlowingCloudL.haya152.nga.app.service;


import com.github.FlowingCloudL.haya152.nga.app.dto.ResponseDTO;
import com.github.FlowingCloudL.haya152.nga.app.service.domain.CommentsQueryDTO;

public interface NgaService {

    ResponseDTO queryComments(CommentsQueryDTO queryDto);

    ResponseDTO queryBuildingByNo(Integer buildingNo);

    String queryBuildingTableName(Integer buildingNo);

    ResponseDTO queryBuildingList();

//    PageResult getPages(PageRequest pageRequest);
}
