package com.github.FlowingCloudL.haya152.nga.crawler.service;

import com.github.FlowingCloudL.haya152.nga.crawler.dao.NGAMapper;
import com.github.FlowingCloudL.haya152.nga.crawler.entity.NGACommentsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SaveService {

    @Autowired
    private NGAMapper ngaMapper;

    public void saveToMysql(List<NGACommentsEntity> list) {
        for (NGACommentsEntity ngaDto : list) {
            ngaMapper.insertAndUpdateNGA(ngaDto);
            ngaMapper.updateDatetime(ngaDto.getTableName(), ngaDto.getDate());
        }
    }
}
