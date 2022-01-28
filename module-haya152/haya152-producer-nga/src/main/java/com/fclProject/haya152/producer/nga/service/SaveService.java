package com.fclProject.haya152.producer.nga.service;

import com.fclProject.haya152.producer.nga.dao.NgaMapper;
import com.fclProject.haya152.producer.nga.dto.NgaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveService {

    @Autowired
    private NgaMapper ngaMapper;

    public void saveToMysql(String buildingName, List<NgaDto> list) {
        for (NgaDto ngaDto : list) {
            try { //尝试insert
                ngaMapper.insertNga(buildingName,ngaDto);
                ngaMapper.updateDatetime(buildingName,ngaDto.getDate());
            } catch (Exception e1) {
                try { // 尝试update
                    ngaMapper.updateNga(buildingName,ngaDto);
                } catch (Exception e2) {
                    System.out.println("insert/update 失败!!!!!");
                }
            }
        }
    }
}
