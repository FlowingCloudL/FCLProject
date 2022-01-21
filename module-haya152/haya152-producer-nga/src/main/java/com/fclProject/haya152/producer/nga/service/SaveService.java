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

    public void saveToMysqlByInsert(List<NgaDto> list, String no) {
        for (NgaDto ngaDto : list) {
            try { //尝试insert
                ngaMapper.insertNga(ngaDto,no);
            } catch (Exception e1) {
                try { // 尝试update
                    ngaMapper.updateNga(ngaDto,no);
                } catch (Exception e2) {
                    System.out.println("insert/update 失败!!!!!");
                }
            }
        }
    }
}
