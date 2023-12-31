package org.example.test;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusVersionTest {

    @Autowired
    private UserMapper userMapper;

    //演示乐观锁生效场景
    @Test
    public void testQuick7() {
        //步骤1: 先查询,在更新 获取version数据
        //同时查询两条,但是version唯一,最后更新的失败
        User user = userMapper.selectById(11);  // 1
        User user1 = userMapper.selectById(11); // 1


        user.setAge(33);  // 22
        user1.setAge(44); // 33

        userMapper.updateById(user); //20 -> version - 2
        // 乐观锁生效,失败!
        userMapper.updateById(user1); // 1 != 2 不是最新数据 修改失败！

        // 22
    }
}
