package top.itlq.mybatis.learning.dao.in;

import org.apache.ibatis.annotations.Select;
import top.itlq.mybatis.learning.dao.User;

/**
 * sql直接写在接口里，需要在conf里注册
 * 注意全限定名+方法不能重复，包括与同文件夹xml也不能重复
 * 这样写sql复杂时可能不如xml
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User selectUserWithInterface(int id);
}
