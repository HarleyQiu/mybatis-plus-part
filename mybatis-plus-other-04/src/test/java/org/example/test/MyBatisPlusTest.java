package org.example.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        //IPage -> Page(页码,页容量)
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);

        //结果 page最后也会被封装结果
        long current = page.getCurrent(); //页码
        long size = page.getSize(); //页容量
        List<User> records = page.getRecords(); //当前页的数据
        long total = page.getTotal(); //总条数
        log.info("{}, {}, {}, {}", current, size, records, total);
    }

    @Test
    public void testMyPage() {
        Page<User> page = new Page<>(1, 2);
        userMapper.queryByAge(page, 20);

        long current = page.getCurrent(); //页码
        long size = page.getSize(); //页容量
        List<User> records = page.getRecords(); //当前页的数据
        long total = page.getTotal(); //总条数
        log.info("{}, {}, {}, {}", current, size, records, total);
    }
}
