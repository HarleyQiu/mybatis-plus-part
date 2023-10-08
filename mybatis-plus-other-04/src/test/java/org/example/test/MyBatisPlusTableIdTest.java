package org.example.test;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class MyBatisPlusTableIdTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setName("驴蛋蛋");
        user.setAge(20);
        user.setEmail("xxxx@qq.com");
        //主键不要赋值
        //主键的策略： 雪花算法 -》 不重复的数字 long
        userMapper.insert(user);
    }
}
