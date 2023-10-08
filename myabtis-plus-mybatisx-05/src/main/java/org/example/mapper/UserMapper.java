package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * @author 21055
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-10-08 16:22:40
 * @Entity org.example.pojo.User
 */
public interface UserMapper extends BaseMapper<User> {

    int insertBatch(@Param("userCollection") Collection<User> userCollection);

    List<User> selectAllByNameAndAge(@Param("name") String name, @Param("age") Integer age);
}




