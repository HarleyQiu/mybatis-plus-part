package org.example.test;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MyBatisTestTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("zhang_san");
        user.setAge(88);
        user.setEmail("1@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void test_delete() {
        //根据id删除
        int rows = userMapper.deleteById(1709029192176930817L);
        System.out.println("rows = " + rows);

        // 根据age删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 20);
        int i = userMapper.deleteByMap(map);
        System.out.println("i = " + i);

        // wrapper 条件封装对象，无限的封装条件
        // userMapper.delete(wrapper);
    }

    @Test
    public void test_update() {
        // TODO: update 当属性值为null的时候，不修改！

        // updatebyId 实体类id必须有值
        // user id = 1 age改为30
        User user = new User();
        user.setId(1L);
        user.setAge(30);
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

        // 将所有人的年龄改为22
        // update 实体类可以没有id值
        User user1 = new User();
        user1.setAge(22);
        int rows = userMapper.update(user1, null); //null没条件
        System.out.println("rows = " + rows);
    }

    @Test
    public void test_select() {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(3L);
        List<User> users = userMapper.selectBatchIds(longs);
        users.forEach(System.out::println);
    }

    @Test
    public void Test() {
        // 创建一个随机数生成器
        Random random = new Random();
        ArrayList<Integer> integers = new ArrayList<>();

        // 生成100个随机整数并添加到列表中
        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(); // 生成一个随机整数
            System.out.println(randomNumber);
            integers.add(randomNumber);
        }

        // 对列表中的整数从小到大排序
        Collections.sort(integers);
        System.out.println("----------------------");
        // 打印排序后的整数列表
        System.out.println("排序后的整数列表:");
        for (int num : integers) {
            System.out.println(num);
        }


    }
}
