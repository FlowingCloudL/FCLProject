package com.fp.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fp.auth.mapper.UserAuthMapper;
import com.fp.auth.entity.UserAuthEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMP {

    @Autowired
    private UserAuthMapper mapper;

    @Test
    public void test1() {
        System.out.println(("----- selectAll method test ------"));
        List<Object> list = mapper.selectObjs(new QueryWrapper<UserAuthEntity>()
                .select("credentials").eq("lid", 1).eq("identity", 1));
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        mapper.selectAll().forEach(System.out::println);
    }
}