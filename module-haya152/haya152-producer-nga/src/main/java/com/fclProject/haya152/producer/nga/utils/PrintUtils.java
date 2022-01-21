package com.fclProject.haya152.producer.nga.utils;

import com.fclProject.haya152.producer.nga.dto.NgaDto;

import java.util.List;

public class PrintUtils {
    public static void print(List<NgaDto> list) {
        for (NgaDto ngaDto : list) {
            System.out.println("#"+ngaDto.getFloor()+"    "+ngaDto.getName()+"    ⯅"+ngaDto.getLike()+"    "+ngaDto.getDate());
//            int tag = ngaDto.getTag();
//            System.out.print("评论类型：");
//            switch (tag) {
//                case 0:
//                    System.out.println("普通评论");
//                    break;
//                case 1:
//                    System.out.println("回复");
//                    break;
//                case 2:
//                    System.out.println("同传");
//                    break;
//            }
            System.out.println(ngaDto.getComments());
            System.out.println();
            System.out.println("===================================================================================");
            System.out.println();
        }
    }
}
